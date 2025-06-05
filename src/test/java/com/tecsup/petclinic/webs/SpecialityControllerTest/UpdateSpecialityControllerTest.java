package com.tecsup.petclinic.webs.SpecialityControllerTest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.tecsup.petclinic.dtos.PetDTO;
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

    public void testUpdatePet() throws Exception {

        String PET_NAME = "Beethoven4";
        int TYPE_ID = 1;
        int OWNER_ID = 1;
        String BIRTH_DATE = "2020-05-20";

        String UP_PET_NAME = "Beethoven5";
        int UP_OWNER_ID = 2;
        int UP_TYPE_ID = 2;

        PetDTO newPetTO = new PetDTO();
        newPetTO.setName(PET_NAME);
        newPetTO.setTypeId(TYPE_ID);
        newPetTO.setOwnerId(OWNER_ID);
        newPetTO.setBirthDate(BIRTH_DATE);

        // CREATE
        ResultActions mvcActions = mockMvc.perform(post("/pets")
                        .content(om.writeValueAsString(newPetTO))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());

        String response = mvcActions.andReturn().getResponse().getContentAsString();
        Integer id = JsonPath.parse(response).read("$.id");

        // UPDATE
        PetDTO upPetTO = new PetDTO();
        upPetTO.setId(id);
        upPetTO.setName(UP_PET_NAME);
        upPetTO.setTypeId(UP_TYPE_ID);
        upPetTO.setOwnerId(UP_OWNER_ID);

        mockMvc.perform(put("/pets/"+id)
                        .content(om.writeValueAsString(upPetTO))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

        // FIND
        mockMvc.perform(get("/pets/" + id))  //
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(id)))
                .andExpect(jsonPath("$.name", is(UP_PET_NAME)))
                .andExpect(jsonPath("$.typeId", is(UP_TYPE_ID)))
                .andExpect(jsonPath("$.ownerId", is(UP_OWNER_ID)));

        // DELETE
        mockMvc.perform(delete("/pets/" + id))
                /*.andDo(print())*/
                .andExpect(status().isOk());
    }

}
