package com.automatedtest.sample.homepage;

import com.automatedtest.sample.basepage.BasePage;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class HomePage extends BasePage{

    private static final String HOME_PAGE_URL = "https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/";

    @FindBy(css = "#hplogo")
    private WebElement logo;

    @FindBy(css = "input[name=q]")
    private WebElement searchInput;
    
    @FindBy(xpath = "//*[@for='application_type_joint']//parent::li")
    private WebElement joint;
    
    @FindBy(xpath = "//*[@for='application_type_single']//parent::li")
    private WebElement single;
    
    @FindBy(xpath = "//*[@for='borrow_type_home']//parent::li")
    private WebElement borrowTypeHome;
    
    @FindBy(xpath = "//*[@for='borrow_type_investment']//parent::li")
    private WebElement borrowTypeInvestment;
    
    @FindBy(xpath = "//*[@title='Number of dependants']")
    private WebElement dependants;
    
    @FindBy(xpath = "//*[@id=\"q1q1\"]")
    private WebElement applicationType;

    @FindBy(xpath = "//*[@id=\"btnBorrowCalculater\"]")
    private WebElement btnBorrowCalculater;
    
    @FindBy(xpath = "//*[@id=\"borrowResultTextAmount\"]")
    private WebElement estimate;
    
    @FindBy(xpath = "//*[@class=\"result__restart\"]/button")
    private WebElement startOver;
    
    @FindBy(xpath = "//*[@class='borrow__error__text']")
    private WebElement warningMSG;

    HomePage() {
        PageFactory.initElements(driver, this);
    }

    void goToHomePage(){
        driver.get(HOME_PAGE_URL);
        wait.forLoading(5);
    }

    void checkLogoDisplay() {
        wait.forElementToBeDisplayed(5, this.logo, "Logo");
    }

    String getTitle() {
        return driver.getTitle();
    }

    void checkSearchBarDisplay() {
        wait.forElementToBeDisplayed(10, this.searchInput, "Search Bar");
    }

    void searchFor(String searchValue) {
        this.searchInput.sendKeys(searchValue);
        this.searchInput.sendKeys(Keys.ENTER);
    }
    void clickFor(String clickValue) {
        if(clickValue.equalsIgnoreCase("Single")) {
        	this.single.click();        	
        }
        else if(clickValue.equalsIgnoreCase("Joint")){
        	this.joint.click();
    }
        else if(clickValue.equalsIgnoreCase("Home to live in")){
        	this.borrowTypeHome.click();
    }
        else if(clickValue.equalsIgnoreCase("Residential investment")){
        	this.borrowTypeInvestment.click();
    }
        else if(clickValue.equalsIgnoreCase("Work out how much I could borrow")){
        	this.btnBorrowCalculater.click();
    }
        else if(clickValue.equalsIgnoreCase("start over")){
        	this.startOver.click();
    }
   }
    void waitFor(String waitValue) throws InterruptedException {
        int timeValue=Integer.parseInt(waitValue);
        driver.manage().timeouts().implicitlyWait(timeValue, TimeUnit.SECONDS);
        Thread.sleep(timeValue*1000);
    }
    void waitForminuts(String waitValue) {
        int timeValue=Integer.parseInt(waitValue);
        driver.manage().timeouts().implicitlyWait(timeValue, TimeUnit.MINUTES);
    }
    void selectFor(String selectValue) {
        int ddlValue=Integer.parseInt(selectValue);
        Select dropdown = new Select(dependants); 
        dropdown.selectByVisibleText(selectValue);
        
    }
    void enterFor(String data, String selectValue) {
    	WebElement element = driver.findElement(By.xpath("//label[contains(text(),'"+selectValue+"')]//parent::div//child::input"));
    	element.sendKeys(data);
        
    }
    
    void compareEstimate(String data) {
    	String amount = this.estimate.getText();
    	String expectedAmount='$'+data;
    	Assert.assertEquals(expectedAmount, amount);
    }
    
    void warningMessage(String data) {
    	String actual = this.warningMSG.getText();
    	String expectedAmount=data;
    	Assert.assertEquals(expectedAmount,actual);
        
    }
    
    void checkSelected(String clickValue) {
    	String val = null;
        if(clickValue.equalsIgnoreCase("Single")) {
        	val = this.single.getAttribute("class");
        }
        else if(clickValue.equalsIgnoreCase("Joint")){
        	val = this.joint.getAttribute("class");
        }
        else if(clickValue.equalsIgnoreCase("Home to live in")){
        	val = this.borrowTypeHome.getAttribute("class");
        }
        else if(clickValue.equalsIgnoreCase("Residential investment")){
        	val = this.borrowTypeInvestment.getAttribute("class");
        }
        
        Assert.assertEquals("selected", val);
    }
    
    void checkValue(String data, String value) {
    	String val= driver.findElement(By.xpath("//label[contains(text(),'"+data+"')]//parent::div//child::input")).getText();
    	System.out.println(val);
    	Assert.assertEquals(value, val);
        
    }
}