
package helperclasses;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * @author Shubham Shrivastava
 * @since 04/12/2021
 */
public class TextBoxHelper extends GenericHelper {

	private WebDriver driver;
	private Logger logger = LoggerHelper.getLogger(TextBoxHelper.class);
	
	public TextBoxHelper(WebDriver driver) {
		super(driver);
		this.driver = driver;
		logger.debug("TextBoxHelper : " + this.driver.hashCode());
	}
	
	public void sendKeys(By locator,String value) {
		logger.info("Locator : " + locator + " Value : " + value);
		getElement(locator).sendKeys(value);
	}
	
	public void clear(By locator) {
		logger.info("Locator : " + locator);
		getElement(locator).clear();
	}
	
	public String getText(By locator) {
		logger.info("Locator : " + locator);
		return getElement(locator).getText();
	}
	
	public void clearAndSendKeys(By locator,String value) {
		WebElement element =  getElement(locator);
		element.clear();
		element.sendKeys(value);
		logger.info("Locator : " + locator + " Value : " + value);
	}

}
