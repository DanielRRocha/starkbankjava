package starkbank.setup.API;

import java.time.Instant;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class APIHooks {

	public static ResourceBundle bundle = ResourceBundle.getBundle("project");
	private static Logger logger = LogManager.getLogger(APIHooks.class);

	@Before
	public void startTest(Scenario scenario) {
		logger.info("Starting API test for scenario: " + scenario.getName());
		logger.info("Base URL= " + get_base_Url());
//		starkbank_authorization();
	}

	@After
	public void tearDown(Scenario scenario) {
		logger.info("Finishing API test for scenario: " + scenario.getName());
	}

	public static String get_base_Url() {
		return get_capability("api.env.url");
	}

	public static String get_version() {
		return get_capability("api.env.version");
	}
	
	public static String get_transfer_urn() {
		return get_capability("api.env.transfer");
	}
	
	public static String get_url(String type) {
		
		switch (type) {
		case "transfer": 
			type = get_transfer_urn();
			break;
		default:
			Assert.fail("Type '" + type + "' don't exist");
		}
		
		return get_base_Url() + get_version() + type;
	}

	public static String get_capability(String key) {
		return bundle.getString(key);
	}
	
	public static long convert_from_unix_timestamp()
	{
		return Instant.now().getEpochSecond();
	}
}
