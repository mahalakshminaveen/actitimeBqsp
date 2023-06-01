package com.actitime.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.actitime.generic.FileLib;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;

@Listeners(com.actitime.generic.ListenerImplementation.class)
public class CustomerModule extends BaseClass {
	@Test
	public void testcreateCustomer() throws EncryptedDocumentException, IOException, InterruptedException
	{   Reporter.log("Create Customer",true);
		FileLib f=new FileLib();
		String customerName = f.getExcelData("createCustomer", 1, 3);
		String custdes = f.getExcelData("createCustomer", 1, 4);
		HomePage h=new HomePage(driver);
		h.setTasksTab();
		TaskListPage t=new TaskListPage(driver);
		t.getAddNewBtn().click();
		t.getNewCustomerOption().click();
		t.getCustNameTbx().sendKeys(customerName);
		t.getCutomerDescriptionTbx().sendKeys(custdes);
		t.getSelectCustomerDD().click();
		t.getBigBangCompany().click();
		t.getCreateCustomerBtn().click();
		Thread.sleep(3000);
		String actualtext = t.getActualCustomerCreated().getText();
		Assert.assertEquals(customerName,actualtext );
		
		
	}
	

}
