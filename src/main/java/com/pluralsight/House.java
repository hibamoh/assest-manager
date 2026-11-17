package com.pluralsight;

import java.math.BigDecimal;

public class House extends Asset{

    private String address;
    private int condition;
    private int squareFoot;
    private int lotSize;

    public House(String description, String dateAcquired, BigDecimal originalCost, String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    @Override
    public BigDecimal getValue(){
        BigDecimal valuePerSqFt = BigDecimal.ZERO;
        switch (condition){
            case 1 -> valuePerSqFt = new BigDecimal("180.00");
            case 2 -> valuePerSqFt = new BigDecimal("130.00");
            case 3 -> valuePerSqFt = new BigDecimal("90.00");
            case 4  -> valuePerSqFt = new BigDecimal("80.00");
            default -> System.out.println("please choose a number 1-4 to describe the quality" +
                    "the house");
        }

        BigDecimal sqFtLotSize = new BigDecimal("0.25");
        BigDecimal totalValue = valuePerSqFt.multiply(BigDecimal.valueOf(squareFoot)).add(sqFtLotSize.multiply(BigDecimal.valueOf(squareFoot)));

        return totalValue;
    }
}
