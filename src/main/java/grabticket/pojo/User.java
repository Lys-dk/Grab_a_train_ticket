package grabticket.pojo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource(value = "classpath:user.properties", encoding = "UTF-8")
public class User {

    public static void main(String[] args) {
        User u = new User();

        System.out.println(u.getPassword());
    }

    @Value("${name}")
    String name;

    @Value("${password}")
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
