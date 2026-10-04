# PracticaJPA - Sistema de Biblioteca

Aplicación Web Java con **JPA + JSP** para gestionar una biblioteca.

## 📋 Características

- 4 módulos: **Autores, Libros, Usuarios, Préstamos**
- Persistencia con **JPA (EclipseLink)** sobre **MySQL**
- Vistas con **JSP + JSTL**
- Servlets como controladores (arquitectura **MVC**)
- Empaquetado como **WAR** desplegado en **Apache Tomcat 10.1**

## 🛠️ Tecnologías

- **Java 21**
- **Jakarta EE 10** (Servlet 6, JSP 3.1, JSTL 3)
- **EclipseLink 4.0.4** (JPA 3.1)
- **MySQL 9.1**
- **Maven 3.x**
- **Apache Tomcat 10.1.60**

## 🚀 Cómo ejecutar

1. Crear la base de datos `biblioteca_db` en MySQL:
   ```sql
   CREATE DATABASE biblioteca_db;
