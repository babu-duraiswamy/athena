package Utilities;

public class Common {

	public static void ShortWait() throws InterruptedException {
		Thread.sleep(2000);
	}
	
	public static void MediumWait() throws InterruptedException {
		Thread.sleep(5000);
	}
	
	public static void LongWait() throws InterruptedException {
		Thread.sleep(10000);
	}
	
	public String CheckCurrentPage() {
	return(BrowserDriver.driver.getCurrentUrl());		
	}

}
