package com.mycompany.practicajpa.dao;

import com.mycompany.practicajpa.modelo.Prestamo;
import jakarta.persistence.*;
import java.util.List;

public class PrestamoDaoJPA {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("PracticaJPA-PU");

    public void insertar(Prestamo prestamo) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(prestamo);
            em.getTransaction().commit();
            System.out.println("✅ Préstamo insertado con ID: " + prestamo.getIdPrestamo());
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.out.println("❌ Error al insertar préstamo: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public List<Prestamo> listarTodos() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT p FROM Prestamo p", Prestamo.class).getResultList();
        } finally {
            em.close();
        }
    }

    public Prestamo buscarPorId(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Prestamo.class, id);
        } finally {
            em.close();
        }
    }

    public void actualizar(Prestamo prestamo) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(prestamo);
            em.getTransaction().commit();
            System.out.println("✅ Préstamo actualizado con ID: " + prestamo.getIdPrestamo());
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.out.println("❌ Error al actualizar préstamo: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void eliminar(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Prestamo p = em.find(Prestamo.class, id);
            if (p != null) {
                em.remove(p);
                System.out.println("✅ Préstamo eliminado con ID: " + id);
            } else {
                System.out.println("⚠️ No se encontró préstamo con ID " + id);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.out.println("❌ Error al eliminar préstamo: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}