package com.CV.PlantOps.Users.Dto;

import com.CV.PlantOps.Users.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RolNMessageResponse {

    private String message;
    private Role role;
}
