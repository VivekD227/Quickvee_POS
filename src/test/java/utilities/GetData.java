package utilities;

import org.testng.annotations.DataProvider;

public class GetData {

	@DataProvider(name = "loginBlankData")
	public static Object[][] blankDataLogin(){
		return new Object[][] {
				{" ", " ", " "},
				{"chain", " ", " "},
				{" ", "vivek.dubey521@gmail.com"," "},
				{" ", " ", "Vivek@123"}
		};
	};
}
