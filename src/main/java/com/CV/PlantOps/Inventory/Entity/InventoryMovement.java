package com.CV.PlantOps.Inventory.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.CV.PlantOps.Distribution.Entity.Batch;
import com.CV.PlantOps.Distribution.Entity.Location;
import com.CV.PlantOps.Inventory.Enum.MovementType;
import com.CV.PlantOps.Users.Entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "inventory_movements")
@Getter
@Setter
public class InventoryMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "batch_id", nullable = false)
    private Batch batch;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "origin_warehouse_id")
    private Location originWarehouse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_warehouse_id")
    private Location destinationWarehouse;

    @Column(name = "type", nullable = false, length = 50)
    private MovementType type; //ENTRADA - SALIDA

    @Column(name = "quantity", nullable = false, precision = 14, scale = 3)
    private BigDecimal quantity;

    @Column(name = "reference_id")
    private Long referenceId;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;
}
