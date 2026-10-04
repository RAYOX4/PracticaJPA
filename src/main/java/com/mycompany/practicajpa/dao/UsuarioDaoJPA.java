package com.mycompany.practicajpa.dao;

import com.mycompany.practicajpa.modelo.Usuario;
import jakarta.persistence.*;
import java.util.List;

public class UsuarioDaoJPA {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("PracticaJPA-PU");

    public void insertar(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
            System.out.println("✅ Usuario insertado: " + usuario.getNombre());
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.out.println("❌ Error al insertar usuario: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public List<Usuario> listarTodos() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
        } finally {
            em.close();
        }
    }

    public Usuario buscarPorId(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public void actualizar(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(usuario);
            em.getTransaction().commit();
            System.out.println("✅ Usuario actualizado: " + usuario.getNombre());
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.out.println("❌ Error al actualizar usuario: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void eliminar(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Usuario u = em.find(Usuario.class, id);
            if (u != null) {
                em.remove(u);
                System.out.println("✅ Usuario eliminado con ID: " + id);
            } else {
                System.out.println("⚠️ No se encontró usuario con ID " + id);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.out.println("❌ Error al eliminar usuario: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}