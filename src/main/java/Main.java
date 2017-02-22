import matrixes.InvertableMatrix;
import matrixes.Matrix;
import matrixes.NotInvertableException;

import java.math.BigInteger;

/**
 * Created by 1 on 15.02.2017.
 */
public class Main {


    public static void main(String[] args) throws NotInvertableException {
        InvertableMatrix matr = new InvertableMatrix(3);
        matr.setElem(0,0,2);
        matr.setElem(0,1,5);
        matr.setElem(0,2,7);
        matr.setElem(1,0,6);
        matr.setElem(1,1,3);
        matr.setElem(1,2,4);
        matr.setElem(2,0,5);
        matr.setElem(2,1,-2);
        matr.setElem(2,2,-3);
        //matr.setElem(1, 1, 45);
        //matr.setElem(1,2, -32);
        //matr.setElem(0,1, 223);
        //matr.setElem(2,0, -444);
        //matr.setElem(3,3,-1);
        //matr.setElem(2,2,-32);
        //req
        /*matr.setElem(0,2,3);
        matr.setElem(1,2,3);
        matr.setElem(2,3,3);
        matr.setElem(3,1,3);
        matr.setElem(0,1,2);
        matr.setElem(1,3,2);
        matr.setElem(3,0,2);
        matr.setElem(2,0,1);
        matr.setElem(3,2,1);
        matr.setElem(3,3,1);
        matr.setElem(0,3,4);
        matr.setElem(1,0,4);
        matr.setElem(1,1,4);
        matr.setElem(2,1,4);
        matr.setElem(2,2,4);*/
        System.out.println(matr);
        System.out.println(matr.getDet());
        System.out.println(matr.getInverse());
        //req
        //System.out.println(matr.getDet());
        //BigInteger b = new BigInteger("1");
        //b = b.multiply(BigInteger.valueOf(42));
        //System.out.println(b);
        //System.out.println();
        //System.out.println(matr);
        //InvertableMatrix arr = new InvertableMatrix(3);
        //for (int i = 0; i < 3; i++) {
        //    arr.setElem(i, i, 1);
        //}
        /*arr.setElem(0, 1,1);
        arr.setElem(1, 0, 4);
        arr.setElem(0,2,3);
        arr.setElem(2,2,1);*//*
        arr.setElem(0,1, 3);
        arr.setElem(0,2, -1);
        arr.setElem(0,3, 2);
        arr.setElem(1,0, 2);
        arr.setElem(1,1, 1);
        arr.setElem(2,0, -2);
        arr.setElem(2,1, -1);
        arr.setElem(2,3, 2);
        arr.setElem(3,0, -5);
        arr.setElem(3,1, 7);
        arr.setElem(3,2, 1);
        arr.setElem(3,3, 1);*/
        //arr.setElem(0,1, 3);
        //arr.setElem(0,1, 3);
        //arr.setElem(0,1, 3);
        //arr.setElem(0,1, 3);
        //arr.setElem(0,1, 3);
        //arr.setElem(0,1, 3);
        //arr.setElem(0,1, 3);
        /*arr.setElem(0,0, 1);
        arr.setElem(0,1, 3);
        arr.setElem(0,2, 2);
        arr.setElem(1,0, 1);
        arr.setElem(1,1, -2);
        arr.setElem(1,2, 1);
        arr.setElem(2,0, 1);
        arr.setElem(2,1, -1);
        arr.setElem(2,2, 1);
        System.out.println(arr);
        System.out.println(arr.getInverse());*/
    }
}
