package com.internal.demo.mobile.page;

import com.internal.demo.mobile.common.CommonPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.PageFactory;

public class Bike extends CommonPage implements Vehicle {
    @AndroidFindBy(id = "com.duolingo:id/introFlowLoginButton")
    private WebElementFacade btnHaveAccount;

    public Bike(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @Override
    public void drive() {
        System.out.println("I am in Car implementation of vehicle");
        btnHaveAccount.click();

    }
}
