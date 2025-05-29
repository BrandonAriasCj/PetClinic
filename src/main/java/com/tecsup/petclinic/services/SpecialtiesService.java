package com.tecsup.petclinic.services;

import java.util.List;
import com.tecsup.petclinic.entities.Speciality;
import com.tecsup.petclinic.exception.SpecialityNotFoundException;

public interface SpecialtiesService {

    @param
    @return
    Speciality create(Speciality speciality);

    @param
    @return
    Speciality update(Speciality speciality);

    @param id
    @throws  SpecialityNotFoundException;
    void delete(Integer id )throws SpecialityNotFoundException;

    @param id
    @return
    Speciality findById(Integer id ) throws SpecialityNotFoundException;

    @param name
    @return
    List<Speciality> findByName(String name);

    @param Office
    @return
    List<Speciality>  findByOffice(String office);

    @return
    List<Speciality> findAll();



}