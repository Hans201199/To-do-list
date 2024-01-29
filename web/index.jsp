<%-- 
    Document   : index
    Created on : 21/01/2024, 11:50:03 PM
    Author     : hanss
--%>

<%@page import="java.util.List"%>
<%@page import="Modelo.Tareas"%>
<%@page import="Controlador.Controlador"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>To do list app</title>
    <link href="css.css" rel="stylesheet" type="text/css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  </head>
  <body>
        <br/>
        <main class="container">
                <div class="card">
                    <div class="card-header">
                    Lista de tareas (TO DO LIST)
                    </div>
                <div class="card-body">               
                    
                    <div class="mb-3">
                        <form action="Controlador?accion=agregar" method="POST">
                            <label class="form-label">Tarea:</label>
                            <input type="text" class="form-control" placeholder="Escriba su tarea" name="tarea" id="tarea" aria-describedby="helpId">
                            <br/>
                            <input class="btn btn-primary" type="submit" name="agregar_tarea" id="agregar_tarea" value="Agregar tarea">
                        </form>
                    </div>
                   
                    <ul class="list-group">                       
                        <c:forEach var="l" items="${listado}">
                            <li class="list-group-item"> 
                                <form action="Controlador?accion=actualizar" method="POST">
                                    <input type="hidden" name="id" value="${l.getId()}" >
                                    <input type="checkbox" class="float-start form-check-input" ${l.getCompletado()==1?'checked' : ''}                                       
                                        id="tarea_check"
                                        name="tarea_check"
                                        value="${l.getCompletado()}"
                                        onChange="this.form.submit()">                                       
                                </form>
                                <span class="float-start ${l.getCompletado()==1?'subrayado' : ''}">&nbsp;${l.getTarea()}</span>
                                
                                <form action="Controlador?accion=eliminar" method="POST">    
                                    <input type="hidden" name="id" value="${l.getId()}" >
                                    &nbsp;&nbsp;<input class="btn btn-danger btn-sm" type="submit" name="eliminar_tarea" id="eliminar_tarea" value="X">
                                </form>
                            </li>
                            
                        </c:forEach>
                    </ul>                   
                    
                    <div class="card-footer text-muted">

                    </div>
                
                </div>
            </div>
        </main>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
  </body>
</html>
