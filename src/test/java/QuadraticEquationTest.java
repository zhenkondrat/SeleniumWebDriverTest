import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: zhenkondrat
 * Date: 20.04.18
 * Time: 9:02
 * To change this template use File | Settings | File Templates.
 */
public class QuadraticEquationTest {
    By param_a = By.id("param_a");
    By param_b = By.id("param_b");
    By param_c = By.id("param_c");

    By solve_btn = By.id("solve");
    By resultate = By.id("result");

    private final WebDriver driver;

    public QuadraticEquationTest(WebDriver _driver)
    {
        this.driver = _driver;
    }

    public void setParam_a(String a){
        driver.findElement(param_a).clear();
        driver.findElement(param_a).sendKeys(a);
    }

    public void setParam_b(String b){
        driver.findElement(param_b).clear();
        driver.findElement(param_b).sendKeys(b);
    }

    public void setParam_c(String c){
        driver.findElement(param_c).clear();
        driver.findElement(param_c).sendKeys(c);
    }

    public void submitData() {
        WebElement button = driver.findElement(solve_btn);
        new Actions(driver).moveToElement(button).click().perform();
        new Actions(driver).moveToElement(button).click().perform();
    }

    public String getResult(){
        try{
            //need create normal waiting
            new WebDriverWait(driver,7).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-success")));
            Thread.sleep(10000);
            return driver.findElement(resultate).getText();
        } catch(Exception e){
            return null;
        }
    }

    private Object parseResult(String data)
    {
        String temp = data;
        if( temp.indexOf(" ")==-1 )
            return new double[]{
                    Double.parseDouble(temp.substring(temp.indexOf("=")+1))
            };

        double x1, x2;
        x1 = Double.parseDouble(temp.substring(temp.indexOf("=")+1, temp.indexOf(" ")));
        temp = temp.substring(temp.indexOf(" ")+1);
        x2 = Double.parseDouble(temp.substring(temp.indexOf("=")+1));

        return new double[]{x1, x2};
    }

    public Object doIt(String a, String b, String c){
        this.setParam_a(a);
        this.setParam_b(b);
        this.setParam_c(c);

        this.submitData();

        String data = this.getResult();
        if(data != null)
            return parseResult(data);
        else
            return null;
    }
}
