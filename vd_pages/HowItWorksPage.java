package vd_pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class HowItWorksPage {
	
	@FindBy(css = ".start-header > h2")
	private WebElement greetingHeading;
	
	@FindBy(xpath = "//button[./img]")
	private WebElement enableVideoButton;
	
	@FindBy(xpath = "//button[text()='Continue my visit']")
	private WebElement continueVisitButton;
	
	private final WebDriver driver;
	
	protected HowItWorksPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getGreetingText() {
		return greetingHeading.getText();
	}
	
	public void enableVideo() {
		enableVideoButton.click();
	}
	
	public WebElement waitForVideoFrame(String srcValue) {
		long stop = 15000;
		while(System.currentTimeMillis() < stop) {
			List<WebElement> list = driver.findElements(By.cssSelector("iframe[src='" + srcValue + "']"));
			if(list.size() == 0) {
				continue;
			} else {
				return list.get(0);
			}
		}
		
		return null;
	}
	
	public void clickContinueVisitButton() {
		continueVisitButton.click();
	}
}
