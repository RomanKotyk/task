package test.Task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import test.Task.dto.UserDTO;
import test.Task.entity.Account;
import test.Task.repository.AccountRepository;
import test.Task.service.UserServiceImpl;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


@SpringBootTest
class UserServiceTests {
	@Mock
	private AccountRepository accountRepository;

	@InjectMocks
	private UserServiceImpl userService;
	@Test
	void testCalculateAgeTrue() {
		LocalDate date = LocalDate.parse("2000-06-10");
		int age = userService.calculateAge(date);
		assertEquals(22, age);

	}

	@Test
	void testGetUserById() {
		Account account = new Account();
		account.setId(1);
		account.setSurname("Kotyk");
		account.setName("Roman");
		account.setBirthday(LocalDate.parse("2004-02-17"));

		UserDTO userResult = new UserDTO();

		given(accountRepository.findById(account.getId())).willReturn(Optional.of(account));

		userResult = userService.getUserByID(account.getId());
		verify(accountRepository).findById(account.getId());

		Assertions.assertEquals("Kotyk",userResult.getSurname());
		Assertions.assertEquals("Roman",userResult.getName());
		Assertions.assertEquals(18,userResult.getAge());
	}

}
