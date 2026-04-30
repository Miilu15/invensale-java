<%@ page import="java.util.List" %>
<%@ page import="modelo.Producto" %>

<html>
<body>

<h2>Lista de Productos</h2>

<table border="1">
<tr>
    <th>ID</th>
    <th>Nombre</th>
    <th>Precio</th>
    <th>Stock</th>
</tr>

<%
List<Producto> lista = (List<Producto>) request.getAttribute("lista");
if (lista != null) for(Producto p : lista){
%>
<tr>
    <td><%= p.getId() %></td>
    <td><%= p.getNombre() %></td>
    <td><%= p.getPrecio() %></td>
    <td><%= p.getStock() %></td>
</tr>
<% } %>

</table>

<a href="form.jsp">Nuevo Producto</a>

</body>
</html>