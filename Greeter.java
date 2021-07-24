import java.util.Locale;
import java.util.ResourceBundle;

public class Greeter {

  private Locale locale;
  private String name;

  public Greeter(String language, String country, String name) {
    locale = new Locale(language, country);
    this.name = name;
  }

  public String sayHello() {
    ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);
    return messages.getString("greeting") + ", " + name.toUpperCase();
  }

  public static void main(String[] args) {

    // create some ternary fallback values if num of args is incorrect
    String language = (args.length > 0) ? args[0]: "en";
    String country = (args.length > 1) ? args[1]: "NZ";
    String name = (args.length > 2) ? args[2]: "Friend";

    Greeter greeter = new Greeter(language, country, name);
    System.out.println(greeter.sayHello());

  }
}