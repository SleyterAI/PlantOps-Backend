package com.CV.PlantOps.Replacements.Entity;

import com.CV.PlantOps.Distribution.Entity.Batch;
import com.CV.PlantOps.Distribution.Entity.DetailDispatch;
import com.CV.PlantOps.Distribution.Entity.Location;
import jakarta.validation.constraints.Positive;
import lombok.*;
import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "replacement_claims")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReplacementClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Generated(event = EventType.INSERT)
    @Column(name = "claim_code", nullable = false, unique = true, length = 60, insertable = false, updatable = false)
    private String claimCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dispatch_id")
    private DetailDispatch dispatch;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "batch_id", nullable = false)
    private Batch batch;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "headquarter_id", nullable = false)
    private Location headquarter;

    @Column(name = "incident_type", nullable = false, length = 80)
    private String incidentType;

    @Positive
    @Column(name = "affected_quantity", nullable = false, precision = 14, scale = 3)
    private BigDecimal affectedQuantity;

    @Column(name = "status", nullable = false, length = 50)
    private String status;

    @Column(name = "authorized_by", length = 120)
    private String authorizedBy;

    @Column(name = "authorization_date")
    private LocalDateTime authorizationDate;
}
