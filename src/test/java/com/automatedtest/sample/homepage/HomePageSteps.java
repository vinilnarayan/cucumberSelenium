package com.automatedtest.sample.homepage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.junit.Assert;

public class HomePageSteps {


    private HomePage homePage;

    public HomePageSteps() {
        this.homePage = new HomePage();
    }

    @Given("^A user navigates to HomePage$")
    public void aUserNavigatesToHomePage() {
        this.homePage.goToHomePage();
    }
    
    @Then("^Google logo is displayed$")
    public void googleLogoIsDisplayed() {
        this.homePage.checkLogoDisplay();
    }

    @And("^search bar is displayed$")
    public void searchBarIsDisplayed() {
        this.homePage.checkSearchBarDisplay();
    }

    @When("^page title is \"([^\"]*)\"$")
    public void pageTitleIs(String title) {
        String displayedTitle = this.homePage.getTitle();
        Assert.assertTrue("Displayed title is " + displayedTitle + " instead of " + title,
                title.equals(displayedTitle));
    }
    
    @When("^a user searches for \"([^\"]*)\"$")
    public void aUserSearchesFor(String searchValue) {
        this.homePage.searchFor(searchValue);
    }
    
    @Then("^click on \"([^\"]*)\"$")
    public void aUserClick(String clickValue) {
        this.homePage.clickFor(clickValue);
    }

    
    @And("^wait for \"([^\"]*)\" seconds$")
    public void andWait(String waitValue) throws InterruptedException {
        this.homePage.waitFor(waitValue);
    }
    
       
    @Then("^select \"([^\"]*)\" dependants$")
    public void aUserSelect(String selectValue) {
        this.homePage.selectFor(selectValue);
    }
    
    @Then("^enter \"([^\"]*)\" in \"([^\"]*)\"$")
    public void aUserEnter(String data, String enterValue) {
        this.homePage.enterFor(data, enterValue);
    }
    
    @And("^wait for the estimate value \"([^\"]*)\"$")
    public void estimate(String data) {
        this.homePage.compareEstimate(data);
    }
    
    @And("^wait for the warning message \"([^\"]*)\"$")
    public void warningMessage(String data) {
        this.homePage.warningMessage(data);
    }
    
    @Then("^check \"([^\"]*)\" is selected$")
    public void checkSelected(String enterValue) {
        this.homePage.checkSelected(enterValue);
    }
    
    @Then("^check \"([^\"]*)\" is \"([^\"]*)\"$")
    public void checkValue(String data, String value) {
        this.homePage.checkValue(data, value);
    }
}
