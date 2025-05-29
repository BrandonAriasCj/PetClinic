package com.tecsup.petclinic.SpecialityServiceTest;

import com.tecsup.petclinic.entities.Speciality;
import com.tecsup.petclinic.services.SpecialtiesService;
import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class Crear{

    @Autowired
    private SpecialtiesService specialtiesService;

    @Test
    public void testCreateSpecialty() {
        String NAME = "Neurology";
        String OFFICE = "305B";
        int H_OPEN = 8;
        int H_CLOSE = 16;

        Speciality speciality = new Speciality(NAME, OFFICE, H_OPEN, H_CLOSE);

        Speciality created = this.specialtiesService.create(speciality);
        log.info("SPECIALTY CREATED: " + created);

        assertNotNull(created.getId());
        assertEquals(NAME, created.getName());
        assertEquals(OFFICE, created.getOffice());
        assertEquals(H_OPEN, created.getHOpen());
        assertEquals(H_CLOSE, created.getHClose());
    }
}
