package matrixes.matrix;

import matrixes.exception.NotInvertableException;

/**
 *
 */
public interface IInvertableMatrix extends IMatrix {
    IInvertableMatrix getInverse() throws NotInvertableException;
}
