package servlet;

import dao.ProductoDAO;
import modelo.Producto;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ProductoServlet extends HttpServlet {

    ProductoDAO dao = new ProductoDAO();

    // GET → listar
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("lista", dao.listar());
        RequestDispatcher rd = request.getRequestDispatcher("/listar.jsp");
        rd.forward(request, response);
    }

    // POST → insertar
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String nombre = request.getParameter("nombre");
            double precio = Double.parseDouble(request.getParameter("precio"));
            int stock = Integer.parseInt(request.getParameter("stock"));

            Producto p = new Producto(nombre, precio, stock);
            dao.insertar(p);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Precio y stock deben ser valores numéricos.");
            request.getRequestDispatcher("/form.jsp").forward(request, response);
            return;
        }

        response.sendRedirect(request.getContextPath() + "/ProductoServlet");
    }
}