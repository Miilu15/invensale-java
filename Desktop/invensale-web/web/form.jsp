<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Registrar Producto</title>
</head>
<body>

<h2>Registrar Producto</h2>

<form action="<%= request.getContextPath() %>/ProductoServlet" method="post">
    Nombre: <input type="text" name="nombre"><br>
    Precio: <input type="text" name="precio"><br>
    Stock: <input type="text" name="stock"><br>
    <button type="submit">Guardar</button>
</form>

<a href="<%= request.getContextPath() %>/ProductoServlet">Ver productos</a>

</body>
</html>