package matrixes.writer;

import matrixes.matrix.IMatrix;

import java.io.IOException;

/**
 *
 */
public interface IMatrixWriter extends AutoCloseable {
    <T extends IMatrix>void write(T matrix) throws IOException;
    void close() throws IOException;
}
