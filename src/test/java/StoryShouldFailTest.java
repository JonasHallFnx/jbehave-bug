import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

public class StoryShouldFailTest extends JUnitStory {

	@Override
	public Configuration configuration() {
		MostUsefulConfiguration configuration = new MostUsefulConfiguration();
		configuration.storyReporterBuilder()
				.withFormats(Format.CONSOLE)
				.withRelativeDirectory("");
		return configuration;
	}

	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), new TestSteps());
	}

	public static class TestSteps {

		@Then("success")
		public void doSomething() {
			System.out.println("SUCCESS");
		}

		@Given("fail")
		public void doFail() {
			System.out.println("FAIL");
			throw new RuntimeException("FAIL");
		}
	}
}