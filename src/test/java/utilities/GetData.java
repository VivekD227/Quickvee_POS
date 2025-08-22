package utilities;

import org.testng.annotations.DataProvider;

public class GetData {

	@DataProvider(name = "loginBlankData")
	public static Object[][] blankDataLogin(){
		return new Object[][] {
				{"", "", ""},
				{"chain", "", ""},
				{"", "vivek.dubey521@gmail.com",""},
				{"", "", "Vivek@123"}
		};
	};
	
	@DataProvider(name = "invalidEmailData")
	public static Object[][] invalidEmailData(){
		return new Object[][] {
			{"chain", "vivek.com", "Vivek@123"},
			{"chain", "vivek@gmail", "Vivek@123"},
			{"chain", "vivek", "Vivek@123"}
		};
		};
		
	@DataProvider(name = "invalidMerchantDetails")
		public static Object[][] merchantDetails(){
			return new Object[][] {
				{"chain", "vivek.dubey521@gmail.com","123"},
				{"chaining", "vivek.dubey521@gmail.com", "Vivek@123"},
				{"chain", "vivek@yahoo.com", "Vivek@123"}
		};
	};
	
	@DataProvider(name = "validDataLogin")
		public static Object[][] validMerchant(){
			return new Object[][] {
				{"chain", "vivek.dubey521@gmail.com", "Vivek@123"}
			};
	};
	
}
