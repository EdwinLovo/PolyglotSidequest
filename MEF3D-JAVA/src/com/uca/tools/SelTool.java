package com.uca.tools;

import com.uca.entidades.Elemento;
import com.uca.entidades.Malla;
import com.uca.entidades.Nodo;
import org.ejml.simple.SimpleMatrix;

import javax.swing.*;

public interface SelTool {
    public Double calcularTenedor(Elemento e, Integer coord, Integer i, Integer j, Malla m);
    public Double obtenerC1(Elemento e, Malla m);
    public Double obtenerC2(Elemento e, Malla m);
    public Double calcularA(Elemento e, Malla m);
    public Double calcularB(Elemento e, Malla m);
    public Double calcularC(Elemento e, Malla m);
    public Double calcularD(Elemento e, Malla m);
    public Double calcularE(Elemento e, Malla m);
    public Double calcularF(Elemento e, Malla m);
    public Double calcularG(Elemento e, Malla m);
    public Double calcularH(Elemento e, Malla m);
    public Double calcularI(Elemento e, Malla m);
    public Double calcularJ(Elemento e, Malla m);
    public Double calcularK(Elemento e, Malla m);
    public Double obtenerCoordenada(Integer c, Nodo n);
    public Nodo obtenerNodo(Integer i, Elemento e, Malla m);
    public void crearSistemasLocales(Malla m, SimpleMatrix localk, SimpleMatrix localb);
}
