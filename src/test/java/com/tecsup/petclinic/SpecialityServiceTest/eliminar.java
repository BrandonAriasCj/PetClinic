package com.tecsup.petclinic.SpecialityServiceTest;

import com.tecsup.petclinic.entities.Speciality;
import com.tecsup.petclinic.exception.SpecialityNotFoundException;
import com.tecsup.petclinic.repositories.SpecialtyRepository;
import com.tecsup.petclinic.services.SpecialtiesService;
import com.tecsup.petclinic.services.SpecialtyServiceTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Slf4j
public class eliminar {

    @Autowired
    private SpecialtiesService service;


    @Test
    void DeleteSpecialty() throws SpecialityNotFoundException {

        Speciality speciality = new Speciality();
        speciality.setId(1);
        speciality.setName("Carlos");

        Speciality savedSpecialty = service.create(speciality);
        service.delete(savedSpecialty.getId());

        assertThrows(SpecialityNotFoundException.class,
                ()->service.findById(savedSpecialty.getId()));

    }


}
