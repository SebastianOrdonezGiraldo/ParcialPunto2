package org.example.domain;


import java.io.Serializable;

public class Juego implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nombre;
    private String tipo;
    private String personajes;

    public Juego(int id, String nombre, String tipo, String personajes) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.personajes = personajes;
    }


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getPersonajes() {
        return personajes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPersonajes(String personajes) {
        this.personajes = personajes;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("┌──────────────────────────────────────┐\n");
        sb.append("│ Juego                                │\n");
        sb.append("├──────────────────────────────────────┤\n");
        sb.append(String.format("│ ID: %-35d │\n", id));
        sb.append(String.format("│ Nombre: %-30s │\n", nombre));
        sb.append(String.format("│ Tipo: %-32s │\n", tipo));
        sb.append(String.format("│ Personajes: %-26s │\n", personajes));
        sb.append("└──────────────────────────────────────┘\n");
        return sb.toString();
    }

}