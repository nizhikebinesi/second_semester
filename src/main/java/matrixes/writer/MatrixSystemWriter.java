package matrixes.writer;

import matrixes.matrix.IMatrix;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

/**
 *
 */
public class MatrixSystemWriter implements IMatrixWriter {
    private OutputStream systemStream = System.out;
    private Writer systemWriter;

    public MatrixSystemWriter() {
        this.systemWriter = new PrintWriter(this.systemStream);
    }

    /**
     *
     * @throws IOException
     */
    public <T extends IMatrix> void write(T matrix) throws IOException {
        String result = (matrix != null)?(matrix.toString()):("None.");
        this.systemWriter.write(result);
        this.systemWriter.flush();
    }

    /**
     *
     * @throws IOException
     */
    public void close() throws IOException {
        this.systemWriter.close();
    }
}
