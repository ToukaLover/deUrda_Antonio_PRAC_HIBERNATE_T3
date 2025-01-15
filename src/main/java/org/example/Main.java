package org.example;

import org.example.DAO.VentaDAO;
import org.example.DAOImpl.*;
import org.example.Utilities.HibernateUtil;
import org.example.models.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        Bateria de Datos:
        crearDatos();

        Scanner sc = new Scanner(System.in);
        CocheDAOImpl cocheDAOImpl = new CocheDAOImpl();
        ClienteDAOImpl clienteDAOImpl = new ClienteDAOImpl();
        UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();
        EmpleadoDAOImpl empleadoDAOImpl = new EmpleadoDAOImpl();
        ReparacionDAOImpl reparacionDAOImpl = new ReparacionDAOImpl();
        VentaDAOImpl ventaDAOImpl = new VentaDAOImpl();

        int opcion=1;
        do {

            System.out.println("Menu");
            System.out.println("Dime que Opcion que quieres:");
            System.out.println("1- Clientes");
            System.out.println("2- Coches");
            System.out.println("3- Empleados");
            System.out.println("4- Reparaciones");
            System.out.println("5- Usuario");
            System.out.println("6- Ventas");
            System.out.println("7- Consultas Dificiles");
            System.out.println("0- Salir");

            System.out.println("Dime que Opcion quieres:");
            opcion=sc.nextInt();

            switch (opcion){
                case 1:
                    int opcionMenu=1;
                    do{
                        System.out.println("Clientes");
                        System.out.println("Dime que Opcion que quieres:");
                        System.out.println("1- Agregar");
                        System.out.println("2- Eliminar");
                        System.out.println("3- Actualizar");
                        System.out.println("4- Listar todos");
                        System.out.println("5- Buscar por Id");
                        System.out.println("0- Salir");

                        System.out.println("Dime que Opcion quieres:");
                        opcionMenu=sc.nextInt();

                        switch (opcionMenu){

                            case 1:
                                clienteDAOImpl.add();
                                break;
                            case 2:
                                clienteDAOImpl.delete();
                                break;
                            case 3:
                                clienteDAOImpl.update();
                                break;
                            case 4:
                                for (Cliente c : clienteDAOImpl.allCliente()){

                                    System.out.println(c);

                                }
                                break;
                            case 5:
                                System.out.println("Dime el id del cliente que quieres buscar");
                                int id = sc.nextInt();
                                System.out.println(clienteDAOImpl.ClienteById(id));
                                break;
                            case 0:
                                System.out.println("Saliendo");
                                break;
                            default:
                                System.out.println("Opcion no valida");
                                break;

                        }
                    }while(opcionMenu!=0);
                    break;
                case 2:
                    int opcionMenu2=1;
                    do{
                        System.out.println("Coche");
                        System.out.println("Dime que Opcion que quieres:");
                        System.out.println("1- Agregar");
                        System.out.println("2- Eliminar");
                        System.out.println("3- Actualizar");
                        System.out.println("4- Listar todos");
                        System.out.println("5- Buscar por Id");
                        System.out.println("0- Salir");

                        System.out.println("Dime que Opcion quieres:");
                        opcionMenu2=sc.nextInt();

                        switch (opcionMenu2){

                            case 1:
                                cocheDAOImpl.add();
                                break;
                            case 2:
                                cocheDAOImpl.delete();
                                break;
                            case 3:
                                cocheDAOImpl.update();
                                break;
                            case 4:
                                for (Coche c : cocheDAOImpl.allCoche()){

                                    System.out.println(c);

                                }
                                break;
                            case 5:
                                System.out.println("Dime el id del coche que quieres buscar");
                                int id = sc.nextInt();
                                System.out.println(cocheDAOImpl.cocheById(id));
                                break;
                            case 0:
                                System.out.println("Saliendo");
                                break;
                            default:
                                System.out.println("Opcion no valida");
                                break;

                        }
                    }while(opcionMenu2!=0);
                    break;
                case 3:
                    int opcionMenu3=1;
                    do{
                        System.out.println("Empleado");
                        System.out.println("Dime que Opcion que quieres:");
                        System.out.println("1- Agregar");
                        System.out.println("2- Eliminar");
                        System.out.println("3- Actualizar");
                        System.out.println("4- Listar todos");
                        System.out.println("5- Buscar por Id");
                        System.out.println("0- Salir");

                        System.out.println("Dime que Opcion quieres:");
                        opcionMenu3=sc.nextInt();

                        switch (opcionMenu3){
                            case 1:
                                empleadoDAOImpl.add();
                                break;
                            case 2:
                                empleadoDAOImpl.delete();
                                break;
                            case 3:
                                empleadoDAOImpl.update();
                                break;
                            case 4:
                                for (Empleado e : empleadoDAOImpl.allEmpleado()){

                                    System.out.println(e);

                                }
                                break;
                            case 5:
                                System.out.println("Dime el id del empleado que quieres buscar");
                                int id = sc.nextInt();
                                System.out.println(empleadoDAOImpl.empleadoById(id));
                                break;
                            case 0:
                                System.out.println("Saliendo");
                                break;
                            default:
                                System.out.println("Opcion no valida");
                                break;

                        }
                    }while(opcionMenu3!=0);
                    break;
                case 4:
                    int opcionMenu4=1;
                    do{
                        System.out.println("Reparacion");
                        System.out.println("Dime que Opcion que quieres:");
                        System.out.println("1- Agregar");
                        System.out.println("2- Eliminar");
                        System.out.println("3- Actualizar");
                        System.out.println("4- Listar todos");
                        System.out.println("5- Buscar por Id");
                        System.out.println("0- Salir");

                        System.out.println("Dime que Opcion quieres:");
                        opcionMenu4=sc.nextInt();

                        switch (opcionMenu4){
                            case 1:
                                reparacionDAOImpl.add();
                                break;
                            case 2:
                                reparacionDAOImpl.delete();
                                break;
                            case 3:
                                reparacionDAOImpl.update();
                                break;
                            case 4:
                                for (Reparacion r : reparacionDAOImpl.allReparacion()){

                                    System.out.println(r);

                                }
                                break;
                            case 5:
                                System.out.println("Dime el id de la reparacion que quieres buscar");
                                int id = sc.nextInt();
                                System.out.println(reparacionDAOImpl.reparacionById(id));
                                break;
                            case 0:
                                System.out.println("Saliendo");
                                break;
                            default:
                                System.out.println("Opcion no valida");
                                break;

                        }
                    }while(opcionMenu4!=0);
                    break;
                case 5:
                    int opcionMenu5=1;
                    do{
                        System.out.println("Usuario:");
                        System.out.println("Dime que Opcion que quieres:");
                        System.out.println("1- Agregar");
                        System.out.println("2- Eliminar");
                        System.out.println("3- Actualizar");
                        System.out.println("4- Listar todos");
                        System.out.println("5- Buscar por Id");
                        System.out.println("0- Salir");

                        System.out.println("Dime que Opcion quieres:");
                        opcionMenu5=sc.nextInt();

                        switch (opcionMenu5){
                            case 1:
                                usuarioDAOImpl.add();
                                break;
                            case 2:
                                usuarioDAOImpl.delete();
                                break;
                            case 3:
                                usuarioDAOImpl.update();
                                break;
                            case 4:
                                for (Usuario u : usuarioDAOImpl.allUsuario()){

                                    System.out.println(u);

                                }
                                break;
                            case 5:
                                System.out.println("Dime el id del usuario que quieres buscar");
                                int id = sc.nextInt();
                                System.out.println(usuarioDAOImpl.usuarioById(id));
                                break;
                            case 0:
                                System.out.println("Saliendo");
                                break;
                            default:
                                System.out.println("Opcion no valida");
                                break;

                        }
                    }while(opcionMenu5!=0);
                    break;
                case 6:
                    int opcionMenu6=1;
                    do{
                        System.out.println("Venta:");
                        System.out.println("Dime que Opcion que quieres:");
                        System.out.println("1- Agregar");
                        System.out.println("2- Eliminar");
                        System.out.println("3- Actualizar");
                        System.out.println("4- Listar todos");
                        System.out.println("5- Buscar por Id");
                        System.out.println("0- Salir");

                        System.out.println("Dime que Opcion quieres:");
                        opcionMenu6=sc.nextInt();

                        switch (opcionMenu6){
                            case 1:
                                ventaDAOImpl.add();
                                break;
                            case 2:
                                ventaDAOImpl.delete();
                                break;
                            case 3:
                                ventaDAOImpl.update();
                                break;
                            case 4:
                                for (Venta v : ventaDAOImpl.allVenta()){

                                    System.out.println(v);

                                }
                                break;
                            case 5:
                                System.out.println("Dime el id de la venta que quieres buscar");
                                int id = sc.nextInt();
                                System.out.println(ventaDAOImpl.ventaById(id));
                                break;
                            case 0:
                                System.out.println("Saliendo");
                                break;
                            default:
                                System.out.println("Opcion no valida");
                                break;

                        }
                    }while(opcionMenu6!=0);
                    break;
                case 7:
                    int opcionMenu7=1;
                    do {

                        System.out.println("Consultas dificiles");
                        System.out.println("1- Listar todos los coches vendidos en un rango de fechas.");
                        System.out.println("2- Mostrar las reparaciones realizadas por un mecánico específico");
                        System.out.println("3- Obtener los coches que ha comprado un cliente en particular");
                        System.out.println("4- Calcular el total de ingresos generados por ventas en un mes");
                        System.out.println("0- Salir");

                        opcionMenu7=sc.nextInt();
                        switch (opcionMenu7){
                            case 1:
                                Scanner sc2 = new Scanner(System.in);
                                DateTimeFormatter t = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                                System.out.println("Dime la fecha de inicio");
                                String fecha1=sc2.nextLine();
                                Date fechaInicio =Date.valueOf(LocalDate.parse(fecha1,t));
                                System.out.println("Dime la fecha de fin");
                                String fecha2=sc2.nextLine();
                                Date fechaFin =Date.valueOf(LocalDate.parse(fecha2,t));
                                List<Coche> coches = listarCochesVendidosEnRango(fechaInicio,fechaFin);
                                for (Coche c : coches){
                                    System.out.println(c.toString());
                                }
                                break;
                            case 2:
                                System.out.println("Dime el id del empleado");
                                int id = sc.nextInt();
                                List<Reparacion> reparaciones = listarReparacionesPorMecanico(id);
                                for (Reparacion r : reparaciones){
                                    System.out.println(r.toString());
                                }
                                break;
                            case 3:
                                System.out.println("Dime el id del cliente");
                                int idCliente = sc.nextInt();
                                List<Coche> cochesCliente = listarCochesPorCliente(idCliente);
                                for (Coche c : cochesCliente){
                                    System.out.println(c.toString());
                                }
                                break;
                            case 4:
                                System.out.println("Dime el numero de mes");
                                int mes = sc.nextInt();
                                System.out.println("Dime el numero de año");
                                int año = sc.nextInt();
                                System.out.println(calcularIngresosPorMes(mes,año));
                                break;
                            case 0:
                                System.out.println("Saliendo");
                                break;
                            default:
                                System.out.println("Opcion no valida");
                                break;
                        }
                    }while (opcionMenu7!=0);

                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }while(opcion!=0);
    }
    public static void crearDatos() {

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        // Formato de fecha
        DateTimeFormatter t = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Crear objetos de Usuario
        Usuario usuario1 = new Usuario("user1", "password1");
        Usuario usuario2 = new Usuario("user2", "password2");
        Usuario usuario3 = new Usuario("user3", "password3");
        Usuario usuario4 = new Usuario("user4", "password4");
        Usuario usuario5 = new Usuario("user5", "password5");
        Usuario usuario6 = new Usuario("user6", "password6");
        Usuario usuario7 = new Usuario("user7", "password7");
        Usuario usuario8 = new Usuario("user8", "password8");
        Usuario usuario9 = new Usuario("user9", "password9");
        Usuario usuario10 = new Usuario("user10", "password10");

        // Crear listas de reparaciones y ventas vacías para llenarlas después
        List<Reparacion> reparaciones1 = new ArrayList<>();
        List<Reparacion> reparaciones2 = new ArrayList<>();
        List<Reparacion> reparaciones3 = new ArrayList<>();
        List<Reparacion> reparaciones4 = new ArrayList<>();
        List<Reparacion> reparaciones5 = new ArrayList<>();

        List<Venta> ventas1 = new ArrayList<>();
        List<Venta> ventas2 = new ArrayList<>();
        List<Venta> ventas3 = new ArrayList<>();
        List<Venta> ventas4 = new ArrayList<>();
        List<Venta> ventas5 = new ArrayList<>();

        // Crear objetos de Cliente
        Cliente cliente1 = new Cliente("Juan Pérez", "juan@example.com", "123456789", ventas1, new ArrayList<>());
        Cliente cliente2 = new Cliente("María López", "maria@example.com", "987654321", ventas2, new ArrayList<>());
        Cliente cliente3 = new Cliente("Carlos García", "carlos@example.com", "567890123", ventas3, new ArrayList<>());
        Cliente cliente4 = new Cliente("Ana Torres", "ana@example.com", "678901234", ventas4, new ArrayList<>());
        Cliente cliente5 = new Cliente("Luis Fernández", "luis@example.com", "789012345", ventas5, new ArrayList<>());

        // Crear objetos de Coche
        Coche coche1 = new Coche("Toyota", "Corolla", 2020, 20000.0, reparaciones1, ventas1, new ArrayList<>());
        Coche coche2 = new Coche("Honda", "Civic", 2019, 22000.0, reparaciones2, ventas2, new ArrayList<>());
        Coche coche3 = new Coche("Ford", "Focus", 2018, 18000.0, reparaciones3, ventas3, new ArrayList<>());
        Coche coche4 = new Coche("Chevrolet", "Cruze", 2021, 25000.0, reparaciones4, ventas4, new ArrayList<>());
        Coche coche5 = new Coche("Nissan", "Sentra", 2022, 23000.0, reparaciones5, ventas5, new ArrayList<>());

        // Crear objetos de Empleado y vincular a usuarios
        Empleado empleado1 = new Empleado("Pedro Martínez", "Mecánico", 3000.0, usuario1, reparaciones1);
        Empleado empleado2 = new Empleado("Laura Gómez", "Vendedora", 3500.0, usuario2, reparaciones2);
        Empleado empleado3 = new Empleado("Jorge Ruiz", "Supervisor", 4000.0, usuario3, reparaciones3);
        Empleado empleado4 = new Empleado("Sofía Ramírez", "Gerente", 4500.0, usuario4, reparaciones4);
        Empleado empleado5 = new Empleado("Raúl Sánchez", "Asistente", 2800.0, usuario5, reparaciones5);
        Empleado empleado6 = new Empleado("Elena Díaz", "Mecánica", 3200.0, usuario6, new ArrayList<>());
        Empleado empleado7 = new Empleado("Carlos López", "Vendedor", 3600.0, usuario7, new ArrayList<>());
        Empleado empleado8 = new Empleado("Rosa Martínez", "Recepcionista", 3000.0, usuario8, new ArrayList<>());
        Empleado empleado9 = new Empleado("Diego Moreno", "Jefe de Taller", 4700.0, usuario9, new ArrayList<>());
        Empleado empleado10 = new Empleado("Clara Fernández", "Contadora", 4200.0, usuario10, new ArrayList<>());

        // Crear objetos de Reparación con fechas
        Reparacion reparacion1 = new Reparacion("Cambio de aceite", Date.valueOf(LocalDate.parse("2021-10-31", t)), 100.0, coche1, empleado1);
        Reparacion reparacion2 = new Reparacion("Reparación de frenos", Date.valueOf(LocalDate.parse("2020-12-03", t)), 200.0, coche2, empleado2);
        Reparacion reparacion3 = new Reparacion("Reemplazo de llantas", Date.valueOf(LocalDate.parse("2022-04-22", t)), 400.0, coche3, empleado3);
        Reparacion reparacion4 = new Reparacion("Revisión general", Date.valueOf(LocalDate.parse("2023-03-28", t)), 150.0, coche4, empleado4);
        Reparacion reparacion5 = new Reparacion("Cambio de batería", Date.valueOf(LocalDate.parse("2024-08-16", t)), 120.0, coche5, empleado5);
        Reparacion reparacion6 = new Reparacion("Reparación de motor", Date.valueOf(LocalDate.parse("2021-10-03", t)), 1000.0, coche1, empleado1);
        Reparacion reparacion7 = new Reparacion("Pintura completa", Date.valueOf(LocalDate.parse("2024-06-02", t)), 600.0, coche2, empleado2);
        Reparacion reparacion8 = new Reparacion("Ajuste de suspensión", Date.valueOf(LocalDate.parse("2023-09-05", t)), 300.0, coche3, empleado3);
        Reparacion reparacion9 = new Reparacion("Cambio de transmisión", Date.valueOf(LocalDate.parse("2024-12-04", t)), 1200.0, coche4, empleado4);
        Reparacion reparacion10 = new Reparacion("Instalación de nuevo sistema de sonido", Date.valueOf(LocalDate.parse("2021-09-13", t)), 800.0, coche5, empleado5);

        // Añadir reparaciones a las listas correspondientes
        reparaciones1.add(reparacion1);
        reparaciones1.add(reparacion6);
        reparaciones2.add(reparacion2);
        reparaciones2.add(reparacion7);
        reparaciones3.add(reparacion3);
        reparaciones3.add(reparacion8);
        reparaciones4.add(reparacion4);
        reparaciones4.add(reparacion9);
        reparaciones5.add(reparacion5);
        reparaciones5.add(reparacion10);

        // Crear objetos de Venta con fechas
        List<Coche> cochesVenta1 = new ArrayList<>();
        cochesVenta1.add(coche1);
        cochesVenta1.add(coche2);

        List<Coche> cochesVenta2 = new ArrayList<>();
        cochesVenta2.add(coche3);
        cochesVenta2.add(coche4);

        List<Coche> cochesVenta3 = new ArrayList<>();
        cochesVenta3.add(coche5);
        cochesVenta3.add(coche1);

        Venta venta1 = new Venta(Date.valueOf(LocalDate.parse("2024-07-09", t)), 42000.0, empleado1, cliente1, cochesVenta1);
        Venta venta2 = new Venta(Date.valueOf(LocalDate.parse("2024-03-09", t)), 48000.0, empleado2, cliente2, cochesVenta2);
        Venta venta3 = new Venta(Date.valueOf(LocalDate.parse("2022-12-11", t)), 43000.0, empleado3, cliente3, cochesVenta3);

        // Añadir ventas a las listas correspondientes
        ventas1.add(venta1);
        ventas2.add(venta2);
        ventas3.add(venta3);

        // Vincular ventas y coches a clientes
        cliente1.getCoches().add(coche1);
        cliente1.getCoches().add(coche2);
        cliente2.getCoches().add(coche3);
        cliente2.getCoches().add(coche4);
        cliente3.getCoches().add(coche5);
        cliente3.getCoches().add(coche1);

        // Vincular ventas y clientes a coches
        coche1.getClientes().add(cliente1);
        coche1.getClientes().add(cliente3);
        coche2.getClientes().add(cliente1);
        coche3.getClientes().add(cliente2);
        coche4.getClientes().add(cliente2);
        coche5.getClientes().add(cliente3);

        try{
            // Guardar usuarios
            session.save(usuario1);
            session.save(usuario2);
            session.save(usuario3);
            session.save(usuario4);
            session.save(usuario5);
            session.save(usuario6);
            session.save(usuario7);
            session.save(usuario8);
            session.save(usuario9);
            session.save(usuario10);

            // Guardar coches
            session.save(coche1);
            session.save(coche2);
            session.save(coche3);
            session.save(coche4);
            session.save(coche5);

            // Guardar clientes
            session.save(cliente1);
            session.save(cliente2);
            session.save(cliente3);
            session.save(cliente4);
            session.save(cliente5);

            // Guardar empleados
            session.save(empleado1);
            session.save(empleado2);
            session.save(empleado3);
            session.save(empleado4);
            session.save(empleado5);
            session.save(empleado6);
            session.save(empleado7);
            session.save(empleado8);
            session.save(empleado9);
            session.save(empleado10);

            // Guardar reparaciones
            session.save(reparacion1);
            session.save(reparacion2);
            session.save(reparacion3);
            session.save(reparacion4);
            session.save(reparacion5);
            session.save(reparacion6);
            session.save(reparacion7);
            session.save(reparacion8);
            session.save(reparacion9);
            session.save(reparacion10);

            // Guardar ventas
            session.save(venta1);
            session.save(venta2);
            session.save(venta3);

            // Commit de la transacción
            transaction.commit();
            System.out.println("Datos creados");
        }catch (Exception e){
            transaction.commit();
            if (transaction!=null){
                transaction.rollback();
                e.printStackTrace();
            }
        }
    }

    public static List<Coche> listarCochesVendidosEnRango(Date fechaInicio, Date fechaFin) {
        Session session = HibernateUtil.getSession();
        String hql = "SELECT c FROM Venta v JOIN v.coches c WHERE v.fecha BETWEEN :fechaInicio AND :fechaFin";
        return session.createQuery(hql, Coche.class)
                .setParameter("fechaInicio", fechaInicio)
                .setParameter("fechaFin", fechaFin)
                .getResultList();
    }

    public static List<Reparacion> listarReparacionesPorMecanico(int mecanicoId) {
        Session session = HibernateUtil.getSession();
        String hql = "FROM Reparacion r WHERE r.empleado.id = :mecanicoId";
        return session.createQuery(hql, Reparacion.class)
                .setParameter("mecanicoId", mecanicoId)
                .getResultList();
    }

    public static List<Coche> listarCochesPorCliente(int clienteId) {
        Session session = HibernateUtil.getSession();
        String hql = "SELECT c FROM Cliente cl JOIN cl.coches c WHERE cl.id = :clienteId";
        return session.createQuery(hql, Coche.class)
                .setParameter("clienteId", clienteId)
                .getResultList();
    }

    public static Double calcularIngresosPorMes(int mes, int anio) {
        Session session = HibernateUtil.getSession();
        String hql = "SELECT SUM(v.monto) FROM Venta v WHERE MONTH(v.fecha) = :mes AND YEAR(v.fecha) = :anio";
        return session.createQuery(hql, Double.class)
                .setParameter("mes", mes)
                .setParameter("anio", anio)
                .uniqueResult();
    }





}