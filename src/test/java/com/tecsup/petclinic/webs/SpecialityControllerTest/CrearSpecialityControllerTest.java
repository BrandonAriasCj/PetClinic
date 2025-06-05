package com.tecsup.petclinic.webs.SpecialityControllerTest.;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tecsup.petclinic.dtos.SpecialityDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CrearSpecialityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final ObjectMapper om = new ObjectMapper();

    @Test
    public void testCrearSpeciality() throws Exception {
        SpecialityDTO speciality = new SpecialityDTO("Cardiology", "A203", 8, 17);

        mockMvc.perform(post("/specialities")
                        .content(om.writeValueAsString(speciality))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Cardiology"))
                .andExpect(jsonPath("$.office").value("A203"))
                .andExpect(jsonPath("$.hOpen").value(8))
                .andExpect(jsonPath("$.hClose").value(17));
    }
}
