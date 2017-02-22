package matrixes;

/**
 * Created by 1 on 15.02.2017.
 */
public class InvertableMatrix extends Matrix implements IInvertableMatrix {

    private InvertableMatrix(int N, double[] arr) {
        super(N);
        this.matrix = arr.clone();
    }

    public InvertableMatrix(int N) {
        super(N);
    }

    public IInvertableMatrix get() {



        return null;
    }

    public IInvertableMatrix getInverse() throws NotInvertableException {
        if (Math.abs(this.getDet()) < 1e-9) {
            throw new NotInvertableException();
        }

        int N = this.getSize();

        double temp;

        int[] changes = new int[N];
        for(int i = 0; i < N; i++) {
            changes[i] = i;
        }

        double [] e = new double[N * N];
        for (int i = 0; i < N; i++) {
            e[i * N + i] = 1d;
        }
/*        double [] e = new double [N * N];
        double [] arr = this.matrix.clone();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                e[i * N + j] = 0d;

                if (i == j) {
                    e[i * N + j] = 1d;
                }
            }
            e[i * N + i] = 1.0;
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
        }*/

        double[] matrix = this.matrix.clone();

        int exchanges = 0;

        double determinator = 1.0;

        int max;
        boolean b = true;
        double[] t = new double[N], tt = new double[N];
        for (int j = 0; j < N - 1; j++) {
            b = true;
            max = j;

            for (int k = j+1; k < N; k++) {
                if ( Math.abs(matrix[k * N + j]) > Math.abs(matrix[max * N + j]) && matrix[k * N + j] != 0 ) {
                    max = k;
                }
            }

            if (matrix[max * N + j] == 0) {
                b &= false;
                break;
            }

            if (max > j) {
                for (int i = 0; i < N; i++) {
                    t[i] = matrix[j * N + i];
                    tt[i] = e[j * N + i];
                }
                for (int i = 0; i < N; i++) {
                    matrix[j * N + i] = matrix[max * N + i];
                    e[j * N + i] = e[max * N + i];
                }
                for (int i = 0; i < N; i++) {
                    matrix[max * N + i] = t[i];
                    e[j * N + i] = tt[i];
                }
                //if (changes[max] != changes[j] && changes[j] != -1) {
                    int tmp = changes[max];
                    changes[max] = changes[j];
                    changes[j] = tmp;
                //} else {
                //    changes[max] = j;
                //    changes[j] = max;
                //}
                exchanges++;
            }

            for (int i = (j + 1); (i < N) && b; i++) {
                temp = matrix[i * N + j];
                for (int k = 0; k < N; k++) {
                    matrix[i * N + k] -= (0.0 + temp * matrix[j * N + k] / matrix[j * N + j]);
                    e[i * N + k] -= (0d + temp * e[j * N + k] / matrix[j * N + j]);
                }
            }


            for (int i = 0; i < N; i++) {
                for (int k = 0; k < N; k++) {
                    System.out.print(matrix[i * N + j] + " ");
                }
                System.out.println("");
            }
                System.out.println("\n\n");
        }

        for (int j = N - 1; j > 0; j--) {
            b = true;
            max = j;

            for (int k = j - 1; k > -1; k--) {
                if ( Math.abs(matrix[k * N + j]) > Math.abs(matrix[max * N + j]) && matrix[k * N + j] != 0 ) {
                    max = k;
                }
            }

            if (matrix[max * N + j] == 0) {
                b &= false;
                break;
            }

            if (max > j) {
                for (int i = 0; i < N; i++) {
                    t[i] = matrix[j * N + i];
                    tt[i] = e[j * N + i];
                }
                for (int i = 0; i < N; i++) {
                    matrix[j * N + i] = matrix[max * N + i];
                    e[j * N + i] = e[max * N + i];
                }
                for (int i = 0; i < N; i++) {
                    matrix[max * N + i] = t[i];
                    e[max * N + i] = tt[i];
                }

                int tmp = changes[max];
                changes[max] = changes[j];
                changes[j] = tmp;

                //exchanges++;
            }

            for (int i = (j - 1); (i > -1) && b; i--) {
                temp = matrix[i * N + j];
                for (int k = 0; k < N; k++) {
                    matrix[i * N + k] -= (0.0 + temp * matrix[j * N + k] / matrix[j * N + j]);
                    e[i * N + k] -= (0d + temp * e[j * N + k] / matrix[j * N + j]);
                }
            }


            for (int i = 0; i < N; i++) {
                for (int k = 0; k < N; k++) {
                    System.out.print(matrix[i * N + j] + " ");
                }
                System.out.println("");
            }
            System.out.println("\n\n");
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                e[i * N + j] /= matrix[i * N + i];
        }

        for (int i = 0; i < N; i++) {
            if (changes[i] != i) {
                for (int j = 0; j < N; j++) {
                    t[j] = e[i * N + j];
                }
                for(int j = 0; j < N; j++) {
                    e[i * N + j] = e[changes[i] * N + j];
                }
                for (int j = 0; j < N; j++) {
                    e[changes[i] * N + j] = t[j];
                }
            }
        }

        return new InvertableMatrix(N, e); // неверно считает, переписать
    }
}

