package com.tecsup.petclinic.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "specialties")
@Data
public class Speciality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String office;

    @Column(name = "h_open")
    private int hOpen;

    @Column(name = "h_close")
    private int hClose;

    // Constructor vacío (requerido por JPA)
    public Speciality() {
    }

    // Constructor con todos los atributos
    public Speciality(Integer id, String name, String office, int hOpen, int hClose) {
        this.id = id;
        this.name = name;
        this.office = office;
        this.hOpen = hOpen;
        this.hClose = hClose;
    }

    // Constructor sin ID (para crear nuevos objetos)
    public Speciality(String name, String office, int hOpen, int hClose) {
        this.name = name;
        this.office = office;
        this.hOpen = hOpen;
        this.hClose = hClose;
    }

    // Getters y setters personalizados para evitar errores con MapStruct

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public int getHOpen() {
        return hOpen;
    }

    public void setHOpen(int hOpen) {
        this.hOpen = hOpen;
    }

    public int getHClose() {
        return hClose;
    }

    public void setHClose(int hClose) {
        this.hClose = hClose;
    }
}
