package Transactions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import testapplication.baseClass;

public class Transaction_Base extends baseClass {



	public void main_Sub_menu_click(String mname, String Submenu ) throws InterruptedException, IOException {
		try {
			Thread.sleep(1000);        
			// String path1 = "/html/body/div[1]/div/div[2]/div[1]/ul/li" ;  
			//  String path2 = "[" ;
			// String path3 = "]/span" ;

			//wait until menu load
			driverwait(getElementByXpath("path1"));
			List<WebElement> element = getElementsByXpath(("path1"));


			int cnt =element.size();

			for(int i=1; i<=cnt; i++) {


				WebElement menele = getElementByXpath("path1","path2",i,"path3");

				ArrayList<String> list = new ArrayList<String>();
				for(WebElement eles : element) {
					list.add(eles.getText());

					for(String ss: list) {

						// System.out.println("array list "+ ss); // print items stored in array list;
					}
				}

				//LinkedList<String> list = new LinkedList<String>();

				String text = menele.getText();
				if(text.contentEquals(mname)){
					// System.out.println("manin menu ==>  "+text);
					//Move Element
					Actions actions = new Actions(driver);
					actions.moveToElement(menele).build().perform();
					//    String subpath1 = "/html/body/div[1]/div/div[2]/div[1]/ul/li["+i+"]/div/ul/li";
					//   String subpath2 = "[";
					//   String subpath3 = "]/span";
					//wait until Sub menu load

					driverwait(getElementByXpath("subpath1",i,"split1"));

					List<WebElement> submenuitem = getElementsByXpath("subpath1",i,"split1");

					int scnt = submenuitem.size();
					for(int j=1; j<=scnt ; j++ ) {

						WebElement subelem =  getElementByXpath("subpath1",i,"split1","subpath2",j,"subpath3");

						String submntxt = subelem.getText();

						if(submntxt.contentEquals(Submenu)) {
							System.out.println(text+" ----->  "+submntxt);
							subelem.click();
							//subelem.clear();
							Thread.sleep(1500);
							test.log(Status.PASS,getPagetitle());
							extent.createTest(getPagetitle());
							break;

						}

					}      		    

				} 



			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			test.log(Status.FAIL, e.getMessage());
			getScreenshot();

			Alert alert = driver.switchTo().alert();
			alert.accept();

		}


	}


	public  void Main_Sub_Sub_menu_click(String mastermenu,String Smenu1,String Smenu2) throws InterruptedException, IOException {

		try {
			Thread.sleep(500);
			// String path1 = "/html/body/div[1]/div/div[2]/div[1]/ul/li" ;  
			//  String path2 = "[" ;
			//  String path3 = "]" ;

			//wait until menu load
			driverwait(getElementByXpath("path1"));
			List<WebElement> element = getElementsByXpath(("path1"));


			int cnt =element.size();       
			for(int i=1; i<=cnt-1; i++ ) {

				WebElement menele = getElementByXpath("path1","path2",i,"path3");

				String text = menele.getText();
				//main menu
				if(text.contentEquals(mastermenu)) {


					// System.out.println("manin menu ==>  "+text);
					//Move Element
					Actions actions = new Actions(driver);
					actions.moveToElement(menele).build().perform();

					//  String subpath1 = "/html/body/div[1]/div/div[2]/div[1]/ul/li["+i+"]/div/ul/li";
					//  String subpath2 = "[";
					//  String subpath3 = "]/span";
					//wait until Sub menu load

					driverwait(getElementByXpath("SSpath1"));  

					//Submenu list
					List<WebElement> submenuitem = getElementsByXpath("subpath1",i,"split1");

					int scnt = submenuitem.size();


					for(int j=1; j<=scnt ; j++ ) {



						WebElement subelem =  getElementByXpath("subpath1",i,"split1","subpath2",j,"subpath3");
						String submntxt = subelem.getText();

						if(submntxt.contentEquals(Smenu1)) {

							//  actions.moveToElement(menele).build().perform();
							actions.moveToElement(subelem).perform();

							// wait for the menu to display
							driverwait(getElementByXpath("SSSpath1",i,"SSSpath2",j,"SSSpath3"));
							// Thread.sleep(1000);

							submenuClick(Smenu2,i,j);
							System.out.println(" page  ----->  "+getPagetitle());
							// test.log(Status.PASS,"2nd submenu clicked"+getPagetitle());
							break;



						} else {
							//  test.log(Status.FAIL,getPagetitle()+ " Mismatch found ");

						}


						// Thread.sleep(1000);


					}


				} 




			}
		} catch (InterruptedException e) {

			Alert alert = driver.switchTo().alert();
			alert.accept();
			test.log(Status.FAIL, "Test failed"+getPagetitle());
			getScreenshot();


			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static void submenuClick(String mname ,int i,int j) throws InterruptedException, IOException {


		Actions actions = new Actions(driver);
		//actions.moveToElement(menele).build().perform(); 

		//   WebElement ele = getElementByClass("k-icon k-i-arrow-e");	      
		//   actions.moveToElement(ele).build().perform();  

		//  String path1 = "/html/body/div[1]/div/div[2]/div[1]/ul/li["+i+"]/div/ul/li["+j+"]/div/ul/li";
		// String path2 = "[";
		//  String path3 = "]/span";

		List<WebElement> list = getElementsByXpath("SSSpath1",i,"SSSpath2",j,"SSSpath3");
		WebElement ele = getElementByXpath("SSSpath1",i,"SSSpath2",j,"SSSpath3");
		actions.moveToElement(ele).build().perform();
		int listcnt = list.size();

		for(int i1=1; i1<=listcnt; i1++) {

			WebElement ele1 = getElementByXpath("SSSpath1",i,"SSSpath2",j,"SSSpath3","SSSpath4",i1,"SSSpath5");
			String txt = ele1.getText();


			try {
				if(txt.contentEquals(mname)) {
					//WebElement element = getElementByXpath(path1+path2+i1+path3);
					//actions.moveToElement(element).doubleClick();
					ele1.click();
					//  getElementByXpath("SSSpath1"+i+"SSSpath2"+j+"SSSpath3"+"SSSpath4"+i1+"SSSpath5").click();

					//  list.get(i1).click();
					Thread.sleep(1000);
					asserts.assertEquals(mname, getPagetitle(), "Comparison");
					System.out.println("Clicked menu page ->"+getPagetitle());
					logger.info("submenu clicked and navigated to page  -> "+getPagetitle()); 
					// test.log(Status.PASS, getPagetitle());

					break;

				} else {

				}


			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				test.log(Status.FAIL, e.getMessage());

				Alert alert = driver.switchTo().alert();
				alert.accept();
				test.log(Status.FAIL, "Test failed"+getPagetitle());
				getScreenshot();

			}


		}


	}



	public Collection<WebElement> listboxtext(String select) throws InterruptedException{
		Thread.sleep(1000);
		getElementByXpath("outletdropdown").click();

		try {
			Collection<WebElement> coll = getElementByCssSelectorList("outletlist1");
			ArrayList<String> list = new ArrayList<String>();
			for(WebElement ele: coll) {

				String txt = ele.getText();
				list.add(txt);
				System.out.println("outlect ->"+txt);

				if(txt.startsWith(select)){
					ele.click();
					System.out.println("elecment selected "+txt);
					test.log(Status.INFO, "outlet is selected ->"+txt);
					break;

				}

			}
			System.out.println("Number value ->"+list.size());

		} catch (Exception e) {

			e.printStackTrace();
			test.log(Status.INFO, "outlet not selected ->"+e.getMessage());
		}

		return null ;
	}


	public static void statementNo(String no) {
		getElementByXpath("statementdropdown").click();

		try {
			List<WebElement> stateno = getElementByCssSelectorList("statementlist");
			int scount = stateno.size();
			for(int i=0; i<=scount; i++) {
				String txt = stateno.get(i).getText();
				if(txt.contentEquals(no)) {

					stateno.get(i).click();
					System.out.println("clicked at  "+txt );
					test.log(Status.INFO, "Statement Number selected ->"+txt);
					break;
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			test.log(Status.FAIL, "Statement Number not selected ->"+e.getMessage());
			e.printStackTrace();
		}
	}



	public static void TransactionType(String name) throws InterruptedException {
		getElementByCssSelector("TransactiontypeDropdown").click();
          Thread.sleep(1000);  
		try {
		
			List<WebElement> transaction = getElementByCssSelectorList("Transactionlist");
			int scount = transaction.size();
			for(int i=0; i<=scount; i++) {

				String txt = transaction.get(i).getText();
				if(txt.contentEquals(name)) {
                       
					transaction.get(i).click();
					System.out.println("clicked at  "+txt );
					test.log(Status.INFO, "Transaction Type Selected -> "+txt);
					break;
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			test.log(Status.INFO, "Transaction Type not Selected -> "+e.getMessage());
		}

	}
	
	
	
	public static void paymentType(String Cash) throws InterruptedException {
		
		getElementByCssSelector("PaymentTypeDropdown").click();
	      Thread.sleep(1000);  
		try {
			List<WebElement> payemnt = getElementByCssSelectorList("PaymentTypelist");
			int scount = payemnt.size();
			for(int i=0; i<=scount; i++) {

				String txt = payemnt.get(i).getText();
				if(txt.contentEquals(Cash)) {

					payemnt.get(i).click();
					System.out.println("clicked at  "+txt );
					test.log(Status.INFO, "Transaction Type Selected -> "+txt);
					break;
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			test.log(Status.INFO, "Transaction Type not Selected -> "+e.getMessage());
		}
		
		
	}


}






