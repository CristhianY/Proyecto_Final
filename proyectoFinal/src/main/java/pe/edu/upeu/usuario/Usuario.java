package pe.edu.upeu.usuario;

import pe.edu.upeu.utils.LeerTeclado;

public class Usuario {

    static LeerTeclado teclado = new LeerTeclado();

    public String nombreApellidos;
    public String ubicacion;
    public String dni;
    public int edad;
    public String referencia;

    public void setEdad(int edad) {
        if (edad >= 18 && edad <= 120) {
            this.edad = edad;
        }else {
            do {
                this.edad = teclado.leer(0, "Ingrese la edad correctamente tienes que ser Mayor de 18: ");
            }while (this.edad < 18 || this.edad >= 120);
        }
    }
    public int getEdad() {
        return edad;
    }

    public void setNombreApellidos(String nombreApellidos) {

        this.nombreApellidos = nombreApellidos;
    }

    public String getNombreApellidos() {

        return nombreApellidos;
    }

    public void setDni(String dni) {
        if (dni.length() == 8) {
            this.dni = dni;
        }else {
            do {
                this.dni = teclado.leer("", "Ingrese el DNI correctamente tiene que contener 8 dígitos: ");
            }while (this.dni.length() != 8);
        }
    }
    public String getDni() {

        return dni;
    }

    public void setReferencia(String referencia) {

        this.referencia = referencia;
    }

    public String getReferencia() {

        return referencia;
    }

    public void setUbicacion(String ubicacion) {

        this.ubicacion = ubicacion;
    }

    public String getUbicacion() {

        return ubicacion;
    }
}
