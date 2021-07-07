package com.uca.tools;

import com.uca.entidades.Malla;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public interface ReadTool {
    public void obtenerDatos(File archivo, Scanner sc, ArrayList<Item> lista, Integer tipo) throws Exception;
    public void escribirResultados(Malla malla, Vector vector, File archivo);
    public void leerMallayCondiciones(Malla m, File archivo) throws Exception;
}
