package com.tecsup.petclinic.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class SpecialityDTO {

    private Integer id;

    private String name;

    private String office;

    private int hOpen;

    private int hClose;
}
