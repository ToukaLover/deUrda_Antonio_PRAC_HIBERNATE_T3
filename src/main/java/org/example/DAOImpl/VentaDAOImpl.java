package org.example.DAOImpl;

import org.example.DAO.VentaDAO;
import org.example.Utilities.HibernateUtil;
import org.example.models.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VentaDAOImpl implements VentaDAO {

    org.hibernate.Session session;
    Transaction transaction = null;

    CocheDAOImpl cocheDAO = new CocheDAOImpl();
    public VentaDAOImpl() {
        this.session = HibernateUtil.getSession();
    }

    @Override
    public void add() {
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter t = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("En que fecha se hizo la venta");
        String fecha1= sc.next();
        Date fecha=Date.valueOf(LocalDate.parse(fecha1,t));
        System.out.println("Dime el monto");
        double monto= sc.nextDouble();
        System.out.println("Dime el id del empleado");
        int idEmpleado=sc.nextInt();
        Empleado empleado = session.get(Empleado.class,idEmpleado);
        System.out.println("Dime el id del cliente");
        int idCliente=sc.nextInt();
        Cliente cliente = session.get(Cliente.class,idCliente);

        List<Coche> cochesParaVenta = new ArrayList<>();
        int idCoche=1;

        Venta v = null;
        Coche c = null;
        do {
            System.out.println("Dime los id del Coche, si pones 0 dejas de poner coches");
            idCoche=sc.nextInt();
            if (idCoche!=0){
                c = session.get(Coche.class,idCoche);
                cochesParaVenta.add(c);


                List<Venta> ventasParaCoche= new ArrayList<>();
                List<Cliente> clientesParaCoches = new ArrayList<>();
                ventasParaCoche.add(v);



                clientesParaCoches.add(cliente);
                c.setClientes(clientesParaCoches);

                session.update(c);

            }
        }while (idCoche!=0);

        v = new Venta(fecha,monto,empleado,cliente,cochesParaVenta);

        for (Coche coche : cochesParaVenta){
            coche.getVentas().add(v);
            session.update(coche);
        }

        try{
            transaction= session.beginTransaction();
            session.save(v);
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
        System.out.println("Dime el id de la venta a eliminar");
        int id = sc.nextInt();

        Venta v = ventaById(id);

        try{
            transaction= session.beginTransaction();
            session.delete(v);
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

        DateTimeFormatter t = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("En que fecha se hizo la venta");
        String fecha1= sc.next();
        Date fecha=Date.valueOf(LocalDate.parse(fecha1,t));
        System.out.println("Dime el monto");
        double monto= sc.nextDouble();
        System.out.println("Dime el id del empleado");
        int idEmpleado=sc.nextInt();
        Empleado empleado = session.get(Empleado.class,idEmpleado);
        System.out.println("Dime el id del cliente");
        int idCliente=sc.nextInt();
        Cliente cliente = session.get(Cliente.class,idCliente);

        List<Coche> cochesParaVenta = new ArrayList<>();
        int idCoche=1;

        Venta v = null;
        Coche c = null;
        do {
            System.out.println("Dime los id del Coche, si pones 0 dejas de poner coches");
            idCoche=sc.nextInt();
            if (idCoche!=0){
                c = session.get(Coche.class,idCoche);
                cochesParaVenta.add(c);


                List<Venta> ventasParaCoche= new ArrayList<>();
                List<Cliente> clientesParaCoches = new ArrayList<>();
                ventasParaCoche.add(v);



                clientesParaCoches.add(cliente);
                c.setClientes(clientesParaCoches);

                session.update(c);

            }
        }while (idCoche!=0);

        v = new Venta(fecha,monto,empleado,cliente,cochesParaVenta);

        for (Coche coche : cochesParaVenta){
            coche.getVentas().add(v);
            session.update(coche);
        }

        try{
            transaction= session.beginTransaction();
            session.update(v);
            transaction.commit();
        }catch (Exception e){

            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Venta> allVenta() {
        String sql="from Venta";

        try{
            Query query = session.createQuery(sql);

            List<Venta> ventas = query.getResultList();

            return  ventas;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Venta ventaById(int id) {
        String sql="from Venta where id=:idDado";

        try{
            Query query = session.createQuery(sql);

            query.setParameter("idDado",id);

            List<Venta> ventas = query.getResultList();

            return ventas.getFirst();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
