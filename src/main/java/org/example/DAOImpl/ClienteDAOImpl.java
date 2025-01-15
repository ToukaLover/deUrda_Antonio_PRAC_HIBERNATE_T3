package org.example.DAOImpl;

import org.example.DAO.ClienteDAO;
import org.example.Utilities.HibernateUtil;
import org.example.models.Cliente;
import org.example.models.Coche;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class ClienteDAOImpl implements ClienteDAO {

    org.hibernate.Session session;
    Transaction transaction = null;


    public ClienteDAOImpl() {
        this.session = HibernateUtil.getSession();
    }

    @Override
    public void add() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Que nombre tiene el cliente");
        String nombre = sc.next();
        System.out.println("Cual es su email");
        String email = sc.next();
        System.out.println("Y su telefono");
        String telefono = sc.next();

        Cliente c = new Cliente(nombre,email,telefono);

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
        System.out.println("Dime el id del cliente a eliminar");
        int id = sc.nextInt();

        Cliente c = this.ClienteById(id);

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

        System.out.println("Dime el id del cliente a actualizar");
        int id = sc.nextInt();

        Cliente c  = this.ClienteById(id);

        System.out.println("Dime el nombre nueva");
        String nombre = sc.next();
        System.out.println("Dime el email nuevo");
        String email = sc.next();
        System.out.println("Dime el telefono nuevo");
        String telefono=sc.next();

        c.setNombre(nombre);
        c.setEmail(email);
        c.setTelefono(telefono);

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
    public List<Cliente> allCliente() {

        String sql="from Cliente";

        try{
            Query query = session.createQuery(sql);

            List<Cliente> clientes = query.getResultList();

            return  clientes;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Cliente ClienteById(int id) {

        String sql="from Cliente where id=:idDado";

        try{
            Query query = session.createQuery(sql);

            query.setParameter("idDado",id);

            List<Cliente> clientes = query.getResultList();

            return clientes.getFirst();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
