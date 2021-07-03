package com.uca.funciones;

import com.uca.entidades.Elemento;
import com.uca.entidades.Malla;
import org.ejml.simple.SimpleMatrix;

public class Components implements com.uca.tools.Components {

    public Sel sel;

    @Override
    public Double crearJLocal(Integer i, Malla m) throws Exception {
        SimpleMatrix J = new SimpleMatrix(3,3);
        /* Formando Jacoviano (J)
        *  | x2-x1  x3-x1   x4-x1|
        *  | y2-y1  y3-y1   y4-y1|
        *  | z2-z1  z3-z1   z4-z1|
        * */
        try {
            Elemento e = m.getElement(i);
            // x = 0, y = 1, z =2

            //Primera Columna
            J.set(0,0, sel.calcularTenedor(e, 0, 2,1, m) );// Elemento, X, 2, 1, malla
            J.set(1,0, sel.calcularTenedor(e, 1, 2,1, m) );// Elemento, Y, 2, 1, malla
            J.set(2,0, sel.calcularTenedor(e, 2, 2,1, m) );// Elemento, Z, 2, 1, malla

            //Segunda Columna
            J.set(0,1, sel.calcularTenedor(e, 0, 3,1, m) );// Elemento, X, 3, 1, malla
            J.set(1,1, sel.calcularTenedor(e, 1, 3,1, m) );// Elemento, Y, 3, 1, malla
            J.set(2,1, sel.calcularTenedor(e, 2, 3,1, m) );// Elemento, Z, 3, 1, malla

            //Tercera Columna
            J.set(0,2, sel.calcularTenedor(e, 0, 4,1, m) );// Elemento, X, 4, 1, malla
            J.set(1,2, sel.calcularTenedor(e, 1, 4,1, m) );// Elemento, Y, 4, 1, malla
            J.set(2,2, sel.calcularTenedor(e, 2, 4,1, m) );// Elemento, Z, 4, 1, malla

            //Devolviendo determinante
            return J.determinant();
        }catch (Exception e){
            throw new Exception("Hubo un error al generar J");
        }
    }

    @Override
    public SimpleMatrix crearTau() {
        SimpleMatrix Tau = new SimpleMatrix(10,1);
        // Tau = [59 -1 -1 -1 4 4 4 4 4 4]
        Tau.set(0,0, 59);
        Tau.set(1,0, -1);
        Tau.set(2,0, -1);
        Tau.set(3,0, -1);
        Tau.set(4,0, 4);
        Tau.set(5,0, 4);
        Tau.set(6,0, 4);
        Tau.set(7,0, 4);
        Tau.set(8,0, 4);
        Tau.set(9,0, 4);

        return Tau;
    }

    @Override
    public SimpleMatrix crearB(Integer i, Malla m) throws Exception {
        SimpleMatrix f = new SimpleMatrix(1,3);
        SimpleMatrix B = new SimpleMatrix(30,1);
        SimpleMatrix Aux = new SimpleMatrix(30,3);

        /*
        * Formando vector f, datos obtenidos en random.org {52,36,-45}
        * */
        f.set(0,0, 52);     f.set(0,1, 36);     f.set(0,2, -45);

        //Seteando valores de Aux en 0
        Aux.zero();
        /* Formando matriz para obtener datos
        * [tau  0       0]
        * [0    tau     0]
        * [0    0     tau]
        * */
        try {
            Aux.insertIntoThis(0,0,crearTau());
            Aux.insertIntoThis(9,1,crearTau());
            Aux.insertIntoThis(19,2,crearTau());
        }catch (Exception e){
            throw new Exception("Hubo un error al insertar datos en matriz");
        }

        // J/120 * [Aux] * [f]
        try{
            B.insertIntoThis(0,0, Aux.mult(f).scale(crearJLocal(i, m)/120)) ;
            return B;
        }catch (Exception e){
            throw new Exception("Hubo un error al crear matriz b");
        }
    }

    @Override
    public SimpleMatrix crearMi(Integer i, Malla m) throws Exception {
        SimpleMatrix Mi = new SimpleMatrix(10,10);
        //Inicializando matriz Mi en 0
        Mi.zero();

        try{
            Elemento e = m.getElement(i);

            /* Formando matriz Mi 10x10
             * [A E 0 0 -F 0 -F G F F]
             * [E B 0 0 -H 0 -H I H H]
             * [0 0 0 0 0 0 0 0 0 0 0]
             * [0 0 0 0 0 0 0 0 0 0 0]
             * [-F -H 0 0 C 0 J -K -C -J]
             * [0 0 0 0 0 0 0 0 0 0 0]
             * [-F -H 0 0 J 0 C -K -J -C]
             * [G I 0 0 -K 0 -K D K K]
             * [F H 0 0 -C 0 -J K C J]
             * [F H 0 0 -J 0 -C K J C]
             * */
            Mi.set(0,0, sel.calcularA(e,m));    Mi.set(0,1, sel.calcularE(e,m));    Mi.set(0,4, - sel.calcularF(e,m));    Mi.set(0,6, - sel.calcularF(e,m));    Mi.set(0,7, sel.calcularG(e,m));    Mi.set(0,8, sel.calcularF(e,m));    Mi.set(0,9, sel.calcularF(e,m));
            Mi.set(1,0, sel.calcularE(e,m));    Mi.set(1,1, sel.calcularB(e,m));    Mi.set(1,4, - sel.calcularH(e,m));    Mi.set(1,6, - sel.calcularH(e,m));    Mi.set(1,7, sel.calcularI(e,m));    Mi.set(1,8, sel.calcularH(e,m));    Mi.set(1,9, sel.calcularH(e,m));
            Mi.set(4,0, -sel.calcularF(e,m));    Mi.set(4,1, -sel.calcularH(e,m));    Mi.set(4,4, sel.calcularC(e,m));    Mi.set(4,6, sel.calcularJ(e,m));    Mi.set(4,7, - sel.calcularK(e,m));    Mi.set(4,8, - sel.calcularC(e,m));    Mi.set(4,9, - sel.calcularJ(e,m));
            Mi.set(6,0, -sel.calcularF(e,m));    Mi.set(6,1, -sel.calcularH(e,m));    Mi.set(6,4, sel.calcularJ(e,m));    Mi.set(6,6, sel.calcularC(e,m));    Mi.set(6,7, - sel.calcularK(e,m));    Mi.set(6,8, - sel.calcularJ(e,m));    Mi.set(6,9, - sel.calcularC(e,m));
            Mi.set(7,0, sel.calcularG(e,m));    Mi.set(7,1, sel.calcularI(e,m));    Mi.set(7,4, - sel.calcularK(e,m));    Mi.set(7,6, - sel.calcularK(e,m));    Mi.set(7,7, sel.calcularD(e,m));    Mi.set(7,8, sel.calcularK(e,m));    Mi.set(7,9, sel.calcularK(e,m));
            Mi.set(8,0, sel.calcularF(e,m));    Mi.set(8,1, sel.calcularH(e,m));    Mi.set(8,4, - sel.calcularC(e,m));    Mi.set(8,6, - sel.calcularJ(e,m));    Mi.set(8,7, sel.calcularK(e,m));    Mi.set(8,8, sel.calcularC(e,m));    Mi.set(8,9, sel.calcularJ(e,m));
            Mi.set(9,0, sel.calcularF(e,m));    Mi.set(9,1, sel.calcularH(e,m));    Mi.set(9,4, - sel.calcularJ(e,m));    Mi.set(9,6, - sel.calcularC(e,m));    Mi.set(9,7, sel.calcularK(e,m));    Mi.set(9,8, sel.calcularJ(e,m));    Mi.set(9,9, sel.calcularC(e,m));

            return Mi;
        }catch (Exception e){
            throw new Exception("Hubo un error al crear matriz Mi");
        }
    }

    @Override
    public SimpleMatrix crearK(Integer i, Malla m) throws Exception {
        Integer EI = 16;
        SimpleMatrix K = new SimpleMatrix(30,30);
        K.zero();
        try{
            /* Formando matriz para obtener datos
             * [mi  0       0]
             * [0    mi     0]
             * [0    0     mi]
             * */
            K.insertIntoThis(0,0, crearMi(i,m));
            K.insertIntoThis(9,9, crearMi(i,m));
            K.insertIntoThis(19,19, crearMi(i,m));

            return K.scale(EI * crearJLocal(i,m)); // EIJ * K

        }catch (Exception e){
            throw new Exception("Hubo un error al crear matriz K");
        }
    }
}
