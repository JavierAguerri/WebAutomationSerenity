package steps;

import io.cucumber.java.en.When;
import pages.ProductsPage;

import java.util.List;

public class ProductOperationSteps {
    ProductsPage productsPage;

    @When("I add item {string}")
    public void i_add_item(String item) {
        productsPage.addItemToCart(
            item.toLowerCase().replace(" ", "-")
        );
    }

    @When("I add items")
    public void i_add_items(List<String> items) {
        items.stream()
            .map(item -> item.toLowerCase().replace(" ", "-"))
            .forEach(productsPage::addItemToCart);
    }

    @When("I remove item {string}")
    public void i_remove_item(String item) {
        productsPage.removeItemFromCart(
            item.toLowerCase().replace(" ", "-")
        );
    }

    @When("I view my cart")
    public void i_view_my_cart() {
        productsPage.goToCart();
    }
}
