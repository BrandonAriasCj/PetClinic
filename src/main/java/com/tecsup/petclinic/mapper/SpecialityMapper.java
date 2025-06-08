package com.tecsup.petclinic.mapper;

import com.tecsup.petclinic.dtos.SpecialityDTO;
import com.tecsup.petclinic.entities.Speciality;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SpecialityMapper {

    SpecialityMapper INSTANCE = Mappers.getMapper(SpecialityMapper.class);

    SpecialityDTO toSpecialityDTO(Speciality speciality);
    Speciality toSpeciality(SpecialityDTO specialityDTO);
}



