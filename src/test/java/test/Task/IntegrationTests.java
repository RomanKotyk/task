package test.Task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import test.Task.repository.AccountRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.MOCK,
		classes = TaskApplication.class)
@AutoConfigureMockMvc
class IntegrationTests {
	@Autowired
	private MockMvc mvc;

	@Autowired
	private AccountRepository repository;
	@Test
	void getUserById() throws Exception {
		mvc.perform(get("/100")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

}
