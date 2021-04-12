
package helperclasses;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * @author Shubham Shrivastava
 * @since 04/12/2021
 */
public class JavaScriptHelper {

	private WebDriver driver;
	private Logger logger = LoggerHelper.getLogger(JavaScriptHelper.class);

	public JavaScriptHelper(WebDriver driver) {
		this.driver = driver;
		logger.debug("JavaScriptHelper : " + this.driver.hashCode());
	}

	public Object executeScript(String script) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		logger.info(script);
		return exe.executeScript(script);
	}

	public Object executeScript(String script, Object... args) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		logger.info(script);
		return exe.executeScript(script, args);
	}

	public void scrollToElemet(WebElement element) {
		executeScript("window.scrollTo(arguments[0],arguments[1])",
				element.getLocation().x, element.getLocation().y);
		logger.info(element);
	}

	public void scrollToElemet(By locator) {
		scrollToElemet(driver.findElement(locator));
		logger.info(locator);
	}

	public void scrollToElemetAndClick(By locator) {
		WebElement element = driver.findElement(locator);
		scrollToElemet(element);
		element.click();
		logger.info(locator);
	}

	public void scrollToElemetAndClick(WebElement element) {
		scrollToElemet(element);
		element.click();
		logger.info(element);
	}

	public void scrollIntoView(WebElement element) {
		executeScript("arguments[0].scrollIntoView()", element);
		logger.info(element);
	}

	public void scrollIntoView(By locator) {
		scrollIntoView(driver.findElement(locator));
		logger.info(locator);
	}

	public void scrollIntoViewAndClick(By locator) {
		WebElement element = driver.findElement(locator);
		scrollIntoView(element);
		element.click();
		logger.info(locator);
	}

	public void scrollIntoViewAndClick(WebElement element) {
		scrollIntoView(element);
		element.click();
		logger.info(element);
	}
}
