package matrixes;

import matrixes.matrix.IMatrix;
import matrixes.matrix.Matrix;
import matrixes.reader.IMatrixReader;
import matrixes.writer.MatrixSystemWriter;

import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by 1 on 16.02.2017.
 */
public class DemoMatrix {
    /**
     *
     * @param matrix
     * @return
     */
    public static double sumOfAllElements(Matrix matrix) {
        double sum = 0.0;
        int N = matrix.getSize();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += matrix.getElem(i, j);
            }
        }
        return sum;
    }

    /**
     *
     * @param writer
     * @param matrix
     * @param <T>
     * @throws IOException
     */
    public static <T extends IMatrix> void toTextStream(MatrixSystemWriter writer, T matrix) throws IOException {
       writer.write(matrix);
    }

    /**
     *
     * @param <T>
     * @param <M>
     */
    public static <T extends IMatrix, M extends IMatrixReader> void readFromStream(M reader, T matrix) throws IOException, ClassNotFoundException {
        reader.read(matrix);
    }

    public static <T extends IMatrix> void randomFilling(T matrix, double lenOfRange, double offset) {
        int size = matrix.getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix.setElem(i, j, Math.random() * lenOfRange - offset);
            }
        }
    }
}
