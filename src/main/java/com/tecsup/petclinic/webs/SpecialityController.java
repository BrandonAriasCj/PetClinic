package com.tecsup.petclinic.webs;

import com.tecsup.petclinic.dtos.SpecialityDTO;
import com.tecsup.petclinic.entities.Speciality;
import com.tecsup.petclinic.exception.SpecialityNotFoundException;
import com.tecsup.petclinic.services.SpecialtiesService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class SpecialityController {

    private final SpecialtiesService specialityService;


    public SpecialityController(SpecialtiesService specialityService) {
        this.specialityService = specialityService;
    }

    /**
     * Get all specialities
     */
    @GetMapping("/specialities")
    public ResponseEntity<List<SpecialityDTO>> findAllSpecialities() {
        List<Speciality> specialities = specialityService.findAll();
        package com.tecsup.petclinic.webs;

import com.tecsup.petclinic.dtos.SpecialityDTO;
import com.tecsup.petclinic.entities.Speciality;
import com.tecsup.petclinic.exception.SpecialityNotFoundException;
import com.tecsup.petclinic.mapper.SpecialityMapper;
import com.tecsup.petclinic.services.SpecialtiesService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

        @RestController
        @Slf4j
        public class SpecialityController {

            private final SpecialtiesService specialityService;
            private final SpecialityMapper mapper;

            public SpecialityController(SpecialtiesService specialityService, SpecialityMapper mapper) {
                this.specialityService = specialityService;
                this.mapper = mapper;
            }

            /**
             * Get all specialities
             */
            @GetMapping("/specialities")
            public ResponseEntity<List<SpecialityDTO>> findAllSpecialities() {
                List<Speciality> specialities = specialityService.findAll();
                List<SpecialityDTO> specialityDTOs = mapper.toDTOList(specialities);
                return ResponseEntity.ok(specialityDTOs);
            }

            /**
             * Create new speciality
             */
            @PostMapping("/specialities")
            @ResponseStatus(HttpStatus.CREATED)
            public ResponseEntity<SpecialityDTO> create(@RequestBody SpecialityDTO specialityDTO) {
                Speciality newSpeciality = mapper.toEntity(specialityDTO);
                Speciality created = specialityService.create(newSpeciality);
                return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(created));
            }

            /**
             * Find speciality by ID
             */
            @GetMapping("/specialities/{id}")
            public ResponseEntity<SpecialityDTO> findById(@PathVariable Integer id) {
                try {
                    Speciality speciality = specialityService.findById(id);
                    return ResponseEntity.ok(mapper.toDTO(speciality));
                } catch (SpecialityNotFoundException e) {
                    return ResponseEntity.notFound().build();
                }
            }

            /**
             * Update speciality by ID
             */
            @PutMapping("/specialities/{id}")
            public ResponseEntity<SpecialityDTO> update(@RequestBody SpecialityDTO specialityDTO, @PathVariable Integer id) {
                try {
                    Speciality specialityToUpdate = specialityService.findById(id);
                    specialityToUpdate.setName(specialityDTO.getName());
                    specialityToUpdate.setOffice(specialityDTO.getOffice());
                    specialityToUpdate.sethOpen(specialityDTO.gethOpen());
                    specialityToUpdate.sethClose(specialityDTO.gethClose());
                    specialityService.update(specialityToUpdate);
                    return ResponseEntity.ok(mapper.toDTO(specialityToUpdate));
                } catch (SpecialityNotFoundException e) {
                    return ResponseEntity.notFound().build();
                }
            }

            /**
             * Delete speciality by ID
             */
            @DeleteMapping("/specialities/{id}")
            public ResponseEntity<String> delete(@PathVariable Integer id) {
                try {
                    specialityService.delete(id);
                    return ResponseEntity.ok("Deleted Speciality ID: " + id);
                } catch (SpecialityNotFoundException e) {
                    return ResponseEntity.notFound().build();
                }
            }
        }

        return ResponseEntity.ok(specialityDTOs);
    }

    /**
     * Create new speciality
     */
    @PostMapping("/specialities")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SpecialityDTO> create(@RequestBody SpecialityDTO specialityDTO) {
        Speciality newSpeciality = mapper.toEntity(specialityDTO);
        Speciality created = specialityService.create(newSpeciality);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(created));
    }

    /**
     * Find speciality by ID
     */
    @GetMapping("/specialities/{id}")
    public ResponseEntity<SpecialityDTO> findById(@PathVariable Integer id) {
        try {
            Speciality speciality = specialityService.findById(id);
            return ResponseEntity.ok(mapper.toDTO(speciality));
        } catch (SpecialityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Update speciality by ID
     */
    @PutMapping("/specialities/{id}")
    public ResponseEntity<SpecialityDTO> update(@RequestBody SpecialityDTO specialityDTO, @PathVariable Integer id) {
        try {
            Speciality specialityToUpdate = specialityService.findById(id);
            specialityToUpdate.setName(specialityDTO.getName());
            specialityToUpdate.setOffice(specialityDTO.getOffice());
            specialityToUpdate.sethOpen(specialityDTO.gethOpen());
            specialityToUpdate.sethClose(specialityDTO.gethClose());
            specialityService.update(specialityToUpdate);
            return ResponseEntity.ok(mapper.toDTO(specialityToUpdate));
        } catch (SpecialityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Delete speciality by ID
     */
    @DeleteMapping("/specialities/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            specialityService.delete(id);
            return ResponseEntity.ok("Deleted Speciality ID: " + id);
        } catch (SpecialityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
