package com.uca.tools;

import com.uca.entidades.Elemento;
import com.uca.entidades.Malla;
import org.ejml.simple.SimpleMatrix;

import java.util.ArrayList;

public interface AssemblyTool {
    public void ensamblar(Malla malla, SimpleMatrix localK, SimpleMatrix localb, SimpleMatrix K, SimpleMatrix B) throws Exception;
    public void aplicarDirichlet_X(Malla malla, SimpleMatrix K, SimpleMatrix b) throws Exception;
    public void aplicarDirichlet_Y(Malla malla, SimpleMatrix K, SimpleMatrix b) throws Exception;
    public void aplicarDirichlet_Z(Malla malla, SimpleMatrix K, SimpleMatrix b) throws Exception;
    public void aplicarNeumann(Malla malla, SimpleMatrix b) throws Exception;
    public SimpleMatrix calcular(SimpleMatrix K, SimpleMatrix b) throws Exception;
    public void ensamblarK(Elemento e, SimpleMatrix localK, SimpleMatrix K) throws Exception;
    public void ensamblarB(Elemento e, SimpleMatrix localb, SimpleMatrix b) throws Exception;
}
