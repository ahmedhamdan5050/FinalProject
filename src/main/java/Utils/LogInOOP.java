package Utils;

import org.openqa.selenium.By;

public class LogInOOP {
    public By SignIn=By.cssSelector("div.header_user_info > a");
    public By email=By.cssSelector("#email");
    public By password=By.cssSelector("#passwd");
    public By loginButton=By.xpath("//*[@id=\"SubmitLogin\"]");
    public By WomenTab=By.cssSelector("#block_top_menu > ul > li:nth-child(1) > a");

    public By Tops=By.cssSelector("#categories_block_left > div > ul > li:nth-child(1) > a");

    public By TopsSize=By.cssSelector("#ul_layered_id_attribute_group_1 > li:nth-child(1) > label > a");
    public By Catagory=By.cssSelector("#ul_layered_category_0 > li:nth-child(1) > label > a");
    public By Size=By.cssSelector("#ul_layered_id_attribute_group_1 > li:nth-child(1) > label > a");
    public By SelectItems=By.xpath("//*[@id=\"center_column\"]/ul");
    public By AddToCartButton=By.xpath("//*[@id=\"add_to_cart\"]/button/span");
    public By ContinueShoppingButton=By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span");
    public By QuantityBox=By.cssSelector("span.ajax_cart_quantity");
    public By Cart=By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a");
    public By ProccedToCheckoutButton=By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]");
    public By addressProccedToCheckout=By.cssSelector("#center_column > form > p > button > span");
    public By termsAndConditon=By.xpath("//*[@id=\"form\"]/div/p[2]/label");
    public By ShippingProccedToCheckout=By.xpath("//*[@id=\"form\"]/p/button/span");
    public By TopsItemBox=By.cssSelector("#center_column > ul");
}
