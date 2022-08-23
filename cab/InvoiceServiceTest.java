package com.BridgeLabz.cab;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {
	public InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
   

    
    public void setUp() {
    }

	@Test
	 public void givenDistanceTimeReturnFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare((double) distance, (int) time);
        Assert.assertEquals(25.0, fare, 1);
    }
    @Test
    public void givenLessDistanceTimeReturnMinFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare((double) time, (int) distance);
        Assert.assertEquals(10.0, fare, 1);
    }

    @Test
    public void givenMultipleRideReturnTotalFare() {
        Ride[] rides = new Ride[]{new Ride(2.0, 5), new Ride(0.1, 1)};
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedSummary, summary);
    }

}