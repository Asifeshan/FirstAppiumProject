package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utilities.ServerManager;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "summary", "html:target/cucumber/report.html",
                  "me.jvt.cucumber.report.PrettyReports:target/pixel 5/cucumber-reports"
        },
        features = "src/test/resources/Features",
        glue = {"step_definitions"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class RunnerTest {
    static ServerManager serverManager = new ServerManager();

    @BeforeClass
    public static void serverInitialize() {
        serverManager.startAppiumServer();
    }

    @AfterClass
    public static void serverCleanUp() {
        serverManager.stopAppiumServer();
    }
}
