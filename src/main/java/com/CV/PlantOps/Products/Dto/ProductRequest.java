package com.CV.PlantOps.Products.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record ProductRequest(
        @NotBlank @Size(max = 150) String name,
        @Size(max = 80) String category,
        @Size(max = 80) String presentation,
        @Size(max = 40) String measureUnit,
        @PositiveOrZero Integer daysUsefulLife,
        @NotNull Boolean active
) {}
