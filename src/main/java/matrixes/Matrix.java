package matrixes;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Comparator;


public class Matrix implements IMatrix {

    /* -- start --*/

    private class Line implements Cloneable {
        public double[] line;

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public Line(int N) {
            this.line = new double[N];
        }

        public Line(Line other) {
            this.line = new double[other.line.length];
            for (int i = 0; i < other.line.length; i++) {
                this.line[i] = other.line[i];
            }
        }
    }

    private class TwoDimArray implements Cloneable {
        public Line[] arr;

        public TwoDimArray(double [] matr) {
            int size = (int) Math.sqrt(matr.length);
            this.arr = new Line[size];
            for (int i = 0; i < size; i++) {
                this.arr[i] = new Line(size);
            }
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    this.arr[i].line[j] = matr[i * size + j];
                }
            }
        }

        public void swap(int i, int j) throws CloneNotSupportedException {
            if (i == j) {
                return;
            }

            Line t = new Line(arr[i]);
            arr[i] = new Line(arr[j]);
            arr[j] = new Line(t);
        }
    }

    /* --end-- */

    // In real Matrix is square matrix
    private int N;
    // Is there 0-index matrix?
    private double[] matrix;
    private boolean isDeterminantActual = true;
    private double det = 0;

    private static final double EPS = 1e-9;

    /**
     *
     */
    public Matrix() {

    }

    /**
     *
     * @param N
     */
    public Matrix(int N) {
        this.N = N;
        this.matrix = new double[N * N];
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        // rewrite
        return super.equals(obj);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        // rewrite
        return super.toString();
    }

    /**
     *
     * @param i
     * @param j
     * @return
     */
    public double getElem(int i, int j) {
        return this.matrix[i * this.N + j];
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     *
     * @param i
     * @param j
     * @return
     */
    public void setElem(int i, int j, double elem) {
        this.matrix[i * this.N + j] = elem;
        this.isDeterminantActual = false;
    }

    private double getTriangledMatrix(double[] matr) throws CloneNotSupportedException {
        //T[] matrix = (T[]) matr.clone();
        // create my own convenient way of storing matrix
        TwoDimArray matrix = new TwoDimArray(matr);

        int exchanges = 0;

        for (int i = 0; i < N; i++) {
            for (int jj = 0; jj < N; jj++) {
                System.out.print(matrix.arr[i].line[jj] + " ");
            }
            System.out.println();
        }

        System.out.println();

        double determinator = 1.0;

        int max;
        boolean b = true;

        for (int j = 0; j < N - 1; j++) {
            b = true;

            max = j;

            for (int k = j+1; k < N; k++) {
                // переписать if
                if ( Math.abs(matrix.arr[k].line[j]) > Math.abs(matrix.arr[max].line[j]) && matrix.arr[k].line[j] != 0)/*(matrix.arr[k].line[j] > matrix.arr[max].line[j])*/ {
                    max = k;
                }
            }

            if (matrix.arr[max].line[j] == 0) {
                System.out.println("HHHHHHHH max = " + max + " HHHHHHHHHHHHH");
                b &= false;
                break;
            }

            if (max > j) {
                matrix.swap(max, j);
                exchanges++;
            }

            System.out.println("GGGGGG");
            for (int i = 0; i < N; i++) {
                for (int jj = 0; jj < N; jj++) {
                    System.out.print(matrix.arr[i].line[jj] + " ");
                }
                System.out.println();
            }
            System.out.println("GGGGG");

            //determinator *= matrix.arr[j].line[j];

            for (int i = j + 1; i < N && b; i++) {
                for (int k = j + 1; k < N; k++) {
                    // допиши

                    //System.out.println("\nWWWWW " + matrix.arr[i].line[k] + " WWWW\n");
                    //if (matrix.arr[j].line[j] != 0)
                    matrix.arr[i].line[k] -= (0.0 + matrix.arr[i].line[j] * matrix.arr[j].line[k] / matrix.arr[j].line[j]);// * matrix.arr[j].line[k];

                    //System.out.println("\nWWWWW " + matrix.arr[i].line[k] + " WWWW\n");

                }
            }


            System.out.println("BBBBBBBBB");
            for (int i = 0; i < N; i++) {
                for (int jj = 0; jj < N; jj++) {
                    System.out.print(matrix.arr[i].line[jj] + " ");
                }
                System.out.println();
            }
            System.out.println("BBBBBBBBBBBB");
        }

        if (!b) {
            return 0;
        }

        //int determinator = 1;
        for (int i = 0; i < N; i++) {
            determinator *= matrix.arr[i].line[i];
        }

        return (exchanges % 2 == 0)?(determinator):((-1)*determinator);
    }

    /**
     *
     * @return
     */
    public double getDet() throws CloneNotSupportedException {
        /*if (matrix == null) {
            return 0;
        }*/

        if (this.isDeterminantActual) {
            return this.det;
        }

        this.det = getTriangledMatrix(matrix);
        this.isDeterminantActual = true;

        return this.det;
    }

    /*protected boolean isDeterminantActual() {
        return this.isDeterminantActual;
    }*/
}
