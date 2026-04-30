package main;

import dao.ProductoDAO;
import modelo.Producto;

public class Main {

    public static void main(String[] args) {

        ProductoDAO dao = new ProductoDAO();

        // INSERTAR
        Producto p = new Producto("Arroz", 2500, 10);
        dao.insertar(p);

        // CONSULTAR
        dao.listar().forEach(prod ->
                System.out.println(prod.getNombre())
        );

        // ACTUALIZAR
        p.setId(1);
        p.setNombre("Arroz Premium");
        dao.actualizar(p);

        // ELIMINAR
        dao.eliminar(1);
    }
}