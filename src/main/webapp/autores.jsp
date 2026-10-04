<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Autores</title>
        <style>
            body { font-family: Arial; padding: 20px; }
            table { border-collapse: collapse; width: 100%; margin-top: 20px; }
            th, td { border: 1px solid #ccc; padding: 10px; text-align: left; }
            th { background: #1976d2; color: white; }
            tr:nth-child(even) { background: #f9f9f9; }
        </style>
    </head>
    <body>
        <h1>👤 Lista de Autores</h1>
        <a href="index.jsp">← Volver al menú</a>

        <c:choose>
            <c:when test="${empty autores}">
                <p>⚠️ No hay autores registrados.</p>
            </c:when>
            <c:otherwise>
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Nacionalidad</th>
                    </tr>
                    <c:forEach var="a" items="${autores}">
                        <tr>
                            <td>${a.idAutor}</td>
                            <td>${a.nombre}</td>
                            <td>${a.nacionalidad}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>
    </body>
</html>