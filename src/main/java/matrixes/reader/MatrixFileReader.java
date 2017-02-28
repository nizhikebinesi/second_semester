package matrixes.reader;

import matrixes.matrix.IMatrix;

import java.io.*;

/**
 *
 */
public class MatrixFileReader implements IMatrixReader {
    private InputStream fileObjectStream;
    private final String path;
    private final String name;

    public MatrixFileReader(final String path, final String name) throws IOException {
        this.name = name;
        this.path = path;
        this.fileObjectStream = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(
                                new File(path.concat(name)
                                )
                        )
                )
        );
    }

    public <T extends IMatrix> void read(T matrix) throws IOException, ClassNotFoundException {
        matrix.readExternal((ObjectInput) fileObjectStream);
    }

    public void close() throws IOException {
        fileObjectStream.close();
    }
}
