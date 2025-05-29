package com.tecsup.petclinic.repositories;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tecsup.petclinic.entities.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {

}
