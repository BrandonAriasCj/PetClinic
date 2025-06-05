package com.tecsup.petclinic.services;

import java.util.List;
import com.tecsup.petclinic.entities.Speciality;
import com.tecsup.petclinic.exception.SpecialityNotFoundException;

public interface SpecialtiesService {

    static Speciality create(Speciality speciality);

    static Speciality update(Speciality speciality);

    void delete(Integer id) throws SpecialityNotFoundException;

    Speciality findById(Integer id) throws SpecialityNotFoundException;

    List<Speciality> findByName(String name);

    List<Speciality> findByOffice(String office);

    List<Speciality> findAll();
}
