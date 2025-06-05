package com.tecsup.petclinic.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tecsup.petclinic.entities.Speciality;

@Repository
public interface SpecialtyRepository extends JpaRepository<Speciality, Integer> {

    List<Speciality> findByName(String name);

    List<Speciality> findByOffice(String office);

    List<Speciality> findByHOpen(int hOpen);

    List<Speciality> findByHClose(int hClose);

    @Override
    List<Speciality> findAll();
}
