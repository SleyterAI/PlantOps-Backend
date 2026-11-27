package com.CV.PlantOps.Distribution.Entity;

import com.CV.PlantOps.Distribution.Enum.DispatchStatus;
import lombok.*;
import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.time.LocalDateTime;

@Entity
@Table(name = "detail_dispatch")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailDispatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Generated(event = EventType.INSERT)
    @Column(name = "dispatch_code", nullable = false, unique = true, length = 60, insertable = false, updatable = false)
    private String dispatchCode;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "origin_headquarter_id", nullable = false)
    private Location originHeadquarter;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "destination_headquarter_id", nullable = false)
    private Location destinationHeadquarter;

    @Column(name = "departure_date")
    private LocalDateTime departureDate;

    @Column(name = "estimated_arrival_date")
    private LocalDateTime estimatedArrivalDate;

    @Column(name = "reception_date")
    private LocalDateTime receptionDate;

    @Column(name = "status", nullable = false, length = 50)
    private DispatchStatus status;

    @Column(name = "is_replacement", nullable = false)
    private Boolean isReplacement;
}
