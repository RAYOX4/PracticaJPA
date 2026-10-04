package com.mycompany.practicajpa.dao;

import com.mycompany.practicajpa.modelo.Libro;
import jakarta.persistence.*;
import java.util.List;

public class LibroDaoJPA {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("PracticaJPA-PU");

    public void insertar(Libro libro) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(libro);
            em.getTransaction().commit();
            System.out.println("✅ Libro insertado: " + libro.getTitulo());
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.out.println("❌ Error al insertar libro: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public List<Libro> listarTodos() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT l FROM Libro l", Libro.class).getResultList();
        } finally {
            em.close();
        }
    }

    public Libro buscarPorId(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Libro.class, id);
        } finally {
            em.close();
        }
    }

    public void actualizar(Libro libro) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(libro);
            em.getTransaction().commit();
            System.out.println("✅ Libro actualizado: " + libro.getTitulo());
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.out.println("❌ Error al actualizar libro: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void eliminar(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Libro l = em.find(Libro.class, id);
            if (l != null) {
                em.remove(l);
                System.out.println("✅ Libro eliminado con ID: " + id);
            } else {
                System.out.println("⚠️ No se encontró libro con ID " + id);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.out.println("❌ Error al eliminar libro: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}