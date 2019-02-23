package com.crm.qa.testdata;

		import java.io.IOException;
		import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
		import org.testng.annotations.DataProvider;
		import org.testng.annotations.Test;
		import com.crm.qa.util.TestUtil;
	
	
	
		public class DataProviderDemo {
	
			private String filePath = "C:\\Users\\shiva\\Desktop\\TestData1.xlsx";
		    private String sheetName = "Contacts";

		    @DataProvider(name="Janaki")
		    public Object[][] readExcel() throws InvalidFormatException, IOException {
		        return TestUtil.excelReading(sheetName) ;
		    }
		    
		    @Test(dataProvider = "Janaki")
		    
	
		   public void read(String Title, String Firstname,String lastname,String Company) {
		  	 System.out.println(Title);
		    
		    }
	
		   
	
		}
