import matrixes.DemoMatrix;
import matrixes.matrix.InvertableMatrix;
import matrixes.exception.NotInvertableException;
import matrixes.matrix.Matrix;
import matrixes.reader.MatrixFileReader;
import matrixes.reader.MatrixSystemReader;
import matrixes.writer.MatrixFileWriter;
import matrixes.writer.MatrixSystemWriter;

import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * Created by 1 on 15.02.2017.
 */
public class Main {

    /**
     *
     * @param args
     * @throws NotInvertableException
     */
    public static void main(String[] args) throws NotInvertableException {
        try(
                MatrixSystemWriter toConsole = new MatrixSystemWriter();
                MatrixSystemReader fromConsole = new MatrixSystemReader();
                MatrixFileWriter toFile = new MatrixFileWriter("/", "target");
                MatrixFileReader fromFile = new MatrixFileReader("/", "source");
        ) {
            Matrix justMatrix = new Matrix(3);
            // Fill justMatrix by random numbers in (-10, 10)
            DemoMatrix.randomFilling(justMatrix, 20, 10);
            // Write to console
            toConsole.write(justMatrix);
            // Read from console
            fromConsole.read(justMatrix);
            // Determinant to console
            System.out.println("Det of matrix = " + justMatrix.getDet());
            //
            InvertableMatrix invert = new InvertableMatrix(3);
            // Read from console
            fromConsole.read(invert);
            // Give(& to console) inverse matrix
            toConsole.write(invert.getInverse());
            // Invert to file
            toFile.write(invert);
            InvertableMatrix invert2 = null;
            // Read invert from file
            fromFile.read(invert2);
            // Invert2 to console
            toConsole.write(invert2);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
