package com.Drug.Drugs.Controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.Drug.Drugs.models.Drugs;
import com.Drug.Drugs.repository.DrugsRepository;
import com.Drug.Drugs.service.DrugsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;



@SpringBootTest
@AutoConfigureMockMvc
public class DrugControllerTest {

	@MockBean
	DrugsRepository repo;


	@Autowired
    private DrugsService service;

    @Autowired
    private MockMvc mockMvc;


     @Test
 	     void getDetails()
         {
 	     when(repo.findAll()).thenReturn(Stream.of(new Drugs(23,"abcd",50.0, 5, "abc", "healyt", "JK", LocalDate.of(2022, 12, 23)),
 	                                               new Drugs(23,"cbau",50.0, 5, "cba", "healyt", "JK", LocalDate.of(2022, 12, 23)))
 	    		             .collect(Collectors.toList()));
 	     assertEquals(2, service.getAllDetails().size());
 	     }


	  @Test
	 	void addDrug() {

	 	Drugs drugs = new Drugs(23,"abcd",50.0, 5, "abc","healyts", "JK", LocalDate.of(2022, 12, 23));
	 	when(repo.save(drugs)).thenReturn(drugs);
	     Drugs res=service.addNewDrug(drugs);
	 	assertEquals(drugs.getDrugsId(),res.getDrugsId());
	 	}













		/*
		 * @Test public void testSaveDrugsDetails() throws Exception { Drugs drugs2 =
		 * new Drugs(13, "abcs2", 15.0, 5, "Bias", "healyts","JK", LocalDate.of(2022,
		 * 12, 23)); doReturn(drugs2).when(service).saveDrugsDetails(any());
		 *
		 * mockMvc.perform(post("/drugs/") .contentType(MediaType.APPLICATION_JSON)
		 * .content(asJsonString(drugs2))). andExpect(status().isOk()).
		 * andExpect(content(). contentType(MediaType.APPLICATION_JSON))
		 * .andExpect(jsonPath("$.drugsId", is(13))); }
		 */



		/*
		 *
		 * static String asJsonString(final Object obj) { try { return new
		 * ObjectMapper().writeValueAsString(obj); } catch (Exception e) { throw new
		 * RuntimeException(e); } }
		 *
		 *
		 */


	/*
	 * @Test // @DisplayName("GET /Drugs success") public void testGetDetails()
	 * throws Exception { Drugs drugs = new Drugs("1","", 15.0, 5, "Bia",
	 * "healyt","JK", null); Drugs drugs1 = new Drugs("13","abcs2", 15.0, 5, "Bias",
	 * "healyts","JK", null); doReturn(Lists.newArrayList(drugs,
	 * drugs1)).when(service).getAllDetails(); mockMvc.perform(
	 * get("/drugs/list")).andExpect(status().isOk()).andExpect(content().
	 * contentType(MediaType.APPLICATION_JSON)) .andExpect(jsonPath("$",
	 * hasSize(2))); }
	 */
}
