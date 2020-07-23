package pe.edu.upeu.app;

import pe.edu.upeu.usuario.FormaDePago;
import pe.edu.upeu.usuario.TecnologiaLaptronic;
import pe.edu.upeu.usuario.Usuario;
import pe.edu.upeu.utils.AppCrud;
import pe.edu.upeu.utils.LeerArchivo;
import pe.edu.upeu.utils.LeerTeclado;

public class App {
    static LeerTeclado teclado = new LeerTeclado();

    public static void main(String ... args) {

        String [] contador = new String[4];
        Usuario usuario = new Usuario();
        FormaDePago pago = new FormaDePago();
        TecnologiaLaptronic tec = new TecnologiaLaptronic();
        LeerArchivo archivo;
        AppCrud app;
        String repeat = "";
        int cantidadTotal = 0;
        int contadorDeMatriz = 0;

        do {
            usuario.setEdad(teclado.leer(0, "Ingrese su edad porfavor: "));
            usuario.setNombreApellidos(teclado.leer("", "Ingrese sus nombres completos: "));
            usuario.setDni(teclado.leer("", "Ingrese su DNI porfavor: "));
            usuario.setUbicacion(teclado.leer("", "Ingrese su ubicación: "));
            usuario.setReferencia(teclado.leer("", "Ingrese alguna referencia suya: "));

            for (int i = 0; i <= contador.length; i++) {
                if (i == 0) {
                    contador[i] = usuario.getNombreApellidos();
                } else if (i == 1) {
                    contador[i] = usuario.getUbicacion();
                } else if (i == 2) {
                    contador[i] = usuario.getReferencia();
                } else if (i == 3) {
                    contador[i] = usuario.getDni();
                }
            }
            String opcion;
            String tarjeta = "";
            opcion = teclado.leer("", "¿Desea pagar con tajeta o sin tarjeta C/S? : ");
            if (opcion.equalsIgnoreCase("c")) {
                tarjeta = teclado.leer("", "Ingrese el tipo de tarjeta: ");
                pago.setPago(true);
            } else if (opcion.equalsIgnoreCase("s")) {
                tarjeta = "Pago en efectivo";
                pago.setPago(false);
            } else {
                do {
                    System.out.println("\nEl valor es incorrecto ingrese nuevamente \n");
                    opcion = teclado.leer("", "¿Desea pagar con tajeta o sin tarjeta c/s? : ");
                } while (!(opcion.equalsIgnoreCase("c")) && !(opcion.equalsIgnoreCase("s")));
                if (opcion.equalsIgnoreCase("c")) {
                    tarjeta = teclado.leer("", "Ingrese el tipo de tarjeta: ");
                } else if (opcion.equalsIgnoreCase("s")) {
                    tarjeta = "Pago en efectivo";
                }
            }
            System.out.println("\nSomos expertos resolviendo problemas tecnicos: \n");

            tec.setCantidad(teclado.leer(0, "Elija la cantidad de dispositivos que hay por reparar: "));
            int[] cantidad = new int[tec.getCantidad()];
            int[] problem = new int[tec.getCantidad()];
            String[] problemasConP = new String[tec.getCantidad()];
            String pp = "Problemas de pantalla";
            String pb = "Problema de bateria";
            String pc = "Problemas sobre conectores";
            String otro = "Otros";
            String tecla = "Teclado";
            String sobre = "Sobrecalentamiento";
            int contadorCantidadCel = 0;
            int contadorCantidadLap = 0;
            int contadorCantidadPc = 0;
            int contadorDeProblemas = 0;
            for (int i = 0; i < cantidad.length; i++) {
                System.out.println("Ingrese el " + (i + 1) + " dispositivo: \n");
                System.out.println("   1.- Mobile \n" +
                        "   2.- Laptop \n" +
                        "   3.- PC \n");
                cantidad[i] = teclado.leer(0, "   Ingrese: ");
                if (cantidad[i] == 1) {
                    System.out.println("Problemas Mobiles \n");
                    System.out.println("   1.- Problemas de pantalla -> 80 soles\n" +
                            "   2.- Problemas de batería -> 30 soles\n" +
                            "   3.- Problemas sobre conectores -> 60 soles\n" +
                            "   4.- Otros -> 70 soles\n");
                    problem[i] = teclado.leer(0, "Ingrese el problema: ");
                    if (problem[i] == 1) {
                        contadorDeProblemas += 80;
                        problemasConP[i] = pp;
                    } else if (problem[i] == 2) {
                        contadorDeProblemas += 30;
                        problemasConP[i] = pb;
                    } else if (problem[i] == 3) {
                        contadorDeProblemas += 60;
                        problemasConP[i] = pc;
                    } else if (problem[i] == 4) {
                        contadorDeProblemas += 70;
                        problemasConP[i] = otro;
                    } else {
                        System.out.println("Incorrecto vuelve a intentar");
                    }
                    contadorCantidadCel += 1;
                } else if (cantidad[i] == 2) {
                    System.out.println("Problema de Laptops");
                    System.out.println("   1.- Problemas de pantalla -> 200 soles\n" +
                            "   2.- Problemas de batería -> 100 soles\n" +
                            "   3.- Problemas sobre conectores -> 200 soles\n" +
                            "   4.- Otros -> 150 soles\n");
                    problem[i] = teclado.leer(0, "Ingrese el problema: ");
                    if (problem[i] == 1) {
                        contadorDeProblemas += 200;
                        problemasConP[i] = pp;
                    } else if (problem[i] == 2) {
                        contadorDeProblemas += 100;
                        problemasConP[i] = pb;
                    } else if (problem[i] == 3) {
                        contadorDeProblemas += 200;
                        problemasConP[i] = pc;
                    } else if (problem[i] == 4) {
                        contadorDeProblemas += 150;
                        problemasConP[i] = otro;
                    } else {
                        System.out.println("Incorrecto vuelve a intentar");
                    }
                    contadorCantidadLap += 1;
                } else if (cantidad[i] == 3) {
                    System.out.println("Problemas de PC");
                    System.out.println("   1.- Problemas de pantalla -> 400 soles\n" +
                            "   2.- Problemas de batería -> 200 soles\n" +
                            "   3.- Problemas sobre conectores -> 300 soles\n" +
                            "   4.- Teclado -> 150 soles\n" +
                            "   5.- Sobrecalentamiento -> 250 soles\n" +
                            "   6.- Otros -> 300 soles\n");
                    problem[i] = teclado.leer(0, "Ingrese el problema: ");
                    if (problem[i] == 1) {
                        contadorDeProblemas += 400;
                        problemasConP[i] = pp;
                    } else if (problem[i] == 2) {
                        contadorDeProblemas += 200;
                        problemasConP[i] = pb;
                    } else if (problem[i] == 3) {
                        contadorDeProblemas += 300;
                        problemasConP[i] = pc;
                    } else if (problem[i] == 4) {
                        contadorDeProblemas += 150;
                        problemasConP[i] = tecla;
                    } else if (problem[i] == 5) {
                        contadorDeProblemas += 250;
                        problemasConP[i] = sobre;
                    } else if (problem[i] == 6) {
                        contadorDeProblemas += 300;
                        problemasConP[i] = otro;
                    } else {
                        System.out.println("Incorrecto vuelve a intentar");
                    }
                    contadorCantidadPc += 1;
                } else {
                    System.out.println("El dato que ingresó no existe");
                }
            }
            System.out.println("--------------------------------------------------");
            System.out.print("Datos Personales\n");
            System.out.print("Nombres y apellidos completos: " + contador[0] + "\n");
            System.out.print("la edad de usted es: " + usuario.getEdad() + "\n");
            System.out.print("Su DNI es: " + contador[3] + "\n");
            System.out.print("Su ubicación es: " + contador[1] + "\n");
            System.out.println("Su referencia actual es: " + contador[2] + "\n");

            System.out.println("La cantidad de dispositivos es: " + tec.getCantidad() + "\n");
            System.out.println("El usuario optó por: ");
            String[] formulario = new String[tec.getCantidad()];
            for (int i = 0; i < cantidad.length; i++) {
                if (cantidad[i] == 1) {
                    System.out.println(contadorCantidadCel + " En Mobile: ");

                    formulario[i] = problemasConP[i];

                    System.out.println((i + 1) + ".- " + formulario[i]);
                } else if (cantidad[i] == 2) {
                    System.out.println(contadorCantidadLap + " En Laptop: ");

                    formulario[i] = problemasConP[i];

                    System.out.println((i + 1) + ".- " + formulario[i]);
                } else if (cantidad[i] == 3) {
                    System.out.println(contadorCantidadPc + " En PC: ");

                    formulario[i] = problemasConP[i];

                    System.out.println((i + 1) + ".- " + formulario[i]);
                }
            }
            System.out.println("El total a pagar es de: " + contadorDeProblemas + " soles");
            System.out.println("Se pagará con: " + tarjeta);
            System.out.println("--------------------------------------------------");

            Object[][] matriz = new Object[1][8];
            matriz[0][0] = contador[0];
            matriz[0][1] = String.valueOf(usuario.getEdad());
            matriz[0][2] = contador[3];
            matriz[0][3] = contador[1];
            matriz[0][4] = contador[2];
            matriz[0][5] = String.valueOf(tec.getCantidad());
            matriz[0][6] = String.valueOf(contadorDeProblemas);
            matriz[0][7] = tarjeta;
            String[][] matrizTec = new String[1][tec.getCantidad()];
            app = new AppCrud();
            archivo = new LeerArchivo("archivo.txt");
            System.out.print("\n");
            app.imprimirLista(matriz);
            app.agregarContenidoM(archivo, matriz);
            System.out.println("");
            repeat = teclado.leer("", "Desea ingresar otro Usuario? s/n: \n");
            contadorDeMatriz += 1;
            cantidadTotal += contadorDeProblemas;
        }while (repeat.equalsIgnoreCase("s"));

        String opcion;
        System.out.println("--------- Datos Adicionales ---------\n");
        do {
            System.out.print("   1.- Monto recaudado\n" +
                    "   2.- cantidad de usuarios ingresados\n");
            int family;
            family = teclado.leer(0,"Ingrese: ");
            switch (family) {
                case 1:
                    System.out.println("El total recaudado es: "+ cantidadTotal);
                    break;
                case 2:
                    System.out.println("Cantidad de usuarios: "+contadorDeMatriz);
                    break;
                default:
                    System.out.println("El valor que ingresó no existe");
                    break;
            }
            opcion = teclado.leer("","Desea parar el algoritmo? s/n: ");
        }while(opcion.equalsIgnoreCase("n"));
    }
}
