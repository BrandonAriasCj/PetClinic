package com.tecsup.petclinic.services;
import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.tecsup.petclinic.entities.Speciality;
import com.tecsup.petclinic.exception.SpecialityNotFoundException;


@Service
@Slf4j
public SpecialtiesServiceImpl implements SpecialtiesService{

    private final Specialties SpecialtyRepository;

    public SpecialtiesServiceImpl(SpecialtyRepository specialtyRepository){

    }
}