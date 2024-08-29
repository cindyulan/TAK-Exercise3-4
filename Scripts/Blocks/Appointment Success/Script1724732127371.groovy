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
WebUI.selectOptionByValue(findTestObject('Web Record/Make Appointment Object/select_facility'), facility, false)

//WebUI.check(findTestObject('Object Repository/Web Record/Make Appointment Object/input_apply_readmission'))
'Melakukan checkbox apply readmission'
if (hospital_readmission == true) {
    WebUI.check(findTestObject('Object Repository/Web Record/Make Appointment Object/input_apply_readmission'))
}

'Memilih radio button health program'
//WebUI.click(findTestObject('Object Repository/Web Record/Make Appointment Object/input_Medicaid_programs'))
def select_radio = hospital_program
switch (select_radio) {
	case select_radio = 'Medicare':
		println(select_radio)
	
		WebUI.click(findTestObject('Object Repository/Web Record/Appointment Confirmation/input_medicare_programs'))
		break
	case select_radio = 'Medicaid':
		println(select_radio)
	
		WebUI.click(findTestObject('Object Repository/Web Record/Appointment Confirmation/input_medicaid_programs'))
		break
	case select_radio = 'None':
		println(select_radio)
	
		WebUI.click(findTestObject('Object Repository/Web Record/Appointment Confirmation/input_none_programs'))
		break
	default:
		println(select_radio)
		WebUI.click(findTestObject('Object Repository/Web Record/Appointment Confirmation/input_none_programs'))
		break
}

'Melakukan klik pada field visit date'
WebUI.click(findTestObject('Object Repository/Web Record/Make Appointment Object/input_visit_date'), FailureHandling.STOP_ON_FAILURE)

'Memilih tanggal visit'
WebUI.click(findTestObject('Object Repository/Web Record/Make Appointment Object/select_date'))

'Memberikan comment'
WebUI.setText(findTestObject('Object Repository/Web Record/Make Appointment Object/textarea_comment'), komen)

'Melakukan klik book appointment'
WebUI.click(findTestObject('Object Repository/Web Record/Make Appointment Object/button_Book Appointment'))

'Memastikan terdapat text appointment confirmation'
WebUI.verifyElementVisible(findTestObject('Object Repository/Web Record/Make Appointment Object/text_appointment_confirmation'))

'Memastikan terdapat text informasi'
WebUI.verifyElementVisible(findTestObject('Object Repository/Web Record/Make Appointment Object/text_informed_appointment'))

'Memastikan facility sama dengan yang diinputkan'
WebUI.verifyElementText(findTestObject('Web Record/Appointment Confirmation/lbl_isi_facility'), facility)

//WebUI.verifyElementText(findTestObject('Web Record/Appointment Confirmation/lbl_yes_no'), hospital_readmission)
'Memastikan apply readmisssion sama dengan yang diinputkan'
if (hospital_readmission == true) {
    WebUI.verifyElementText(findTestObject('Object Repository/Web Record/Appointment Confirmation/lbl_yes_no'), 'Yes')
} else {
    WebUI.verifyElementText(findTestObject('Object Repository/Web Record/Appointment Confirmation/lbl_yes_no'), 'No')
}

'Memastikan program sesuai dengan yang diisikan'
//WebUI.verifyElementText(findTestObject('Web Record/Appointment Confirmation/lbl_isi_program'), hospital_program)
switch (select_radio) {
	case select_radio = 'Medicare':
		println(select_radio)
		WebUI.verifyElementText(findTestObject('Web Record/Appointment Confirmation/lbl_isi_program'), 'Medicare')
		break
	case select_radio = 'Medicaid':
		println(select_radio)
		WebUI.verifyElementText(findTestObject('Web Record/Appointment Confirmation/lbl_isi_program'), 'Medicaid')
		break
	case select_radio = 'None':
		println(select_radio)
		WebUI.verifyElementText(findTestObject('Web Record/Appointment Confirmation/lbl_isi_program'), 'None')
		break
	default:
		println(select_radio)
		WebUI.verifyElementText(findTestObject('Web Record/Appointment Confirmation/lbl_isi_program'), 'None')
		break
}

'Memastikan tanggal yang diisi sesuai'
WebUI.verifyElementText(findTestObject('Web Record/Appointment Confirmation/lbl_isi_date'), date)

'Memastikan komen yang diisi sesuai'
WebUI.verifyElementText(findTestObject('Web Record/Appointment Confirmation/lbl_isi_comment'), komen)

'Melakukan klik \'Go to Homepage\''
WebUI.click(findTestObject('Object Repository/Web Record/Make Appointment Object/button_homepage_afterbooking'))

'Memastikan terdapat text \'CURA Healthcare Service\''
WebUI.verifyElementVisible(findTestObject('Object Repository/Web Record/Make Appointment Object/text_cura_healthcare_service'))

