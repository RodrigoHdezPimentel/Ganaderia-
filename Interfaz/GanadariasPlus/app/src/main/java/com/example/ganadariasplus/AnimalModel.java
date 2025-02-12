package com.example.ganadariasplus;

public class AnimalModel {

    private int id;
    private String especie;
    private String sexo;
    private int edad;
    private String estado;

    private int id_explotacion;

    public AnimalModel(int id, String especie, String sexo, int edad) {
        this.id = id;
        this.especie = especie;
        this.sexo = sexo;
        this.edad = edad;
    }

    public int getId_explotacion() {
        return id_explotacion;
    }

    public void setId_explotacion(int id_explotacion) {
        this.id_explotacion = id_explotacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
