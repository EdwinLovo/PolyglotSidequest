package com.uca.funciones;

import com.uca.Utils;
import com.uca.entidades.Malla;
import com.uca.tools.Item;
import com.uca.tools.ReadTool;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import static com.uca.Utils.Nodos;

public class Read implements ReadTool {
    @Override
    public void obtenerDatos(File archivo, Scanner sc, ArrayList<Item> lista, Integer tipo) throws Exception {
        try{
            String data;
            sc.nextLine();
            Boolean flag = false; //Bandera que detendra leida de datos
            switch (tipo){
                case 0: //Nodos
                    data = sc.nextLine();
                    String[] aux2 = data.split(" ");
                    Double t[] = parsearADouble(aux2);
                    Item i = null;
                    lista.add(i.setValores(Integer.parseInt(t[0].toString()),t[1],t[2], t[3], 0, 0,0,0,0d ));
                    break;
                case 1://Elementos
                    data = sc.nextLine();
                    String[] aux1 = data.split(" ");
                    Integer a[] = parsearAInteger(aux1);
                    Item i2 = null;
                    lista.add(i2.setValores(a[0],0d,0d, 0d, a[1], a[2],a[3],a[4],0d ));
                    break;
                case 2:
                    data = sc.nextLine();
                    String[] aux3 = data.split(" ");
                    Double b[] = parsearADouble(aux3);
                    Item i3 = null;
                    lista.add(i3.setValores(0,0d,0d, 0d,Integer.parseInt(b[0].toString()) , 0,0,0,b[1] ));
                    break;
            }


        }catch (Exception e){
            throw new Exception("Hubo uun error al leer el archivo");
        }
    }

    @Override
    public void escribirResultados(Malla malla, Vector vector, File archivo) {

    }

    @Override
    public void leerMallayCondiciones(Malla m, File archivo) throws Exception {
        try{
            Scanner sc = new Scanner(archivo);
            Boolean flag = false;
            String data;
            ArrayList<Integer> datos = new ArrayList<>();

            data = sc.nextLine();//Obteniendo EI y datos de vector f
            String[] aux = data.split(" ");

            //Setearemos los datos a double
            Double params[] = parsearADouble(aux);
            //Setearemos correctamente los datos
            m.setParametros(params[0], params[1], params[2], params[3] );//EI, f_x, f_y, f_z

            data = sc.nextLine();//Obteniendo #coordenadas, #elementos, #dirichlet_x, #dirichlet_y, #dirichlet_z,#neuwmann
            String[] aux2 = data.split(" ");
            Integer t[] = parsearAInteger(aux2);

            m.setTamanios(t[0], t[1], t[2], t[3], t[4], t[5]);
            m.crearData();

            //Se salta la linea en blanco y luego el titulo
            sc.nextLine();
            obtenerDatos(archivo,sc, m.getNodos().getClass().cast(Item.class),0);
            sc.nextLine();
            obtenerDatos(archivo,sc, m.getElementos().getClass().cast(Item.class),0);
            sc.nextLine();
            obtenerDatos(archivo,sc, m.getDirichlet().getClass().cast(Item.class),0);
            sc.nextLine();
            obtenerDatos(archivo,sc, m.getNeumann().getClass().cast(Item.class),0);

            sc.close();

        }catch (Exception e){
            throw new Exception("Hubo un error al leer archivo");
        }
    }

    public Double[] parsearADouble(String lista[]){
        Double parametros[] = new Double[lista.length];
        for (int i =0 ; i<lista.length; i++){
            parametros[i] = Double.parseDouble(lista[i]);
        }
        return parametros;
    }

    public Integer[] parsearAInteger(String lista[]){
        Integer parametros[] = new Integer[lista.length];
        for (int i =0 ; i<lista.length; i++){
            parametros[i] = Integer.parseInt(lista[i]);
        }
        return parametros;
    }
}
