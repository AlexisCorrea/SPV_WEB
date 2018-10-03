package com.accenture.web.Acciones;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;

import com.accenture.web.Utilidades.*;
import com.accenture.TestFramework2.RunEvent;

public class LogoutAcciones {
	public RunEvent<?> runevent;

	public static String 
	user
	,pss;
	public String[] argumentosAutenticacionMovil = new String[4];
	public XSSFSheet sheet;
	String testtype;
	
	public void setUp() throws InterruptedException, IOException {
		System.out.println("Set Up");

		if(runevent == null) {
			FirstsetUp();
		}

		String port =System.getProperty("port");
		if ((port==null)||(port.equals(""))) {
			port= "4723"  ;
		}
		String url =System.getProperty("url");
		if ((port==null)||(port.equals(""))) {
			url= ""  ;
		}
		String ip =System.getProperty("port");
		if ((ip==null)||(ip.equals(""))) {
			ip= "0.0.0.0"  ;
		}
		String pack =System.getProperty("pack");
		if ((pack==null)||(pack.equals(""))) {
			//		 pack= "com.banistmo.ca.apr.app.personas"  ;
			pack= "src/resources/drivers/chromedriver"  ;
		}
		String act =System.getProperty("act");
		if ((act==null)||(act.equals(""))) {
			//		 act= "com.banistmo.ca.apr.app.personas.MainActivity"  ;
			act= "Report"  ;
		}

		// com.banistmo.ca.apr.app.personas/com.banistmo.ca.apr.app.personas.MainActivity}

		runevent.setIp(ip);
		runevent.setPort(port);
		sheet = runevent.leerExcel(System.getProperty("user.dir") + "/Data/DataDriveLogout.xlsx",0);
		runevent.initDriver(pack, act, 10);
		runevent.setCapturar(true);
		//	driver = runevent.getDriver();
		Thread.sleep(2000); // tiempo de espera por que la aplicacion demora demaciado en iniciar 

		// verificar si el app es hybrida para implementar esta linea de codigo 
		if (testtype.contains("Appium")||testtype.contains("AWS")) {
			runevent.ingresarAlWebview("Ionic App");
			Thread.sleep(6000);
		}else {
			runevent.gotoUrl("https://d3c7mdofqu33va.cloudfront.net/login");
		}
	}
	
	public void FirstsetUp() {
		System.out.println("First SetUp");
		try {


			testtype =System.getProperty("testtype");
			if ((testtype==null)||(testtype.equals(""))) {
				//			 testtype= "AWS"  ;
				testtype= "SeleniumChrome";
			}
			runevent = Utilidades.setDriverType(testtype);
			runevent.setupReportTest("Logout");
			System.out.println("First SetUp Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void validarmensajeerror(String message) throws Exception {
		Thread.sleep(1000);
		System.out.println("Validar Error ");
		//	runevent.CompararTexto((By.id("msgError")), megError);
		runevent.CompararTexto((By.className("message")), message);
	}



	//@AfterMethod(alwaysRun = true)
	//@AfterTest(alwaysRun = true)
	//metodo para cerrar ventanas
	public void tearDown(){

		try {
			runevent.closeDriver();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void executeCommand(String command) {
		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
		} catch (Exception e) {
			// Implementing
		}
	} 




	// metodo que ha de ser prticular segun la HU , y la longitud de datos que esta necesite 
	public int findExpectativa(String expectativa) throws Exception {
		for (int i = 1; i<=sheet.getLastRowNum(); i++) {
			argumentosAutenticacionMovil = runevent.leerFilaExcel(i, argumentosAutenticacionMovil.length, sheet);
			System.out.println("expectativa = "+expectativa+"Found = "+argumentosAutenticacionMovil[3]);
			if(argumentosAutenticacionMovil[3].equals(expectativa)) {
				user =argumentosAutenticacionMovil[0];
				pss = argumentosAutenticacionMovil[1];
				return i;
			}
		}

		throw	new Exception("Expectativa no encontrada");	
	}

}
