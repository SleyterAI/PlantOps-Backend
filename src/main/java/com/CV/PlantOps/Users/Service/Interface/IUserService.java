package com.CV.PlantOps.Users.Service.Interface;

import com.CV.PlantOps.Users.Dto.UserRequest;
import com.CV.PlantOps.Users.Dto.UserResponse;
import com.CV.PlantOps.Users.Entity.User;
import com.CV.PlantOps.Users.Dto.MessageResponse;
import java.util.List;

public interface IUserService {
    //Create
    MessageResponse createUser(UserRequest request);

    //Read
    List<UserResponse> getAllUser();
    User getUserById(Long id);

    //Update
    User updateUser(Long id, UserRequest request);

    //Delete
    MessageResponse deleteUser(Long id);
}
