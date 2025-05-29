package com.tecsup.petclinic.services;
import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.exception.PetNotFoundException;

@Service
public SpecialtiesServiceImpl implements SepecialtiesService{

    private final Sepcialties SpecialtyRepository;

    public SpecialtiesServiceImpl(SpeacialtyRepository sepcialtyRepository){

    }
}