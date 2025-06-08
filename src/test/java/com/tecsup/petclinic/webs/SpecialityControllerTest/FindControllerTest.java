package com.tecsup.petclinic.webs.SpecialityControllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerTest {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findAll() throws Exception {
        int buscarid = 1;

        this.mockMvc.perform(get("/specialities"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$[0].id", is(buscarid)));
    }

    @Test
    public void findSpecialty() throws Exception {
        int specialtyId = 1;

        this.mockMvc.perform(get("/specialities/1"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(specialtyId)))
                .andExpect(jsonPath("$.name", is("radiology")))
                .andExpect(jsonPath("$.office",is("Farewell")))
                .andExpect(jsonPath("$.hOpen",is(8)))
                .andExpect(jsonPath("$.hClose",is(18)));
    }
}
