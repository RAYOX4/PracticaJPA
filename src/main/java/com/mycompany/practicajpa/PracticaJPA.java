package com.mycompany.practicajpa;

import com.mycompany.practicajpa.dao.*;
import com.mycompany.practicajpa.modelo.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class PracticaJPA {

    static Scanner sc = new Scanner(System.in);

    static AutorDaoJPA autorDao = new AutorDaoJPA();
    static LibroDaoJPA libroDao = new LibroDaoJPA();
    static UsuarioDaoJPA usuarioDao = new UsuarioDaoJPA();
    static PrestamoDaoJPA prestamoDao = new PrestamoDaoJPA();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n========= MENÚ BIBLIOTECA (JPA) =========");
            System.out.println("1. Autores");
            System.out.println("2. Libros");
            System.out.println("3. Usuarios");
            System.out.println("4. Préstamos");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = leerEntero();

            switch (opcion) {
                case 1 -> menuAutores();
                case 2 -> menuLibros();
                case 3 -> menuUsuarios();
                case 4 -> menuPrestamos();
                case 0 -> System.out.println("👋 Saliendo...");
                default -> System.out.println("❌ Opción no válida");
            }
        } while (opcion != 0);

        sc.close();
    }

    // =========================================================
    //                      MENÚ AUTORES
    // =========================================================
    private static void menuAutores() {
        int op;
        do {
            System.out.println("\n--- AUTORES ---");
            System.out.println("1. Listar todos");
            System.out.println("2. Buscar por ID");
            System.out.println("3. Insertar");
            System.out.println("4. Actualizar");
            System.out.println("5. Eliminar");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            op = leerEntero();

            switch (op) {
                case 1 -> listarAutores();
                case 2 -> buscarAutor();
                case 3 -> insertarAutor();
                case 4 -> actualizarAutor();
                case 5 -> eliminarAutor();
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("❌ Opción no válida");
            }
        } while (op != 0);
    }

    private static void listarAutores() {
        List<Autor> lista = autorDao.listarTodos();
        if (lista.isEmpty()) {
            System.out.println("⚠️ No hay autores registrados.");
        } else {
            System.out.println("\n--- Lista de Autores ---");
            lista.forEach(System.out::println);
        }
    }

    private static void buscarAutor() {
        System.out.print("ID a buscar: ");
        int id = leerEntero();
        Autor a = autorDao.buscarPorId(id);
        if (a != null) {
            System.out.println("✅ " + a);
        } else {
            System.out.println("❌ No se encontró autor con ID " + id);
        }
    }

    private static void insertarAutor() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Nacionalidad: ");
        String nacionalidad = sc.nextLine();

        Autor a = new Autor(nombre, nacionalidad);
        autorDao.insertar(a);
    }

    private static void actualizarAutor() {
        System.out.print("ID a actualizar: ");
        int id = leerEntero();
        Autor a = autorDao.buscarPorId(id);
        if (a == null) {
            System.out.println("❌ No existe ese autor.");
            return;
        }
        System.out.print("Nuevo nombre (" + a.getNombre() + "): ");
        String nombre = sc.nextLine();
        System.out.print("Nueva nacionalidad (" + a.getNacionalidad() + "): ");
        String nacionalidad = sc.nextLine();

        a.setNombre(nombre);
        a.setNacionalidad(nacionalidad);
        autorDao.actualizar(a);
    }

    private static void eliminarAutor() {
        System.out.print("ID a eliminar: ");
        int id = leerEntero();
        autorDao.eliminar(id);
    }

    // =========================================================
    //                      MENÚ LIBROS
    // =========================================================
    private static void menuLibros() {
        int op;
        do {
            System.out.println("\n--- LIBROS ---");
            System.out.println("1. Listar todos");
            System.out.println("2. Buscar por ID");
            System.out.println("3. Insertar");
            System.out.println("4. Actualizar");
            System.out.println("5. Eliminar");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            op = leerEntero();

            switch (op) {
                case 1 -> listarLibros();
                case 2 -> buscarLibro();
                case 3 -> insertarLibro();
                case 4 -> actualizarLibro();
                case 5 -> eliminarLibro();
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("❌ Opción no válida");
            }
        } while (op != 0);
    }

    private static void listarLibros() {
        List<Libro> lista = libroDao.listarTodos();
        if (lista.isEmpty()) {
            System.out.println("⚠️ No hay libros registrados.");
        } else {
            System.out.println("\n--- Lista de Libros ---");
            lista.forEach(System.out::println);
        }
    }

    private static void buscarLibro() {
        System.out.print("ID a buscar: ");
        int id = leerEntero();
        Libro l = libroDao.buscarPorId(id);
        if (l != null) {
            System.out.println("✅ " + l);
        } else {
            System.out.println("❌ No se encontró libro con ID " + id);
        }
    }

    private static void insertarLibro() {
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Año de publicación: ");
        int anio = leerEntero();

        System.out.println("Autores disponibles:");
        autorDao.listarTodos().forEach(System.out::println);
        System.out.print("ID del autor: ");
        int idAutor = leerEntero();

        Autor autor = autorDao.buscarPorId(idAutor);
        if (autor == null) {
            System.out.println("❌ No existe autor con ID " + idAutor);
            return;
        }

        Libro l = new Libro(titulo, anio, autor);
        libroDao.insertar(l);
    }

    private static void actualizarLibro() {
        System.out.print("ID a actualizar: ");
        int id = leerEntero();
        Libro l = libroDao.buscarPorId(id);
        if (l == null) {
            System.out.println("❌ No existe ese libro.");
            return;
        }
        System.out.print("Nuevo título (" + l.getTitulo() + "): ");
        String titulo = sc.nextLine();
        System.out.print("Nuevo año (" + l.getAnioPublicacion() + "): ");
        int anio = leerEntero();

        l.setTitulo(titulo);
        l.setAnioPublicacion(anio);
        libroDao.actualizar(l);
    }

    private static void eliminarLibro() {
        System.out.print("ID a eliminar: ");
        int id = leerEntero();
        libroDao.eliminar(id);
    }

    // =========================================================
    //                      MENÚ USUARIOS
    // =========================================================
    private static void menuUsuarios() {
        int op;
        do {
            System.out.println("\n--- USUARIOS ---");
            System.out.println("1. Listar todos");
            System.out.println("2. Buscar por ID");
            System.out.println("3. Insertar");
            System.out.println("4. Actualizar");
            System.out.println("5. Eliminar");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            op = leerEntero();

            switch (op) {
                case 1 -> listarUsuarios();
                case 2 -> buscarUsuario();
                case 3 -> insertarUsuario();
                case 4 -> actualizarUsuario();
                case 5 -> eliminarUsuario();
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("❌ Opción no válida");
            }
        } while (op != 0);
    }

    private static void listarUsuarios() {
        List<Usuario> lista = usuarioDao.listarTodos();
        if (lista.isEmpty()) {
            System.out.println("⚠️ No hay usuarios registrados.");
        } else {
            System.out.println("\n--- Lista de Usuarios ---");
            lista.forEach(System.out::println);
        }
    }

    private static void buscarUsuario() {
        System.out.print("ID a buscar: ");
        int id = leerEntero();
        Usuario u = usuarioDao.buscarPorId(id);
        if (u != null) {
            System.out.println("✅ " + u);
        } else {
            System.out.println("❌ No se encontró usuario con ID " + id);
        }
    }

    private static void insertarUsuario() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();

        Usuario u = new Usuario(nombre, email, telefono);
        usuarioDao.insertar(u);
    }

    private static void actualizarUsuario() {
        System.out.print("ID a actualizar: ");
        int id = leerEntero();
        Usuario u = usuarioDao.buscarPorId(id);
        if (u == null) {
            System.out.println("❌ No existe ese usuario.");
            return;
        }
        System.out.print("Nuevo nombre (" + u.getNombre() + "): ");
        String nombre = sc.nextLine();
        System.out.print("Nuevo email (" + u.getEmail() + "): ");
        String email = sc.nextLine();
        System.out.print("Nuevo teléfono (" + u.getTelefono() + "): ");
        String telefono = sc.nextLine();

        u.setNombre(nombre);
        u.setEmail(email);
        u.setTelefono(telefono);
        usuarioDao.actualizar(u);
    }

    private static void eliminarUsuario() {
        System.out.print("ID a eliminar: ");
        int id = leerEntero();
        usuarioDao.eliminar(id);
    }

    // =========================================================
    //                      MENÚ PRÉSTAMOS
    // =========================================================
    private static void menuPrestamos() {
        int op;
        do {
            System.out.println("\n--- PRÉSTAMOS ---");
            System.out.println("1. Listar todos");
            System.out.println("2. Buscar por ID");
            System.out.println("3. Insertar");
            System.out.println("4. Actualizar (marcar devolución)");
            System.out.println("5. Eliminar");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            op = leerEntero();

            switch (op) {
                case 1 -> listarPrestamos();
                case 2 -> buscarPrestamo();
                case 3 -> insertarPrestamo();
                case 4 -> actualizarPrestamo();
                case 5 -> eliminarPrestamo();
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("❌ Opción no válida");
            }
        } while (op != 0);
    }

    private static void listarPrestamos() {
        List<Prestamo> lista = prestamoDao.listarTodos();
        if (lista.isEmpty()) {
            System.out.println("⚠️ No hay préstamos registrados.");
        } else {
            System.out.println("\n--- Lista de Préstamos ---");
            lista.forEach(System.out::println);
        }
    }

    private static void buscarPrestamo() {
        System.out.print("ID a buscar: ");
        int id = leerEntero();
        Prestamo p = prestamoDao.buscarPorId(id);
        if (p != null) {
            System.out.println("✅ " + p);
        } else {
            System.out.println("❌ No se encontró préstamo con ID " + id);
        }
    }

    private static void insertarPrestamo() {
        System.out.println("Libros disponibles:");
        libroDao.listarTodos().forEach(System.out::println);
        System.out.print("ID del libro: ");
        int idLibro = leerEntero();

        Libro libro = libroDao.buscarPorId(idLibro);
        if (libro == null) {
            System.out.println("❌ No existe libro con ID " + idLibro);
            return;
        }

        System.out.println("Usuarios disponibles:");
        usuarioDao.listarTodos().forEach(System.out::println);
        System.out.print("ID del usuario: ");
        int idUsuario = leerEntero();

        Usuario usuario = usuarioDao.buscarPorId(idUsuario);
        if (usuario == null) {
            System.out.println("❌ No existe usuario con ID " + idUsuario);
            return;
        }

        System.out.print("Fecha de devolución (YYYY-MM-DD, deja vacío si es pendiente): ");
        String fechaStr = sc.nextLine().trim();
        LocalDate fechaDevolucion = fechaStr.isEmpty() ? null : LocalDate.parse(fechaStr);

        Prestamo p = new Prestamo(libro, usuario, LocalDate.now(), fechaDevolucion);
        prestamoDao.insertar(p);
    }

    private static void actualizarPrestamo() {
        System.out.print("ID a actualizar: ");
        int id = leerEntero();
        Prestamo p = prestamoDao.buscarPorId(id);
        if (p == null) {
            System.out.println("❌ No existe ese préstamo.");
            return;
        }

        System.out.print("Fecha de devolución actual: " + p.getFechaDevolucion());
        System.out.print("\nNueva fecha (YYYY-MM-DD, vacío para pendiente): ");
        String fechaStr = sc.nextLine().trim();
        p.setFechaDevolucion(fechaStr.isEmpty() ? null : LocalDate.parse(fechaStr));

        prestamoDao.actualizar(p);
    }

    private static void eliminarPrestamo() {
        System.out.print("ID a eliminar: ");
        int id = leerEntero();
        prestamoDao.eliminar(id);
    }

    // =========================================================
    //              UTILIDAD PARA LEER ENTEROS
    // =========================================================
    private static int leerEntero() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("❌ Ingresa un número válido: ");
            }
        }
    }
}