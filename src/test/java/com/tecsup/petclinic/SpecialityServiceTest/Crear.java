package com.tecsup.petclinic.SpecialityServiceTest;

import com.tecsup.petclinic.entities.Speciality;
import com.tecsup.petclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class Crear {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    private Speciality speciality;

    @BeforeEach
    public void setUp() {
        speciality = new Speciality("Cardiology", "Room 101", 9, 17);
    }

    @Test
    public void testCreateSpecialty() {
        String name = "Neurology";
        String office = "305B";
        int h_open = 8;
        int h_close = 16;

        Speciality speciality = new Speciality(name, office, h_open, h_close);

        Speciality created = specialtyRepository.save(speciality);
        System.out.println("SPECIALITY CREATED: " + created);

        assertNotNull(created.getId());
        assertEquals(name, created.getName());
        assertEquals(office, created.getOffice());
        assertEquals(h_open, created.gethOpen());
        assertEquals(h_close, created.gethClose());
    }
}

