package com.uca.funciones;

import com.uca.Utils;
import com.uca.entidades.Condiciones;
import com.uca.entidades.Elemento;
import com.uca.entidades.Malla;
import com.uca.tools.AssemblyTool;
import org.ejml.data.Matrix;
import org.ejml.simple.SimpleMatrix;

import java.util.ArrayList;

public class Assembly implements AssemblyTool {

    @Override

    public void ensamblar(Malla m, SimpleMatrix localK, SimpleMatrix localb, SimpleMatrix K, SimpleMatrix B) throws Exception {
        for (int i =0; i< m.getTamanios(Utils.Elementos); i++){
            Elemento e = m.getElement(i);
            ensamblarK(e, localK, K);
            ensamblarB(e, localb, B);
        }
    }

    @Override
    public void aplicarDirichlet_X(Malla malla, SimpleMatrix K, SimpleMatrix b) throws Exception {
        for(int i = 0; i< malla.getTamanios(Utils.Dirichlet_X); i++){
            Condiciones c = malla.getCondition(i, Utils.Dirichlet_X);
            Integer index = c.getNodo_1()-1;

            K.extractVector(true,index);
            b.extractVector(true,index);

            for (int row = 0; row< K.extractVector(true,index).getNumElements(); row++ ){
                Double cell = K.get(row,index);
                b.set(row, -1*c.getValor()*cell);
            }
        }
    }

    @Override
    public void aplicarDirichlet_Y(Malla malla, SimpleMatrix K, SimpleMatrix b) throws Exception {
        for(int i = 0; i< malla.getTamanios(Utils.Dirichlet_Y); i++){
            Condiciones c = malla.getCondition(i, Utils.Dirichlet_Y);
            Integer index = c.getNodo_1()-1;

            K.extractVector(true,index);
            b.extractVector(true,index);

            for (int row = 0; row< K.extractVector(true,index).getNumElements(); row++ ){
                Double cell = K.get(row,index);
                b.set(row, -1*c.getValor()*cell);
            }
        }
    }

    @Override
    public void aplicarDirichlet_Z(Malla malla, SimpleMatrix K, SimpleMatrix b) throws Exception {
        for(int i = 0; i< malla.getTamanios(Utils.Dirichlet_Z); i++){
            Condiciones c = malla.getCondition(i, Utils.Dirichlet_Z);
            Integer index = c.getNodo_1()-1;

            K.extractVector(true,index);
            b.extractVector(true,index);

            for (int row = 0; row< K.extractVector(true,index).getNumElements(); row++ ){
                Double cell = K.get(row,index);
                b.set(row, -1*c.getValor()*cell);
            }
        }
    }

    @Override
    public void aplicarNeumann(Malla malla, SimpleMatrix b) throws Exception {
        for (int i = 0; i<malla.getTamanios(Utils.Neumann); i++){
            Condiciones c = malla.getCondition(i, Utils.Neumann);
            b.set(c.getNodo_1()-1, c.getValor());
        }
    }

    @Override
    public SimpleMatrix calcular(SimpleMatrix K, SimpleMatrix b) throws Exception {
        try{
            System.out.println("Iniciando calculo de respuesta");
            SimpleMatrix W = null;
            W.set(K.pseudoInverse().mult(b));
            return W;
        }catch (Exception e){
            throw new Exception("Hubo un error al hacer calculo final");
        }
    }

    @Override
    public void ensamblarK(Elemento e, SimpleMatrix localK, SimpleMatrix K) throws Exception {
        try{
            Integer index1 = e.getNodo_1();
            Integer index2 = e.getNodo_2();
            Integer index3 = e.getNodo_3();
            Integer index4 = e.getNodo_4();

            K.set(index1, index1, localK.getIndex(0,0));
            K.set(index1, index2, localK.getIndex(0,1));
            K.set(index1, index3, localK.getIndex(0,2));
            K.set(index1, index4, localK.getIndex(0,3));
            K.set(index2, index1, localK.getIndex(1,0));
            K.set(index2, index2, localK.getIndex(1,1));
            K.set(index2, index3, localK.getIndex(1,2));
            K.set(index2, index4, localK.getIndex(1,3));
            K.set(index3, index1, localK.getIndex(2,0));
            K.set(index3, index2, localK.getIndex(2,1));
            K.set(index3, index3, localK.getIndex(2,2));
            K.set(index3, index4, localK.getIndex(2,3));
            K.set(index4, index1, localK.getIndex(3,0));
            K.set(index4, index2, localK.getIndex(3,1));
            K.set(index4, index3, localK.getIndex(3,2));
            K.set(index4, index4, localK.getIndex(3,3));
        }catch (Exception e1){
            throw new Exception("Hubo uun error al momento de ensamblar la matriz K");
        }
    }

    @Override
    public void ensamblarB(Elemento e, SimpleMatrix localb, SimpleMatrix b) throws Exception {
        try{
            Integer index1 = e.getNodo_1();
            Integer index2 = e.getNodo_2();
            Integer index3 = e.getNodo_3();
            Integer index4 = e.getNodo_4();

            b.set(index1, index1, localb.getIndex(0,0));
            b.set(index2, index1, localb.getIndex(1,0));
            b.set(index3, index1, localb.getIndex(2,0));
            b.set(index4, index1, localb.getIndex(3,0));
        }catch(Exception ex){
            throw new Exception("Hubo un error al momento de ensamblar la matriz/vector b");
        }
    }
}
