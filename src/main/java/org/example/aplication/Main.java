package org.example.aplication;

import org.example.aplication.service.JuegoService;
import org.example.aplication.service.JuegoServiceImpl;
import org.example.domain.Juego;
import org.example.infraestructure.repository.JuegoRepositoryImpl;
import org.example.interfaces.JuegoRepository;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final JuegoService juegoService;

    static {
        JuegoRepository juegoRepository = new JuegoRepositoryImpl();
        juegoService = new JuegoServiceImpl(juegoRepository);
    }

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            System.out.println("1. Listar juegos");
            System.out.println("2. Crear juego");
            System.out.println("3. Actualizar juego");
            System.out.println("4. Eliminar juego");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    listarJuegos();
                    break;
                case 2:
                    crearJuego();
                    break;
                case 3:
                    actualizarJuego();
                    break;
                case 4:
                    eliminarJuego();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private static void listarJuegos() {
        List<Juego> juegos = juegoService.obtenerTodosLosJuegos();
        if (juegos.isEmpty()) {
            System.out.println("No hay juegos registrados.");
        } else {
            System.out.println("Listado de juegos:");
            for (Juego juego : juegos) {
                System.out.println(juego);
            }
        }
    }

    private static void crearJuego() {
        System.out.print("Ingrese el ID del juego: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el nombre del juego: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el tipo del juego: ");
        String tipo = scanner.nextLine();
        System.out.print("Ingrese los personajes del juego: ");
        String personajes = scanner.nextLine();

        juegoService.crearJuego(id, nombre, tipo, personajes);
        System.out.println("Juego creado exitosamente.");
    }

    private static void actualizarJuego() {
        System.out.print("Ingrese el ID del juego a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Juego juego = juegoService.obtenerJuego(id);
        if (juego == null) {
            System.out.println("No se encontró el juego con ID " + id);
            return;
        }

        System.out.print("Ingrese el nuevo nombre del juego (dejar en blanco para no cambiar): ");
        String nombre = scanner.nextLine();
        if (!nombre.isEmpty()) {
            juego.setNombre(nombre);
        }

        System.out.print("Ingrese el nuevo tipo del juego (dejar en blanco para no cambiar): ");
        String tipo = scanner.nextLine();
        if (!tipo.isEmpty()) {
            juego.setTipo(tipo);
        }

        System.out.print("Ingrese los nuevos personajes del juego (dejar en blanco para no cambiar): ");
        String personajes = scanner.nextLine();
        if (!personajes.isEmpty()) {
            juego.setPersonajes(personajes);
        }

        juegoService.actualizarJuego(id, juego.getNombre(), juego.getTipo(), juego.getPersonajes());
        System.out.println("Juego actualizado exitosamente.");
    }

    private static void eliminarJuego() {
        System.out.print("Ingrese el ID del juego a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        Juego juego = juegoService.obtenerJuego(id);
        if (juego == null) {
            System.out.println("No se encontró el juego con ID " + id);
            return;
        }

        juegoService.eliminarJuego(id);
        System.out.println("Juego eliminado exitosamente.");
    }
}