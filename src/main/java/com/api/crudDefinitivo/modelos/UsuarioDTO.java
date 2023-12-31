package com.api.crudDefinitivo.modelos;
import lombok.Data;

import javax.persistence.Column;

@Data
public class UsuarioDTO {
    private Long id;

    private String nombre;

    private String apellido;

    private String email;

    private int legajo;

    public UsuarioDTO(Long id, String nombre, String apellido, String email, int legajo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.legajo = legajo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }
}
