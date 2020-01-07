package ecomm_TestUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class configReader {
	
Properties p;	
	
public configReader() {

try {	
	
String str ="E:\\SeleniumP\\Guru99_Ecommerce_task\\configuration\\config.properties";	

FileInputStream fis = new FileInputStream(str);

p = new Properties();

p.load(fis);

}

catch(Exception e) {
	
System.out.println(" This is error getting triggered at configuration class  "+e.getMessage());
		
}

}

public String  getChromePath(){
	
String chrome_path = p.getProperty("chromePath");	
	
return chrome_path;
	
	}

public String getBaseURL() {

String appurl = p.getProperty("BaseUrl");

return appurl;
	
}

public String getEmailId() {
	
String emailid = p.getProperty("username");

return emailid;

}

public String getPassword() {
	
String password = p.getProperty("password");

return password;
}

public Integer timeDuration() {
	
 String timeout = p.getProperty("ITO");
 
 return Integer.parseInt(timeout);
		 
}

public String Address() {

String add = p.getProperty("address");

return add;
	
}

public String City() {
	
	String cty = p.getProperty("city");
	
	return cty;
	
}

public String State() {
	
	String stte = p.getProperty("state");
	
	return stte;
	
}

public String zipcode() {
	
	String zip = p.getProperty("pincode");
	
	return zip;
	
}

public String country() {
	
	String coun = p.getProperty("country");
	
	return coun;
	
}

public String ContactNumber() {
	
	String num = p.getProperty("phonenumber");
	
	return num;
	
}
}
