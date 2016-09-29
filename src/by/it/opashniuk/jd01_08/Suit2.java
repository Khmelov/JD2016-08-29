package by.it.opashniuk.jd01_08;


public class Suit2 extends Dress {


    private String dlyaKogo="для женщин";
    private int razmer=48;

    @Override
    public void appoimtmet() {
        super.appoimtmet();
    }

    @Override
    public void color() {
        super.color();
    }

    @Override
    public void composition() {
        super.composition();
    }

    @Override
    public void density() {
        super.density();
    }

    @Override
    public void forWhom() {
        System.out.println("Для кого - "+this.dlyaKogo);

    }

    @Override
    public void size() {
        System.out.println("Размер - "+this.razmer);
    }

    @Override
    public void width() {
        super.width();
    }
}
