package es.cic.curso25.proy005;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
class Proy005ApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@Test
	void testTelefonoDelete() throws Exception {
		mockMvc
			.perform(delete("/telefono/4")) //.content("{'id': 4}".getbytes("UTF-8"))
			.andDo(print())
			.andExpect(status().isOk())
			.andReturn();
	}
	void contextLoads() {
	}


	@Test
	void testLista() {
		ArrayList miLista = new ArrayList();
		miLista.add("Hola");

		List<String> miSegundaLista = new ArrayList<>(); //esto es notación para abreviar tener que repetir dos veces
														//lo que está entre <>. Es una buena alternativa al casting. Da fallo de
														//compilación cuando no se le mete el mismo tipo que se ha indicado.
		miSegundaLista.add("Mi mensaje");
		String mensajeOriginal = miSegundaLista.get(0);
	}
}
