
package helperclasses;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.DateTimeHelper;
import utilities.ResourceHelper;


/**
 * @author Shubham Shrivastava
 * @since 04/12/2021
 */
public class GenericHelper {

	private WebDriver driver;
	private Logger logger = LoggerHelper.getLogger(GenericHelper.class);

	public GenericHelper(WebDriver driver) {
		this.driver = driver;
		logger.debug("GenericHelper : " + this.driver.hashCode());
	}

	public WebElement getElement(By locator) {
		logger.info(locator);
		if (IsElementPresentFast(locator))
			return driver.findElement(locator);
		
		try {
			throw new NoSuchElementException("Element Not Found : " + locator);
		} catch (RuntimeException re) {
			logger.error(re);
			throw re;
		}
	}
	
	public List<WebElement> getElements(String element) {
		logger.info(element);
		By locator = By.xpath(element);
		return driver.findElements(locator);
	}
	
	/**
	 * Check for element is present based on locator
	 * If the element is present return the web element otherwise null
	 * @param locator
	 * @return WebElement or null
	 */
	
	public WebElement getElementWithNull(By locator) {
		logger.info(locator);
		try {
			return driver.findElement(locator);
		} catch (NoSuchElementException e) {
			// Ignore
		}
		return null;
	}

	public boolean IsElementPresentFast(By locator) {
		boolean flag = driver.findElements(locator).size() >= 1;
		logger.info(flag);
		return flag;
	}

	public String takeScreenShot(String name) throws IOException {

		File destDir = new File(ResourceHelper.getResourcePath("screenshots/")
				+ DateTimeHelper.getCurrentDate());
		if (!destDir.exists())
			destDir.mkdir();

		File destPath = new File(destDir.getAbsolutePath()
				+ System.getProperty("file.separator") + name + ".jpg");
		try {
			FileUtils
					.copyFile(((TakesScreenshot) driver)
							.getScreenshotAs(OutputType.FILE), destPath);
		} catch (IOException e) {
			logger.error(e);
			throw e;
		}
		logger.info(destPath.getAbsolutePath());
		return destPath.getAbsolutePath();
	}

	public String takeScreenShot() {
		logger.info("");
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}

}
