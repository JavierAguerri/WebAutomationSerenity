package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SignInPage;
import pages.ProductsPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static utils.Constants.USER_SHOULD_BE_AT_THE_PRODUCTS_PAGE;

public class AuthenticationSteps {
    SignInPage signInPage;
    ProductsPage productsPage;

    @Given("I am signed in as a standard user")
    public void i_am_signed_in_as_a_standard_user() {
        i_am_at_the_sign_in_screen();
        i_sign_in_as_a_standard_user();
    }

    @Given("I am at the sign in screen")
    public void i_am_at_the_sign_in_screen() {
        signInPage.open();
    }

    @When("I sign in as a standard user")
    public void i_sign_in_as_a_standard_user() {
        signInPage.signInAsStandardUser();
    }

    @Then("I should be at the products page")
    public void i_am_signed_in() {
        assertThat(USER_SHOULD_BE_AT_THE_PRODUCTS_PAGE, productsPage.isAt(), is(true));
    }
}
