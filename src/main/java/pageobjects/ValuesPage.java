
package pageobjects;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import helperclasses.GenericHelper;
import helperclasses.LoggerHelper;
import junit.framework.Assert;
import junit.framework.AssertionFailedError;

/**
 * @author Shubham Shrivastava
 * @since 04/12/2021
 */
public class ValuesPage extends PageBase{
	private WebDriver driver;
	GenericHelper helper = new GenericHelper(driver);
	private final Logger log = LoggerHelper.getLogger(ValuesPage.class);
	
	public ValuesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/** WebElements **/

	@FindBy(how = How.ID, using = "lbl_val_1")
	public WebElement labelValue1;

	@FindBy(how = How.ID, using = "lbl_val_2")
	public WebElement labelValue2;

	@FindBy(how = How.ID, using = "lbl_val_3")
	public WebElement labelValue3;

	@FindBy(how = How.ID, using = "lbl_val_4")
	public WebElement labelValue4;

	@FindBy(how = How.ID, using = "lbl_val_5")
	public WebElement labelValue5;

	@FindBy(how = How.ID, using = "txt_val_1")
	public WebElement textValue1;

	@FindBy(how = How.ID, using = "txt_val_2")
	public WebElement textValue2;

	@FindBy(how = How.ID, using = "txt_val_3")
	public WebElement textValue3;

	@FindBy(how = How.ID, using = "txt_val_4")
	public WebElement textValue4;

	@FindBy(how = How.ID, using = "txt_val_5")
	public WebElement textValue5;

	@FindBy(how = How.ID, using = "txt_ttl_val")
	public WebElement totalBalanceValue;

	@FindBy(how = How.ID, using = "lbl_ttl_val")
	public WebElement totalBalanceLabel;

	String textValues = "//*[contain(@id,'txt_val_')]";
	String labelValues = "//*[contain(@id,'lbl_val_')]";

	/** Region Methods **/
	
	public void countOfValues() {
		List<WebElement> values = helper.getElements(textValues);
		List<WebElement> labels = helper.getElements(labelValues);
		Assert.assertTrue((values.size() == labels.size()));
		log.info("Count of Values is correct");
	}

	public void valuesGreaterThan0() {
		String retrievedText = null;
		List<WebElement> values = helper.getElements(textValues);
		for (WebElement element : values) {
			retrievedText = element.getText();
			double retrieved = Double.parseDouble(retrievedText.replaceAll("[^.a-zA-Z0-9]", ""));
			if (retrieved > 0) {
				log.info(retrievedText + " is greater than 0");
			} else {
				log.error(retrievedText + " is not greater than 0");
				throw new AssertionFailedError();
			}
		}
	}

	public void totalBalanceCorrectToListedValues() {
		String retrievedText = null;
		String totalValue = totalBalanceValue.getText();
		double totalVal = Double.parseDouble(totalValue.replaceAll("[^.a-zA-Z0-9]", ""));
		List<WebElement> values = helper.getElements(textValues);
		for (WebElement element : values) {
			retrievedText = element.getText();
			double retrieved = Double.parseDouble(retrievedText.replaceAll("[^.a-zA-Z0-9]", ""));
			if (totalVal > retrieved) {
				log.info("Total Balance " + totalValue + " is greater than Value" + retrievedText);
			} else {
				log.error("Total Balance " + totalValue + " is not greater than Value" + retrievedText);
				throw new AssertionFailedError();
			}
		}
	}

	public void valuesFormattedAsCurrencyValidation() {
		String retrievedText = null;
		String dollarFormatted = null;
		Locale usa = new Locale("en", "US");
		// Create a formatter given the Locale
		NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(usa);
		List<WebElement> values = helper.getElements(textValues);
		for (WebElement element : values) {
			retrievedText = element.getText();
			dollarFormatted = dollarFormat.format(retrievedText);
			if (dollarFormatted.equals(retrievedText)) {
				log.info(retrievedText + " is in currency format");
			} else {
				log.info(retrievedText + " is not in currency format");
				throw new AssertionFailedError();
			}
		}
	}
	
	public void totalBalanceIsSumOfValues() {
		String retrievedText = null;
		double sum = 0.00;
		List<WebElement> values = helper.getElements(textValues);
		for (WebElement element : values) {
			retrievedText = element.getText();
			double retrieved = Double.parseDouble(retrievedText.replaceAll("[^.a-zA-Z0-9]", ""));
			sum = sum+retrieved;
		}
		String totalValue = totalBalanceValue.getText();
		double totalVal = Double.parseDouble(totalValue.replaceAll("[^.a-zA-Z0-9]", ""));
		if (sum==totalVal) {
			log.info("Total Value is equal to sum of all the values");
		} else {
			log.error("Total Value is not equal to sum of all the values");
			throw new AssertionFailedError();
		}
	}

}
