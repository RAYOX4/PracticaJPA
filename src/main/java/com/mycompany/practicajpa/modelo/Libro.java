package com.mycompany.practicajpa.modelo;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "libros")
public class Libro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private int idLibro;

    @Column(name = "titulo", nullable = false, length = 150)
    private String titulo;

    @Column(name = "anio_publicacion")
    private int anioPublicacion;

    // Relación N → 1 con Autor
    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;

    public Libro() {
    }

    public Libro(String titulo, int anioPublicacion, Autor autor) {
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        this.autor = autor;
    }

    public int getIdLibro() { return idLibro; }
    public void setIdLibro(int idLibro) { this.idLibro = idLibro; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public int getAnioPublicacion() { return anioPublicacion; }
    public void setAnioPublicacion(int anioPublicacion) { this.anioPublicacion = anioPublicacion; }
    public Autor getAutor() { return autor; }
    public void setAutor(Autor autor) { this.autor = autor; }

    @Override
    public String toString() {
        return idLibro + " | " + titulo + " (" + anioPublicacion + ") | Autor: " + 
               (autor != null ? autor.getNombre() : "sin autor");
    }
}