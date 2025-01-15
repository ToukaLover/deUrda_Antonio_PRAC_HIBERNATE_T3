package org.example.DAOImpl;

import org.example.DAO.EmpleadoDAO;
import org.example.Utilities.HibernateUtil;
import org.example.models.Coche;
import org.example.models.Empleado;
import org.example.models.Usuario;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class EmpleadoDAOImpl implements EmpleadoDAO {

    org.hibernate.Session session;
    Transaction transaction = null;

    public EmpleadoDAOImpl() {
        this.session = HibernateUtil.getSession();
    }

    @Override
    public void add() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Cual es el nombre del empleado");
        String nombre = sc.next();
        System.out.println("Cual es su puesto");
        String puesto = sc.next();
        System.out.println("Cual es su salario");
        double salario= sc.nextDouble();

        Empleado em = new Empleado(nombre,puesto,salario);

        System.out.println("Dime el id de su usuario");
        int id = sc.nextInt();
        em.setUsuario(session.get(Usuario.class,id));

        try{
            transaction= session.beginTransaction();
            session.save(em);
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
        System.out.println("Dime el id del empleado a eliminar");
        int id = sc.nextInt();

        Empleado em = this.empleadoById(id);

        try{
            transaction= session.beginTransaction();
            session.delete(em);
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

        System.out.println("Cual es el id del empleado a actualizar");
        int id=sc.nextInt();

        Empleado em = this.empleadoById(id);

        System.out.println("Dime la nombre nuev");
        String nombre = sc.next();
        System.out.println("Dime el puesto nuevo");
        String puesto = sc.next();
        System.out.println("Dime el salario nuevo");
        double salario=sc.nextDouble();
        System.out.println("Dime el id del usuario nuevo");
        int idUsuario=sc.nextInt();

        em.setNombre(nombre);
        em.setPuesto(puesto);
        em.setSalario(salario);
        em.setUsuario(session.get(Usuario.class,idUsuario));


        try{
            transaction= session.beginTransaction();
            session.update(em);
            transaction.commit();
        }catch (Exception e){

            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        }
    }

    @Override
    public List<Empleado> allEmpleado() {
        String sql="from Empleado";

        try{
            Query query = session.createQuery(sql);

            List<Empleado> empleados = query.getResultList();

            return  empleados;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Empleado empleadoById(int id) {
        String sql="from Empleado where id=:idDado";

        try{
            Query query = session.createQuery(sql);

            query.setParameter("idDado",id);

            List<Empleado> empleados = query.getResultList();

            return empleados.getFirst();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
