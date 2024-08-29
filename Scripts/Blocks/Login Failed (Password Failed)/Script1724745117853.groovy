import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'Melakukan klik menu toggle'
WebUI.click(findTestObject('Web Record/Login Object/button_menu toggle'))

'Melakukan klik menu login'
WebUI.click(findTestObject('Web Record/Login Object/button_login_toggle'))

'Menginputkan username yang benar'
WebUI.setText(findTestObject('Web Record/Login Object/input_username'), username)

'Menginputkan password yang salah'
WebUI.setEncryptedText(findTestObject('Object Repository/Web Record/Login Object/input_password_failed'), password)

'Melakukan klik button login'
WebUI.click(findTestObject('Web Record/Login Object/button_login'))

'Memastikan validasi gagal login muncul'
WebUI.verifyElementVisible(findTestObject('Web Record/Login Object/text_login_failed'), FailureHandling.STOP_ON_FAILURE)

