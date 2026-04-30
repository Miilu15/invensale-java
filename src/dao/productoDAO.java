package dao;

import config.Conexion;
import modelo.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    // INSERTAR
    public void insertar(Producto p) {
        String sql = "INSERT INTO producto(nombre, precio, stock) VALUES (?, ?, ?)";

        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.executeUpdate();

            System.out.println("Producto insertado");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // CONSULTAR
    public List<Producto> listar() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM producto";

        try (Connection conn = Conexion.conectar();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));

                lista.add(p);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return lista;
    }

    // ACTUALIZAR
    public void actualizar(Producto p) {
        String sql = "UPDATE producto SET nombre=?, precio=?, stock=? WHERE id=?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setInt(4, p.getId());
            ps.executeUpdate();

            System.out.println("Producto actualizado");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // ELIMINAR
    public void eliminar(int id) {
        String sql = "DELETE FROM producto WHERE id=?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Producto eliminado");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}