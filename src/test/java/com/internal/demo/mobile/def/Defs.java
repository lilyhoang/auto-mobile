package com.internal.demo.mobile.def;

import com.internal.demo.mobile.step.VehicleShoppingStep;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;

public class Defs {
    @Steps
    VehicleShoppingStep vehicleShoppingStep;

    @Given("^I want to$")
    public void Test() {
        vehicleShoppingStep.testDrive();
    }

//    public static void main(String[] args) {
////        Injector injector = Guice.createInjector(new VehicleShoppingModule());
////        injector.injectMembers(injector.getInstance(VehicleShoppingStep.class));
////         vehicleShoppingStep = injector.getInstance(VehicleShoppingStep.class);
//
//    }
}
