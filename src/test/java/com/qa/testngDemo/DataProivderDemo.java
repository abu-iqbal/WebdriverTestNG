package com.qa.testngDemo;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataProivderDemo extends BaseTest{

    String envRootDir = System.getProperty("user.dir");

     @BeforeClass
    public void clkSignIn()
    {
        driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
    }



    @Test(dataProvider="empLogin")
    public void verfiyLoginCredentials(String username, String password)
    {
        System.out.println("the username is :="+username);
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys(username);
        System.out.println("the password is :="+password);
        driver.findElement(By.xpath("//*[@id='passwd']")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id='SubmitLogin']")).click();
    }

    @DataProvider(name="empLogin")
    public Object[][] loginData() {
        Object[][] arrayObject = getExcelData("./TestData/LoginPage.xls","Sheet1");

        return arrayObject;
    }

    public String[][] getExcelData(String fileName, String sheetName) {
        String[][] arrayExcelData = null;
        try {
            FileInputStream fs = new FileInputStream(fileName);
            Workbook wb = Workbook.getWorkbook(fs);
            Sheet sh = wb.getSheet(sheetName);

            int totalNoOfCols = sh.getColumns();

            System.out.println("Total number of columns :="+totalNoOfCols);
            int totalNoOfRows = sh.getRows();

            System.out.println("Total number of rows :="+totalNoOfRows);

            arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];

            for (int i= 1 ; i < totalNoOfRows; i++) {

                for (int j=0; j < totalNoOfCols; j++) {
                    arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        return arrayExcelData;
    }

}
