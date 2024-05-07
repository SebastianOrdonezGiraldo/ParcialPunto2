package org.example.aplication.service;

import org.example.domain.Juego;
import org.example.interfaces.JuegoRepository;

import java.util.List;

// Services/JuegoServiceImpl.java
public class JuegoServiceImpl implements JuegoService {
    private JuegoRepository juegoRepository;

    public JuegoServiceImpl(JuegoRepository juegoRepository) {
        this.juegoRepository = juegoRepository;
    }

    @Override
    public void crearJuego(int id, String nombre, String tipo, String personajes) {
        Juego juego = new Juego(id, nombre, tipo, personajes);
        juegoRepository.guardar(juego);
    }

    @Override
    public void eliminarJuego(int id) {
        juegoRepository.eliminar(id);
    }

    @Override
    public void actualizarJuego(int id, String nombre, String tipo, String personajes) {
        Juego juego = new Juego(id, nombre, tipo, personajes);
        juegoRepository.actualizar(juego);
    }

    @Override
    public Juego obtenerJuego(int id) {
        return juegoRepository.buscar(id);
    }

    @Override
    public List<Juego> obtenerTodosLosJuegos() {
        return juegoRepository.buscarTodos();
    }
}