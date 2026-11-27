package com.CV.PlantOps.Users.Service;

import com.CV.PlantOps.Users.Dto.MessageResponse;
import com.CV.PlantOps.Users.Dto.RolNMessageResponse;
import com.CV.PlantOps.Users.Dto.UserRequest;
import com.CV.PlantOps.Users.Dto.UserResponse;
import com.CV.PlantOps.Users.Enum.Role;
import com.CV.PlantOps.Users.Repository.UserRepository;
import com.CV.PlantOps.GlobalException.DuplicateResourceException;
import com.CV.PlantOps.Users.Entity.User;
import com.CV.PlantOps.Users.Service.Interface.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public MessageResponse createUser(UserRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException("Email already exists");
        }
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new DuplicateResourceException("Username already exists");
        }
        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.OPERARIO)
                .active(true)
                .build();
        userRepository.saveAndFlush(user);
        return new MessageResponse("User created correctly");
    }

    @Override
    public List<UserResponse> getAllUser() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserResponse(
                        user.getId(),
                        user.getUsername(),
                        user.getEmail(),
                        user.getRole(),
                        user.getActive()
                ))
                .toList();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public User updateUser(Long id, UserRequest request) {
        return null;
    }

    @Override
    public MessageResponse deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User doesnt exist");
        }
        userRepository.deleteById(id);
        return new MessageResponse("User deleted correctly");
    }

    public RolNMessageResponse updateRole(Long id, Role role) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User doesnt exist"));

        user.setRole(role);
        User newUser = userRepository.save(user);
        return new RolNMessageResponse("User promoted correctly: ", newUser.getRole());
    }
}
