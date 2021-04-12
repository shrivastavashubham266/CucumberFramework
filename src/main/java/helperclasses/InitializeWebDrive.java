
package helperclasses;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import browsers.BrowserType;
import browsers.ChromeBrowser;
import configReader.PropertyFileReader;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import exceptions.NoDriverFoundException;
import settings.ObjectRepo;

/**
 * @author Shubham Shrivastava
 * @since 04/12/2021
 */

public class InitializeWebDrive {

	private Logger logger = LoggerHelper.getLogger(InitializeWebDrive.class);

	public InitializeWebDrive(PropertyFileReader reader) {
		ObjectRepo.reader = reader;
	}

	public WebDriver standAloneStepUp(BrowserType bType) throws Exception {
		try {
			logger.info(bType);

			switch (bType) {

			case Chrome:
				ChromeBrowser chrome = ChromeBrowser.class.newInstance();
				return chrome.getChromeDriver(chrome.getChromeCapabilities());

			default:
				throw new NoDriverFoundException(" Driver Not Found : "
						+ ObjectRepo.reader.getBrowser());
			}
		} catch (Exception e) {
			logger.equals(e);
			throw e;
		}
	}
	
	@Before({"~@chrome"})
	public void before() throws Exception {
		setUpDriver(ObjectRepo.reader.getBrowser());
		logger.info(ObjectRepo.reader.getBrowser());
	}

	@After({"~@chrome"})
	public void after(Scenario scenario) throws Exception {
		tearDownDriver(scenario);
		logger.info("");
	}
	
	public void setUpDriver(BrowserType browserType) throws Exception {
		ObjectRepo.driver = standAloneStepUp(browserType);
		logger.debug("InitializeWebDrive : " + ObjectRepo.driver.hashCode());
		ObjectRepo.driver
				.manage()
				.timeouts()
				.pageLoadTimeout(ObjectRepo.reader.getPageLoadTimeOut(),
						TimeUnit.SECONDS);
		ObjectRepo.driver
				.manage()
				.timeouts()
				.implicitlyWait(ObjectRepo.reader.getImplicitWait(),
						TimeUnit.SECONDS);
		ObjectRepo.driver.manage().window().maximize();

	}

	public void tearDownDriver(Scenario scenario) throws Exception {
		
		try {
			if (ObjectRepo.driver != null) {
				
				if(scenario.isFailed())
					scenario.write(new GenericHelper(ObjectRepo.driver).takeScreenShot(scenario.getName()));
				
				ObjectRepo.driver.quit();
				ObjectRepo.reader = null;
				ObjectRepo.driver = null;
				logger.info("Shutting Down the driver");
			}
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}

}
