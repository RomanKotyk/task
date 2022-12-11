package test.Task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.Task.dto.UserDTO;
import test.Task.entity.Account;
import test.Task.repository.AccountRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private AccountRepository accountRepository;
    public UserDTO getUserByID(long id){
        Optional<Account> account;
        account = accountRepository.findById(id);
        String name = account.get().getName();
        String surname = account.get().getSurname();
        LocalDate date = account.get().getBirthday();
        int age = calculateAge(date);
        UserDTO userDTO  = new UserDTO();
        userDTO.setName(name);
        userDTO.setSurname(surname);
        userDTO.setAge(age);
        return userDTO;
    }

    /***
     *
     * @param date
     * @return age of the person
     */
    public int calculateAge(LocalDate date){
        int age;
        LocalDateTime now = LocalDateTime.now();
        age = now.getYear() - date.getYear();
        if (now.getMonthValue() == date.getMonthValue()){
            if (now.getDayOfMonth() < date.getDayOfMonth()) --age;
        }
        if (now.getMonthValue() < date.getMonthValue()) --age;
        return age;
    }
}
