package com.tecsup.petclinic.SpecialityServiceTest;

import com.tecsup.petclinic.entities.Speciality;
import com.tecsup.petclinic.exception.SpecialityNotFoundException;
import com.tecsup.petclinic.services.SpecialtiesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class buscar {

    @Autowired
    private SpecialtiesService service;

    @Test
    void findById() throws SpecialityNotFoundException {

        Speciality specialty= new Speciality();
        specialty.setName("test");
        specialty.setOffice("404");
        Speciality savedSpecialty = service.create(specialty);

        Speciality foundSpecialty = service.findById(savedSpecialty.getId());

        assertNotNull(foundSpecialty);
        assertEquals(savedSpecialty.getId(),foundSpecialty.getId());


    }
}
