package org.example.DAO;

import org.example.models.Coche;

import java.util.List;

public interface CocheDAO {

    void add();
    void delete();
    void update();
    List<Coche> allCoche();
    Coche cocheById(int id);

}
