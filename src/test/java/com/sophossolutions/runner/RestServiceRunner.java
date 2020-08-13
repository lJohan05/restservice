package com.sophossolutions.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/rest_service.feature",
    glue = "com.sophossolutions.stepdefinition",
    snippets = SnippetType.CAMELCASE)
public class RestServiceRunner {
}
