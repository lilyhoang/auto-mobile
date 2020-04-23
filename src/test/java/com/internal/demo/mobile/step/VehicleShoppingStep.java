package com.internal.demo.mobile.step;

import com.internal.demo.mobile.page.Vehicle;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class VehicleShoppingStep extends ScenarioSteps {
    Vehicle vehicle;

    @Step
    public void testDrive() {
        vehicle.drive();
    }
}
