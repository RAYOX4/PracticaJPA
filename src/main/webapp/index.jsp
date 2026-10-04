<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Biblioteca JPA</title>
        <style>
            body { font-family: Arial; padding: 40px; background: #f5f5f5; }
            h1 { color: #333; }
            .card {
                background: white; padding: 20px; margin: 10px 0;
                border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1);
                display: block; text-decoration: none; color: #1976d2;
                font-size: 20px;
            }
            .card:hover { background: #e3f2fd; }
        </style>
    </head>
    <body>
        <h1>📚 Sistema de Biblioteca (JPA + JSP)</h1>
        <a class="card" href="autores">👤 Ver Autores</a>
        <a class="card" href="libros">📖 Ver Libros</a>
        <a class="card" href="usuarios">👥 Ver Usuarios</a>
        <a class="card" href="prestamos">📋 Ver Préstamos</a>
    </body>
</html>