package com.CV.PlantOps.Products.Dto;

public record ProductResponse(
        Long id,
        String internalCode,
        String name,
        String category,
        String presentation,
        String measureUnit,
        Integer daysUsefulLife,
        Boolean active
) {}
