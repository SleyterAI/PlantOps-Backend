package com.CV.PlantOps.Users.Controller;

import com.CV.PlantOps.Users.Dto.*;
import com.CV.PlantOps.Users.Enum.Role;
import com.CV.PlantOps.Users.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<MessageResponse> createUser(@Valid @RequestBody UserRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.createUser(request));
    }

    @GetMapping
    /*@PreAuthorize("hasRole('ADMIN')")*/
    public ResponseEntity<List<UserResponse>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }

    @PatchMapping("/{id}/role")
    /*@PreAuthorize("hasRole('ADMIN')")*/
    public ResponseEntity<RolNMessageResponse> updateRole(
            @PathVariable Long id, @RequestBody RoleRequest request) {
        return ResponseEntity.ok(userService.updateRole(id, request.getRole()));
    }

    @DeleteMapping("/{id}")
    /*@PreAuthorize("hasRole('ADMIN')")*/
    public ResponseEntity<MessageResponse> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
