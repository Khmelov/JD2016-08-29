package by.it.opashniuk.jd01_08;

public abstract class Dress implements IMaterial{

    private int razmer=52;
    private String naznachenie="для спорта";
    private String dlyaKogo="для мужчин";
    private String cvet="красный";
    private String sostav="полиэстер 20%, хлопок 80%";
    private int plotnost=120;
    private double tolschina=0.05;




    public void size() {
        System.out.println("Размер - "+razmer);
    }

    public void appoimtmet() {
        System.out.println("Назначение - "+naznachenie);
    }

    public void forWhom() {
        System.out.println("Для кого - "+dlyaKogo);
    }

    @Override
    public void color() {
        System.out.println("Цвет - "+cvet);
    }

    @Override
    public void composition() { System.out.println("Состав - "+sostav);
    }

    @Override
    public void density() { System.out.println("Плотность - "+plotnost+"g/m2");

    }

    @Override
    public void width() { System.out.println("Толщина - "+tolschina);

    }
}

