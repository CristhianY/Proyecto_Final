package pe.edu.upeu.utils;

import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.io.IOException;

public class LeerTeclado {
    BufferedReader lecturaDeDatos = new BufferedReader(new InputStreamReader(System.in));

    public int leer(int dato, String mensaje) {
        try {
            System.out.print(mensaje);
            dato = Integer.parseInt(lecturaDeDatos.readLine());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return dato;
    }

    public String leer(String dato, String mensaje) {
        try {
            System.out.print(mensaje);
            dato = lecturaDeDatos.readLine();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return dato;
    }

    public char leer(char dato, String mensaje) {
        try {
            System.out.print(mensaje);
            dato = lecturaDeDatos.readLine().charAt(0);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return dato;
    }

    public double leer(double dato, String mensaje) {
        try {
            System.out.print(mensaje);
            dato=Double.parseDouble(lecturaDeDatos.readLine());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return dato;
    }
}
