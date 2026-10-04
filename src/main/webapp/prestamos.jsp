<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Préstamos</title>
        <style>
            body { font-family: Arial; padding: 20px; }
            table { border-collapse: collapse; width: 100%; margin-top: 20px; }
            th, td { border: 1px solid #ccc; padding: 10px; text-align: left; }
            th { background: #7b1fa2; color: white; }
            tr:nth-child(even) { background: #f9f9f9; }
        </style>
    </head>
    <body>
        <h1>📋 Lista de Préstamos</h1>
        <a href="index.jsp">← Volver al menú</a>

        <c:choose>
            <c:when test="${empty prestamos}">
                <p>⚠️ No hay préstamos registrados.</p>
            </c:when>
            <c:otherwise>
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Libro</th>
                        <th>Usuario</th>
                        <th>Fecha Préstamo</th>
                        <th>Fecha Devolución</th>
                    </tr>
                    <c:forEach var="p" items="${prestamos}">
                        <tr>
                            <td>${p.idPrestamo}</td>
                            <td>${p.libro.titulo}</td>
                            <td>${p.usuario.nombre}</td>
                            <td>${p.fechaPrestamo}</td>
                            <td>${empty p.fechaDevolucion ? 'Pendiente' : p.fechaDevolucion}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>
    </body>
</html>