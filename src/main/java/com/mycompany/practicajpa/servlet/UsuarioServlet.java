package com.mycompany.practicajpa.servlet;

import com.mycompany.practicajpa.dao.UsuarioDaoJPA;
import com.mycompany.practicajpa.modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/usuarios")
public class UsuarioServlet extends HttpServlet {

    private final UsuarioDaoJPA usuarioDao = new UsuarioDaoJPA();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Usuario> lista = usuarioDao.listarTodos();
        request.setAttribute("usuarios", lista);
        request.getRequestDispatcher("/usuarios.jsp").forward(request, response);
    }
}