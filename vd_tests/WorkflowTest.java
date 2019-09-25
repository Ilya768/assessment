package vd_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import vd_pages.VDFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkflowTest {
	VDFactory factory;
	WebDriver driver;
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		factory = new VDFactory(driver);
	}
	
	@Test
	public void openLandingPageTest() {
		factory.openBaseUrl();
		assertTrue(factory.lp.waitForPageToLoad(factory.getDefaultWaitValue()));
		
		WebElement header = factory.lp.getHeader();
		WebElement sideBar = factory.lp.getSideBarElement();
		WebElement supportButton = factory.lp.getSupportButton();
		assertTrue(header.isDisplayed());
		assertTrue(sideBar.isDisplayed());
		assertTrue(supportButton.isDisplayed());
		
		String headingText = factory.lp.getPageHeadingText();
		String workflowTopic = factory.getWorkflowTopic();
		assertTrue(headingText.contains(workflowTopic));
	}
	
	@Test
	public void navigateToGreetingsPageTest() {
		factory.openBaseUrl();
		factory.lp.waitForPageToLoad(factory.getDefaultWaitValue());
		
		factory.lp.typeInEmail(factory.getEmailAddress());
		factory.lp.typeInFirstName(factory.getFirstName());
		factory.lp.typeInLastName(factory.getLastName());
		factory.lp.typeInPassword(factory.generatedRandomPassword());		
		factory.lp.checkAgreeCheckbox();
		assertTrue(factory.lp.checkBoxIsChecked());
		
		factory.lp.clickStartVisitButton();
		WebDriverWait wait = new WebDriverWait(driver, factory.getDefaultWaitValue());
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("tabs")));
		
		String greetingsText = factory.howPage.getGreetingText();
		assertTrue(greetingsText.contains(factory.getFirstName()));
		
		factory.howPage.enableVideo();
		WebElement videoFrame = factory.howPage.waitForVideoFrame(factory.getVideoSrc());
		assertTrue(videoFrame.isDisplayed());
	}
	
	@Test
	public void completeWorkflowTest() {
		factory.openBaseUrl();
		factory.lp.waitForPageToLoad(factory.getDefaultWaitValue());		
		factory.lp.typeInEmail(factory.getEmailAddress());
		factory.lp.typeInFirstName(factory.getFirstName());
		factory.lp.typeInLastName(factory.getLastName());
		factory.lp.typeInPassword(factory.generatedRandomPassword());		
		factory.lp.checkAgreeCheckbox();
		factory.lp.clickStartVisitButton();
		factory.howPage.clickContinueVisitButton();
		
		WebDriverWait wait = new WebDriverWait(driver, factory.getDefaultWaitValue());
		String xPath = factory.basicPage.getBasicsHeaderSelector();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
		
		factory.basicPage.clickMaleOption();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("flow-question")));
		
		WebElement disclaimerHeader = factory.basicPage.getDisclaimerHeader();
		assertTrue(disclaimerHeader.isDisplayed());
		
		factory.basicPage.clickGotItButton();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("menu-main-navigation")));
		
		String currentUrl = factory.getCurrentUrl();
		String homeUrl = factory.getHomeUrl();
		assertEquals(currentUrl, homeUrl);
	}
}
