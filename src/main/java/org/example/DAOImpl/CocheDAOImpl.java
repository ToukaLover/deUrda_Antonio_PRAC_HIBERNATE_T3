package org.example.DAOImpl;

import com.mysql.cj.Session;
import org.example.DAO.CocheDAO;
import org.example.Utilities.HibernateUtil;
import org.example.models.Cliente;
import org.example.models.Coche;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class CocheDAOImpl implements CocheDAO {

    org.hibernate.Session session;
    Transaction transaction = null;


    public CocheDAOImpl() {
        this.session = HibernateUtil.getSession();
    }

    @Override
    public void add() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Que marca tiene el coche");
        String marca = sc.next();
        System.out.println("Cual es su modelo");
        String modelo = sc.next();
        System.out.println("Cual es su año");
        int año = sc.nextInt();
        System.out.println("Cual es su precio");
        double precio=sc.nextDouble();

        Coche c = new Coche(marca,modelo,año,precio);

        try{
            transaction= session.beginTransaction();
            session.save(c);
            transaction.commit();
        }catch (Exception e){

            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        }
    }

    @Override
    public void delete() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Dime el id del coche a eliminar");
        int id = sc.nextInt();

        Coche c = this.cocheById(id);

        try{
            transaction= session.beginTransaction();
            session.delete(c);
            transaction.commit();
        }catch (Exception e){

            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        }

    }

    @Override
    public void update() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Cual es el id del Coche a actualizar");
        int id=sc.nextInt();

        Coche c = this.cocheById(id);

        System.out.println("Dime la marca nueva");
        String marca = sc.next();
        System.out.println("Dime el modelo nuevo");
        String modelo = sc.next();
        System.out.println("Dime el año nuevo");
        int año=sc.nextInt();
        System.out.println("Dime el precio nuevo");
        double precio = sc.nextDouble();

        c.setMarca(marca);
        c.setModelo(modelo);
        c.setAño(año);
        c.setPrecio(precio);

        try{
            transaction= session.beginTransaction();
            session.update(c);
            transaction.commit();
        }catch (Exception e){

            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        }

    }


    @Override
    public List<Coche> allCoche() {

        String sql="from Coche";

        try{
            Query query = session.createQuery(sql);

            List<Coche> coches = query.getResultList();

            return  coches;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Coche cocheById(int id) {

        String sql="from Coche where id=:idDado";

        try{
            Query query = session.createQuery(sql);

            query.setParameter("idDado",id);

            List<Coche> coches = query.getResultList();

            return coches.getFirst();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
