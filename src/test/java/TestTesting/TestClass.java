package TestTesting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;

import static Interactions.ClickActions.click;
import static Utils.ElementFinder.fetchElement;

@ExtendWith({Lifecycles.class, TestWatcherHandle.class})
public class TestClass {

    @Test
    public void test01(){
        System.out.println("my test is running :) :)");

        click(fetchElement(By.xpath("//h5[text()='Book Store Application']\n")));
    }
}
