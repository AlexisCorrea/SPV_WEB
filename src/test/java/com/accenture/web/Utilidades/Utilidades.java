package com.accenture.web.Utilidades;

import java.util.Locale;

import com.accenture.TestFramework2.AWSDeviceFarm;
import com.accenture.TestFramework2.AppiumLocal;
import com.accenture.TestFramework2.RunEvent;
import com.accenture.TestFramework2.SeleniumChrome;
import com.accenture.TestFramework2.SeleniumFirefox;
import com.accenture.TestFramework2.SeleniumIExplorer;
import com.accenture.TestFramework2.SeleniumSafari;

public class Utilidades {
	public static RunEvent<?> setDriverType(String type) {
		switch (type) {
		case "AppiumLocal":
			return new AppiumLocal(); 
		case "SeleniumChrome":
			return new SeleniumChrome(); 
		case "SeleniumSafari":
			 return new SeleniumSafari(); 
		case "SeleniumFirefox":
			return new SeleniumFirefox(); 
		case "SeleniumIExplorer":
			return new SeleniumIExplorer(); 
		case "AWS":
			return new AWSDeviceFarm(); 
		default:
			return new SeleniumChrome(); 
		}
	}
	public static String GetDefaultDriverDir(String type) {
		
			    
			    
		
		switch (type) {
		case "AppiumLocal":
//			return new AppiumLocal(); 
		case "SeleniumChrome":
			return SetPathOS("chromedriver");
			
		case "SeleniumSafari":
			 return ""; // no se necesita es un plugin en el navegador 
		case "SeleniumFirefox":
			return SetPathOS("geckodriver");
//			return new SeleniumFirefox(); 
		case "SeleniumIExplorer":
			return SetPathOS("IEDriverServer"); 
		case "Opera":
			return SetPathOS("operadriver");
		case "AWS":
//			return new AWSDeviceFarm(); 
		default:
//			return new SeleniumChrome(); 
		}
		return "";
	}
	public static String SetPathOS(String driver) {
		String separador ="/";
	      String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
	      String path="";
	      if (OS.indexOf("win") >= 0) {
		        separador ="\\";
		      }
	      
	      
	      // verificacion del os 
	      if ((OS.indexOf("mac") >= 0) || (OS.indexOf("darwin") >= 0)) {
	    	  path=""+System.getProperty("user.dir")+separador+"Drivers"+separador+driver;
	      } else if (OS.indexOf("win") >= 0) {
	    	  path=""+System.getProperty("user.dir")+separador+"Drivers"+separador+driver+".exe";
	      } else if (OS.indexOf("nux") >= 0) {
	    	  path=""+System.getProperty("user.dir")+separador+"Drivers"+separador+"Linux"+separador+driver;
	      } 
	        
	      return path;
	}
}


