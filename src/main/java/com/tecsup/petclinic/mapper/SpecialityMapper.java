package com.tecsup.petclinic.mapper;

import com.tecsup.petclinic.dtos.SpecialityDTO;
import com.tecsup.petclinic.entities.Speciality;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface SpecialityMapper {

    SpecialityDTO toSpecialityDTO(Speciality speciality);

    Speciality toSpeciality(SpecialityDTO specialityDTO);
}
