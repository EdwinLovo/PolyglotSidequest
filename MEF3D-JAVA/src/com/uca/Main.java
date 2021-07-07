package com.uca;

import com.uca.entidades.Malla;
import com.uca.funciones.Assembly;
import com.uca.funciones.Read;
import com.uca.funciones.Sel;
import org.ejml.simple.SimpleMatrix;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/*
* Integrantes:
*   - Walter Antoniell Bustillo Ayala   001896117
*   - Edwin Ernesto Lovo Ramos          00120617
*   - Francisco Josue Molina Lopez      00300917
* */
public class Main {

    public static void main(String[] args) throws Exception {

        Read r = new Read();
        Sel s = new Sel();
        Assembly a = new Assembly();
        File archivo = new File("src/com/uca/proyecto.dat"); //Extraemos el archivo
        Scanner sc = new Scanner(archivo);

        SimpleMatrix K = null,b = null,w = null, localK = null, localB =null;
        Malla m = new Malla();

        System.out.println("====== METODO DE LOS ELEMENTOS FINITOS EN 3D (Proyecto) ======\n" +
                                "\t\t\t\t-- Grupo 22 --\n");

        r.leerMallayCondiciones(m,archivo);
        System.out.println("Datos leidos");
        s.crearSistemasLocales(m, localK,localB);

        K.zero();
        b.zero();
        w.zero();

        System.out.println("Ensamblando....");
        a.ensamblar(m,localK,localB,K,b);

        a.aplicarNeumann(m,b);
        a.aplicarDirichlet_X(m,K,b);
        a.aplicarDirichlet_Y(m,K,b);
        a.aplicarDirichlet_Z(m,K,b);

        System.out.println("Calculando....");
        w.set(a.calcular(K,b));
    }
}
