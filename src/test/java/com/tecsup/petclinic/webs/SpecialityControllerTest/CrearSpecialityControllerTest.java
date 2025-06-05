package com.tecsup.petclinic.webs.SpecialityControllerTest;

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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CrearSpecialityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final ObjectMapper om = new ObjectMapper();

    @Test
    public void testCrearSpeciality() throws Exception {

        String name = "Cardiology";
        String office = "A203";
        int hOpen = 8;
        int hClose = 17;

        SpecialityDTO newSpecialityDTO = new SpecialityDTO();
        newSpecialityDTO.setName(name);
        newSpecialityDTO.setOffice(office);
        newSpecialityDTO.setHOpen(hOpen);
        newSpecialityDTO.setHClose(hClose);

        this.mockMvc.perform(post("/specialities")
                        .content(om.writeValueAsString(newSpecialityDTO))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.office").value(office))
                .andExpect(jsonPath("$.hOpen").value(hOpen))
                .andExpect(jsonPath("$.hClose").value(hClose));
    }
}



