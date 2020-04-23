package com.internal.demo.mobile.utils;


import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import static io.appium.java_client.service.local.AppiumDriverLocalService.buildService;

public class AppiumServerController {
    private final static AppiumDriverLocalService service;


    static {
        System.out.println("Print Default Data");
        service = buildService(new AppiumServiceBuilder().withIPAddress("0.0.0.0").usingPort(Integer.parseInt("4723")));
    }


    public static void startAppiumServer() {
        try {
            service.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void stopAppiumServer() {
        try {
            if (service.isRunning()) {
                service.stop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
