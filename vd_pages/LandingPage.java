package vd_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	@FindBy(css = "header[class*=sc-gZMcBi]")
	private WebElement pageHeader;
	
	@FindBy(xpath = "//header//button[contains(text(), 'Help?')]")
	private WebElement helpButton;
	
	@FindBy(css = "h2[class*=sign_up]")
	private WebElement signUpHeader;
	
	@FindBy(className = "sign_up-sidebar")
	private WebElement sideBar;
	
	@FindBy(id = "temporaryEmail")
	private WebElement emailField;
	
	@FindBy(id = "firstName")
	private WebElement firstNameField;
	
	@FindBy(id = "lastName")
	private WebElement lastNameField;
	
	@FindBy(id = "password")
	private WebElement passwordField;
	
	@FindBy(id = "agreedToTos")
	private WebElement agreedCheckBox;
	
	@FindBy(css = "#Embed > button")
	private WebElement supportButton;
	
	@FindBy(css = "#Embed input[class*=searchInput]")
	private WebElement supportSearchField;
	
	@FindBy(css = "button[type='submit']")
	private WebElement startVisitButton;
	
	private final WebDriver driver;
	
	protected LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean waitForPageToLoad(int delay) {
		long stop = System.currentTimeMillis() + Integer.toUnsignedLong(delay) * 1000;
		while(System.currentTimeMillis() < stop) {
			if(driver.findElements(By.cssSelector("div[class='start_preloader']")).size() > 0) {
				continue;
			} else {
				System.out.println("Home Page successfully loaded within " + delay);
				return true;
			}
		}
		
		System.out.println("Home Page failed to load within " + delay);
		return false;
	}
	
	public WebElement getHeader() {
		return pageHeader;
	}
	
	public String getPageHeadingText() {
		return signUpHeader.getText();
	}
	
	public WebElement getSideBarElement() {
		return sideBar;
	}
	
	public void typeInEmail(String email) {
		emailField.sendKeys(email);
	}
	
	public void typeInFirstName(String name) {
		firstNameField.sendKeys(name);
	}
	
	public void typeInLastName(String lastName) {
		lastNameField.sendKeys(lastName);
	}
	
	public void typeInPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void checkAgreeCheckbox() {
		agreedCheckBox.click();
	}
	
	public boolean checkBoxIsChecked() {
		return agreedCheckBox.isSelected();
	}
	
	public WebElement getSupportButton() {
		return supportButton;
	}
	
	public void clickStartVisitButton() {
		startVisitButton.click();
	}
}
