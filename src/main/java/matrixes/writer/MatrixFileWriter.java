package matrixes.writer;

import matrixes.matrix.IMatrix;

import java.io.*;

/**
 *
 */
public class MatrixFileWriter implements IMatrixWriter {
    private OutputStream fileObjectStream;
    private final String path;
    private final String name;

    public MatrixFileWriter(final String path, final String name) throws IOException {
        this.path = path;
        this.name = name;
        this.fileObjectStream = new ObjectOutputStream(
                new FileOutputStream(
                        new File(
                                path.concat(name)
                        )
                )
        );
    }

    public <T extends IMatrix> void write(T matrix) throws IOException {
        matrix.writeExternal((ObjectOutput) this.fileObjectStream);
    }

    public void close() throws IOException {
        fileObjectStream.close();
    }
}
