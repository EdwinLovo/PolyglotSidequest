package com.uca;

public interface Utils {

    //Listado de Modos
    public static final Integer None = 0;
    public static final Integer IntDouble = 1;
    public static final Integer IntDoubleDouble = 2;
    public static final Integer IntIntIntInt = 3;

    //Listado de Lineas
    public static final Integer SinLinea = 0;
    public static final Integer LineaSimple = 1;
    public static final Integer DobleLinea = 2;


    //Listado de Parametros
    public static final Integer EI = 0;
    public static final Integer F_x = 1;
    public static final Integer F_y = 2;
    public static final Integer F_z = 3;


    //Listado de Tamanios
    public static final Integer Nodos = 0;
    public static final Integer Elementos = 1;
    public static final Integer Dirichlet_X = 2;
    public static final Integer Dirichlet_Y = 3;
    public static final Integer Dirichlet_Z = 4;
    public static final Integer Neumann = 5;

    //Listado de coordenadas
    public enum coordenadas{EQUIS,YE,ZETA} ;
}
