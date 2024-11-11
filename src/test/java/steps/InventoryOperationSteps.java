package steps;

import io.cucumber.java.en.Then;
import pages.InventoryPage;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static utils.Constants.*;

public class InventoryOperationSteps {

    InventoryPage inventoryPage;

    @Then("the items should be in the cart")
    public void the_items_should_be_in_the_cart(List<String> items) {
        List<String> itemsInCart = inventoryPage.getItemsInCart();
        assertThat(ITEMS_IN_THE_CART_SHOULD_CONTAIN_ALL_EXPECTED_ITEMS, itemsInCart, hasItems(items.toArray(new String[0])));
    }

    @Then("the item {string} should be in the cart")
    public void the_item_should_be_in_the_cart(String item) {
        assertThat(ITEM_SHOULD_BE_IN_THE_CART + item, inventoryPage.isItemInCart(item), is(true));
    }

    @Then("the item {string} should not be in the cart")
    public void the_item_should_not_be_in_the_cart(String item) {
        assertThat(ITEM_SHOULD_NOT_BE_IN_THE_CART + item, inventoryPage.isItemInCart(item), is(false));
    }

    @Then("the total price should match")
    public void the_total_price_should_match(List<String> prices) {
        BigDecimal expectedTotal = prices.stream()
            .map(price -> price.replace("$", "").trim())
            .map(BigDecimal::new)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal actualTotal = inventoryPage.getTotalPriceBigDecimal();
        assertThat(THE_TOTAL_PRICE_SHOULD_MATCH, actualTotal, comparesEqualTo(expectedTotal));
    }
}
