package pages;

import io.github.cdimascio.dotenv.Dotenv;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import static utils.Constants.PASSWORD_NOT_SET;
import static utils.Constants.USERNAME_NOT_SET;

public class SignInPage extends PageObject {
    @FindBy(css = "[data-test='username']")
    private WebElement usernameField;
    @FindBy(css = "[data-test='password']")
    private WebElement passwordField;
    @FindBy(css = "[data-test='login-button']")
    private WebElement loginButton;

    @Step
    public void signInAsStandardUser() {
        String env = System.getProperty("env");
        Dotenv dotenv = Dotenv
                .configure()
                .directory("src/test/resources/secrets")
                .filename(".env."+env)
                .load();
        String username = dotenv.get("SIGNIN_USERNAME");;
        String password = dotenv.get("SIGNIN_PASSWORD");;
        if (username == null) {
            throw new RuntimeException(USERNAME_NOT_SET);
        }
        if (password == null) {
            throw new RuntimeException(PASSWORD_NOT_SET);
        }
        $(usernameField).type(username);
        $(passwordField).type(password);
        $(loginButton).click();
    }
}
