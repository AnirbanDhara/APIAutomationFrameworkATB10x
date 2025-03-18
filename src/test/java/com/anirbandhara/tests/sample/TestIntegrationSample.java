package com.anirbandhara.tests.sample;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestIntegrationSample {
    // Create a Booking
    // Verify the Get Booking
    // Update the Booking
    // Delete Booking

    @Test(groups = "qa", priority = 1)
    @Owner("Anirban")
    @Description("TCINT1 - Step 1.Verify that Booking can created")
    public void testCreateBooking()
    {
        Assert.assertTrue(true);
    }

    @Test(groups = "qa", priority = 2)
    @Owner("Anirban")
    @Description("TCINT2 - Step 2.Verify that Booking get By Id")
    public void testGetBooking()
    {
        Assert.assertTrue(true);
    }

    @Test(groups = "qa", priority = 3)
    @Owner("Anirban")
    @Description("TCINT3 - Step 3.Verify that Booking can updated")
    public void testUpdateBooking()
    {
        Assert.assertTrue(true);
    }

    @Test(groups = "qa", priority = 4)
    @Owner("Anirban")
    @Description("TCINT4 - Step 4. Verify that Booking can deleted")
    public void testDeleteBooking()
    {
        Assert.assertTrue(true);
    }
}
