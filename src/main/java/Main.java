import matrixes.Matrix;

/**
 * Created by 1 on 15.02.2017.
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Matrix matr = new Matrix(4);
        //matr.setElem(0,0,3);
        //matr.setElem(1, 1, 45);
        matr.setElem(1,2, -32);
        matr.setElem(0,1, 223);
        matr.setElem(2,0, -444);
        matr.setElem(3,3,-1);
        //matr.setElem(2,2,-32);
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
        System.out.println(matr.getDet());
    }
}
