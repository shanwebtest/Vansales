package test;

import java.io.IOException;



public class utility {
  
	
	public static boolean WriteResultUtility(Xls_Reader1 xls, String sheetName, String ColName, int rowNum, String Result) throws IOException{			
		return xls.WriteResult(sheetName, rowNum, ColName, Result);		 	
	}
	
	
	
}
