package com.tecsup.petclinic.SpecialityServiceTest;

import com.tecsup.petclinic.entities.Speciality;
import com.tecsup.petclinic.repositories.SpecialtyRepository;
import com.tecsup.petclinic.services.SpecialtiesService;
import com.tecsup.petclinic.services.SpecialtyServiceTest;
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

    @Test
    public void testUpdateSpecialty() {

        int ID = 15;
        String NAME = "Carlos";

        String OFICCE = "Cardiologia";
        int hOpen = 11;
        int hClose = 13;

        speciality = new Speciality(ID, NAME, OFICCE, hOpen, hClose);

        // ------------ Create ---------------

        //log.info(">" + speciality);
        Speciality SpecialityCreated = SpecialtiesService.create(speciality);
        //log.info(">>" + SpecialityCreated);

        // ------------ Update ---------------

        String UPGRATE_NAME = "Sebas";
        String UPGRATE_OFICCE = "Neurologia";
        int UPGRATE_hOpen = 11;
        int UPGRATE_hClose = 13;

        // Prepare data for update
        SpecialityCreated.setId(ID);
        SpecialityCreated.setName(UPGRATE_NAME);
        SpecialityCreated.setOffice(UPGRATE_OFICCE);
        SpecialityCreated.sethClose(UPGRATE_hOpen);
        SpecialityCreated.sethClose(UPGRATE_hClose);

        // Execute update
        Speciality upgradeSpeciality = SpecialtiesService.update(SpecialityCreated);
        //log.info(">>>>" + upgradeSpeciality);

        //            EXPECTED        ACTUAL
        assertEquals(UPGRATE_NAME, upgradeSpeciality.getName());
        assertEquals(UPGRATE_OFICCE, upgradeSpeciality.getOffice());
        assertEquals(UPGRATE_hOpen, upgradeSpeciality.gethOpen());
        assertEquals(UPGRATE_hClose, upgradeSpeciality.gethClose());
    }
}
