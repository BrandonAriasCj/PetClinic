package com.tecsup.petclinic.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("hOpen")
    private int hOpen;

    @JsonProperty("hClose")
    private int hClose;
}
