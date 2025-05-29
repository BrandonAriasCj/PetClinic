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
public class CrearS {

    @Autowired
    private SpecialtiesService specialtiesService;

    @Test
    public void testCreateSpecialty() {
        String name = "Neurology";
        String office = "305B";
        int h_open = 8;
        int h_close = 16;

        Speciality speciality = new Speciality(name, office, h_open, h_close);

        Speciality created = this.specialtiesService.create(speciality);
        log.info("SPECIALITY CREATED: " + created);

        assertNotNull(created.getId());
        assertEquals(name, created.getName());
        assertEquals(office, created.getOffice());
        assertEquals(h_open, created.getHOpen());
        assertEquals(h_close, created.getHClose());
    }
}
