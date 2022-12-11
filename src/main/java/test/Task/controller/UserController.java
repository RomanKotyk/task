package test.Task.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import test.Task.dto.UserDTO;
import test.Task.service.UserServiceImpl;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/{id}")
    public UserDTO getUserBirthday(@PathVariable long id){
        return userService.getUserByID(id);
    }
}
