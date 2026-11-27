package com.CV.PlantOps.Users.Entity;

import com.CV.PlantOps.Users.Enum.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 30, nullable = false)
    private String username;

    @Column(unique = true, length = 50, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
    //ADMIN - OPERARIO - CALIDAD

    @Column(nullable = false)
    private Boolean active;
}
