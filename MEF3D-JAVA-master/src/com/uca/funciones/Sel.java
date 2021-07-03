package com.uca.funciones;

import com.uca.Utils;
import com.uca.entidades.Elemento;
import com.uca.entidades.Malla;
import com.uca.entidades.Nodo;
import com.uca.tools.SelTool;

import javax.crypto.MacSpi;

public class Sel implements SelTool {

    @Override
    public Double calcularTenedor(Elemento e, Integer coord, Integer i, Integer j, Malla m) {
        Nodo n1 = obtenerNodo(i,e,m);
        Nodo n2 = obtenerNodo(j,e,m);

        return obtenerCoordenada(coord, n1) - obtenerCoordenada(coord, n2);
    }
    /* Funcion para obtener c1
    * c1 = 1/(x2-x1)^2
    * */
    @Override
    public Double obtenerC1(Elemento e, Malla m) {
        Double c1 = 1/Math.pow(calcularTenedor(e,0,2,1,m),2);// EQUIS = 0
        return c1;
    }
    /* Funcion para obtener c2
     * c2 = (1/(x2-x1))*(4 x1+ 4 x2- 8 x8)
     * */
    @Override
    public Double obtenerC2(Elemento e, Malla m) {
        Nodo n1 = obtenerNodo(1,e,m);
        Nodo n2 = obtenerNodo(2,e,m);
        Nodo n8 = obtenerNodo(8,e,m);

        Double aux = (4 * obtenerCoordenada(0,n1)) + (4 * obtenerCoordenada(0,n2)) - (8 * obtenerCoordenada(0,n8));
        Double c2 = (1/calcularTenedor(e,0,2,1,m)) * aux;// EQUIS = 0
        return c2;
    }
    /*
    * A = ((-1/192c22) * (4c1-c2)^4) - ((1/24c2) * (4c1-c2)^3) - ((1/3840c32) * (4c1-c2)^5) + ((1/3840c32) * (4c1-3c2)^5)
    * */
    @Override
    public Double calcularA(Elemento e, Malla m) {
        Double a = -1/(192 * Math.pow(obtenerC2(e,m),2)); //(-1/192c2^2)
        Double b = Math.pow((4 * obtenerC1(e,m)) - obtenerC2(e,m),4);// (4c1-c2)^4)
        Double c = 1/(24 * obtenerC2(e, m)); // 1/24c2
        Double d = Math.pow((4 * obtenerC1(e, m))- obtenerC2(e, m),3); // (4c1-c2)^3)
        Double f = 1/(3840 * Math.pow(obtenerC2(e, m),3)); //((1/3840c2^3)
        Double g = Math.pow((4 * obtenerC1(e, m))- obtenerC2(e, m),5); //(4c1-c2)^5)
        Double h = Math.pow((4 * obtenerC1(e,m)) - (3*obtenerC2(e,m)),5); //(4c1-3c2)^5)

        Double answer = (a*b) - (c*d) - (f*g) + (f*h);
        return answer;
    }
    /*
    * B = ((-1/192c2^2) * (4c1+c2)^4) + ((1/24c2) * (4c1+c2)^3) + (((1/3840c2^3) * (4c1+c2)^5) - (((1/3840c2^3) * (4c1-3c2)^5)
    * */
    @Override
    public Double calcularB(Elemento e, Malla m) {
        Double a = -1/(192 * Math.pow(obtenerC2(e,m),2)); //(-1/192c2^2)
        Double b = Math.pow((4 * obtenerC1(e,m)) + obtenerC2(e,m),4);// (4c1+c2)^4)
        Double c = 1/(24 * obtenerC2(e, m)); // 1/24c2
        Double d = Math.pow((4 * obtenerC1(e, m))+ obtenerC2(e, m),3); // (4c1+c2)^3)
        Double f = 1/(3840 * Math.pow(obtenerC2(e, m),3)); //((1/3840c2^3)
        Double g = Math.pow((4 * obtenerC1(e, m)) + obtenerC2(e, m),5); //(4c1+c2)^5)
        Double h = Math.pow((4 * obtenerC1(e,m)) - (3*obtenerC2(e,m)),5); //(4c1-3c2)^5)

        Double answer = (a*b) + (c*d) + (f*g) - (f*h);
        return answer;
    }
    /*
    * C = (4/15) * c2^2
    * */
    @Override
    public Double calcularC(Elemento e, Malla m) {
        return (4/15) * Math.pow(obtenerC2(e, m),2);
    }

    /*
    * D = ((1/192c2^2) * (4c2-c1)^4) - ((1/3840c2^3) * (4c2-c1)^3) + ((1/7680c2^3) * (4c2+8c1)^5) -
    *       ((7/7680c2^3) * (4c2-8c1)^5) +((7/768c2^3) * (-8c1)^5) - ((c1/96c2^3) * (4c2-8c1)^4) + ((2c1-1/192c32) * (-8c1)^4)
    * */
    @Override
    public Double calcularD(Elemento e, Malla m) {
        Double a = 1/(192 * Math.pow(obtenerC2(e,m),2)); // (1/192c2^2)
        Double b = Math.pow((4 * obtenerC2(e,m)) - obtenerC1(e,m),4);// (4c2-c1)^4)
        Double c = 1/(3840 * Math.pow(obtenerC2(e, m),3)); // ((1/3840c2^3)
        Double d = Math.pow((4 * obtenerC2(e, m))- obtenerC1(e, m),3); // (4c2-c1)^3)
        Double f = 1/(7680* Math.pow( obtenerC2(e, m),3));// (1/7680c2^3)
        Double g = Math.pow((4 * obtenerC2(e,m)) + (8*obtenerC1(e,m)),5); // (4c2+8c1)^5)
        Double h = 7/(7680* Math.pow(obtenerC2(e, m),3));// (7/7680c2^3)
        Double i = Math.pow((4 * obtenerC2(e,m)) - (8*obtenerC1(e,m)),5); // (4c2-8c1)^5)
        Double j = 7/(768 * Math.pow(obtenerC2(e, m),3)); // (7/768c2^3)
        Double k = Math.pow(-8*obtenerC1(e, m),5);//(-8c1)^5)
        Double l = obtenerC1(e, m)/(96*Math.pow(obtenerC2(e, m),3));// (c1/96c2^3)
        Double n = Math.pow((4 * obtenerC2(e, m))- (8*obtenerC1(e, m)),4); // (4c2-8c1)^4)
        Double o = ((2*obtenerC1(e, m)) - 1)/(192* Math.pow(obtenerC2(e, m),3));// (2c1-1/192c2^3)
        Double p = Math.pow(-8*obtenerC1(e, m),5);// (-8c1)^4)

        Double answer = (a*b) - (c*d) + (f*g) - (h*i) + (j*k) - (l*n) + (o * p);
        return answer;
    }

    /*
    * E = ((8/3) * c1^2) + ((1/30) * c2^2)
    * */
    @Override
    public Double calcularE(Elemento e, Malla m) {
        Double a = (8/3) * Math.pow(obtenerC1(e, m),2); // (8/3) * c1^2)
        Double b = (1/30) * Math.pow(obtenerC2(e, m),2);// ((1/30) * c2^2)

        return a+b;
    }
    /*
    * F = ((2/3) * c1c2) - ((1/30) * c2^2)
    * */
    @Override
    public Double calcularF(Elemento e, Malla m) {
        Double a = (2/3) * (obtenerC1(e, m) * obtenerC2(e, m)); // ((2/3) * c1c2)
        Double b = (1/30) * Math.pow(obtenerC2(e, m),2);// ((1/30) * c2^2)

        return a-b;
    }
    /*
    * G = ((-16/3) * c21) - ((4/3) * c1c2) - ((2/15) * c22)
    * */
    @Override
    public Double calcularG(Elemento e, Malla m) {
        Double a = (-16/3) * Math.pow(obtenerC1(e, m),2); // (-16/3) * c1^2
        Double b = (4/3) * (obtenerC1(e, m) * obtenerC2(e, m));// (4/3) * c1c2
        Double c = (2/15) * Math.pow(obtenerC2(e, m),2);// (2/15) * c2^2

        return a-b-c;
    }
    /*
    * H = ((2/3) * c1c2) + ((1/30) * c2^2)
    * */
    @Override
    public Double calcularH(Elemento e, Malla m) {
        Double a = (2/3) * (obtenerC1(e, m) * obtenerC2(e, m)); // ((2/3) * c1c2)
        Double b = (1/30) * Math.pow(obtenerC2(e, m),2);// ((1/30) * c2^2)

        return a+b;
    }
    /*
    * I = ((-16/3) * c1^2) + ((2/3) * c2^2)
    * */
    @Override
    public Double calcularI(Elemento e, Malla m) {
        Double a = (-16/3) * Math.pow(obtenerC1(e, m),2); // -16/3 * c1^2
        Double b = (2/3) * Math.pow(obtenerC2(e, m),2);// (2/3) * c2^2

        return a+b;
    }
    /*
    * J = (2/15) * c2^2
    * */
    @Override
    public Double calcularJ(Elemento e, Malla m) {
        return (2/15) * Math.pow(obtenerC2(e, m),2);
    }
    /*
    * K = (-4/3) * c1c2
    * */
    @Override
    public Double calcularK(Elemento e, Malla m) {
        return (-4/3) * (obtenerC1(e, m) * obtenerC2(e, m));
    }

    @Override
    public Double obtenerCoordenada(Integer c, Nodo n) {
        Double v= 0d;
        switch (c){
            case 0: v = n.getX(); break;//X
            case 1: v = n.getY(); break;//Y
            case 2: v = n.getZ(); break;//Z
            default:
                throw new IllegalStateException("Ocurrio un error al obtener la coordenada: " + c);
        }
        return v;
    }

    @Override
    public Nodo obtenerNodo(Integer i, Elemento e, Malla m) {
        Nodo n;
        switch (i){
            case 1: n = m.getNode(e.getNodo_1()-1); break;
            case 2: n = m.getNode(e.getNodo_2()-1); break;
            case 3: n = m.getNode(e.getNodo_3()-1); break;
            case 4: n = m.getNode(e.getNodo_4()-1); break;
            case 5: n = m.getNode(e.getNodo_5()-1); break;
            case 6: n = m.getNode(e.getNodo_6()-1); break;
            case 7: n = m.getNode(e.getNodo_7()-1); break;
            case 8: n = m.getNode(e.getNodo_8()-1); break;
            case 9: n = m.getNode(e.getNodo_9()-1); break;
            case 10: n = m.getNode(e.getNodo_10()-1); break;
            default:
                throw new IllegalStateException("Ocurrio un error al obtener el nodo: " + i);
        }
        return n;
    }
}
