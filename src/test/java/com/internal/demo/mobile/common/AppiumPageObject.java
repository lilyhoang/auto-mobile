package com.internal.demo.mobile.common;

import com.google.common.base.Predicate;
import com.google.inject.Inject;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AppiumPageObject extends PageObject {
    @Inject
    public AppiumPageObject(final WebDriver driver) {
        super(driver, new Predicate<PageObject>() {
            @Override
            public boolean apply(PageObject page) {
                PageFactory.initElements(new AppiumFieldDecorator(
                        ((WebDriverFacade) page.getDriver()).getProxiedDriver(), page.getImplicitWaitTimeout()), page);
                return true;
            }
        });
    }


}