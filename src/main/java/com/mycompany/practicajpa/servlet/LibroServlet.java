package com.mycompany.practicajpa.servlet;

import com.mycompany.practicajpa.dao.LibroDaoJPA;
import com.mycompany.practicajpa.modelo.Libro;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/libros")
public class LibroServlet extends HttpServlet {

    private final LibroDaoJPA libroDao = new LibroDaoJPA();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Libro> lista = libroDao.listarTodos();
        request.setAttribute("libros", lista);
        request.getRequestDispatcher("/libros.jsp").forward(request, response);
    }
}