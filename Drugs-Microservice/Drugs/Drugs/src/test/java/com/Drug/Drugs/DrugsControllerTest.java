package com.Drug.Drugs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.Drug.Drugs.controller.DrugsController;
import com.Drug.Drugs.models.Drugs;
import com.Drug.Drugs.repository.DrugsRepository;
import com.Drug.Drugs.service.DrugsService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class DrugsControllerTest {
    @MockBean
    private DrugsService service;
    @Autowired
    DrugsController controller;
    @MockBean
    DrugsRepository repository;



    Drugs drug;
    List<Drugs> drugs;



    @Test
    public void testGetDetails() throws Exception {
        drugs = new ArrayList<Drugs>();
        drugs.add(new Drugs(1, "abcs", 15.0, 2,"qfujfxjxw","cfrdjxuhj","ygrtytu", LocalDate.of(2022, 02, 01)));
        when(service.getAllDetails()).thenReturn(drugs);
        assertEquals(1, controller.getDetails().size());
    }



    @Test
    public void testSaveDrugsDetails() throws Exception {
        drug = new Drugs(1, "abcs", 15.0, 2,"dfuhscd","uryhjh","syfryy", LocalDate.of(2022, 02, 01));
        when(service.addNewDrug(drug)).thenReturn(drug);
        assertEquals(drug, controller.addDrug(drug).getBody());
    }



    @Test
    public void throwsgetByDrugsIdCustomException() {
        drug = new Drugs(1, "bcd", 23.0, 1,"rytuyyu","rtuyhjdty","ghvetrygh", LocalDate.of(2022, 02, 01));
        int drugId = 1;
        if (repository.existsById(drugId)) {
            return;
        } else {
            assertThat(String.format("ID NOT FOUND " + drugId));
        }
    }



    private void assertThat(String format) {
		// TODO Auto-generated method stub

	}



	@Test
    public void throwsUpdateDrugsDetailsCustomException() {
        drug = new Drugs(1, "bcd", 23.0, 1,"xruytigsrt","trytuyhsyujf","utf", LocalDate.of(2022, 02, 01));



        if (repository.save(drug) != null) {
            return;
        } else {
            assertThat(String.format("ID NOT FOUND " + drug));
        }
    }



    @Test
    public void throwsDeleteDrugsCustomException() {
        drug = new Drugs(1, "bcd", 23.0, 1,"rturty","5uyg","rtgh7tugh", LocalDate.of(2022, 02, 01));
        int drugId = 1;
        if (repository.existsById(drugId)) {
            repository.deleteById(drugId);
            return;
        }
        else
        {
            assertThat(String.format("ID NOT FOUND " + drugId));
         }
    }

    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    }



