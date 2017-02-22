package matrixes;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Comparator;


public class Matrix implements IMatrix, Cloneable, Serializable {
    private int N;
    protected double[] matrix;
    private boolean isDeterminantActual = true;
    private double det = 0;
    protected static final double EPS = 1e-9;

    /**
     *
     */
    public Matrix() {
        this.matrix = new double[0];
        this.N = 0;
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
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < this.N; i++) {
            for (int j = 0; j < this.N; j++) {
                s.append(matrix[this.N * i + j] + " ");
            }
            s.append("\n");
        }
        return s.toString();
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

    public int getSize() {
        return this.N;
    }

    /**
     *
     * @return
     */
    public double getDet() {
        if (this.N <= 0) {
            throw new IllegalArgumentException();
        }

        //System.out.println();

        double[] matrix = this.matrix.clone();

        int exchanges = 0;

        double determinator = 1.0;

        int max;
        boolean b = true;
        double[] t = new double[this.N];

        for (int j = 0; j < this.N - 1; j++) {
            b = true;
            max = j;

            for (int k = j+1; k < this.N; k++) {
                if ( Math.abs(matrix[k * this.N + j]) > Math.abs(matrix[max * this.N + j]) && matrix[k * this.N + j] != 0) {
                    max = k;
                }
            }

            if (matrix[max * this.N + j] == 0) {
                b &= false;
                break;
            }

            if (max > j) {
                for (int i = 0; i < this.N; i++) {
                    t[i] = matrix[j * this.N + i];
                }
                for (int i = 0; i < this.N; i++) {
                    matrix[j * this.N + i] = matrix[max * this.N + i];
                }
                for (int i = 0; i < this.N; i++) {
                    matrix[max * this.N + i] = t[i];
                }
                exchanges++;
            }

            for (int i = j + 1; i < N && b; i++) {
                double temp = matrix[i * this.N + j];
                for (int k = 0; k < N; k++) {
                    matrix[i * this.N + k] -= (0.0 + temp * matrix[j * this.N + k] / matrix[j * this.N + j]);
                }

            }
        }

        if (!b) {
            return 0;
        }

        for (int i = 0; i < N; i++) {
            determinator *= matrix[i * this.N + i];
        }

        return (exchanges % 2 == 0)?(determinator):((-1)*determinator);
    }
}
