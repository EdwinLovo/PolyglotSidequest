package com.uca.entidades;

import com.uca.Utils;

import java.util.ArrayList;

public class Malla implements Utils {

    public Double[] parametros = new Double[4];
    public Integer[] tamanios = new Integer[6];
    protected ArrayList<Nodo> lista_nodos;
    protected ArrayList<Elemento> lista_elementos;
    protected ArrayList<Integer> indices_dirichlet;
    protected ArrayList<Condiciones> lista_dirichlet;
    protected ArrayList<Condiciones> lista_neumann;

    public Double getParametros(Integer i) {
        return parametros[i];
    }

    public Integer getTamanios(Integer i) {
        return tamanios[i];
    }

    public ArrayList<Integer> getIndicesDirichlet() {
        return indices_dirichlet;
    }

    public void setIndices_dirichlet(ArrayList<Integer> indices_dirichlet) {
        this.indices_dirichlet = indices_dirichlet;
    }

    public ArrayList<Nodo> getNodos() {
        return lista_nodos;
    }

    public void setLista_nodos(ArrayList<Nodo> lista_nodos) {
        this.lista_nodos = lista_nodos;
    }

    public ArrayList<Elemento> getElementos() {
        return lista_elementos;
    }

    public void setLista_elementos(ArrayList<Elemento> lista_elementos) {
        this.lista_elementos = lista_elementos;
    }

    public ArrayList<Condiciones> getDirichlet() {
        return lista_dirichlet;
    }

    public void setLista_dirichlet(ArrayList<Condiciones> lista_dirichlet) {
        this.lista_dirichlet = lista_dirichlet;
    }

    public ArrayList<Condiciones> getNeumann() {
        return lista_neumann;
    }

    public void setLista_neumann(ArrayList<Condiciones> lista_neumann) {
        this.lista_neumann = lista_neumann;
    }

    public void setParametros(Double Ei, Double f_x , Double f_y, Double f_z) throws Exception {
        try{
            this.parametros[EI] = Ei;
            this.parametros[F_x] = f_x;
            this.parametros[F_y] = f_y;
            this.parametros[F_z] = f_z;
        }catch (Exception e){
            throw new Exception("Hubo un error al setear parametros");
        }
    }

    public void setTamanios(Integer nNodos, Integer nElem, Integer nDirichlet_X, Integer nDirichlet_Y, Integer nDirichlet_Z, Integer nNeumann) throws Exception {
        try{
            this.tamanios[Nodos] = nNodos;
            this.tamanios[Elementos] = nElem;
            this.tamanios[Dirichlet_X] = nDirichlet_X;
            this.tamanios[Dirichlet_Y] = nDirichlet_Y;
            this.tamanios[Dirichlet_Z] = nDirichlet_Z;
            this.tamanios[Neumann] = nNeumann;
        }catch (Exception e){
            throw new Exception("Error al setear tamanios");
        }
    }

    public Condiciones getCondition(Integer i, Integer tipo) throws Exception {
        try{
            switch (tipo){
                case 2://Dirichlet_x
                case 3://Dirichlet_y
                case 4://Dirichlet_z
                    return lista_dirichlet.get(i);
                case 5://Neumman
                    return lista_neumann.get(i);
                default:
                    throw new Exception("Tipo de condicion no valido");
            }
        }catch (Exception e){
            throw new Exception("Hubo un error al obtener las condiciones");
        }
    }

    public void crearData(){
        lista_nodos = new ArrayList<Nodo>();
        lista_elementos = new ArrayList<Elemento>();
        indices_dirichlet = new ArrayList<Integer>();
        lista_dirichlet = new ArrayList<Condiciones>();
        lista_neumann = new ArrayList<Condiciones>();
    }

    public Nodo getNode(Integer i){
        return lista_nodos.get(i);
    }

    public Elemento getElement(Integer i){
        return lista_elementos.get(i);
    }
}
