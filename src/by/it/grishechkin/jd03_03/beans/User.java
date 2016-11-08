package by.it.grishechkin.jd03_03.beans;

/**
 * Created by Yury on 30.10.2016.
 */
public class User {

    private int ID;
    private String FirstName;
    private String LastName;
    private String PasportNum;
    private int FK_Role;

    public User () {
    }

    public User(int ID, String firstName, String lastName, String pasportNum, int FK_Role) {
        this.ID = ID;
        FirstName = firstName;
        LastName = lastName;
        PasportNum = pasportNum;
        this.FK_Role = FK_Role;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", PasportNum='" + PasportNum + '\'' +
                ", FK_Role=" + FK_Role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (ID != user.ID) return false;
        if (FK_Role != user.FK_Role) return false;
        if (FirstName != null ? !FirstName.equals(user.FirstName) : user.FirstName != null) return false;
        if (LastName != null ? !LastName.equals(user.LastName) : user.LastName != null) return false;
        return PasportNum != null ? PasportNum.equals(user.PasportNum) : user.PasportNum == null;

    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (FirstName != null ? FirstName.hashCode() : 0);
        result = 31 * result + (LastName != null ? LastName.hashCode() : 0);
        result = 31 * result + (PasportNum != null ? PasportNum.hashCode() : 0);
        result = 31 * result + FK_Role;
        return result;
    }

    public int getID() { return ID; }

    public void setID(int ID) { this.ID = ID; }

    public String getFirstName() { return FirstName; }

    public void setFirstName(String firstName) { FirstName = firstName; }

    public String getLastName() {return LastName;}

    public void setLastName(String lastName) {LastName = lastName;}

    public String getPasportNum() {return PasportNum;}

    public void setPasportNum(String pasportNum) {PasportNum = pasportNum;}

    public int getFK_Role() {return FK_Role;}

    public void setFK_Role(int FK_Role) {this.FK_Role = FK_Role;}
}
