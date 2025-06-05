package com.tecsup.petclinic.SpecialityServiceTest;

import com.tecsup.petclinic.entities.Speciality;
import com.tecsup.petclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class Actualizar {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    private Speciality speciality;

    @BeforeEach
    public void setUp() {

        speciality = new Speciality("Cardiology", "Room 101", 9, 17);
    }

    @Test
    public void testCreateSpeciality() {

        Speciality savedSpeciality = specialtyRepository.save(speciality);


        assertNotNull(savedSpeciality);
        assertNotNull(savedSpeciality.getId());
        assertEquals("Cardiology", savedSpeciality.getName());
        assertEquals("Room 101", savedSpeciality.getOffice());
        assertEquals(9, savedSpeciality.gethOpen());
        assertEquals(17, savedSpeciality.gethClose());
    }
}
