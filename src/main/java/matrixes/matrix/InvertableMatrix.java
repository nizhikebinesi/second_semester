package matrixes.matrix;

import matrixes.exception.NotInvertableException;

/**
 *
 */
public class InvertableMatrix extends Matrix implements IInvertableMatrix {

    private InvertableMatrix(int N, double[] arr) {
        super(N);
        this.matrix = arr.clone();
    }

    public InvertableMatrix(int N) {
        super(N);
    }

    public IInvertableMatrix getInverse() throws NotInvertableException {
        if (Math.abs(this.getDet()) < super.EPS) {
            throw new NotInvertableException();
        }

        int N = this.getSize();
        double temp;

        double [] e = new double [N * N];
        double [] arr = this.matrix.clone();

        for (int i = 0; i < N; i++) {
            e[i * N + i] = 1d;
        }

        for (int k = 0; k < N; k++) {
            temp = arr[k * N + k];

            for (int j = 0; j < N; j++) {
                arr[k * N + j] /= temp;
                e[k * N + j] /= temp;
            }

            for (int i = k + 1; i < N; i++) {
                temp = arr[i * N + k];

                for (int j = 0; j < N; j++) {
                    arr[i * N + j] -= arr[k * N + j] * temp;
                    e[i * N + j] -= e[k * N + j] * temp;
                }
            }
        }

        for (int k = N - 1; k > 0; k--) {
            for (int i = k - 1; i >= 0; i--) {
                temp = arr[i * N + k];

                for (int j = 0; j < N; j++) {
                    arr[i * N + j] -= arr[k * N + j] * temp;
                    e[i * N + j] -= e[k * N + j] * temp;
                }
            }
        }

        return new InvertableMatrix(N, e);
    }
}

