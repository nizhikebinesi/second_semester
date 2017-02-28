package matrixes.reader;
import matrixes.matrix.IMatrix;

import java.io.IOException;

/**
 *
 */
public interface IMatrixReader extends AutoCloseable {
    <T extends IMatrix> void read(T matrix) throws IOException, ClassNotFoundException;
    void close() throws IOException;
}
