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

    protected Double valor;

    public Double getZ() {
        return z;
    }

    public void setZ(Double z) {
        this.z = z;
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

    public Integer getNodo_4() {
        return nodo_4;
    }

    public void setNodo_4(Integer nodo_4) {
        this.nodo_4 = nodo_4;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    //Funciones extra
    void setValores() {
        setValores(0, 0d, 0d,0d ,0 ,0 ,0,0,0d);
    }

    public abstract Item setValores(Integer a, Double b, Double c, Double d, Integer e, Integer f, Integer g, Integer h, Double i);
}
