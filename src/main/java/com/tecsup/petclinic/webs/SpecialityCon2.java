package com.tecsup.petclinic.webs;

import com.tecsup.petclinic.dtos.SpecialityDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tecsup.petclinic.entities.Speciality;
import com.tecsup.petclinic.exception.SpecialityNotFoundException;

import com.tecsup.petclinic.services.SpecialtiesService;

import java.util.List;

/**
 *
 * @author jgomezm
 *
 */
@RestController
@Slf4j
public class SpecialityCon2 {

    String name = null;


    /**
     * Update and create pet
     *
     * @param petTO
     * @param id
     * @return
     */
    @PutMapping(value = "/pets/{id}")
    ResponseEntity<SpecialityDTO>  update(@RequestBody SpecialityDTO petTO, @PathVariable Integer id) {

        SpecialityDTO updatePetTO = null;

        try {

            Speciality updatePet = SpecialtiesService.findById(id);

            updatePet.setName(petTO.getName());
            updatePet.setOffice(petTO.getOffice());
            updatePet.sethOpen(petTO.getHOpen());
            updatePet.sethOpen(petTO.getHClose());

            SpecialtiesService.update(updatePet);


        } catch (SpecialityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatePetTO);
    }


}