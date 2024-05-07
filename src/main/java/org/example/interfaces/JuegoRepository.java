package org.example.interfaces;

import org.example.domain.Juego;

import java.util.List;

public interface JuegoRepository {
    void guardar(Juego juego);
    void eliminar(int id);
    void actualizar(Juego juego);
    Juego buscar(int id);
    List<Juego> buscarTodos();
}
