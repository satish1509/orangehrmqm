package testRunner;

import io.cucumber.testng.*;
import org.testng.annotations.*;

import com.qa.utils.AllureReportUtil;

public class Regressiontestrunner extends AbstractTestNGCucumberTests {

    private TestNGCucumberRunner testNGCucumberRunner;

    @Parameters({"cucumber.features", "cucumber.tags", "cucumber.glue", "cucumber.plugin"})
    @BeforeClass(alwaysRun = true)
    public void setUpClass(@Optional("src/test/resources/Features") String features,
                           @Optional("@Reg") String tags,
                           @Optional("applicationHooks,stepDefination") String glue,
                           @Optional("html:./Reports/myReports.html") String plugin) {

        System.setProperty("cucumber.features", features);
        System.setProperty("cucumber.filter.tags", tags); // <-- Correct usage
        System.setProperty("cucumber.glue", glue);
        System.setProperty("cucumber.plugin", plugin);

        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(dataProvider = "scenarios")
    public void runScenario(PickleWrapper pickle, FeatureWrapper feature) {
        testNGCucumberRunner.runScenario(pickle.getPickle());
    }

    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
    }

    @AfterSuite
    public void generateAllureReport() {
        AllureReportUtil.openAllureReport();
    }
}
