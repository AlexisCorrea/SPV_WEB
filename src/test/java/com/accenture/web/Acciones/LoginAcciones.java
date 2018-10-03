package com.accenture.web.Acciones;

import java.io.IOException;
import java.net.URL;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.accenture.TestFramework2.RunEvent;
import com.accenture.web.Utilidades.*;

public class LoginAcciones {
	public RunEvent<?> runevent;
	public static String user, pss;
	public String[] argumentosAutenticacionMovil = new String[4];
	public XSSFSheet sheet;
	public String testtype;

	public void setUp() throws InterruptedException, IOException {

		System.out.println("Set Up");

		if (runevent == null) {
			FirstsetUp();
		}

		String port = System.getProperty("port");
		if ((port == null) || (port.equals(""))) {
			port = "4723";
		}
		String url = System.getProperty("url");
		if ((port == null) || (port.equals(""))) {
			url = "";
		}
		String ip = System.getProperty("port");
		if ((ip == null) || (ip.equals(""))) {
			ip = "0.0.0.0";
		}
		String pack = System.getProperty("pack");
		if ((pack == null) || (pack.equals(""))) {
//			 pack= "com.banistmo.ca.apr.app.personas"  ;
//			 pack= "C:\\Users\\d.diaz.alvarez\\Downloads\\chromedriver_win32\\chromedriver.exe"  ;
			pack = Utilidades.GetDefaultDriverDir(testtype);
		}
		String act = System.getProperty("act");
		if ((act == null) || (act.equals(""))) {
//			 act= "com.banistmo.ca.apr.app.personas.MainActivity"  ;
			act = "Report";
		}

		// com.banistmo.ca.apr.app.personas/com.banistmo.ca.apr.app.personas.MainActivity}

		runevent.setIp(ip);
		runevent.setPort(port);
		sheet = runevent.leerExcel(System.getProperty("user.dir") + "/Data/DataDriveAutenticacionMovil.xlsx", 0);
		runevent.initDriver(pack, act, 10);
		runevent.setCapturar(true);
//		driver = runevent.getDriver();
		Thread.sleep(2000); // tiempo de espera por que la aplicacion demora demaciado en iniciar

		// verificar si el app es hybrida para implementar esta linea de codigo
		if (testtype.contains("Appium") || testtype.contains("AWS")) {
			runevent.ingresarAlWebview("Ionic App");
			Thread.sleep(6000);
		} else {
//			runevent.gotoUrl("https://d3qacmft9our92.cloudfront.net/login");
			runevent.gotoUrl("https://d3c7mdofqu33va.cloudfront.net/login");
			
		}
	}

	public void FirstsetUp() {
		System.out.println("First SetUp");
		try {

			testtype = System.getProperty("testtype");
			if ((testtype == null) || (testtype.equals(""))) {
//				 testtype= "AWS"  ;
				testtype = "SeleniumChrome";
			}

			runevent = Utilidades.setDriverType(testtype);

			runevent.setupReportTest("Login");

			System.out.println("First SetUp Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void loginExitoso(String usuario ,String passwrd,RunEvent runer) throws Exception {
		
		runevent = runer;
		runevent.createTest("loginExitoso");
		Thread.sleep(100);
		ingresaruser(usuario);
		clickContinuar();
		ingresarPss(passwrd);
		clickIngresar();
		
		
	}

	public void validarmensajeerror(String message) throws Exception {
		Thread.sleep(1000);
		System.out.println("Validar Error ");
		runevent.CompararTexto((By.cssSelector("div.message > p")), message);


	}
	public void validarmensajeerrorUsuario(String message) throws Exception {
		Thread.sleep(1000);
		System.out.println("Validar Error ");
		runevent.CompararTexto((By.cssSelector("div.error > div.content")), message);
	}

	public void clickIngresar() {

//		runevent.clickWait(By.id("btn_login"));
		runevent.clickWait(((WebDriver) runevent.getDriver()).findElements(By.id("btn_login")).get(1));

	}

	public void ingresaruser(String user) {
		runevent.clickWait(By.id("inp_user"));
		runevent.sendKeys(
				((WebDriver) runevent.getDriver()).findElement(By.id("inp_user")).findElement(By.cssSelector("input")),
				user);
//		runevent.sendKeys(By.id("inp_user"), user);
//		runevent.clickWait(By.id("inp_user"));

	}

	public void clickContinuar() throws IOException {

//		runevent.clickCentral(By.id("btn_continue"));
		runevent.clickWait(((WebDriver) runevent.getDriver()).findElements(By.id("btn_continue")).get(1));
	}

	public void clickCancelar() {
//		runevent.clickWait(((WebDriver)runevent.getDriver()).findElements(By.name("marca-persona")).get(1));
		runevent.clickWait(By.id("btn_cancel"));
//		runevent.clickWait(((WebDriver)runevent.getDriver()).findElements(By.id("btn_continue")).get(1));
	}

	public void ingresarPss(String pssword) {
		runevent.clickWait(By.id("inp_password"));
		runevent.sendKeys(((WebDriver) runevent.getDriver()).findElement(By.id("inp_password"))
				.findElement(By.cssSelector("input")), pssword);
//		runevent.sendKeys(By.id("inp_password"), pssword);
	}

	public void validaringreso() throws Exception {
		// se debe cambiar
		runevent.click(By.id("btn_logout"));
		if (!runevent.isElementPresent(By.id("btn_logout"))) {
			throw new Exception("Not loged");
		}
//		runevent.clickWait(By.className("back-button"));
//		runevent.clickWait(((WebDriver)runevent.getDriver()).findElements(By.id("btn_continue")).get(1));
	}

	public void ingresarRecordandouser() throws IOException {

		System.out.println("Set Up");

		String port = System.getProperty("port");
		if ((port == null) || (port.equals(""))) {
			port = "4723";
		}
		String url = System.getProperty("url");
		if ((port == null) || (port.equals(""))) {
			url = "";
		}
		String ip = System.getProperty("port");
		if ((ip == null) || (ip.equals(""))) {
			ip = "0.0.0.0";
		}
		String pack = System.getProperty("pack");
		if ((pack == null) || (pack.equals(""))) {
			pack = "com.banistmo.ca.apr.app.personas";
		}
		String act = System.getProperty("act");
		if ((act == null) || (act.equals(""))) {
			act = "com.banistmo.ca.apr.app.personas.MainActivity";
		}
		testtype = System.getProperty("testtype");
		if ((testtype == null) || (testtype.equals(""))) {
			testtype = "AWS";
		}
		// com.banistmo.ca.apr.app.personas/com.banistmo.ca.apr.app.personas.MainActivity}

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", "Android"); // Nombre del sistema operativo

		capabilities.setCapability("appPackage", pack);

		capabilities.setCapability("appActivity", act);

		capabilities.setCapability("noReset", "true");

		runevent = Utilidades.setDriverType(testtype);
		runevent.initDriver(capabilities, new URL("http://127.0.0.1:4723/wd/hub"), 90);
		runevent.setIp(ip);
		runevent.setPort(port);
		sheet = runevent.leerExcel(System.getProperty("user.dir") + "/Data/DataDriveAutenticacionMovil.xlsx", 0);
//		runevent.initDriver(pack, act, 10);
		runevent.setCapturar(false);
	}

	public void clickShowPasword() throws Exception {
		// TODO Auto-generated method stub
		String DepextooEinv = ((WebDriver)runevent.getDriver()).findElement(By.id("inp_user")).getText();
		System.out.println("|"+DepextooEinv+"|");

		runevent.CompararTexto(By.id("inp_user"), "Enter user");
		

	}

	public void validarTextoCaracteres() throws Exception {
		runevent.CompararTexto(By.id("inp_user"), "");
	}

	public void clickToolTipuser() {
		
		runevent.click(By.className("tooltip"));
	}

	public void clickToolTippassword() {

		runevent.click(By.className("tooltip"));
	}

	public void validarmensajetolltipusuario(String message) throws Exception {
//		Thread.sleep(1000);
//		System.out.println("Validar Error");
//		runevent.CompararTexto(By.className("tooltip"), message);
		runevent.CompararTextodeAtributo(By.className("tooltip"), "You define it when registering in the People Virtual Branch or Banistmo APP, it is personal and non-transferable ", "message");
		

	}

	public void validarmensajetolltippassword(String message) throws Exception {
//		Thread.sleep(1000);
//		System.out.println("Validar Error");
//		runevent.CompararTexto(By.className("tooltip"), message);
		runevent.CompararTextodeAtributo(By.className("tooltip"), "The password was defined by you at the time of registration to the Personal Branch or Banistmo APP, is personal and non-transferable ", "message");
		

	}

	// metodo que ha de ser prticular segun la HU , y la longitud de datos que esta
	// necesite
	public int findExpectativa(String expectativa) throws Exception {
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			argumentosAutenticacionMovil = runevent.leerFilaExcel(i, argumentosAutenticacionMovil.length, sheet);
			System.out.println("expectativa = " + expectativa + "Found = " + argumentosAutenticacionMovil[3]);
			if (argumentosAutenticacionMovil[3].equals(expectativa)) {
				user = argumentosAutenticacionMovil[0];
				pss = argumentosAutenticacionMovil[1];
				return i;
			}
		}

		throw new Exception("Expectativa no encontrada");
	}
}
