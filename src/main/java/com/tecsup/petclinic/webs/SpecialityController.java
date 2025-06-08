package com.tecsup.petclinic.webs;

import com.tecsup.petclinic.dtos.SpecialityDTO;
import com.tecsup.petclinic.entities.Speciality;
import com.tecsup.petclinic.exception.SpecialityNotFoundException;
import com.tecsup.petclinic.mapper.SpecialityMapper;
import com.tecsup.petclinic.services.SpecialtiesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class SpecialityController {
    private final SpecialtiesService specialtiesService;
    private final SpecialityMapper mapper;

    public SpecialityController(SpecialtiesService specialityService, SpecialityMapper mapper) {
        this.specialtiesService = specialityService;
        this.mapper = mapper;
    }

    @GetMapping("/specialities")
    public ResponseEntity<List<SpecialityDTO>> findAllSpecialities() {
        List<Speciality> specialities = specialtiesService.findAll();
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
        Speciality created = specialtiesService.create(newSpeciality);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(created));
    }

    /**
     * Update especiality
     */
    @PutMapping("/specialities/update/{id}")
    public ResponseEntity<SpecialityDTO> update(@RequestBody SpecialityDTO specialityDTO, @PathVariable Integer id) {
        try {
            Speciality existing = specialtiesService.findById(id);

            existing.setName(specialityDTO.getName());
            existing.setOffice(specialityDTO.getOffice());
            existing.setHOpen(specialityDTO.getHOpen());
            existing.setHClose(specialityDTO.getHClose());

            Speciality updated = specialtiesService.update(existing);

            return ResponseEntity.ok(mapper.toDTO(updated));

        } catch (SpecialityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    /**
     * Find speciality by ID
     */
    @GetMapping("/specialities/{id}")
    public ResponseEntity<SpecialityDTO> findById(@PathVariable Integer id) {
        try {
            Speciality speciality = specialtiesService.findById(id);
            return ResponseEntity.ok(mapper.toDTO(speciality));
        } catch (SpecialityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
