package DeltaxRegistration.Delatx_registartiongForm.Registration;

import java.io.IOException;

import org.openqa.selenium.InvalidElementStateException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DeltaxRegistration.Delatx_registartiongForm.testBase.TestBase;
import DeltaxRegistration.Delatx_registartiongForm.uiActions.RegistrationForm;

public class Tc_004_VerifyRegistrationWithSpecialChracters extends TestBase{

	RegistrationForm register;
	@BeforeTest
	public void setup() throws Exception
	{
		
		init();
		
	}
	
	@DataProvider(name ="testData")
	public String[][]getData() throws IOException
	{
		
		
		String dataset[][] = getData("deltax_data", "RegisterData_withSameEmailData");
		
		return dataset;
		
		
		
	}
	
	
	@Test(dataProvider = "testData")
	public void VerifyRegistrationwithValiddata(String fname,String lname,String uname,String password ,String c_password,String dep,String ename,String contactNumber )
	{
		log("==============  starting Tc_00_VerifyRegistrationwithValiddata===============");
		
		try{
		register = new RegistrationForm(driver);
		log("Register user with userId data");
		register.registerUser(fname, lname, uname, password, dep, c_password, ename, contactNumber);
		register.submitForm();
		takeScreenshot("registration_with_valid_data");
		}
		catch (InvalidElementStateException e) {
			
			takeScreenshot("fail");
			
		}
		
		
		
		log("==============  finished Tc_00_VerifyRegistrationwithValiddata===============");
		
		
	}
	
	@AfterTest
	public void endTest()
	{
		
		closeBrowser();
		
		
	}


}
