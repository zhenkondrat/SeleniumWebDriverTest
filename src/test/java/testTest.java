/**
 * Created with IntelliJ IDEA.
 * User: zhenkondrat
 * Date: 30.03.18
 * Time: 22:44
 * To change this template use File | Settings | File Templates.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testTest{
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://web-quadratic-equation.herokuapp.com/");

        WebElement a = driver.findElement(By.id("param_a"));
        a.sendKeys("3");

        WebElement b = driver.findElement(By.id("param_b"));
        b.sendKeys("5   ");

        WebElement c = driver.findElement(By.id("param_c"));
        c.sendKeys("1");

        WebElement button = driver.findElement(By.id("solve"));
        new Actions(driver).moveToElement(button).click().perform();
        button.click();

        WebDriverWait wait = new WebDriverWait(driver,9);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#result math")));

            WebElement result = driver.findElement(By.id("result"));
            System.out.println("(x1, x2): " + result.getText());
        } catch(Exception e){
            System.out.println("no result");
        }
        driver.quit();
    }
}