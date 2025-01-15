package org.example.DAO;

import org.example.models.Coche;
import org.example.models.Empleado;
import org.example.models.Usuario;

import java.util.List;

public interface UsuarioDAO {
    void add();
    void delete();
    void update();
    List<Usuario> allUsuario();
    Usuario usuarioById(int id);
}
