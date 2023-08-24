package starkbank.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.ValidatableResponse;
import starkbank.logic.TransferLogic;
import starkbank.setup.API.APIHooks;

public class TransferSteps {
	
	private TransferLogic transferLogic = new TransferLogic();
	private static Logger logger = LogManager.getLogger(TransferSteps.class);
	
	ValidatableResponse response;
	
	@Given("I send a get request to {string} using before date {string} and after date {string}")
	public void i_send_a_get_request_to_using_before_date_and_after_date(String urn, String after_date, String before_date) {
		logger.info("Sending a get request to " + APIHooks.get_url(urn));
		logger.info("Using after date: " + after_date);
		logger.info("Using before date: " + before_date);
		response = transferLogic.get_list_transfers(urn, after_date, before_date);
	}

	@Then("validate the status code {int} and the response contains {string}")
	public void validate_the_status_code_and_the_response_contains(int status_code, String text) {
		logger.info("Validating response");
	    transferLogic.validate_list_transfer_response(response, status_code, text);
	}

}
