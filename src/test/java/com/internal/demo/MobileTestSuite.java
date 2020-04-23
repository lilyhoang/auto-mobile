package com.internal.demo;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static com.internal.demo.mobile.utils.AppiumServerController.startAppiumServer;
import static com.internal.demo.mobile.utils.AppiumServerController.stopAppiumServer;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features", tags = "@Test")
public class MobileTestSuite {
    @BeforeClass
    public static void startAppium() {
        startAppiumServer();


    }

    @AfterClass
    public static void stopAppium() {
        stopAppiumServer();
    }


}
