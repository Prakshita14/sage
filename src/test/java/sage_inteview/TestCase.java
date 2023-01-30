package sage_inteview;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase extends BaseClass {

	public TestCase() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setUp() throws IOException {

		driver = initialization();

	}

	@Test(priority = 0, enabled = true)
	public void testCase() throws InterruptedException, IOException {

		PageClass page = new PageClass(driver);
		ArrayList<String> data = Uitility.getData();
		ArrayList<String> notAvailableProduct = new ArrayList<String>();
		ArrayList<String> eBookAvailable = new ArrayList<String>();
		ArrayList<String> eBookNotAvailable = new ArrayList<String>();
		String parentId = null;
		Select dd = new Select(page.locationDD);
		if (page.locationPopUp.isDisplayed()) {
			 parentId = driver.getWindowHandle();
			Set<String> ids = driver.getWindowHandles();
			while (ids.iterator().hasNext()) {
				if (ids.iterator().next() != parentId) {
					driver.switchTo().window(ids.iterator().next());
					dd.selectByVisibleText("United States");
					page.submitbtn.click();
					break;
				}
			}
		}


		for (int i = 0; i < data.size(); i++) {
			page.searchInput.sendKeys(data.get(i));
			page.searchIcon.click();
			boolean displayed=page.noProductsText.isDisplayed();
			if (displayed) {
				notAvailableProduct.add(data.get(i));
			} else {
				Actions actions = new Actions(driver);
				actions.moveToElement(page.productlink).click().build().perform();;
				if (page.ebook.isDisplayed())
					eBookAvailable.add(data.get(i));
				else
					eBookNotAvailable.add(data.get(i));
			}
		}
		for (String string : eBookAvailable) {
			System.out.println("Product is not available " + string);
		}
		for (String string : eBookNotAvailable) {
			System.out.println("eBook is not available " + string);
		}
		for (String string : notAvailableProduct) {
			System.out.println("eBook is available " + string);
		}
		
		

	}
	
	@AfterMethod
	public void tearDown() {

		driver.quit();

	}

	

}
