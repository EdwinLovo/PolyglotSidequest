package com.uca;

import org.ejml.simple.SimpleMatrix;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hola mundo");
        SimpleMatrix A = new SimpleMatrix(2,1);
        SimpleMatrix B = new SimpleMatrix(2,2);
        SimpleMatrix C = new SimpleMatrix(3,3);
        B.set(0,0,1);
        B.set(0,1,2);
        B.set(1,0,3);
        B.set(1,1,4);

        A.set(0, 0, 1);
        A.set(1, 0, 1);
       // A.zero();
        A.print();
        System.out.println("Matriz B multiplicacion 1");
        B.mult(A).scale(2).print();
        System.out.println("Matriz B multiplicacion 2");
        B.print();

        //C.set(A.plus(B));
        C.insertIntoThis(1,1,B);

        System.out.println("Esta matriz es C");
        C.print();


    }
}
