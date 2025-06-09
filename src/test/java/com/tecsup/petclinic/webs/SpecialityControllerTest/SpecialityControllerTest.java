package com.tecsup.petclinic.webs.SpecialityControllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.tecsup.petclinic.dtos.SpecialityDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SpecialityControllerTest {

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


    //private static final ObjectMapper om = new ObjectMapper();

    //@Autowired
    //private MockMvc mockMvc;

    @Test
    public void testUpdateSpecialities() throws Exception {

        String name = "Radiologia";
        String office = "A203";
        int hOpen = 8;
        int hClose = 17;

        SpecialityDTO newSpecialityDTO = new SpecialityDTO();
        newSpecialityDTO.setName(name);
        newSpecialityDTO.setOffice(office);
        newSpecialityDTO.setHOpen(hOpen);
        newSpecialityDTO.setHClose(hClose);

        ResultActions mvcActions = this.mockMvc.perform(post("/specialities")
                        .content(om.writeValueAsString(newSpecialityDTO))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.office").value(office))
                .andExpect(jsonPath("$.hOpen").value(hOpen))
                .andExpect(jsonPath("$.hClose").value(hClose));

        String response = mvcActions.andReturn().getResponse().getContentAsString();
        Integer id = JsonPath.parse(response).read("$.id");


        // UPDATE

        String UPGRATE_NAME = "Neurologia";
        String UPGRATE_OFICCE = "A204";
        int UPGRATE_hOpen = 11;
        int UPGRATE_hClose = 13;

        SpecialityDTO upSpecialTO = new SpecialityDTO();
        upSpecialTO.setId(id);
        upSpecialTO.setName(UPGRATE_NAME);
        upSpecialTO.setOffice(UPGRATE_OFICCE);
        upSpecialTO.setHOpen(UPGRATE_hOpen);
        upSpecialTO.setHClose(UPGRATE_hClose);


        mockMvc.perform(put("/specialities/update/" + id)
                        .content(om.writeValueAsString(upSpecialTO))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    private static final ObjectMapper MAPPER = new ObjectMapper();

    //@Autowired
    //private MockMvc mockMvc;



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
                .andExpect(jsonPath("$.name", is("Cardiology")))
                .andExpect(jsonPath("$.office",is("A203")))
                .andExpect(jsonPath("$.hOpen",is(8)))
                .andExpect(jsonPath("$.hClose",is(17)));
    }
}

