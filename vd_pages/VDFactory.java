package vd_pages;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class VDFactory {
	private static final String HOME_URL = "https://www.hellorory.com";
	private static final String BASE_URL = "https://start.ro.co/rory/vaginal-dryness/";
	private static final int RESPONSE_CODE = 200;
	private static final int DEFAULT_WAIT = 20;
	
	private final String workflowTopic = "vaginal dryness";
	private final String email = "test.person@gmail.com";
	private final String firstName = "Test";
	private final String lastName = "Person";
	private final String password = "Password";
	private final String videoSrc = "https://www.youtube.com/embed/OHZOIOVDJic?autoplay=1";
	
	public final LandingPage lp;
	public final HowItWorksPage howPage;
	public final BasicsPage basicPage;
	private final WebDriver driver;
	
	public VDFactory(WebDriver driver) {
		this.driver = driver;
		lp = new LandingPage(driver);
		howPage = new HowItWorksPage(driver);
		basicPage = new BasicsPage(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void openBaseUrl() {
		driver.get(BASE_URL);
	}
	
	public String getHomeUrl() {
		return HOME_URL;
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public int getExpectedResponseCode() {
		return RESPONSE_CODE;
	}
	
	public int getDefaultWaitValue() {
		return DEFAULT_WAIT;
	}
	
	public String getWorkflowTopic() {
		return workflowTopic;
	}
	
	public String getEmailAddress() {
		return email;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String generatedRandomPassword() {
		Random random = new Random();
		int postFix = random.nextInt(Integer.MAX_VALUE);
		String randomPassword = password + postFix;
		return randomPassword;
	}
	
	public String getVideoSrc() {
		return videoSrc;
	}
}
