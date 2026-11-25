package com.CV.PlantOps.Distribution.Entity;

import com.CV.PlantOps.Distribution.Enum.QualityStatus;
import com.CV.PlantOps.Production.Entity.ProductionOrder;
import com.CV.PlantOps.Products.Entity.Product;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "batch")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "production_order_id")
    private ProductionOrder productionOrder;

    @Column(name = "batch_code", nullable = false, unique = true, length = 80)
    private String batchCode;

    @PositiveOrZero
    @Column(name = "initial_quantity", nullable = false, precision = 14, scale = 3)
    private BigDecimal initialQuantity;

    @Column(name = "manufacture_date")
    private LocalDateTime manufactureDate;

    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    @Column(name = "quality_status", length = 50)
    private QualityStatus status;
}
