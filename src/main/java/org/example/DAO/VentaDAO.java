package org.example.DAO;

import org.example.models.Coche;
import org.example.models.Venta;

import java.util.List;

public interface VentaDAO {
    void add();
    void delete();
    void update();
    List<Venta> allVenta();
    Venta ventaById(int id);

}
