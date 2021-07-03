package com.uca.tools;

import com.uca.entidades.Malla;
import org.ejml.simple.SimpleMatrix;

public interface Components {

    public Double crearJLocal(Integer i, Malla m) throws Exception;
    public SimpleMatrix crearTau();
    public SimpleMatrix crearB(Integer i, Malla m) throws Exception;
    public SimpleMatrix crearMi(Integer i, Malla m) throws Exception;
    public SimpleMatrix crearK(Integer i, Malla m) throws Exception;
}
