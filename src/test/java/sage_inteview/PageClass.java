package sage_inteview;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageClass {
	
	@FindBy(xpath = "//*[contains(text(),'Search tips:')]")
	public WebElement noProductsText;

	@FindBy(xpath = "//div[@id='modal-change-location']")
	public WebElement locationPopUp ;
	
	@FindBy(xpath = "//select")
	public WebElement locationDD;

	@FindBy(xpath = "//input[contains(@title,'Search Submit')]")
	public WebElement searchIcon ;
	
	@FindBy(xpath = "//input[@value='Set']")
	public WebElement submitbtn;

	@FindBy(xpath = "//input[contains(@placeholder,'Search')]")
	public WebElement searchInput;
	
	@FindBy(xpath = "//h1[contains(.,'Search')]/..//a/img")
	public WebElement productlink;

	@FindBy(xpath = "//h2[contains(.,'Select a Purchasing Option')]/..//div[contains(.,'eBook') and @class='strong margin-bottom--small']")
	public WebElement ebook;
	
	public PageClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
