package com.tecsup.petclinic.webs.SpecialityControllerTest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.tecsup.petclinic.dtos.SpecialityDTO;
import lombok.extern.slf4j.Slf4j;
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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 *
 */
@AutoConfigureMockMvc
@SpringBootTest
@Slf4j
public class UpdateSpecialityControllerTest {

    private static final ObjectMapper om = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    public void testUpdateSpecialities() throws Exception {

        int ID = 15;
        String NAME = "Carlos";

        String OFICCE = "Cardiologia";
        int hOpen = 11;
        int hClose = 13;


        String UPGRATE_NAME = "Sebas";

        String UPGRATE_OFICCE = "Neurologia";
        int UPGRATE_hOpen = 11;
        int UPGRATE_hClose = 13;

        SpecialityDTO newSpecialTO = new SpecialityDTO();
        newSpecialTO.setName(NAME);
        newSpecialTO.setOffice(OFICCE);
        newSpecialTO.setHOpen(hOpen);
        newSpecialTO.setHClose(hClose);

        // CREATE
        ResultActions mvcActions = mockMvc.perform(post("/specialities")
                        .content(om.writeValueAsString(newSpecialTO))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());

        String response = mvcActions.andReturn().getResponse().getContentAsString();
        Integer id = JsonPath.parse(response).read("$.id");

        // UPDATE
        SpecialityDTO upSpecialTO = new SpecialityDTO();
        upSpecialTO.setId(id);
        upSpecialTO.setName(UPGRATE_NAME);
        upSpecialTO.setOffice(UPGRATE_OFICCE);
        upSpecialTO.setHOpen(UPGRATE_hOpen);
        upSpecialTO.setHClose(UPGRATE_hClose);


        mockMvc.perform(put("/specialities/"+id)
                        .content(om.writeValueAsString(upSpecialTO))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

        // FIND
        mockMvc.perform(get("/specialities/" + id))  //
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(id)))
                .andExpect(jsonPath("$.name", is(UPGRATE_NAME)))
                .andExpect(jsonPath("$.office", is(UPGRATE_OFICCE)))
                .andExpect(jsonPath("$.hopen", is(UPGRATE_hOpen)))
                .andExpect(jsonPath("$.hclose", is(UPGRATE_hClose)));

        // DELETE
        mockMvc.perform(delete("/specialities/" + id))
                /*.andDo(print())*/
                .andExpect(status().isOk());
    }

}
