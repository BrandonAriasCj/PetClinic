package com.tecsup.petclinic.services;

import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.tecsup.petclinic.entities.Speciality;
import com.tecsup.petclinic.exception.SpecialityNotFoundException;
import com.tecsup.petclinic.repositories.SpecialtyRepository;

@Service
@Slf4j
public class SpecialtiesServiceImpl implements SpecialtiesService {

    private final SpecialtyRepository SpecialtyRepository;

    public SpecialtiesServiceImpl(SpecialtyRepository SpecialtyRepository) {
        this.SpecialtyRepository = SpecialtyRepository;
    }

    @Override
    public Speciality create(Speciality Speciality) {
        return SpecialtyRepository.save(Speciality);
    }

    @Override
    public Speciality update(Speciality Speciality) {
        return SpecialtyRepository.save(Speciality);
    }

    @Override
    public void delete(Integer id) throws SpecialityNotFoundException {
        Speciality Speciality = findById(id);
        SpecialtyRepository.delete(Speciality);
    }

    @Override
    public Speciality findById(Integer id) throws SpecialityNotFoundException {
        Optional<Speciality> Speciality = SpecialtyRepository.findById(id);

        if (!Speciality.isPresent())
            throw new SpecialityNotFoundException("Record not found...!");

        return Speciality.get();
    }

    @Override
    public List<Speciality> findByName(String name) {
        List<Speciality> specialties = SpecialtyRepository.findByName(name);
        specialties.forEach(s -> log.info("" + s));
        return specialties;
    }

    @Override
    public List<Speciality> findByOffice(String office) {
        List<Speciality> specialties = SpecialtyRepository.findByOffice(office);
        specialties.forEach(s -> log.info("" + s));
        return specialties;
    }

    @Override
    public List<Speciality> findAll() {
        return SpecialtyRepository.findAll();
    }
}
