import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class LoginSteps {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("User has Navigated to the login page")
	def NavigateToLoginPage() {
		WebUI.openBrowser(GlobalVariable.Test_URL)
		WebUI.click(findTestObject('Page_CuraHomepage/btn_MakeAppointment'))
	}

	@When("User enters (.*) and (.*)")
	def EnterUsername(String username, String password) {
		WebUI.setText(findTestObject('Page_Login/txt_UserName'), username)
		
		WebUI.setText(findTestObject('Page_Login/txt_Password'), password)
	}
	@And("User clicks on the login button")
	def ClickLoginButton() {
		WebUI.click(findTestObject('Page_Login/btn_Login'))
	}

	@Then("User will be logged into the system")
	def I_verify_the_status_in_step() {
		WebUI.verifyElementPresent(findTestObject('Page_CuraAppointment/div_Appointment'), GlobalVariable.timeout)
	}
}