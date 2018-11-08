import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainIOC {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        Account account = context.getBean("account",Account.class);
        account.income(100,"P'benz give");
        System.out.println(account.getBalance());
    }
}
