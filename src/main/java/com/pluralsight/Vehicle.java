package com.pluralsight;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Vehicle extends Asset{
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, BigDecimal originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }
// region Getters/Setters
    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }
//endregion
    @Override
    public BigDecimal getValue() {
        int currentYear = LocalDateTime.now().getYear();
        int age = currentYear - year;
        BigDecimal value = BigDecimal.ZERO;
        if (age <= 3) {
            BigDecimal valueReduction = getOriginalCost().multiply(new BigDecimal("0.03"));
            value = getOriginalCost().subtract(valueReduction);
        } else if (age <= 6) {
            BigDecimal valueReduction = getOriginalCost().multiply(new BigDecimal("0.06"));
            value = getOriginalCost().subtract(valueReduction);
        } else if (age <= 7 && age <= 10) {
            BigDecimal valueReduction = getOriginalCost().multiply(new BigDecimal("0.08"));
            value = getOriginalCost().subtract(valueReduction);
        } else value = new BigDecimal("1000.00");

        if (this.odometer > 100_000){
            if(!(this.makeModel.contains("Honda") || this.makeModel.contains("Toyata"))){
            }
        }
    return value;
    }

}
