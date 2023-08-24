package starkbank.setup.API;

import java.time.Instant;
import java.util.Date;
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
	
	
//	public void starkbank_authorization() {
//		// This is only an example of a private key content. You should use your own key.
//		String privateKeyContent = """
//		-----BEGIN EC PARAMETERS-----
//		BgUrgQQACg==
//		-----END EC PARAMETERS-----
//		-----BEGIN EC PRIVATE KEY-----
//		MHQCAQEEIMCwW74H6egQkTiz87WDvLNm7fK/cA+ctA2vg/bbHx3woAcGBSuBBAAK
//		oUQDQgAE0iaeEHEgr3oTbCfh8U2L+r7zoaeOX964xaAnND5jATGpD/tHec6Oe9U1
//		IF16ZoTVt1FzZ8WkYQ3XomRD4HS13A==
//		-----END EC PRIVATE KEY-----
//		""";
//
//		// for project users:
//		Project user = new Project(
//		    "sandbox",
//		    "5656565656565656",
//		    privateKeyContent
//		);
//
////		// or, for organization users:
////		Organization user = new Organization(
////		    "sandbox",
////		    "4545454545454545",
////		    privateKeyContent
////		);
//
//		Settings.user = user;
//	}
	
	
}
