<%-- 
    Document   : nuevo
    Created on : 27 abr. 2022, 22:48:54
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <h2>Registro de Usuario</h2>
        
        <br />
        
        <form action="" method="POST" autocomplete="off">
            <p>
                Nombre: 
                <input id="nombre" name="nombre" type="text" />
            </p>
            
            <p>
                Apellido: 
                <input id="apellido" name="apellido" type="text" />
            </p>
            
            <p>
                Email: 
                <input id="email" name="email" type="text" />
            </p>
            
            <p>
                Contraseña: 
                <input id="password" name="password" type="text" />
            </p>
            
            <button id="guardar" name="guardar" type="submit">Guardar</button>
        </form>
    </body>
</html>
