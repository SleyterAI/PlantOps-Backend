package com.CV.PlantOps.Distribution.Entity;

import com.CV.PlantOps.Distribution.Enum.LocationType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.math.BigDecimal;

@Entity
@Table(name = "locations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Generated(event = EventType.INSERT)
    @Column(name = "location_code", nullable = false, unique = true, length = 60, insertable = false, updatable = false)
    private String locationCode;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "address", length = 250)
    private String address;

    @Column(name = "latitude", precision = 10, scale = 7)
    private BigDecimal latitude;

    @Column(name = "longitude", precision = 10, scale = 7)
    private BigDecimal longitude;

    @Column(name = "responsible", length = 120)
    private String responsible;

    @Column(name = "type", length = 50)
    private LocationType type; //HEAD - WARE

    @Column(name = "active", nullable = false)
    private Boolean active;
}
