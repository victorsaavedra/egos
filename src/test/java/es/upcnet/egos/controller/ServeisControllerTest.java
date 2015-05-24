package es.upcnet.egos.controller;

import static org.hamcrest.Matchers.hasProperty;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:webmvc-config-test.xml")
public class ServeisControllerTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void retornar_resposta_200_ok_json_serveis() throws Exception {			
		mockMvc.perform(get("/serveis/json")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk());
	}
	
	@Test
	public void retornar_reposta_200_ok_cerca_serveis() throws Exception {
		mockMvc.perform(get("/serveis").param("nom", "Servei 1"))
				.andExpect(status().isOk());
				
	}
	
	@Test
	public void reposta_cerca_serveis_conte_registre_per_nom() throws Exception {
		mockMvc.perform(get("/serveis").param("nomCerca", "Servei 1"))
				.andExpect(status().isOk())
				.andExpect(model().attribute("serveisForm", hasProperty("registresServeisCataleg")));
	}
}
