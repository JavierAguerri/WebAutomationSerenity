package pages;

import net.serenitybdd.annotations.At;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.Constants.PRODUCTS_PAGE_TITLE;

@At(".*/inventory.html")
public class ProductsPage extends PageObject {

    @FindBy(css = "[data-test='shopping-cart-link']")
    private WebElement shoppingCartButton;

    @FindBy(css = "[data-test='title']")
    private WebElement title;


    public Boolean isAt() {
        return title.getText().equals(PRODUCTS_PAGE_TITLE);
    }

    public void addItemToCart(String itemName) {
        String addItemButtonSelector = String.format("[data-test='add-to-cart-%s']", itemName);
        $(By.cssSelector(addItemButtonSelector)).click();
    }

    public void removeItemFromCart(String itemName) {
        String removeItemButtonSelector = String.format("[data-test='remove-%s']", itemName);
        $(By.cssSelector(removeItemButtonSelector)).click();
    }

    public void goToCart() {
        shoppingCartButton.click();
    }

}
