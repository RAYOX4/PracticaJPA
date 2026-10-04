<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Libros</title>
        <style>
            body { font-family: Arial; padding: 20px; }
            table { border-collapse: collapse; width: 100%; margin-top: 20px; }
            th, td { border: 1px solid #ccc; padding: 10px; text-align: left; }
            th { background: #388e3c; color: white; }
            tr:nth-child(even) { background: #f9f9f9; }
        </style>
    </head>
    <body>
        <h1>📖 Lista de Libros</h1>
        <a href="index.jsp">← Volver al menú</a>

        <c:choose>
            <c:when test="${empty libros}">
                <p>⚠️ No hay libros registrados.</p>
            </c:when>
            <c:otherwise>
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Título</th>
                        <th>Año</th>
                        <th>Autor</th>
                    </tr>
                    <c:forEach var="l" items="${libros}">
                        <tr>
                            <td>${l.idLibro}</td>
                            <td>${l.titulo}</td>
                            <td>${l.anioPublicacion}</td>
                            <td>${l.autor.nombre}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>
    </body>
</html>