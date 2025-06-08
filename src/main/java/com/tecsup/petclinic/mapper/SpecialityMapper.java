package com.tecsup.petclinic.mapper;

import com.tecsup.petclinic.dtos.SpecialityDTO;
import com.tecsup.petclinic.entities.Speciality;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface SpecialityMapper {


    SpecialityDTO toDTO(Speciality speciality);

    Speciality toEntity(SpecialityDTO specialityDTO);

    List<Speciality> toEntityList(List<SpecialityDTO> specialityDTOs);

    List<SpecialityDTO> toDTOList(List<Speciality> specialities);
}
