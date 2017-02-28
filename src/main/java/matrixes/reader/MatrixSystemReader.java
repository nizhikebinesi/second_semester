package matrixes.reader;

import matrixes.matrix.IMatrix;
import matrixes.matrix.InvertableMatrix;
import matrixes.matrix.Matrix;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 *
 */
public class MatrixSystemReader implements IMatrixReader {
    private InputStream systemStream = System.in;
    private Scanner scanner = new Scanner(this.systemStream);



    public InvertableMatrix readInvertableMatrix() throws IOException, ClassNotFoundException {
        int size = this.scanner.nextInt();
        InvertableMatrix invertableMatrix = new InvertableMatrix(size);
        this.read(invertableMatrix);
        return invertableMatrix;
    }

    public Matrix readMatrix() throws IOException, ClassNotFoundException {
        System.out.print("Size of matrix: ");
        int size = this.scanner.nextInt();
        Matrix matrix = new Matrix(size);
        this.read(matrix);
        return matrix;
    }

    public <T extends IMatrix> void read(T matrix) throws IOException, ClassNotFoundException {
        int size = matrix.getSize();
        double elem;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("matrix[" + i + "][" + j + "] = ");
                elem = this.scanner.nextDouble();
                matrix.setElem(i, j, elem);
            }
        }
    }

    public void close() throws IOException {
        this.scanner.close();
    }
}
