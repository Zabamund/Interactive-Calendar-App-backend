package calendApp;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import calendApp.repository.UserRepository;

@Sql("data.sql")
public class test {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	UserRepository repo;


	@Test
	public void retrieveUser() throws Exception {
		mockMvc.perform(get("/users/1").accept(APPLICATION_JSON));//
			System.out.println(mockMvc.perform(get("/users/1").accept(APPLICATION_JSON)));
				/*.andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))//
				.andExpect(status().isOk())//
				.andExpect(jsonPath("$.id", is(1)))//
				.andExpect(jsonPath("$.firstName", is("John")))//
				.andExpect(jsonPath("$.lastName", is("Smith")))//
				.andExpect(jsonPath("$.username", is(username)))//
				.andExpect(jsonPath("$.email", is("jsmith@example.com")))//
				.andExpect(jsonPath("$.password").doesNotExist())//
				.andExpect(jsonPath("$.roles").doesNotExist())//
				.andExpect(jsonPath("$.tweets").doesNotExist());*/
	}

}
