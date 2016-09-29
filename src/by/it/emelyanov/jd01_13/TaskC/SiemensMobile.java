package by.it.emelyanov.jd01_13.TaskC;

import java.lang.*;

public abstract class SiemensMobile implements Mobile {
    private int levelVolume;

    public SiemensMobile(int levelVolume) throws MobileExceptions {
        if (levelVolume >= 10 && levelVolume <= 10) {
            this.levelVolume = levelVolume;
        } else {
            throw new MobileExceptions("Ошибка в уровне громкости");
        }
    }

    public int getLevelVolume() {
        return levelVolume;
    }

    @Override
    public void switchOn() {
        System.out.println("Телефон включён");
    }

    @Override
    public void switchOff() {
        System.out.println("Телефон выключен");
    }

    @Override
    public void checkBalance() {
        System.out.println("Ваш баланс -10 рублей");
    }

    @Override
    public void setVolume() {
        System.out.println("Уровень громкости " + getLevelVolume());
    }

    @Override
    public void vibrateOn() {
        System.out.println("Вибрация включена");
    }

    @Override
    public void vibrateOff() {
        System.out.println("Вибрация выключена");
    }

    @Override
    public void flightModeOn() {
        System.out.println("Режим в самолёте включен");
    }

    @Override
    public void flightModeOff() {
        System.out.println("Режим в самолёте выключен");
    }
}
