package calendApp.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import calendApp.AbstractCalendappWebIntegrationTests;
import calendApp.repository.EventRepository;





@Sql("/test-data.sql")
	public class RestEventControllerTest extends AbstractCalendappWebIntegrationTests {

		@Autowired
		MockMvc mockMvc;

		@Autowired
		EventRepository repo;
		
		@Test
		public void JoinEvent() throws Exception {
			mockMvc.perform(post("/events/111/toggle").contentType(APPLICATION_JSON)//
					.content("1"))//
					.andExpect(status().is2xxSuccessful());
			
			mockMvc.perform(post("/events/111/toggle").contentType(APPLICATION_JSON)//
					.content("1"))//
					.andExpect(status().is2xxSuccessful());
	
		}
	
	
		


	}