package com.internal.demo.mobile.def;

import com.internal.demo.mobile.step.VehicleShoppingStep;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;

public class Defs {
    @Steps
    VehicleShoppingStep vehicleShoppingStep;

    @Given("^I want to learn language$")
    public void Test() {
        vehicleShoppingStep.testDrive();
    }
}
