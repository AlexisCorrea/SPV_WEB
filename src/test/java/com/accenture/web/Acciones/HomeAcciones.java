package com.accenture.web.Acciones;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.accenture.TestFramework2.RunEvent;
import com.accenture.web.Utilidades.*;

public class HomeAcciones {
	public RunEvent<?> runevent;

	public static String 
	user
	,pss,
	clienteName; 
	public String[] argumentosAutenticacionMovil = new String[4];
	public XSSFSheet sheet;

	public String testtype;
	
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
			//			 pack= "com.banistmo.ca.apr.app.personas"  ;
//			pack= "src/resources/drivers/chromedriver"  ;
			pack = Utilidades.GetDefaultDriverDir(testtype);
		}
		String act =System.getProperty("act");
		if ((act==null)||(act.equals(""))) {
			//			 act= "com.banistmo.ca.apr.app.personas.MainActivity"  ;
			act= "Report"  ;
		}

		// com.banistmo.ca.apr.app.personas/com.banistmo.ca.apr.app.personas.MainActivity}

		runevent.setIp(ip);
		runevent.setPort(port);
		sheet = runevent.leerExcel(System.getProperty("user.dir") + "/Data/DataDriveAutenticacionMovil.xlsx",0);
		runevent.initDriver(pack, act, 10);
		runevent.setCapturar(true);
		//		driver = runevent.getDriver();
		Thread.sleep(2000); // tiempo de espera por que la aplicacion demora demaciado en iniciar 

		// verificar si el app es hybrida para implementar esta linea de codigo 
		if (testtype.contains("Appium")||testtype.contains("AWS")) {
			runevent.ingresarAlWebview("Ionic App");
			Thread.sleep(6000);
		}else {
			runevent.gotoUrl("https://d3c7mdofqu33va.cloudfront.net/login");
//			runevent.gotoUrl("https://d3qacmft9our92.cloudfront.net/login");
		} 
	}
	
	public void FirstsetUp() {
		System.out.println("First SetUp");
		try {


			testtype =System.getProperty("testtype");
			if ((testtype==null)||(testtype.equals(""))) {
				//				 testtype= "AWS"  ;
				testtype= "SeleniumChrome";
			}

			
			runevent = Utilidades.setDriverType(testtype);

			runevent.setupReportTest("consturccion del home");

			System.out.println("First SetUp Done");
		} catch (Exception e) {
			e.printStackTrace();
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


	public void validarElemento(By boton, String mensaje) throws Exception {
		WebElement button = (new WebDriverWait((WebDriver)runevent.getDriver(), 25)).until(ExpectedConditions.visibilityOfElementLocated(boton));
		runevent.indicarElemento(boton, mensaje);



	}
	public Double convertirDouble(By boton) throws Exception {
		
		String elemento = ((WebDriver)runevent.getDriver()).findElement(boton).getText();
		elemento=elemento.substring(1);
		elemento=elemento.replace(",", "");
		elemento=elemento.replace(".", "");
		Double saldoElemento =  Double.parseDouble(elemento);
		System.out.println(elemento);
		
		
        return saldoElemento;

	}

	public void validarElementoclick(By boton, String mensaje) throws Exception {
		WebElement element = (new WebDriverWait((WebDriver)runevent.getDriver(), 15)).until(ExpectedConditions.visibilityOfElementLocated(boton));
		runevent.indicarElemento(boton, mensaje);
		runevent.click(boton);
		


	}
	


	// metodo que ha de ser prticular segun la HU , y la longitud de datos que esta necesite 
	public int findExpectativa(String expectativa) throws Exception {
		for (int i = 1; i<=sheet.getLastRowNum(); i++) {
			argumentosAutenticacionMovil = runevent.leerFilaExcel(i, argumentosAutenticacionMovil.length, sheet);
			System.out.println("expectativa = "+expectativa+"Found = "+argumentosAutenticacionMovil[3]);
			if(argumentosAutenticacionMovil[3].equals(expectativa)) {
				user =argumentosAutenticacionMovil[0];
				pss = argumentosAutenticacionMovil[1];
				clienteName = argumentosAutenticacionMovil[4];
				return i;
			}
		}

		throw	new Exception("Expectativa no encontrada");	
	}

}
