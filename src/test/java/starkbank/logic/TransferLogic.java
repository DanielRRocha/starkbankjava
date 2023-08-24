package starkbank.logic;

import static io.restassured.RestAssured.given;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import starkbank.models.TransfersModel;
import starkbank.setup.API.APIHooks;
import starkbank.steps.TransferSteps;

public class TransferLogic {
	
	private static Logger logger = LogManager.getLogger(TransferSteps.class);
	
	Response resp;
	
	public ValidatableResponse get_list_transfers(String urn, String after_date, String before_date) {
		
		resp = given()
				.header("Access-Time", APIHooks.convert_from_unix_timestamp())
				.queryParam("after", after_date)
				.queryParam("before", before_date)
				.when().get(APIHooks.get_url(urn));
		
		return resp.then(); 
		
	}
	
	public ValidatableResponse post_create_transfers(String urn, TransfersModel transfer){
		resp = given()
				.header("Access-Time", APIHooks.convert_from_unix_timestamp())
				.body(transfer)
				.when()
				.get(APIHooks.get_url(urn));
		
		return resp.then();
	}
	
	public void validate_list_transfer_response(ValidatableResponse response, int status_code, String text) {
		logger.info("Validating status code");
		logger.info("Expected: " + status_code + " ; received: " + resp.getStatusCode());
		response.statusCode(status_code);
		get_response_body(response);
		
		String responseString = response.extract().asString();
		Assert.assertNotNull(responseString);
		logger.info("Response is not null");
		Assert.assertTrue("Response not contains text '" + text + "'", responseString.contains(text));
		logger.info("Response contains text '" + text + "'");
		
	}
	
	public ValidatableResponse get_response_body(ValidatableResponse response) {
		logger.info("Response body:");
		return response.log().body();
	}
}
