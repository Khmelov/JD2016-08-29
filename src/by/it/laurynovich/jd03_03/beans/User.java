package by.it.laurynovich.jd03_03.beans;

public class User {
    private int id_User = 0;
    private String login;
    private String password;
    private String first_name;
    private String last_name;
    private String n_passport;
    private int bag = 0;
    private int role = 0 ;
    private String email;

    public User() {
    }

    public User(int id_User,String login, String password, String email, String first_name,
                String last_name, String n_passport , int bag, int role) {
        this.id_User = id_User;
        this.login = login;
        this.password = password;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.n_passport = n_passport;
        this.bag = bag;
        this.role = role;
    }



    public int getId() {
        return id_User;
    }

    public void setId(int id_User) {
        this.id_User = id_User;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getN_passport() {
        return n_passport;
    }

    public void setN_passport(String n_passport) {
        this.n_passport = n_passport;
    }

    public int getBag() {
        return bag;
    }

    public void setBag(int bag) {
        this.bag = bag;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User users = (User) o;

        if (id_User != users.id_User) return false;
        if (role != users.role) return false;
        if (login != null ? !login.equals(users.login) : users.login != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;
        return email != null ? email.equals(users.email) : users.email == null;

    }

    @Override
    public int hashCode() {
        int result = id_User;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + role;
        return result;
    }

    @Override
    public String toString() {
        return "User[" +
                "id_User=" + id_User +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", n_passport='" + n_passport + '\'' +
                ", bag=" + bag +
                ", role=" + role +
                ", email='" + email + '\'' +
                ']';
    }

}
