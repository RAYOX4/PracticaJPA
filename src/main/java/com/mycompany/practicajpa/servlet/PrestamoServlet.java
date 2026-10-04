package com.mycompany.practicajpa.servlet;

import com.mycompany.practicajpa.dao.PrestamoDaoJPA;
import com.mycompany.practicajpa.modelo.Prestamo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/prestamos")
public class PrestamoServlet extends HttpServlet {

    private final PrestamoDaoJPA prestamoDao = new PrestamoDaoJPA();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Prestamo> lista = prestamoDao.listarTodos();
        request.setAttribute("prestamos", lista);
        request.getRequestDispatcher("/prestamos.jsp").forward(request, response);
    }
}