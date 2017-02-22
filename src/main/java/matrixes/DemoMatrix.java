package matrixes;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;

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

    public static void toTextStream(OutputStreamWriter wr, Matrix matrix) throws IOException {
        wr.write(matrix.toString());
        wr.flush();
    }
}
