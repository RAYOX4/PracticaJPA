<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Usuarios</title>
        <style>
            body { font-family: Arial; padding: 20px; }
            table { border-collapse: collapse; width: 100%; margin-top: 20px; }
            th, td { border: 1px solid #ccc; padding: 10px; text-align: left; }
            th { background: #f57c00; color: white; }
            tr:nth-child(even) { background: #f9f9f9; }
        </style>
    </head>
    <body>
        <h1>👥 Lista de Usuarios</h1>
        <a href="index.jsp">← Volver al menú</a>

        <c:choose>
            <c:when test="${empty usuarios}">
                <p>⚠️ No hay usuarios registrados.</p>
            </c:when>
            <c:otherwise>
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Email</th>
                        <th>Teléfono</th>
                    </tr>
                    <c:forEach var="u" items="${usuarios}">
                        <tr>
                            <td>${u.idUsuario}</td>
                            <td>${u.nombre}</td>
                            <td>${u.email}</td>
                            <td>${u.telefono}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>
    </body>
</html>