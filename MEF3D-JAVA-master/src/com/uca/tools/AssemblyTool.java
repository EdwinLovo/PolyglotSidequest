package com.uca.tools;

import com.uca.entidades.Elemento;
import com.uca.entidades.Malla;
import org.ejml.simple.SimpleMatrix;

public interface AssemblyTool {
    public void ensamblar(Malla malla, SimpleMatrix localK, SimpleMatrix localb, SimpleMatrix K, SimpleMatrix B);
    public void aplicarDirichlet(Malla malla, SimpleMatrix K, SimpleMatrix b);
    public SimpleMatrix calcular(SimpleMatrix K, SimpleMatrix b);
    public void ensamblarK(Elemento e, SimpleMatrix localK, SimpleMatrix K);
    public void ensamblarB(Elemento e, SimpleMatrix localb, SimpleMatrix b);
}
