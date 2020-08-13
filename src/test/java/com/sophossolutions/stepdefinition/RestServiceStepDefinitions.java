package com.sophossolutions.stepdefinition;

import com.sophossolutions.exceptions.ExceptionError;
import com.sophossolutions.task.PostMethod;
import com.sophossolutions.utils.MsgError;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class RestServiceStepDefinitions {

    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^Candidate create a user with the post method in \"([^\"]*)\"$")
    public void candidateCreateAUserWithThePostMethodIn(String BaseUrl) {
        theActorCalled("Alejandro").whoCan(CallAnApi.at(BaseUrl));
    }


    @When("^Candidate provide information the post method with \"([^\"]*)\"$")
    public void candidateProvideInformationThePostMethodWith(String endpoint, List<Map<String, String>> datos) {
        theActorInTheSpotlight().attemptsTo(PostMethod.createUser(endpoint, PostMethod.bodyUser(datos.get(0))));
    }

    @Then("^(.*) verify the creation of this user with the get method$")
    public void johanVerifyTheCreationOfThisUserWithTheGetMethod(String actor) {
        theActorInTheSpotlight()
                .should(seeThatResponse(response -> response.body("result.first_name", equalTo(actor)))
                        .orComplainWith(ExceptionError.class, MsgError.MSG_VALUE_ERROR.getMsg()));
    }
}