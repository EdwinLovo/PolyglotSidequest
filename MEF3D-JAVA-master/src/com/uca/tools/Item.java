package com.uca.tools;

//Clase base
public abstract class Item {

    protected Integer id;
    protected Double x;
    protected Double y;
    protected Double z;
    protected Integer nodo_1;
    protected Integer nodo_2;
    protected Integer nodo_3;
    protected Integer nodo_4;
    protected Integer nodo_5;
    protected Integer nodo_6;
    protected Integer nodo_7;
    protected Integer nodo_8;
    protected Integer nodo_9;
    protected Integer nodo_10;

    protected Double valor;

    public Double getZ() {
        return z;
    }

    public void setZ(Double z) {
        this.z = z;
    }

    public Integer getNodo_4() {
        return nodo_4;
    }

    public void setNodo_4(Integer nodo_4) {
        this.nodo_4 = nodo_4;
    }

    public Item() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Integer getNodo_1() {
        return nodo_1;
    }

    public void setNodo_1(Integer nodo_1) {
        this.nodo_1 = nodo_1;
    }

    public Integer getNodo_2() {
        return nodo_2;
    }

    public void setNodo_2(Integer nodo_2) {
        this.nodo_2 = nodo_2;
    }

    public Integer getNodo_3() {
        return nodo_3;
    }

    public void setNodo_3(Integer nodo_3) {
        this.nodo_3 = nodo_3;
    }

    public Integer getNodo_5() {
        return nodo_5;
    }

    public void setNodo_5(Integer nodo_5) {
        this.nodo_5 = nodo_5;
    }

    public Integer getNodo_6() {
        return nodo_6;
    }

    public void setNodo_6(Integer nodo_6) {
        this.nodo_6 = nodo_6;
    }

    public Integer getNodo_7() {
        return nodo_7;
    }

    public void setNodo_7(Integer nodo_7) {
        this.nodo_7 = nodo_7;
    }

    public Integer getNodo_8() {
        return nodo_8;
    }

    public void setNodo_8(Integer nodo_8) {
        this.nodo_8 = nodo_8;
    }

    public Integer getNodo_9() {
        return nodo_9;
    }

    public void setNodo_9(Integer nodo_9) {
        this.nodo_9 = nodo_9;
    }

    public Integer getNodo_10() {
        return nodo_10;
    }

    public void setNodo_10(Integer nodo_10) {
        this.nodo_10 = nodo_10;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    //Funciones extra
    void setValores() {
        setValores(0, 0d, 0d,0d ,0 ,0 ,0,0,0 ,0 ,0,0,0,0,0d);
    }

    public abstract void setValores(Integer a, Double b, Double c,Double d, Integer e, Integer f, Integer g, Integer h,Integer i, Integer j, Integer k, Integer l,Integer m, Integer n,Double o);
}
