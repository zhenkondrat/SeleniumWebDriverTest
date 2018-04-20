/**
 * Created with IntelliJ IDEA.
 * User: zhenkondrat
 * Date: 16.04.18
 * Time: 9:44
 * To change this template use File | Settings | File Templates.
 */
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class TestTest{
    public static void main(String[] args) {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://web-quadratic-equation.herokuapp.com/");

        ArrayList<DataInput> arr = new ArrayList<DataInput>();
//            //good data
//            arr.add(new DataInput("1", "-26", "120", new double[]{20, 6}));
//            arr.add(new DataInput("2", "1", "-3", new double[]{1, -1.5}));
//            arr.add(new DataInput("1", "4", "-21", new double[]{3, -7}));
//            arr.add(new DataInput("2", "0", "-18", new double[]{3, -3}));
//            arr.add(new DataInput("9", "-12", "4",  new double[]{2.0 / 3}));
//            //wrong data
//            arr.add(new DataInput("a", "-112", "14", null));
//            arr.add(new DataInput("a", "-c", "14", null));
            //random data
            arr.add(new DataInput("23", "-2", "0", ""));
            arr.add(new DataInput("4", "8", "1", ""));

        QuadraticEquationTest page = new QuadraticEquationTest(driver);
        for(DataInput di : arr){
            double[] result = (double[]) page.doIt(di.a, di.b, di.c);
            System.out.println(" NEW TEST: ----------------------");
            System.out.println(" input params: " + di.toString());
            di.outObject();
            di.outObject(result);
            System.out.println(" result: " +di.analise(result));
        }

        driver.quit();
    }
}