package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageobjects.ValuesPage;
import settings.ObjectRepo;

public class Problem1 {

	private ValuesPage valuePage;
	
	@Given("^: User is on Values Page$")
	public void user_is_on_Values_Page() throws Throwable {
		ObjectRepo.driver.get(ObjectRepo.reader.getWebsite());
		valuePage = new ValuesPage(ObjectRepo.driver);
	}

	@Then("^: Right count of values appear on screen$")
	public void right_count_of_values_appear_on_screen() throws Throwable {
		valuePage.countOfValues();
	}

	@And("^: Verify the values on the screen are greater than 0$")
	public void verify_the_values_on_the_screen_are_greater_than_0() throws Throwable {
		valuePage.valuesGreaterThan0();
	}

	@And("^: Verify the total balance is correct based on the values listed on the screen$")
	public void verify_the_total_balance_is_correct_based_on_the_values_listed_on_the_screen() throws Throwable {
		valuePage.totalBalanceCorrectToListedValues();
	}
	
	@And("^: Verify the values are formatted as currencies$")
	public void verify_the_values_are_formatted_as_currencies() throws Throwable {
		valuePage.valuesFormattedAsCurrencyValidation();
	}
	
	@And("^: Verify the total balance matches the sum of the values$")
	public void verify_the_total_balance_matches_the_sum_of_the_values() throws Throwable {
		valuePage.totalBalanceIsSumOfValues();
	}

}
