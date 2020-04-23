package com.internal.demo.mobile.common;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Duration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CommonPage extends PageObject {

    private static String ANDROID_HOME;

    public String getCurrentActivity() {
        WebDriver facade = getDriver();
        WebDriver driver = ((WebDriverFacade) facade).getProxiedDriver();
        return ((StartsActivity) driver).currentActivity();
    }


    public WebElementFacade getFacadeWithSubString(String coinType, String str1, String str2) {
        // Get the first numeric character of the string as index of element
        String ordinalNumber = StringUtils.substring(coinType, 0, 1);
        String XPath = str1 + ordinalNumber + str2;
        return find(XPath);
    }



    @NotNull
    public WebDriverWait getWebDriverWait(int timeout) {
        return new WebDriverWait(getDriver(), timeout);
    }


    @NotNull
    public WebDriverWait getWebDriverWait(int timeout1, int timeout2) {
        return new WebDriverWait(getDriver(), timeout1, timeout2);
    }



    public void enterToElement(String text, WebElementFacade facade) {
        facade.sendKeys(text);
    }

    public AppiumDriver<AndroidElement> mobileDriver() {
        return (AppiumDriver<AndroidElement>) ((WebDriverFacade) getDriver()).getProxiedDriver();
    }




    public void performEditorActionByJs(String actName) {
        // ActName: The name or an integer code of the editor action to be executed
        ((JavascriptExecutor) getDriver()).executeScript("mobile: performEditorAction", ImmutableMap.of("action", actName));
    }


    public void verifyStringIs(String expectedResult, String actualResult) {
        assertThat(actualResult, is(expectedResult));
    }


    public void verifyElementText(WebElementFacade facade, String expectedResult) {
        String actualResult = facade.getText();
        verifyStringIs(actualResult, expectedResult);
    }

    public void rotateScreen() {
        mobileDriver().rotate(ScreenOrientation.LANDSCAPE);
        waitABit(300);
        mobileDriver().rotate(ScreenOrientation.PORTRAIT);

    }

    public void multiTouch() {
        TouchAction touchActionOne = new TouchAction(mobileDriver());
        touchActionOne.press(PointOption.point(300, 300));
        //touchActionOne.release();
        TouchAction touchActionTwo = new TouchAction(mobileDriver());
        touchActionTwo.press(PointOption.point(500, 500));
        //touchActionTwo.release();
        MultiTouchAction action = new MultiTouchAction(mobileDriver());
        action.add(touchActionOne);
        action.add(touchActionTwo);
        action.perform();
    }

    public void tabOnElement(String xpath) {
        //String xpath = "(//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout)[1]";

        WebElement e = getDriver().findElement(By.xpath(xpath));
        TouchAction touchAction = new TouchAction(mobileDriver());
        touchAction.tap(TapOptions.tapOptions()
                .withElement(ElementOption.element(e)))
                .perform();
    }

    public void tabOnElementWithWait(String xPath) {
        AndroidElement e = mobileDriver().findElementByXPath(xPath);
        TouchAction touchAction = new TouchAction(mobileDriver());
        TapOptions tapOptions = new TapOptions();
        touchAction.tap(tapOptions
                .withElement(element(e)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000)))
                .perform();
    }

    public void tabOnCoordinate(int x, int y) {
        TouchAction touchAction = new TouchAction(mobileDriver());
        touchAction.tap(PointOption.point(1280, 1013))
                //.waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000)))
                .perform();

    }

    public void swipeToRight() {
        int heightOfScreen = mobileDriver().manage().window().getSize().getHeight();
        int widthOfScreen = mobileDriver().manage().window().getSize().getWidth();
        int middleHeightOfScreen = heightOfScreen / 2;
        // To get 50% of width
        int x = (int) (widthOfScreen * 0.5);
        // To get 50% of height
        int y = (int) (heightOfScreen * 0.5);
        TouchAction swipe = new TouchAction(mobileDriver())
                .press(PointOption.point(widthOfScreen / 5, heightOfScreen / 2))
                .waitAction(WaitOptions.waitOptions((Duration.ofMillis(3000))))
                .moveTo(PointOption.point(5 * (widthOfScreen / 6), heightOfScreen / 2))
                .release()
                .perform();
    }

    public void swipeToLeft() {
        int heightOfScreen = mobileDriver().manage().window().getSize().getHeight();
        int widthOfScreen = mobileDriver().manage().window().getSize().getWidth();
        int middleHeightOfScreen = heightOfScreen / 2;
        // To get 50% of width
        int x = (int) (widthOfScreen * 0.5);
        // To get 50% of height
        int y = (int) (heightOfScreen * 0.5);
        TouchAction swipe = new TouchAction(mobileDriver())
                .press(PointOption.point(4 * (widthOfScreen / 5), heightOfScreen / 2))
                .waitAction(WaitOptions.waitOptions((Duration.ofMillis(3000))))
                .moveTo(PointOption.point(0, heightOfScreen / 2))
                .release()
                .perform();
    }

    public void scrollDownByAction() {
        int deviceHeight = getDriver().manage().window().getSize().getHeight();
        int deviceWidth = getDriver().manage().window().getSize().getWidth();

        TouchAction action = new TouchAction(mobileDriver());
        action.longPress(PointOption.point(deviceWidth / 2, deviceHeight / 2))
                .moveTo(PointOption.point(deviceWidth / 2, 0))
                .release()
                .perform();

    }

    public void scrollUpByAction() {
        int deviceHeight = getDriver().manage().window().getSize().getHeight();
        int deviceWidth = getDriver().manage().window().getSize().getWidth();

        TouchAction action = new TouchAction(mobileDriver());
        action.longPress(PointOption.point(deviceWidth / 2, deviceHeight / 4))
                .moveTo(PointOption.point(deviceWidth / 2, deviceHeight / 2))
                .release()
                .perform();

    }

    public void scrollDownToElement(String xpath) {
        String xPathBottonElement = "//*[@contentDescription='Checkpoint']";
        int deviceHeight = getDriver().manage().window().getSize().getHeight();
        int deviceWidth = getDriver().manage().window().getSize().getWidth();

        TouchAction action = new TouchAction(mobileDriver());
        int size = 0;
        size = findAll(By.xpath(xpath)).size();
        while ((size < 1) || (findAll(By.xpath(xPathBottonElement)).size() < 0)) {
            action.longPress(PointOption.point(deviceWidth / 2, deviceHeight / 2))
                    .moveTo(PointOption.point(deviceWidth / 2, deviceHeight / 4))
                    .release()
                    .perform();
            size = findAll(By.xpath(xpath)).size();
        }

    }


    public void scrollDownByADB() {
        int deviceHeight = getDriver().manage().window().getSize().getHeight();
        int deviceWidth = getDriver().manage().window().getSize().getWidth();
        adbCommand("swipe", deviceWidth / 2 + " " + deviceHeight / 2 + " " + deviceWidth / 2 + " " + 0, 1);
    }

    public void adbCommand(String command, String points, int numOfTimes) {
        command = "adb shell input " + command.trim() + " " + points.trim();
        for (int i = 0; i < numOfTimes; i++) {
            executeCommand(command);
        }

    }

    public static String executeCommand(String fullCommand) {

        StringBuffer output = new StringBuffer();
        if (fullCommand.startsWith("adb"))
            fullCommand = fullCommand.replace("adb ", getAndroidHome() + "/platform-tools/adb ");
        Process p;
        try {
            p = Runtime.getRuntime().exec(fullCommand);
            p.waitFor();

            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("execute adb = " + fullCommand + " result = " + output.toString());
        return output.toString().trim();

    }

    public static String getAndroidHome() {
        if (ANDROID_HOME == null) {
            ANDROID_HOME = System.getenv("ANDROID_HOME");
        }

        if (ANDROID_HOME == null)
            throw new RuntimeException(
                    "Failed to find ANDROID_HOME. Make sure you have ANDROID_HOME set as an environment variable!");

        return ANDROID_HOME;
    }
}
