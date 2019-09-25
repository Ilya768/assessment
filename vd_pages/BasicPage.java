package vd_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasicsPage {
	
	private final String basicsHeaderSelector = "//h2[text()='The Basics']";
	
	@FindBy(xpath = "//div[./input[@id='male']]")
	private WebElement maleOption;
	
	@FindBy(xpath = "//div[contains(text(), 'Unfortunatelly')]")
	private WebElement disclaimerHeader;
	
	@FindBy(xpath = "//button[text()='got it']")
	private WebElement gotItButton;
	
	private final WebDriver driver;
	
	protected BasicsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getBasicsHeaderSelector() {
		return basicsHeaderSelector;
	}
	
	public void clickMaleOption() {
		maleOption.click();
	}
	
	public WebElement getDisclaimerHeader() {
		return disclaimerHeader;
	}
	
	public void clickGotItButton() {
		gotItButton.click();
	}
}
