package Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
         features="src/test/resources/Features/Leads.feature",
		 //features="@rerun/failed_scenarios.txt",
         glue= {"StepDefinitions","AppHooks"},
         publish=true,
         plugin={"html:target/cucumber-reports.html","pretty"}
          //tags="@DeleteLead"
         //tags="@Buycomputer and @BuyingTab or @Buycomputer and @BuyingDesktop or @BuyCar"
         )

public class MyRunner extends AbstractTestNGCucumberTests{


}
