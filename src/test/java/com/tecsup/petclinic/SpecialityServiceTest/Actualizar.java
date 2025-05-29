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
public class Actualizar {

    @Autowired
    private SpecialtiesService specialtiesService;

    @Test
    public void testUpdateSpecialty() {
        // Paso 1: Crear una especialidad primero
        Speciality speciality = new Speciality("Oncology", "201A", 9, 17);
        Speciality created = specialtiesService.create(speciality);
        assertNotNull(created.getId());

        // Paso 2: Modificar algunos campos
        created.setName("Updated Oncology");
        created.setOffice("301C");
        created.setHOpen(10);
        created.setHClose(18);

        // Paso 3: Actualizar en la base de datos
        Speciality updated = specialtiesService.update(created);

        log.info("SPECIALTY UPDATED: " + updated);

        // Paso 4: Verificar los cambios
        assertEquals("Updated Oncology", updated.getName());
        assertEquals("301C", updated.getOffice());
        assertEquals(10, updated.getHOpen());
        assertEquals(18, updated.getHClose());
    }
}

