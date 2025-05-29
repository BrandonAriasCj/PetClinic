package com.tecsup.petclinic.services;

import java.util.List;
import
public interface SpecialtiesService.java {

    @param
    @return
    Specialties create(Specialties specialties);

    @param
    @return
    Specialties update(Specialties specialties);

    @param id
    @throws  EspecialtiesNotFoundException
    void delete(Integer id )throws EspecialtiesNotFoundException;

    @param id
    @return
    Specialties findById(Integer id ) throws EspecialtiesNotFoundException;

    @param name
    @return
    List<Specialties> findByName(String name);

    @param Office
    @return
    List<Specialties>  findByOffice(String office);

    @return
    List<Specialties> findAll();



}