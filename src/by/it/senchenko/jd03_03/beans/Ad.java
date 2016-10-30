package by.it.senchenko.jd03_03.beans;


public class Ad {

    private int ID;
    private String Name;
    private String Autor;
    private String Date;
    private int FK_User;

    public Ad() {
    }

    public Ad(int ID, String name, String autor, String date, int FK_User) {
        this.ID = ID;
        Name = name;
        Autor = autor;
        Date = date;
        this.FK_User = FK_User;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getFK_User() {
        return FK_User;
    }

    public void setFK_User(int FK_User) {
        this.FK_User = FK_User;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Autor='" + Autor + '\'' +
                ", Date='" + Date + '\'' +
                ", FK_User=" + FK_User +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ad ad = (Ad) o;

        if (ID != ad.ID) return false;
        if (FK_User != ad.FK_User) return false;
        if (Name != null ? !Name.equals(ad.Name) : ad.Name != null) return false;
        if (Autor != null ? !Autor.equals(ad.Autor) : ad.Autor != null) return false;
        return Date != null ? Date.equals(ad.Date) : ad.Date == null;

    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (Name != null ? Name.hashCode() : 0);
        result = 31 * result + (Autor != null ? Autor.hashCode() : 0);
        result = 31 * result + (Date != null ? Date.hashCode() : 0);
        result = 31 * result + FK_User;
        return result;
    }
}
