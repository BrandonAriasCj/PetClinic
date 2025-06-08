package com.tecsup.petclinic.webs;

import com.tecsup.petclinic.dtos.SpecialityDTO;
import com.tecsup.petclinic.entities.Speciality;
import com.tecsup.petclinic.mapper.SpecialityMapper;
import com.tecsup.petclinic.services.SpecialtiesService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class SpecialityController {

    private final SpecialtiesService specialityService;
    private final SpecialityMapper mapper;

    public SpecialityController(SpecialtiesService specialityService, SpecialityMapper mapper) {
        this.specialityService = specialityService;
        this.mapper = mapper;
    }

    @PostMapping(value = "/specialities")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SpecialityDTO> create(@RequestBody SpecialityDTO specialityDTO) {

        Speciality newSpeciality = this.mapper.toSpeciality(specialityDTO);
        SpecialityDTO newSpecialityDTO = this.mapper.toSpecialityDTO(specialityService.create(newSpeciality));

        return ResponseEntity.status(HttpStatus.CREATED).body(newSpecialityDTO);
    }
}
