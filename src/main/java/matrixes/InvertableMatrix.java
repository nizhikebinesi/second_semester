package matrixes;

/**
 * Created by 1 on 15.02.2017.
 */
public class InvertableMatrix extends Matrix implements IInvertableMatrix {

    private InvertableMatrix(double[] matr) {

    }

    public InvertableMatrix(int N) {
        super(N);
    }

    public IInvertableMatrix getInverse() throws CloneNotSupportedException {
        if (super.getDet() == 0) {
            return null;
        }
        // допиши
        return null;
    }
}
