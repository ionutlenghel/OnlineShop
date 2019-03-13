package onlineShop;

import org.testng.annotations.DataProvider;

public class dataChk {
	
	@DataProvider(name="dataCheckout")
    public Object [][] checkoutData() {
        Object[][] obj = new Object[1][10];
        
            obj[0][0]="email@email.com";
            obj[0][1]="john";
            obj[0][2]="carter";
            obj[0][3]="6505488989";
            obj[0][4]="913 oakes";
            obj[0][5]="ln";
            obj[0][6]="palo alto";
            obj[0][7]="United States";
            obj[0][8]="California";
            obj[0][9]="94303";
            
        return obj;
    }
}
