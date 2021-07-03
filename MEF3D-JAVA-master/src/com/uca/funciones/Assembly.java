package com.uca.funciones;

import com.uca.Utils;
import com.uca.entidades.Condiciones;
import com.uca.entidades.Elemento;
import com.uca.entidades.Malla;
import com.uca.tools.AssemblyTool;
import org.ejml.simple.SimpleMatrix;

public class Assembly implements AssemblyTool {

    @Override

    public void ensamblar(Malla m, SimpleMatrix localK, SimpleMatrix localb, SimpleMatrix K, SimpleMatrix B) {
        for (int i =0; i< m.getTamanios(Utils.Elementos); i++){
            Elemento e = m.getElement(i);
            ensamblarK(e, localK, K);
            ensamblarB(e, localK, K);
        }
    }

    @Override
    public void aplicarDirichlet(Malla malla, SimpleMatrix K, SimpleMatrix b) {
        for(int i = 0; i< malla.getTamanios(Utils.Dirichlet); i++){
            Condiciones c = malla.getCondition(i, Utils.Dirichlet);
            Integer index = c.getNodo_1()-1;
        }
    }

    @Override
    public SimpleMatrix calcular(SimpleMatrix K, SimpleMatrix b) {
        return null;
    }

    @Override
    public void ensamblarK(Elemento e, SimpleMatrix localK, SimpleMatrix K) {

    }

    @Override
    public void ensamblarB(Elemento e, SimpleMatrix localb, SimpleMatrix b) {

    }
}
