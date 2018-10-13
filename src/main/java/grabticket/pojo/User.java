package grabticket.pojo;



public class User {

    public static void main(String[] args) {
        User u = new User();

        System.out.println(u.getPassword());
    }


    String name;

    String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
