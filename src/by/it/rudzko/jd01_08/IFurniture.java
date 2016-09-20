package by.it.rudzko.jd01_08;

/**
 * Created by Leta on 17.09.2016.
 */
public interface IFurniture {

    void getPar();
    float findSq();
    void getPrice();
    boolean lessThanAv(float[] prices);
    void descr();
    void descr(float[] prices);
    String fitSize(float lenRoom, float widRoom);



}
