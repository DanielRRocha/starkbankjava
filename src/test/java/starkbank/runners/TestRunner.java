package starkbank.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import io.qameta.allure.Epic;

@RunWith(Cucumber.class)
@CucumberOptions(
		features	=	{"src/test/resources/features"},
		glue		=	{"starkbank.steps", "starkbank.setup.API"},
		snippets	=	SnippetType.UNDERSCORE,
		tags		=	{"@ListTransfer"})
@Epic("TestRunner")
public class TestRunner {

}
