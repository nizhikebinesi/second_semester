package matrixes.matrix;

import matrixes.exception.NotInvertableException;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 1 on 15.02.2017.
 */
public interface IMatrix extends Externalizable {
    double getElem(int i, int j);
    void setElem(int i, int j, double elem);
    double getDet() throws NotInvertableException;// better use Gauss method
    int getSize();
}
