package com.tecsup.petclinic.mapper;

import com.tecsup.petclinic.dtos.SpecialityDTO;
import com.tecsup.petclinic.entities.Speciality;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface SpecialityMapperAxel {

    SpecialityMapperAxel INSTANCE = Mappers.getMapper(SpecialityMapperAxel.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "office", target = "office")
    @Mapping(source = "hOpen", target = "HOpen")
    @Mapping(source = "hClose", target = "HClose")
    SpecialityDTO toDTO(Speciality speciality);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "office", target = "office")
    @Mapping(source = "HOpen", target = "hOpen")
    @Mapping(source = "HClose", target = "hClose")
    Speciality toEntity(SpecialityDTO specialityDTO);

    List<Speciality> toEntityList(List<SpecialityDTO> specialityDTOs);

    List<SpecialityDTO> toDTOList(List<Speciality> specialities);
    }
