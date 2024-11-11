package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.util.List;

public class InventoryPage extends PageObject {

    @FindBy(css = "[data-test='inventory-item-price']")
    private List<WebElement> inventoryItemPriceList;

    @FindBy(css = "[data-test='inventory-item-name']")
    private List<WebElement> inventoryItemNameList;

    public boolean isItemInCart(String itemName) {
        String itemXPath = String.format("//div[@class='inventory_item_name'][text()='%s']", itemName);
        return $(By.xpath(itemXPath)).isPresent();
    }

    public BigDecimal getTotalPriceBigDecimal() {
        return inventoryItemPriceList.stream()
            .map(item -> item.getText().replace("$", "").trim())
            .map(BigDecimal::new)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<String> getItemsInCart() {
        return inventoryItemNameList
            .stream()
            .map(WebElement::getText)
            .toList();
    }
}
