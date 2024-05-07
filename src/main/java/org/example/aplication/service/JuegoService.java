package org.example.aplication.service;

import org.example.domain.Juego;

import java.util.List;

public interface JuegoService {
    void crearJuego(int id, String nombre, String tipo, String personajes);
    void eliminarJuego(int id);
    void actualizarJuego(int id, String nombre, String tipo, String personajes);
    Juego obtenerJuego(int id);
    List<Juego> obtenerTodosLosJuegos();
}
