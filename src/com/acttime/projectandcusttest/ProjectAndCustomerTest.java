package com.acttime.projectandcusttest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.bcel.generic.CPInstruction;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.actitime.genericLib.Constants;
import com.actitime.genericLib.Driver;
import com.actitime.genericLib.ExcelLib;
import com.actitime.genericLib.WebDriverCommonLib;
import com.acttime.pageObjectRepoLib.AtiveProjectAndCust;
import com.acttime.pageObjectRepoLib.Common;
import com.acttime.pageObjectRepoLib.CreateNewCustomer;
import com.acttime.pageObjectRepoLib.EditCustomerInfo;
import com.acttime.pageObjectRepoLib.EnterTimeTrack;
import com.acttime.pageObjectRepoLib.Login;
import com.acttime.pageObjectRepoLib.OpenTask;
import com.gargoylesoftware.htmlunit.Page;

public class ProjectAndCustomerTest {
	//object deceleration
	ExcelLib eLib;
	WebDriver driver;
	Login loginPage;
	Common comPage;
	EnterTimeTrack timePage;
	OpenTask openTask;
	AtiveProjectAndCust actPage;
	CreateNewCustomer createCustPage;
	
	@BeforeClass
	public void configBeforeClass(){
		eLib = new ExcelLib();
		driver = Driver.getDriver();
		loginPage = PageFactory.initElements(driver, Login.class);
		comPage = PageFactory.initElements(driver, Common.class);
		timePage = PageFactory.initElements(driver, EnterTimeTrack.class);
		openTask = PageFactory.initElements(driver, OpenTask.class);
		actPage = PageFactory.initElements(driver, AtiveProjectAndCust.class);
		createCustPage= PageFactory.initElements(driver, CreateNewCustomer.class);
	}
	
	
	@BeforeMethod
	public void configBeforeMtd(){
		String userNAme = Constants.userName;
		String password = Constants.password;
		loginPage.loginToAPP(userNAme, password);
	}
	
	@Test
	public void createCustomerTest()throws EncryptedDocumentException, InvalidFormatException, IOException{
		String customerNAme = eLib.getExcelData("Sheet1", 1, 2);
		//step2 : navigate to create Customer Page
		timePage.navigateToTaskPage();
		openTask.navigateToProjectAndCustomnerPage();
		//step 3 : create Customer
		actPage.navigateToCustomerPage();
		createCustPage.createCustomer(customerNAme);
		//step 4 : navigate to Customer details Page
		actPage.nvigateToCustMerDeatilsPage(customerNAme);
		//step 5 : verify Customer details
		EditCustomerInfo edit = PageFactory.initElements(driver, EditCustomerInfo.class);
		String actualCustomer = edit.getCustomerNameInfo().getText();
		Assert.assertEquals(actualCustomer, customerNAme,"customerName is not verified==FAIL");
		
	}
	
	
	@Test
	public void modifyCustomerTest() throws EncryptedDocumentException, InvalidFormatException, IOException{
		String customerNAme = eLib.getExcelData("Sheet1", 2, 2);
		String[] customerNameArr = customerNAme.split(";");
		//step2 : navigate to create Customer Page
				timePage.navigateToTaskPage();
				openTask.navigateToProjectAndCustomnerPage();
				//step 3 : create Customer
				actPage.navigateToCustomerPage();
				createCustPage.createCustomer(customerNameArr[0]);
				//step 4 : navigate to Customer details Page
				actPage.nvigateToCustMerDeatilsPage(customerNameArr[0]);
				//step 5 : modify & verify Customer details
				EditCustomerInfo edit = PageFactory.initElements(driver, EditCustomerInfo.class);
				String actualCustomer = edit.getCustomerNameInfo().getText();
				Assert.assertEquals(actualCustomer, customerNameArr[0],"customerName is not verified==FAIL");
				
	}

	@AfterMethod
	public void configAfterMtd(){
		comPage.logOut();
	}

	@AfterClass
	public void configAfterClass(){
		driver.quit();
	}






}
