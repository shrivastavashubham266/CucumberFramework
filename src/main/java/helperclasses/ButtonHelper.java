package helperclasses;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Shubham Shrivastava
 * @since 04/12/2021
 */
public class ButtonHelper {

	private WebDriver driver;
	private Logger logger = LoggerHelper.getLogger(ButtonHelper.class);

	public ButtonHelper(WebDriver driver) {
		this.driver = driver;
		logger.debug("Button Helper : " + this.driver.hashCode());
	}

	public void click(By locator) {
		click(driver.findElement(locator));
		logger.info(locator);
	}

	public void click(WebElement element) {
		element.click();
		logger.info(element);
	}
}
