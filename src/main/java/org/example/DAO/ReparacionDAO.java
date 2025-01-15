package org.example.DAO;

import org.example.models.Cliente;
import org.example.models.Reparacion;

import java.util.List;

public interface ReparacionDAO {

    void add();
    void delete();
    void update();
    List<Reparacion> allReparacion();
    Reparacion reparacionById(int id);

}
