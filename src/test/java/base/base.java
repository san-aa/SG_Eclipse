package base;
 
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.FileUtils;
 
import java.io.File;
import java.time.Duration;
 
import java.time.Duration;
 
public class base {

	    // Function for click operation
	    public void clickElement(By locator) {
	        driver.findElement(locator).click();
	    }
 
	    // Function for clicking outside the modal
	    public void clickOutsideModal() {
	        WebElement body = driver.findElement(By.tagName("body"));
	        body.click();
	    }
 
	    // Function for Forcefully enabled element and Set Text
	    public void forceEnableAndSetText(By locator, String text) {
	        WebElement elem = driver.findElement(locator);
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].removeAttribute('disabled')", elem);
	        elem.sendKeys(text);
	    }
 
	    // Function for scroll down to enable the element
	    public void scrollDown() {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0, 500);");
	    }
 
	    // Function for scroll to top
	    public void scrollTop() {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0, 0);");
	    }
 
	    // Function for Inputting some text to text fields
	    public void setText(By locator, String value) {
	        driver.findElement(locator).sendKeys(value);
	    }
 
	    // Function for fuzzy Search with dropdown
	    public void fuzzySearchDropDown(By locator1, String value, By locator2) {
	        driver.findElement(locator1).sendKeys(value);
	        try {
	            Thread.sleep(6000); // Wait for dropdown options
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        driver.findElement(locator2).click();
	    }
 
	    // Function for checkbox click
	    public void checkCheckbox(By locator, boolean value) {
	        WebElement checkbox = driver.findElement(locator);
	        if (value && !checkbox.isSelected()) {
	            checkbox.click();
	        } else if (!value && checkbox.isSelected()) {
	            checkbox.click();
	        }
	    }
 
	    // Function for selecting a dropdown value
	    public void selectDropDownValue(By locator, String value) {
	        Select select = new Select(driver.findElement(locator));
	        select.selectByVisibleText(value);
	    }
 
	    // Function for clearing the text field
	    public void clearText(By locator) {
	        driver.findElement(locator).clear();
	    }
 
	    // Function for getting the text from an element
	    public String getText(By locator) {
	        return driver.findElement(locator).getText();
	    }
 
	    // Function for typing and hitting enter
	    public void typeAndEnter(By locator, String value) {
	        WebElement elem = driver.findElement(locator);
	        elem.sendKeys(value);
	        elem.sendKeys(Keys.ENTER);
	    }
 
	    // Function for Wait for specific time
	    public void waitForElement(By locator, int timeout) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }
 
	    // Function for waiting for an element to disappear
	    public void waitForElementToDisappear(By locator, int timeout) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	    }
 
	    // Function for clicking an element by XPath
	    public void clickElementByXpath(String xpath) {
	        driver.findElement(By.xpath(xpath)).click();
	    }
 
	    // Function for file upload
	    public void fileUploader(By locator, String filePath) {
	        WebElement uploadElement = driver.findElement(locator);
	        uploadElement.sendKeys(filePath);
	    }
 
	    // Function for getting the value from a text field
	    public String getTextFromElement(By locator) {
	        return driver.findElement(locator).getAttribute("value");
	    }
 
	    // Function for assert a URL change
	    public void verifyUrlChange(String expectedUrl) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        wait.until(ExpectedConditions.urlToBe(expectedUrl));
	    }
 
	    // Function to check if element is visible
	    public boolean isElementVisible(By locator) {
	        try {
	            return driver.findElement(locator).isDisplayed();
	        } catch (NoSuchElementException e) {
	            return false;
	        }
	    }
 
	    // Function to check if element is enabled
	    public boolean isElementEnabled(By locator) {
	        return driver.findElement(locator).isEnabled();
	    }
 
	    // Function to check if element is disabled
	    public boolean isElementDisabled(By locator) {
	        return !driver.findElement(locator).isEnabled();
	    }
 
	    // Function for verifying the element contains text
	    public void shouldContains(By locator, String text) {
	        WebElement elem = driver.findElement(locator);
	        if (!elem.getText().contains(text)) {
	            throw new AssertionError("Text not found: " + text);
	        }
	    }
 
	    // Function to wait for a specified duration
	    public void waitForDuration(int millis) {
	        try {
	            Thread.sleep(millis);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
 
	    // Function to handle pagination (clicking next button)
	    public void clickThroughPagination(By nextButtonLocator, int maxAttempts) {
	        int attempts = 0;
	        while (attempts < maxAttempts) {
	            WebElement nextButton = driver.findElement(nextButtonLocator);
	            if (nextButton.isDisplayed() && nextButton.isEnabled()) {
	                nextButton.click();
	                waitForDuration(1500); // Wait for page to load
	                attempts++;
	            } else {
	                System.out.println("Reached last page or 'Next' button is disabled.");
	                break;
	            }
	        }
	    }
 
	    // Function to get future date after n days
	    public String addDaysToDate(int daysToAdd) {
	        java.util.Calendar calendar = java.util.Calendar.getInstance();
	        calendar.add(java.util.Calendar.DAY_OF_MONTH, daysToAdd);
	        java.util.Date futureDate = calendar.getTime();
	        return new java.text.SimpleDateFormat("yyyy-MM-dd").format(futureDate);
	    }
 
	    // Function to handle date picker by setting date
	    public void setDateFromDatePicker(By locator, String date) {
	        WebElement datePicker = driver.findElement(locator);
	        datePicker.sendKeys(date);
	    }
 
	    // Function for clicking the last element in a list
	    public void clickLastElement(By locator) {
	        WebElement lastElement = driver.findElement(locator);
	        lastElement.click();
	    }
 
	    // Function to click the last "View" button
	    public void clickLastViewButton(By locator) {
	        WebElement lastRow = driver.findElement(locator);
	        lastRow.findElement(By.xpath("//td[last()]/button[contains(@class, 'bi-eye')]")).click();
	    }

 
	
    protected WebDriver driver;
 
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
 
          }
//
//    @AfterMethod
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}