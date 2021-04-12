
package helperclasses;

import java.util.LinkedList;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * @author Shubham Shrivastava
 * @since 04/12/2021
 * 
 */
public class BrowserHelper extends GenericHelper {

	private WebDriver driver;
	private Logger logger = LoggerHelper.getLogger(BrowserHelper.class);

	public BrowserHelper(WebDriver driver) {
		super(driver);
		this.driver = driver;
		logger.debug("BrowserHelper : " + this.driver.hashCode());
	}

	public void goBack() {
		driver.navigate().back();
		logger.info("");
	}

	public void goForward() {
		driver.navigate().forward();
		logger.info("");
	}

	public void refresh() {
		driver.navigate().refresh();
		logger.info("");
	}

	public Set<String> getWindowHandlens() {
		logger.info("");
		return driver.getWindowHandles();
	}

	public void SwitchToWindow(int index) {

		LinkedList<String> windowsId = new LinkedList<String>(getWindowHandlens());

		if (index < 0 || index > windowsId.size())
			throw new IllegalArgumentException("Invalid Index : " + index);

		driver.switchTo().window(windowsId.get(index));
		logger.info(index);
	}

	public void switchToParentWindow() {
		LinkedList<String> windowsId = new LinkedList<String>(getWindowHandlens());
		driver.switchTo().window(windowsId.get(0));
		logger.info("");
	}

	public void switchToParentWithChildClose() {
		switchToParentWindow();
		LinkedList<String> windowsId = new LinkedList<String>(getWindowHandlens());
		for (int i = 1; i < windowsId.size(); i++) {
			logger.info(windowsId.get(i));
			driver.switchTo().window(windowsId.get(i));
			driver.close();
		}
		switchToParentWindow();
	}

	public void switchToFrame(By locator) {
		driver.switchTo().frame(getElement(locator));
		logger.info(locator);
	}

	public void switchToFrame(String nameOrId) {
		driver.switchTo().frame(nameOrId);
		logger.info(nameOrId);
	}
}
