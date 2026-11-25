package com.CV.PlantOps.Quality.Entity;

import com.CV.PlantOps.Distribution.Entity.Batch;
import com.CV.PlantOps.Users.Entity.User;
import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "quality_inspection")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QualityInspection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "batch_id", nullable = false)
    private Batch batch;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User inspector;

    @Column(name = "inspection_date", nullable = false)
    private LocalDateTime inspectionDate;

    @Column(name = "result", nullable = false, length = 50)
    private String result;

    @Column(name = "observations", length = 1000)
    private String observations;

    @Column(name = "url_evidence", length = 500)
    private String urlEvidence;
}
