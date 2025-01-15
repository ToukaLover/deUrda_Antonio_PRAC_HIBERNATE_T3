package org.example.DAOImpl;

import org.example.DAO.ReparacionDAO;
import org.example.Utilities.HibernateUtil;
import org.example.models.Cliente;
import org.example.models.Coche;
import org.example.models.Empleado;
import org.example.models.Reparacion;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.swing.text.DateFormatter;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ReparacionDAOImpl implements ReparacionDAO {

    org.hibernate.Session session;
    Transaction transaction = null;
    CocheDAOImpl cocheDAO = new CocheDAOImpl();
    EmpleadoDAOImpl empleadoDAO = new EmpleadoDAOImpl();

    public ReparacionDAOImpl() {
        this.session = HibernateUtil.getSession();
    }

    @Override
    public void add() {

        Scanner sc = new Scanner(System.in);

        DateTimeFormatter t = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("Dime la descripcion de la reparacion");
        String desc=sc.nextLine();
        System.out.println("Dime la fecha");
        String fecha1= sc.next();
        Date fecha=Date.valueOf(LocalDate.parse(fecha1,t));
        System.out.println("Dime el costo");
        double costo=sc.nextDouble();
        System.out.println("Dime el id del coche");
        int id = sc.nextInt();
        Coche coche = cocheDAO.cocheById(id);
        System.out.println("Dime el id del empleado");
        int id1 = sc.nextInt();
        Empleado empleado = empleadoDAO.empleadoById(id1);

        Reparacion r = new Reparacion(desc,fecha,costo,coche,empleado);

        r.setCoche(coche);
        r.setEmpleado(empleado);

        try{
            transaction= session.beginTransaction();
            session.save(r);
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
        System.out.println("Dime el id de la reparacion a eliminar");
        int id = sc.nextInt();

        Reparacion r = this.reparacionById(id);

        try{
            transaction= session.beginTransaction();
            session.delete(r);
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

        System.out.println("Cual es el id del Coche a actualizar");
        int id=sc.nextInt();

        Reparacion r = this.reparacionById(id);

        System.out.println("Dime la descripcion de la reparacion");
        String desc=sc.nextLine();
        System.out.println("Dime la fecha");
        String fecha1= sc.next();
        Date fecha=Date.valueOf(LocalDate.parse(fecha1,t));
        System.out.println("Dime el costo");
        double costo=sc.nextDouble();
        System.out.println("Dime el id del coche");
        int id2 = sc.nextInt();
        Coche coche = cocheDAO.cocheById(id2);
        System.out.println("Dime el id del empleado");
        int id1 = sc.nextInt();
        Empleado empleado = empleadoDAO.empleadoById(id1);

        r.setDescripcion(desc);
        r.setFecha(fecha);
        r.setCosto(costo);
        r.setCoche(coche);
        r.setEmpleado(empleado);

        try{
            transaction= session.beginTransaction();
            session.update(r);
            transaction.commit();
        }catch (Exception e){

            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        }
    }

    @Override
    public List<Reparacion> allReparacion() {
        String sql="from Reparacion";

        try{
            Query query = session.createQuery(sql);

            List<Reparacion> reparaciones = query.getResultList();

            return  reparaciones;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Reparacion reparacionById(int id) {
        String sql="from Reparacion where id=:idDado";

        try{
            Query query = session.createQuery(sql);

            query.setParameter("idDado",id);

            List<Reparacion> reparaciones = query.getResultList();

            return reparaciones.getFirst();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
