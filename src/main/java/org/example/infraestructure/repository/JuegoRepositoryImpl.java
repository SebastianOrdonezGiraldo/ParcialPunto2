package org.example.infraestructure.repository;

import org.example.domain.Juego;
import org.example.interfaces.JuegoRepository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class JuegoRepositoryImpl implements JuegoRepository {
    private static final String ARCHIVO_JUEGOS = "juegos.dat";
    private List<Juego> juegos;

    public JuegoRepositoryImpl() {
        cargarDatos();
    }

    private void cargarDatos() {
        try {
            FileInputStream fileInput = new FileInputStream(ARCHIVO_JUEGOS);
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            juegos = (List<Juego>) objectInput.readObject();
            objectInput.close();
            fileInput.close();
        } catch (Exception e) {
            juegos = new ArrayList<>();
        }
    }

    private void guardarDatos() {
        try {
            FileOutputStream fileOutput = new FileOutputStream(ARCHIVO_JUEGOS);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(juegos);
            objectOutput.close();
            fileOutput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void guardar(Juego juego) {
        juegos.add(juego);
        guardarDatos();
    }

    @Override
    public void eliminar(int id) {
        juegos.removeIf(juego -> juego.getId() == id);
        guardarDatos();
    }

    @Override
    public void actualizar(Juego juego) {
        eliminar(juego.getId());
        guardar(juego);
    }

    @Override
    public Juego buscar(int id) {
        return juegos.stream()
                .filter(juego -> juego.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Juego> buscarTodos() {
        return juegos;
    }
}