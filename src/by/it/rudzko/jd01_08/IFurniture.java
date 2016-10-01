package by.it.rudzko.jd01_08;

/**
 * @author Olga Rudzko
 *
 */
public interface IFurniture {

    void getPar();                                  //gets parameters of furniture
    float findSq();                                 //returns square of furniture
    void getPrice();                                //gets price of furniture
    boolean lessThanAv(float[] prices);             //returns whether this furniture costs less than average price for other furniture in the room
    void descr();                                   //prints short description of the furniture;
    void descr(float[] prices);                     //places the price of the furniture to the array of prices
    String fitSize(float lenRoom, float widRoom);   //returns answer whether the furniture fits length and width of the room



}
