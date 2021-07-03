package com.uca.tools;

import com.uca.entidades.Malla;

import java.io.*;
import java.util.Vector;

public interface ReadTool {
    public void obtenerDatos(File archivo, Integer nLineas, Integer n);
    public void escribirResultados(Malla malla, Vector vector, File archivo);
}
