
package helperclasses;

import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;


/**
 * @author Shubham Shrivastava
 * @since 04/12/2021
 */

public class NavigationHelper {
	
	private WebDriver driver;
	private Logger logger = LoggerHelper.getLogger(NavigationHelper.class);

	public NavigationHelper(WebDriver driver) {
		this.driver = driver;
		logger.debug("NavigationHelper : " + this.driver.hashCode());
	}
	
	public void navigateTo(String url) {
		logger.info(url);
		driver.get(url);
	}

	public void naviagteTo(URL url) {
		logger.info(url.getPath());
		driver.get(url.getPath());
	}

	public String getTitle() {
		String title = driver.getTitle();
		logger.info(title);
		return driver.getTitle();
	}

	public String getCurrentUrl() {
		String url = driver.getCurrentUrl();
		logger.info(url);
		return driver.getCurrentUrl();
	}
	

}
