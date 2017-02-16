package matrixes;

/**
 * Created by 1 on 15.02.2017.
 */
public interface IInvertableMatrix extends IMatrix {
    public IInvertableMatrix getInverse() throws CloneNotSupportedException;
}
