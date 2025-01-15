package org.example.DAOImpl;

import org.example.DAO.UsuarioDAO;
import org.example.Utilities.HibernateUtil;
import org.example.models.Coche;
import org.example.models.Empleado;
import org.example.models.Usuario;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class UsuarioDAOImpl implements UsuarioDAO {

    org.hibernate.Session session;
    Transaction transaction = null;

    public UsuarioDAOImpl() {
        this.session = HibernateUtil.getSession();
    }

    @Override
    public void add() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Cual es el usuario");
        String nombre = sc.next();
        System.out.println("Cual es su contrasela");
        String contraseña= sc.next();

        Usuario u = new Usuario(nombre,contraseña);

        try{
            transaction= session.beginTransaction();
            session.save(u);
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

        Usuario u = this.usuarioById(id);

        try{
            transaction= session.beginTransaction();
            session.delete(u);
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

        System.out.println("Cual es el id del Usuario a actualizar");
        int id=sc.nextInt();

        Usuario u = this.usuarioById(id);

        System.out.println("Dime el usuario nuevo");
        String user= sc.next();
        System.out.println("Dime la contraseña nueva");
        String contraseña=sc.next();

        u.setUsername(user);
        u.setPassword(contraseña);

        try{
            transaction= session.beginTransaction();
            session.update(u);
            transaction.commit();
        }catch (Exception e){

            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        }

    }

    @Override
    public List<Usuario> allUsuario() {
        String sql="from Usuario";

        try{
            Query query = session.createQuery(sql);

            List<Usuario> usuarios = query.getResultList();

            return  usuarios;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Usuario usuarioById(int id) {
        String sql="from Usuario where id=:idDado";

        try{
            Query query = session.createQuery(sql);

            query.setParameter("idDado",id);

            List<Usuario> usuarios = query.getResultList();

            return usuarios.getFirst();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
