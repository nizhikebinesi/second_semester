package matrixes;

/**
 * Created by 1 on 15.02.2017.
 */
public interface IMatrix {
    public double getElem(int i, int j);
    public void setElem(int i, int j, double elem);
    public double getDet() throws CloneNotSupportedException;// better use Gauss method
}
