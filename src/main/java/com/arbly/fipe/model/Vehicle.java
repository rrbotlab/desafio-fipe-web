package com.arbly.fipe.model;

public record Vehicle(
        Integer vehicleType,
        String price,
        String brand,
        String model,
        Integer modelYear,
        String fuel,
        String codeFipe,
        String referenceMonth,
        String fuelAcronym
) {}
