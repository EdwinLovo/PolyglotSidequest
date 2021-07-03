package com.uca.entidades;

import com.uca.Utils;

import java.util.ArrayList;

public class Malla implements Utils {

    public Double[] parametros = new Double[2];
    public Integer[] tamanios = new Integer[4];
    protected ArrayList<Nodo> lista_nodos;
    protected ArrayList<Elemento> lista_elementos;
    protected Integer indices_dirichlet;
    protected ArrayList<Condiciones> lista_dirichlet;
    protected ArrayList<Condiciones> lista_neumann;

    public Double getParametros(Integer i) {
        return parametros[i];
    }

    public Integer getTamanios(Integer i) {
        return tamanios[i];
    }

    public Integer getIndicesDirichlet() {
        return indices_dirichlet;
    }

    public void setIndices_dirichlet(Integer indices_dirichlet) {
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

    public void setParametros(Double E, Double AK, Double F){
        this.parametros[ConductividadTermica] = F;
        this.parametros[Ak] = AK;
        this.parametros[FuenteDeCalor] = E;
    }

    public void setTamanios(Integer nNodos, Integer nElem, Integer nDirichlet, Integer nNeumann){
        this.tamanios[Nodos] = nNodos;
        this.tamanios[Elementos] = nElem;
        this.tamanios[Dirichlet] = nDirichlet;
        this.tamanios[Neumann] = nNeumann;
    }

    public Condiciones getCondition(Integer i, Integer tipo){
        if(tipo.equals(Utils.Dirichlet)){
            return lista_dirichlet.get(i);
        }else{
            return lista_neumann.get(i);
        }
    }

    public Nodo getNode(Integer i){
        return lista_nodos.get(i);
    }

    public Elemento getElement(Integer i){
        return lista_elementos.get(i);
    }
}
