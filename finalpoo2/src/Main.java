import hotel.controlador.HabitacionController;
import hotel.controlador.ReporteController;
import hotel.controlador.ReservaControlador;
import hotel.model.ComponenteHabitacion;
import hotel.model.EstrategiaPago;
import hotel.model.Habitacion;
import hotel.model.Huesped;
import hotel.model.NivelSeguridad;
import hotel.model.PagoBilleteraDigital;
import hotel.model.PagoEfectivo;
import hotel.model.PagoTarjeta;
import hotel.model.Reserva;
import hotel.model.ReporteIngresosEfectivo;
import hotel.model.ReporteOcupacion;
import hotel.model.TipoHabitacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HabitacionController habitacionController = new HabitacionController();
        ReservaControlador reservaController = new ReservaControlador();
        ReporteController reporteController = new ReporteController();
        List<Huesped> huespedes = new ArrayList<>();

        int opcion;

        do {

            System.out.println("\n====================================");
            System.out.println("      SISTEMA DE GESTIÓN HOTELERA");
            System.out.println("====================================");
            System.out.println("1. Gestión de habitaciones");
            System.out.println("2. Gestión de reservas");
            System.out.println("3. Reportes");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = leerEntero(sc);

            switch (opcion) {

                case 1:
                    menuHabitaciones(sc, habitacionController);
                    break;

                case 2:
                    menuReservas(sc, reservaController, habitacionController, huespedes);
                    break;

                case 3:
                    menuReportes(sc, reporteController, reservaController, habitacionController);
                    break;

                case 0:
                    System.out.println("\nGracias por usar el sistema.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        sc.close();
    }

    private static void menuHabitaciones(Scanner sc, HabitacionController controller) {

        int opcion;

        do {

            System.out.println("\n---- GESTIÓN DE HABITACIONES ----");
            System.out.println("1. Agregar habitación");
            System.out.println("2. Listar habitaciones");
            System.out.println("3. Buscar habitaciones por tipo");
            System.out.println("4. Reservar habitación (marcar ocupada)");
            System.out.println("5. Liberar habitación");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = leerEntero(sc);

            switch (opcion) {

                case 1: {
                    System.out.print("Número de habitación: ");
                    int numero = leerEntero(sc);
                    System.out.print("Precio base: ");
                    double precio = leerDouble(sc);
                    TipoHabitacion tipo = elegirTipoHabitacion(sc);

                    controller.agregarHabitacion(numero, precio, tipo);
                    System.out.println("Habitación " + numero + " (" + tipo + ") agregada correctamente.");
                    break;
                }

                case 2: {
                    List<ComponenteHabitacion> habitaciones = controller.obtenerHabitaciones();
                    if (habitaciones.isEmpty()) {
                        System.out.println("No hay habitaciones registradas todavía.");
                    } else {
                        System.out.println("\nNº\tTipo\tPrecio\tEstado");
                        for (ComponenteHabitacion c : habitaciones) {
                            if (c instanceof Habitacion) {
                                Habitacion h = (Habitacion) c;
                                System.out.println(h.getNumero() + "\t" + h.getTipo()
                                        + "\t" + h.getPrecioBase() + "\t" + h.getEstado());
                            }
                        }
                    }
                    break;
                }

                case 3: {
                    TipoHabitacion tipo = elegirTipoHabitacion(sc);
                    List<Habitacion> resultado = controller.buscarHabitaciones(tipo);
                    if (resultado.isEmpty()) {
                        System.out.println("No se encontraron habitaciones de tipo " + tipo + ".");
                    } else {
                        for (Habitacion h : resultado) {
                            System.out.println("Nº " + h.getNumero() + " - S/ " + h.getPrecioBase()
                                    + " - " + h.getEstado());
                        }
                    }
                    break;
                }

                case 4: {
                    Habitacion h = buscarHabitacionPorNumero(sc, controller);
                    if (h != null) {
                        controller.reservarHabitacion(h);
                        System.out.println("Habitación " + h.getNumero() + " marcada como OCUPADA.");
                    }
                    break;
                }

                case 5: {
                    Habitacion h = buscarHabitacionPorNumero(sc, controller);
                    if (h != null) {
                        controller.liberarHabitacion(h);
                        System.out.println("Habitación " + h.getNumero() + " liberada.");
                    }
                    break;
                }

                case 0:
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    private static void menuReservas(Scanner sc,
                                     ReservaControlador reservaController,
                                     HabitacionController habitacionController,
                                     List<Huesped> huespedes) {

        int opcion;

        do {

            System.out.println("\n---- GESTIÓN DE RESERVAS ----");
            System.out.println("1. Crear reserva");
            System.out.println("2. Listar reservas");
            System.out.println("3. Pagar reserva");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = leerEntero(sc);

            switch (opcion) {

                case 1: {
                    Habitacion h = buscarHabitacionPorNumero(sc, habitacionController);
                    if (h == null) {
                        break;
                    }

                    System.out.print("ID de la reserva: ");
                    int idReserva = leerEntero(sc);

                    System.out.print("Nombre del huésped: ");
                    String nombre = sc.nextLine();
                    System.out.print("Correo del huésped: ");
                    String correo = sc.nextLine();
                    System.out.print("Nº de pasaporte: ");
                    String pasaporte = sc.nextLine();

                    Huesped huesped = new Huesped(String.valueOf(huespedes.size() + 1),
                            nombre, correo, "1234", pasaporte);
                    huespedes.add(huesped);

                    LocalDate inicio = leerFecha(sc, "Fecha de inicio (aaaa-mm-dd): ");
                    LocalDate fin = leerFecha(sc, "Fecha de fin (aaaa-mm-dd): ");

                    Reserva reserva = reservaController.crearReservaEstandar(
                            idReserva, huesped, h, inicio, fin);

                    habitacionController.reservarHabitacion(h);

                    System.out.println("Reserva creada. Total a pagar: S/ " + reserva.getTotal());
                    break;
                }

                case 2: {
                    List<Reserva> reservas = reservaController.listarReservas();
                    if (reservas.isEmpty()) {
                        System.out.println("No hay reservas registradas todavía.");
                    } else {
                        for (Reserva r : reservas) {
                            System.out.println("ID " + r.getIdReserva()
                                    + " - Huésped: " + r.getHuesped().getNombre()
                                    + " - " + r.getFechaInicio() + " a " + r.getFechaFin()
                                    + " - Estado: " + r.getEstado()
                                    + " - Total: S/ " + r.getTotal());
                        }
                    }
                    break;
                }

                case 3: {
                    System.out.print("ID de la reserva a pagar: ");
                    int idReserva = leerEntero(sc);
                    Reserva reserva = reservaController.buscarPorId(idReserva);

                    if (reserva == null) {
                        System.out.println("No existe una reserva con ese ID.");
                        break;
                    }

                    EstrategiaPago estrategia = elegirEstrategiaPago(sc);
                    reservaController.pagarReserva(reserva, estrategia);
                    break;
                }

                case 0:
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    private static void menuReportes(Scanner sc,
                                     ReporteController reporteController,
                                     ReservaControlador reservaController,
                                     HabitacionController habitacionController) {

        int opcion;

        do {

            System.out.println("\n---- REPORTES ----");
            System.out.println("1. Reporte de ocupación (habitaciones registradas)");
            System.out.println("2. Reporte de ingresos (reservas registradas)");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = leerEntero(sc);

            switch (opcion) {

                case 1: {
                    reporteController.configurarGeneradorReporte(new ReporteOcupacion());
                    List<Object> datos = new ArrayList<>(habitacionController.obtenerHabitaciones());
                    double resultado = reporteController.ejecutarReporte(datos);
                    reporteController.registrarAccionSistema("admin", "Reporte de ocupación", NivelSeguridad.INFO);
                    System.out.println("Habitaciones registradas: " + resultado);
                    break;
                }

                case 2: {
                    reporteController.configurarGeneradorReporte(new ReporteIngresosEfectivo());
                    List<Object> datos = new ArrayList<>(reservaController.listarReservas());
                    double totalReservas = reporteController.ejecutarReporte(datos);
                    double totalIngresos = 0;
                    for (Reserva r : reservaController.listarReservas()) {
                        totalIngresos += r.getTotal();
                    }
                    reporteController.registrarAccionSistema("admin", "Reporte de ingresos", NivelSeguridad.INFO);
                    System.out.println("Reservas registradas: " + totalReservas);
                    System.out.println("Ingresos totales: S/ " + totalIngresos);
                    break;
                }

                case 0:
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    private static TipoHabitacion elegirTipoHabitacion(Scanner sc) {
        System.out.println("Tipo de habitación: 1. SIMPLE  2. DOBLE  3. SUITE");
        System.out.print("Opción: ");
        int opcion = leerEntero(sc);
        switch (opcion) {
            case 2:
                return TipoHabitacion.DOBLE;
            case 3:
                return TipoHabitacion.SUITE;
            default:
                return TipoHabitacion.SIMPLE;
        }
    }

    private static EstrategiaPago elegirEstrategiaPago(Scanner sc) {
        System.out.println("Método de pago: 1. Efectivo  2. Tarjeta  3. Billetera digital");
        System.out.print("Opción: ");
        int opcion = leerEntero(sc);
        switch (opcion) {
            case 2:
                return new PagoTarjeta();
            case 3:
                return new PagoBilleteraDigital("Yape");
            default:
                return new PagoEfectivo();
        }
    }

    private static Habitacion buscarHabitacionPorNumero(Scanner sc, HabitacionController controller) {
        System.out.print("Número de habitación: ");
        int numero = leerEntero(sc);

        for (ComponenteHabitacion c : controller.obtenerHabitaciones()) {
            if (c instanceof Habitacion && c.getNumero() == numero) {
                return (Habitacion) c;
            }
        }

        System.out.println("No existe una habitación con ese número.");
        return null;
    }

    private static LocalDate leerFecha(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = sc.nextLine();
            try {
                return LocalDate.parse(texto.trim());
            } catch (Exception e) {
                System.out.println("Formato inválido. Usa aaaa-mm-dd, por ejemplo 2026-07-15.");
            }
        }
    }

    private static int leerEntero(Scanner sc) {
        while (true) {
            String linea = sc.nextLine().trim();
            try {
                return Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.print("Ingresa un número válido: ");
            }
        }
    }

    private static double leerDouble(Scanner sc) {
        while (true) {
            String linea = sc.nextLine().trim();
            try {
                return Double.parseDouble(linea);
            } catch (NumberFormatException e) {
                System.out.print("Ingresa un número válido: ");
            }
        }
    }
}
