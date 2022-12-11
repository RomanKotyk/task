package test.Task.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import test.Task.dto.UserDTO;
import test.Task.entity.Account;
import test.Task.repository.AccountRepository;
import test.Task.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/{id}")
    public UserDTO getUserBirthday(@PathVariable long id){
        return userService.getUserByID(id);
    }

    @GetMapping("/all")
    public List<Account> get(){
        List<Account> accountList = new ArrayList<>();
        accountRepository.findAll().forEach(a -> accountList.add(a));
        return accountList;
    }
}
