package com.CV.PlantOps.Distribution.Entity;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "headquarters_inventory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HeadquartersInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Location warehouse;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "batch_id", nullable = false)
    private Batch batch;

    @PositiveOrZero
    @Column(name = "available_quantity", nullable = false, precision = 14, scale = 3)
    private BigDecimal availableQuantity;

    @PositiveOrZero
    @Column(name = "withheld_quantity", nullable = false, precision = 14, scale = 3)
    private BigDecimal withheldQuantity;

    @Column(name = "update_date", nullable = false)
    private LocalDateTime updateDate;

}
