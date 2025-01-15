package org.example.DAO;

import org.example.models.Coche;
import org.example.models.Empleado;

import java.util.List;

public interface EmpleadoDAO {
    void add();
    void delete();
    void update();
    List<Empleado> allEmpleado();
    Empleado empleadoById(int id);
}
