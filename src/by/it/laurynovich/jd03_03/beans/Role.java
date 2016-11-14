package by.it.laurynovich.jd03_03.beans;

public class Role {
    private int idRole = 0;
    private String role;

    public Role (int idRole,String role){
        this.idRole = idRole;
        this.role = role;
    }

    public Role (){
        this.idRole = idRole;
        this.role = role;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role1 = (Role) o;

        if (idRole != role1.idRole) return false;
        return role.equals(role1.role);

    }

    @Override
    public int hashCode() {
        int result = idRole;
        result = 31 * result + role.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Role{" +
                "idRole=" + idRole +
                ", role='" + role + '\'' +
                '}';
    }


}
