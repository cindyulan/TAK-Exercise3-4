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

'Memastikan terdapat text \'Make Appointment\''
WebUI.verifyElementVisible(findTestObject('Object Repository/Web Record/Make Appointment Object/text_make_appointment'))

'Memilih facility'
WebUI.selectOptionByValue(findTestObject('Object Repository/Web Record/Make Appointment Object/select_facility'), 'Hongkong CURA Healthcare Center', 
    true)

'Melakukan checkbox apply readmission'
WebUI.click(findTestObject('Object Repository/Web Record/Make Appointment Object/input_apply_readmission'))

'Memilih radio button health program'
WebUI.click(findTestObject('Object Repository/Web Record/Make Appointment Object/input_Medicaid_programs'))

'Melakukan klik pada field visit date'
WebUI.click(findTestObject('Object Repository/Web Record/Make Appointment Object/input_visit_date'))

'Memilih tanggal visit'
WebUI.click(findTestObject('Object Repository/Web Record/Make Appointment Object/select_date'))

'Memberikan comment'
WebUI.setText(findTestObject('Object Repository/Web Record/Make Appointment Object/textarea_comment'), 'comment')

'Melakukan klik book appointment'
WebUI.click(findTestObject('Object Repository/Web Record/Make Appointment Object/button_Book Appointment'))

'Memastikan terdapat text appointment confirmation'
WebUI.verifyElementVisible(findTestObject('Object Repository/Web Record/Make Appointment Object/text_appointment_confirmation'))

'Memastikan terdapat text informasi'
WebUI.verifyElementVisible(findTestObject('Object Repository/Web Record/Make Appointment Object/text_informed_appointment'))

'Melakukan klik \'Go to Homepage\''
WebUI.click(findTestObject('Object Repository/Web Record/Make Appointment Object/button_homepage_afterbooking'))

'Memastikan terdapat text \'CURA Healthcare Service\''
WebUI.verifyElementVisible(findTestObject('Object Repository/Web Record/Make Appointment Object/text_cura_healthcare_service'))

