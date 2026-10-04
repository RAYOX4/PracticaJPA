package com.mycompany.practicajpa.servlet;

import com.mycompany.practicajpa.dao.AutorDaoJPA;
import com.mycompany.practicajpa.modelo.Autor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/autores")
public class AutorServlet extends HttpServlet {

    private final AutorDaoJPA autorDao = new AutorDaoJPA();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Autor> lista = autorDao.listarTodos();
        request.setAttribute("autores", lista);
        request.getRequestDispatcher("/autores.jsp").forward(request, response);
    }
}