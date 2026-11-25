package com.CV.PlantOps.Products.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "internal_code", nullable = false, unique = true, length = 60)
    private String internalCode;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "category", length = 80)
    private String category;

    @Column(name = "presentation", length = 80)
    private String presentation;

    @Column(name = "measure_unit", length = 40)
    private String measureUnit;

    @PositiveOrZero
    @Column(name = "days_useful_life")
    private Integer daysUsefulLife;

    @Column(name = "active", nullable = false)
    private Boolean active;
}