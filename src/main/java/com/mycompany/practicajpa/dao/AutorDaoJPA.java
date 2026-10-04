package com.mycompany.practicajpa.dao;

import com.mycompany.practicajpa.modelo.Autor;
import jakarta.persistence.*;
import java.util.List;

public class AutorDaoJPA {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("PracticaJPA-PU");

    public void insertar(Autor autor) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(autor);
            em.getTransaction().commit();
            System.out.println("✅ Autor insertado: " + autor.getNombre());
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.out.println("❌ Error al insertar: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public List<Autor> listarTodos() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT a FROM Autor a", Autor.class).getResultList();
        } finally {
            em.close();
        }
    }

    public Autor buscarPorId(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Autor.class, id);
        } finally {
            em.close();
        }
    }

    public void actualizar(Autor autor) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(autor);
            em.getTransaction().commit();
            System.out.println("✅ Autor actualizado: " + autor.getNombre());
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.out.println("❌ Error al actualizar: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void eliminar(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Autor a = em.find(Autor.class, id);
            if (a != null) {
                em.remove(a);
                System.out.println("✅ Autor eliminado con ID: " + id);
            } else {
                System.out.println("⚠️ No se encontró autor con ID " + id);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.out.println("❌ Error al eliminar: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}