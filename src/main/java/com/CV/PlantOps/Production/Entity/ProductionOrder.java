package com.CV.PlantOps.Production.Entity;

import com.CV.PlantOps.Products.Entity.Product;
import com.CV.PlantOps.Users.Entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "production_orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductionOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User operator;

    @Column(name = "order_number", nullable = false, unique = true, length = 60)
    private String orderNumber;

    @PositiveOrZero
    @Column(name = "planned_quantity", nullable = false, precision = 14, scale = 3)
    private BigDecimal plannedQuantity;

    @PositiveOrZero
    @Column(name = "produced_quantity", nullable = false, precision = 14, scale = 3)
    private BigDecimal producedQuantity;

    @Column(name = "production_date")
    private LocalDateTime productionDate;
}
