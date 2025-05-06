package comp.qa.oopencart.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	WebElement element;
	WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public void doClick(By locator) {
		element = findElement(locator);
		element.click();

	}

	public void getElementList(By listLink) {
		List<WebElement> eleList = findElements(listLink);
		System.out.println("Link Count :" + eleList.size());
		for (WebElement e : eleList) {
			String linkText = e.getText();
			System.out.println(linkText);
		}
	}

	public void clickSearchedListItem(By listLink, String searchText) {
		List<WebElement> eleList = findElements(listLink);
		// System.out.println("Link Count :"+ eleList.size());
		for (WebElement e : eleList) {
			String linkText = e.getText();
			// System.out.println(linkText);
			if (linkText.contains(searchText)) {
				System.out.println("Element Found!!");
				e.click();
				break;
			}
		}

	}

	public void doSendKeys(By locator, String value) {
		element = findElement(locator);
		element.clear();
		element.sendKeys(value);
	}

	public String doGetText(By locator) {
		element = findElement(locator);
		String outputString = element.getText().trim();
		System.out.println("getText output: " + outputString);
		return outputString;
	}

	public boolean isDisplayedElement(By locator) {
		try {
			return findElement(locator).isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("Element id not displayed with locator: " + locator);
			return false;
		}
	}

	public List<WebElement> findElements(By locator) {
		return driver.findElements(locator);

	}

	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	
	// ********************* Context Menu Handling ************************
	
	public List<WebElement> getContextMenuItems(By rightClicklocator, By contextMenu)
	{
		Actions act=new Actions(driver);
		act.contextClick(findElement(rightClicklocator)).perform();
		return findElements(contextMenu);
	}

	// *********************************JQueryDropdown********************************************

	/**
	 * Select all or specific values from dropdown. Give "all" as input param for
	 * selectelemetList if you want to select the entire list Give list values as
	 * input param for selectelemetList when few values are to be selected. eg
	 * "choice 1","choice 2"
	 * 
	 * @param dropdown
	 * @param dropdownElementList
	 * @param selectelemetList
	 */
	public void selectElementsInDropdown(By dropdown, By dropdownElementList, String... selectelemetList) {
		doClick(dropdown);
		List<WebElement> elementList = findElements(dropdownElementList);

		for (String eleName : selectelemetList) {
			if (eleName.equalsIgnoreCase("all")) {
				for (WebElement ele : elementList) {
					ele.click();
				}
			} else {
				for (WebElement ele : elementList) {
					if (ele.getText().equals(eleName)) {
						System.out.println(ele.getText());
						ele.click();
					}
				}
			}
		}
	}

	// ************************* Explicit Wait **********************

	/**
	 * Expected wait introduced before sendKeys
	 * 
	 * @param webElement
	 * @param inputValue
	 * @param timeOut
	 */
	public void waitForSendKeys(By webElement, String inputValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(webElement))).clear();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(webElement))).sendKeys(inputValue);
	}

	public void multiLevelMenu(By menuLevel1, By menuLevel2, By menuLevel3, By menuLevel4) {
		Actions act = new Actions(driver);
		driver.findElement(menuLevel1).click();
		act.moveToElement(WaitForVisibilityOfElementLocated(menuLevel2, 5)).click().perform();
		act.moveToElement(WaitForVisibilityOfElementLocated(menuLevel3, 5)).click().perform();
		WaitForVisibilityOfElementLocated(menuLevel4, 5).click();

	}

	public WebElement WaitForVisibilityOfElementLocated(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement WaitForPresenceOfElementLocated(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public boolean waitForGetWindowHandles(int numberOfHandles, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			return wait.until(ExpectedConditions.numberOfWindowsToBe(numberOfHandles));
		} catch (Exception e) {
			System.out.println("===Number of window handles are not correct===");
			return false;
		}
	}

	public boolean WaitForgetWindowTitle(String searchTitle, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			return wait.until(ExpectedConditions.titleContains(searchTitle));
		} catch (Exception e) {
			System.out.println("===Window title is not correct===");
			return false;
		}
	}

	public List<WebElement> waitForVisibilityOfAllElementsLocatedBy(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public List<WebElement> waitForPresenceOfAllElementsLocatedBy(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	public boolean WaitForPageLoad(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		String pageLoadStatus = wait
				.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete'")).toString();
		return Boolean.parseBoolean(pageLoadStatus);
	}

}
