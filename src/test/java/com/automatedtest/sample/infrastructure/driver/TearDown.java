package com.automatedtest.sample.infrastructure.driver;

import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TearDown {

    private WebDriver driver;

    public TearDown() {
        this.driver = Setup.driver;
    }

    @After
    public void quitDriver(){

        this.driver.quit();
    }

}
