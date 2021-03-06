package com.internal.demo.mobile.page;

import com.internal.demo.mobile.common.CommonPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class Bike extends CommonPage implements Vehicle {
    @AndroidFindBy(id = "com.duolingo:id/introFlowLoginButton")
    private WebElementFacade btnHaveAccount;


    @Override
    public void drive() {
        System.out.println("I am in Car implementation of vehicle");
        btnHaveAccount.click();

    }
}
