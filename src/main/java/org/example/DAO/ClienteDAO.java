package org.example.DAO;

import org.example.models.Cliente;
import org.example.models.Coche;

import java.util.List;

public interface ClienteDAO {

    void add();
    void delete();
    void update();
    List<Cliente> allCliente();
    Cliente ClienteById(int id);

}
