package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.external.GoogleAuthPage;

import static helpers.DriverHelper.configureDriver;

public class TestBase {
    GoogleAuthPage googleAuthPage = new GoogleAuthPage();

    @BeforeAll
    public static void beforeAll(){
        configureDriver();

    }
}
