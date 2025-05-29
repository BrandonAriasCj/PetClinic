package com.tecsup.petclinic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tecsup.petclinic.entities.Speciality;

@Repository
public interface SpecialtyRepository extends JpaRepository<Speciality, Integer> {

    // Buscar por nombre
    List<Speciality> findByName(String name);

    // Buscar por oficina
    List<Speciality> findByOffice(String office);

    // Buscar por hora de apertura
    List<Speciality> findByHOpen(int hOpen);

    // Buscar por hora de cierre
    List<Speciality> findByHClose(int hClose);

    @Override
    List<Speciality> findAll();
}