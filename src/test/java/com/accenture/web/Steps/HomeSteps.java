package com.accenture.web.Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.accenture.web.Acciones.HomeAcciones;
import com.accenture.web.Acciones.LoginAcciones;
import com.accenture.web.Utilidades.*;

public class HomeSteps {
	static HomeAcciones acciones= new HomeAcciones();
	static LoginAcciones login = new LoginAcciones();
	String DepoEinv, creditLoan;
	Double saldoCreditos,saldoPrestamos,saldodepo,saldoDepoInv,totalCUentasDepo,_saldodepo,saldoInv;
	
	
	@Given("^el usuario ve la pantalla principal de la app de banistmo y procede a realizar el inicio de sesion$")
	public void el_usuario_ve_la_pantalla_principal_de_la_app_de_banistmo_y_procede_a_realizar_el_inicio_de_sesion()
			throws Exception {
		acciones.setUp();
		login.loginExitoso("osorioJuan", "12345678", acciones.runevent);

	}

	@When("^el usuario busca el encabezado$")
	public void el_usuario_busca_el_encabezado() throws Exception {
		acciones.runevent.createTest("ValidarEncabezado");
		acciones.validarElemento(By.id("btn_logout"), "LogOut");
		System.out.println("encontre logout");
		acciones.validarElemento(By.id("lbl_HeaderHelp"), "Notificaciones");
		System.out.println("encontre notificaciones");
		acciones.validarElemento(By.id("lbl_HeaderSelf-management"), "Autogestion");
		System.out.println("autogestion");
		acciones.validarElemento(By.id("lbl_HeaderNotification"), "help");
		// System.out.println("help");
		acciones.runevent.CompararTexto(By.className("welcome-text"), " Welcome to the Virtual Branch People ");// pendienre
																												// id

	}

	@Then("^el usuario deberia poder visualizar el encabezado en el home$")
	public void el_usuario_deberia_poder_visualizar_el_encabezado_en_el_home() throws Exception {

		acciones.runevent.indicarElemento(By.className("date"), "ultima fecha corrrecta");
		tearDown();
	}

	@When("^el usuario busca la opcion de resumen de productos$")
	public void el_usuario_busca_la_opcion_de_resumen_de_productos() throws Exception {
		acciones.runevent.createTest("ResumenDeProductos");
		acciones.validarElemento(By.id("lbl_DepoInvTitle"), "depositos e inversiones");// pendiente id
		System.out.println("depositos monto label");
		DepoEinv = ((WebDriver) acciones.runevent.getDriver()).findElement(By.id("lbl_depInvTotalAmount")).getText();
		System.out.println("depositos monto" + DepoEinv);
		creditLoan = ((WebDriver) acciones.runevent.getDriver()).findElement(By.id("lbl_CreditPresTotalAmount"))
				.getText();
		System.out.println("credit loan" + creditLoan);
//		validarElementoclick(By.id("btn_hideSummary"), "resumen up");//pendiente id
		acciones.validarElementoclick(By.cssSelector("i#btn_hideSummary"), "resume up");

		System.out.println("esconder");
		Thread.sleep(5000);

	}

	@Then("^el usuario deberia poder visualizar informacion de resumen de producto$")
	public void el_usuario_deberia_poder_visualizar_informacion_de_resumen_de_producto() throws Exception {
		String depoinvresume = ((WebDriver) acciones.runevent.getDriver())
				.findElement(By.id("lbl_depInvTotalAmountResume")).getText();
		String creditoprestamoresume = ((WebDriver) acciones.runevent.getDriver())
				.findElement(By.id("lbl_CreditLoanTotalAmountResume")).getText();

		if (depoinvresume.contains(DepoEinv) && creditLoan.contains(creditoprestamoresume)) {

			acciones.validarElemento(By.id("lbl_CreditLoanTotalAmountResume"), "ready");
			acciones.validarElemento(By.id("lbl_depInvTotalAmountResume"), "ready");
		} else {
			acciones.runevent.indicarElementoFail(By.id("lbl_CreditLoanTotalAmountResume"),
					"no coincide devositos e inversiones");
			acciones.runevent.indicarElementoFail(By.id("lbl_depInvTotalAmountResume"),
					"no coincide devositos e inversiones");

		}
		tearDown();
	}

	@When("^el usuario busca la opcion de saldos generales Deposito de inversion$")
	public void el_usuario_busca_la_opcion_de_saldos_generales_Deposito_de_inversion() throws Exception {
		acciones.runevent.createTest("SaldosgeneralesDepInv");
		

		try { 

			acciones.validarElemento(By.id("lbl_DepoInvTitle"), "depositos e inversiones titulo ");//pendiente id
			String DepoEinv = ((WebDriver)acciones.runevent.getDriver()).findElement(By.id("lbl_depInvTotalAmount")).getText();
			DepoEinv=DepoEinv.substring(1);
			DepoEinv=DepoEinv.replace(",", "");
			DepoEinv=DepoEinv.replace(".", "");
			System.out.println("saldo"+DepoEinv);
			 saldoDepoInv =  Double.parseDouble(DepoEinv);
			System.out.println(saldoDepoInv);
			
			acciones.validarElemento(By.id("lbl_DepoBalanceValue"), "depositos");//pendiente id
            String cardDepositos = ((WebDriver)acciones.runevent.getDriver()).findElement(By.id("lbl_DepoBalanceValue")).getText();
			cardDepositos= cardDepositos.substring(1);
			cardDepositos=cardDepositos.replace(",", "");
			cardDepositos=cardDepositos.replace(".", "");
			System.out.println("saldo"+DepoEinv);
			 saldodepo =  Double.parseDouble(cardDepositos);
			System.out.println(cardDepositos);
			
			acciones.validarElemento(By.id("lbl_InvBalanceValue"), "inversiones");//pendiente id
            String cardinversiones= ((WebDriver)acciones.runevent.getDriver()).findElement(By.id("lbl_InvBalanceValue")).getText();
			cardinversiones=cardinversiones.substring(1);
			cardinversiones=cardinversiones.replace(",", "");
			cardinversiones=cardinversiones.replace(".", "");
			saldoInv =  Double.parseDouble(cardinversiones);
			
		
			
		} catch (Exception e) {
			acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
			throw e;
		}
		

		
	}

	@Then("^el usuario deberia poder visualizar informacion de Deposito e inversiones los cual deberian de coincidir con la opcion de resumen de productos$")
	public void el_usuario_deberia_poder_visualizar_informacion_de_Deposito_e_inversiones_los_cual_deberian_de_coincidir_con_la_opcion_de_resumen_de_productos()
			throws Exception {
		System.out.println(saldoInv);
		
		if((saldodepo+saldoInv)==saldoDepoInv) {
			System.out.println((saldodepo+saldoInv)+"=="+saldoDepoInv);
			acciones.validarElemento(By.id("lbl_depInvTotalAmount"), ((saldodepo+saldoInv)+"=="+saldoDepoInv));
		}
		tearDown();
	}

	@When("^el usuario busca la opcion de saldos generalesde Creditos prestamos$")
	public void el_usuario_busca_la_opcion_de_saldos_generalesde_Creditos_prestamos() throws Exception {
		acciones.runevent.createTest("saldosgeneralesCrediPrest");
		acciones.validarElemento(By.id("lbl_CreditPresTotalAmount"), "creditos y prestamos titulo ");// pendiente id
		String DepoEinv = ((WebDriver) acciones.runevent.getDriver()).findElement(By.id("lbl_CreditPresTotalAmount"))
				.getText();
		DepoEinv = DepoEinv.substring(1);
		DepoEinv = DepoEinv.replace(",", "");
		DepoEinv = DepoEinv.replace(".", "");
		System.out.println("saldo" + DepoEinv);
		 saldoDepoInv = Double.parseDouble(DepoEinv);
		System.out.println(saldoDepoInv);

		acciones.validarElemento(By.id("lbl_LoanBalanceValue"), "depositos");// pendiente id
		String cardPrestamos = ((WebDriver) acciones.runevent.getDriver()).findElement(By.id("lbl_LoanBalanceValue"))
				.getText();
		cardPrestamos = cardPrestamos.substring(1);
		cardPrestamos = cardPrestamos.replace(",", "");
		cardPrestamos = cardPrestamos.replace(".", "");
		System.out.println("saldo" + DepoEinv);
		 saldoPrestamos = Double.parseDouble(cardPrestamos);
		System.out.println(cardPrestamos);

		acciones.validarElemento(By.id("lbl_CreditsCardsBalanceValue"), "creditos");// pendiente id
		String cardCreditos = ((WebDriver) acciones.runevent.getDriver())
				.findElement(By.id("lbl_CreditsCardsBalanceValue")).getText();
		cardCreditos = cardCreditos.substring(1);
		cardCreditos = cardCreditos.replace(",", "");
		cardCreditos = cardCreditos.replace(".", "");
		saldoCreditos = Double.parseDouble(cardCreditos);
		System.out.println(saldoCreditos);

	

	}

	@Then("^el usuario deberia poder visualizar informacion de saldos generales de Creditos y prestamos los cuales deberia de coincidir con la opcion de resumen de productos$")
	public void el_usuario_deberia_poder_visualizar_informacion_de_saldos_generales_de_Creditos_y_prestamos_los_cuales_deberia_de_coincidir_con_la_opcion_de_resumen_de_productos()
			throws Exception {
		if ((saldoPrestamos + saldoCreditos) == saldoDepoInv) {
			System.out.println((saldoPrestamos + saldoCreditos) + "==" + saldoDepoInv);
			acciones.validarElemento(By.id("lbl_depInvTotalAmount"),
					((saldoPrestamos + saldoCreditos) + "==" + saldoDepoInv));
		}
		tearDown();
	}

	@When("^el usuario busca la opcion de tus productos$")
	public void el_usuario_busca_la_opcion_de_tus_productos() throws Exception {

		acciones.runevent.createTest("validarcontenedorTusProductos");
	}

	@Then("^el usuario deberia poder visualizar todas las opciones diferentes de sus productos$")
	public void el_usuario_deberia_poder_visualizar_todas_las_opciones_diferentes_de_sus_productos() throws Exception {
		try {
			acciones.validarElemento(By.className("categories-container"), "contenedor tus productos");// pendiente id
		} catch (Exception e) {
			acciones.runevent.indicarElementoFail(
					((WebDriver) acciones.runevent.driver).findElement(By.cssSelector("body")), "error " + e);
			throw e;
		}
		tearDown();
	}

	@When("^el usuario se dirige al menu y elige la opcion de trsnaferencias$")
	public void el_usuario_se_dirige_al_menu_y_elige_la_opcion_de_trsnaferencias() throws Exception {
		acciones.runevent.createTest("navegacionMenuTransaferencias");

		acciones.validarElemento(By.id("lbl_DepoInvTitle"), "depositos");
	}

	@Then("^el usuario deberia poder navegar por las diferentes opciones del menu de trasnferencias$")
	public void el_usuario_deberia_poder_navegar_por_las_diferentes_opciones_del_menu_de_trasnferencias()
			throws Exception {
		if (acciones.runevent.isElementPresent(By.className("menu-toggle"))) {
			System.out.println("responsive");
			acciones.validarElementoclick(By.className("menu-toggle"), "menu");
			// *[@id="menuItemTransfers"]/span
			// *[@id="menuItemPayments"]/span
			// *[@id="menuItemPayments"]/span
			acciones.validarElementoclick(By.xpath("//*[@id=\"menuItemTransfers\"]/span"), "menu");
			// runevent.clickCentral(By.id("menuItemTransfers"));
			for (int i = 1; i < 6; i++) {

				acciones.runevent.indicarElemento(By.id("menuItemTransfers_" + i), "");
			}
		} else {
			System.out.println("no hay responsive");
			acciones.validarElemento(By.xpath("//*[@id=\"menuItemTransfers\"]/span"), "item transferencias");
			acciones.runevent.mouseOver(By.xpath("//*[@id=\"menuItemTransfers\"]/span"));
			Thread.sleep(2000);
			for (int i = 1; i < 6; i++) {

				acciones.runevent.indicarElemento(By.id("menuItemTransfers_" + i), "subMenu item");

			}
		}
		tearDown();
	}

	@When("^el usuario se dirige al menu y elige la opcion de pagos$")
	public void el_usuario_se_dirige_al_menu_y_elige_la_opcion_de_pagos() throws Exception {

		acciones.runevent.createTest("navegacionPagos");
		acciones.validarElemento(By.id("lbl_DepoInvTitle"), "depositos");
	}

	@Then("^el usuario deberia poder navegar por las diferentes opciones del menu de pagos$")
	public void el_usuario_deberia_poder_navegar_por_las_diferentes_opciones_del_menu_de_pagos() throws Exception {
		try {
			acciones.validarElemento(By.id("lbl_DepoInvTitle"), "depositos");

			if (acciones.runevent.isElementPresent(By.className("menu-toggle"))) {
				System.out.println("responsive");
				acciones.validarElementoclick(By.className("menu-toggle"), "menu");

				acciones.validarElementoclick(By.xpath("//*[@id=\"menuItemPayments\"]/span"), "menu");

				for (int i = 1; i < 8; i++) {

					acciones.runevent.indicarElemento(By.id("menuItemPayments_" + i), "subMenuItem");
				}
			} else {
				System.out.println("no hay responsive");
				acciones.validarElemento(By.xpath("//*[@id=\"menuItemPayments\"]/span"), "item pagos");
				acciones.runevent.mouseOver(By.xpath("//*[@id=\"menuItemPayments\"]/span"));
				Thread.sleep(2000);
				for (int i = 1; i < 8; i++) {

					acciones.runevent.indicarElemento(By.id("menuItemPayments_" + i), "");

				}
			}

		} catch (Exception e) {
			acciones.runevent.indicarElementoFail(
					((WebDriver) acciones.runevent.driver).findElement(By.cssSelector("body")), "error " + e);
			throw e;
		}
		tearDown();
	}

	@When("^el usuario se dirige al menu y elige la opcion de recargas$")
	public void el_usuario_se_dirige_al_menu_y_elige_la_opcion_de_recargas() throws Exception {
		acciones.runevent.createTest("navegacionMenuRecargas");

		acciones.validarElemento(By.id("lbl_DepoInvTitle"), "depositos");
	}

	@Then("^el usuario deberia poder navegar por las diferentes opciones del menu de recargas$")
	public void el_usuario_deberia_poder_navegar_por_las_diferentes_opciones_del_menu_de_recargas() throws Exception {
		try {
			if (acciones.runevent.isElementPresent(By.className("menu-toggle"))) {
				System.out.println("responsive");
				acciones.validarElementoclick(By.className("menu-toggle"), "menu");

				acciones.validarElementoclick(By.xpath("//*[@id=\"menuItemRecharge\"]/span"), "menu");

				for (int i = 1; i < 4; i++) {

					acciones.runevent.indicarElemento(By.id("menuItemRecharge_" + i), "");

				}
			} else {
				System.out.println("no hay responsive");
				acciones.validarElemento(By.xpath("//*[@id=\"menuItemRecharge\"]/span"), "item recargas");
				acciones.runevent.mouseOver(By.xpath("//*[@id=\"menuItemRecharge\"]/span"));
				Thread.sleep(2000);
				for (int i = 1; i < 4; i++) {

					acciones.runevent.indicarElemento(By.id("menuItemRecharge_" + i), "");

				}
			}

		} catch (Exception e) {
			acciones.runevent.indicarElementoFail(
					((WebDriver) acciones.runevent.driver).findElement(By.cssSelector("body")), "error " + e);
			throw e;
		}
		tearDown();
	}

	@When("^el usuario se dirige al menu y elige la opcion de configuracion$")
	public void el_usuario_se_dirige_al_menu_y_elige_la_opcion_de_configuracion() throws Exception {
		acciones.runevent.createTest("navegacionConfiguracion");
		acciones.validarElemento(By.id("lbl_DepoInvTitle"), "depositos");

	}

	@Then("^el usuario deberia poder navegar por las diferentes opciones del menu de configuracion$")
	public void el_usuario_deberia_poder_navegar_por_las_diferentes_opciones_del_menu_de_configuracion()
			throws Exception {
		try {
			acciones.validarElemento(By.id("lbl_DepoInvTitle"), "depositos");

			if (acciones.runevent.isElementPresent(By.className("menu-toggle"))) {
				System.out.println("responsive");
				acciones.validarElementoclick(By.className("menu-toggle"), "menu");

				acciones.validarElementoclick(By.xpath("//*[@id=\"menuConfiguration\"]/span"), "menu");

				for (int i = 1; i < 4; i++) {
					acciones.runevent.indicarElemento(By.id("menuConfiguration_" + i), "");
				}
			} else {
				System.out.println("no hay responsive");
				acciones.validarElemento(By.xpath("//*[@id=\"menuConfiguration\"]/span"), "item congifuracion");
				acciones.runevent.mouseOver(By.xpath("//*[@id=\"menuConfiguration\"]/span"));
				Thread.sleep(2000);
				for (int i = 1; i < 4; i++) {
					acciones.runevent.indicarElemento(By.id("menuConfiguration_" + i), "");
				}
			}

		} catch (Exception e) {
			acciones.runevent.indicarElementoFail(
					((WebDriver) acciones.runevent.driver).findElement(By.cssSelector("body")), "error " + e);
			throw e;
		}
		tearDown();
	}

	@When("^el usuario busca la opcion de solicitar otro producto$")
	public void el_usuario_busca_la_opcion_de_solicitar_otro_producto() throws Exception {
		acciones.runevent.createTest("solicitarProductos");

		acciones.validarElemento(By.className("card-add-product"), "solicitar Productos");

	}

	@Then("^el usuario deberia poder ver la opcion de solicitar producto$")
	public void el_usuario_deberia_poder_ver_la_opcion_de_solicitar_producto() throws Exception {
		try {
			acciones.runevent.indicarElemento(By.className("card-add-product"), "boton solicitar productos");

			Thread.sleep(3000);
		} catch (Exception e) {
			acciones.runevent.indicarElementoFail(
					((WebDriver) acciones.runevent.driver).findElement(By.cssSelector("body")), "error " + e);
			throw e;
		}
		tearDown();
	}

	@When("^el usuario busca la opcion de resumen de productos por tipo$")
	public void el_usuario_busca_la_opcion_de_resumen_de_productos_por_tipo() throws Exception {
		acciones.runevent.createTest("ResumenTipoProducto");

		acciones.validarElemento(By.className("categories"), "contenedor tus productos");// pendiente id

	}

	@Then("^el usuario deberia poder ver un resumen de sus productos por tipo$")
	public void el_usuario_deberia_poder_ver_un_resumen_de_sus_productos_por_tipo() throws Exception {
		try {
			acciones.validarElemento(By.id("lbl_depoAccontsTitle"), "tipo de producto");
			acciones.validarElemento(By.id("lbl_DepoBalanceValue"), "saldo actual");

			acciones.validarElemento(By.id("lbl_numberProudcts_1"), "numero de productos");
		} catch (Exception e) {
			acciones.runevent.indicarElementoFail(
					((WebDriver) acciones.runevent.driver).findElement(By.cssSelector("body")), "error " + e);
			throw e;
		}
		tearDown();
	}

	@When("^el usuario busca la opcion de tus productos para verlos por orden$")
	public void el_usuario_busca_la_opcion_de_tus_productos_para_verlos_por_orden() throws Exception {
		acciones.runevent.createTest("OrdenResumenTipoProducto");

		acciones.validarElemento(By.className("categories"), "contenedor tus productos");// pendiente id
		System.out.println("contenedor de productos");
	}

	@Then("^el usuario deberia poder ver su productos oredenados de la forma Cuentas de deposito,Tarjetas de credito,Prestamos e Inversiones$")
	public void el_usuario_deberia_poder_ver_su_productos_oredenados_de_la_forma_Cuentas_de_deposito_Tarjetas_de_credito_Prestamos_e_Inversiones()
			throws Exception {
		try {
			acciones.validarElemento(By.id("lbl_depoAccontsTitle"), "depositos");// pendiente id
			acciones.validarElemento(By.id(" lbl_CreditsCardsTitle"), "tarejtas");// pendiente id
			acciones.validarElemento(By.id(" lbl_LoanTitle"), "prestamos");// pendiente id
			acciones.validarElemento(By.id("lbl_InvTitle"), "inversiones");// pendiente id

		} catch (Exception e) {
			acciones.runevent.indicarElementoFail(
					((WebDriver) acciones.runevent.driver).findElement(By.cssSelector("body")), "error " + e);
			throw e;
		}

		tearDown();
	}

	@When("^el usuario busca la opcion de tipo de producto$")
	public void el_usuario_busca_la_opcion_de_tipo_de_producto() throws Exception {
		acciones.runevent.createTest("productoSeleccionado");

		acciones.validarElementoclick(By.id(" lbl_CreditsCardsTitle"), "producto seleccionado");// pendiente id

	}

	@Then("^el usuario deberia poder ver los productos asociados a ese tipo de producto$")
	public void el_usuario_deberia_poder_ver_los_productos_asociados_a_ese_tipo_de_producto() throws Exception {
		try {
			for (int i = 1; i < 6; i++) {
				acciones.validarElemento(By.id("containerCard_DepositAccounts_" + i), "productos");
			}

		} catch (Exception e) {
			acciones.runevent.indicarElementoFail(
					((WebDriver) acciones.runevent.driver).findElement(By.cssSelector("body")), "error " + e);
			throw e;
		}

		tearDown();
	}

	@When("^el usuario busca la opcion de ver productos en forma de categoria$")
	public void el_usuario_busca_la_opcion_de_ver_productos_en_forma_de_categoria() throws Exception {
		acciones.runevent.createTest("vistaCategorias");
		acciones.validarElemento(By.className("categories"), "contenedor tus productos");// pendiente id
	}

	@Then("^el usuario deberia poder ver su productos en forma de categoria$")
	public void el_usuario_deberia_poder_ver_su_productos_en_forma_de_categoria() throws Exception {
		try {
			acciones.validarElementoclick(By.id("btn_ProductsCategories"), "boton lista categorias");// pendiente id

		} catch (Exception e) {
			acciones.runevent.indicarElementoFail(
					((WebDriver) acciones.runevent.driver).findElement(By.cssSelector("body")), "error " + e);
			throw e;
		}

		tearDown();
	}

	@When("^el usuario busca la opcion de ver productos en forma de lista$")
	public void el_usuario_busca_la_opcion_de_ver_productos_en_forma_de_lista() throws Exception {
		acciones.runevent.createTest("vistaLista");

		acciones.validarElementoclick(By.id("btn_ProductsList"), "boton lista categorias");// pendiente id

	}

	@Then("^el usuario deberia poder ver su productos en forma de lista$")
	public void el_usuario_deberia_poder_ver_su_productos_en_forma_de_lista() throws Exception {
		try {
			acciones.validarElemento(By.className("list-container"), "contenedor tus productos");// pendiente id

		} catch (Exception e) {
			acciones.runevent.indicarElementoFail(
					((WebDriver) acciones.runevent.driver).findElement(By.cssSelector("body")), "error " + e);
			throw e;
		}

		tearDown();
	}
	@When("^el usuario visualiza todo los productos suma todas las cantidades$")
	public void el_usuario_visualiza_todo_los_productos_suma_todas_las_cantidades() throws Exception {
		acciones.runevent.createTest("SaldosgeneralesDepInv");
		

		try { 

			acciones.validarElemento(By.id("lbl_DepoInvTitle"), "depositos e inversiones titulo ");//pendiente id
			
			acciones.validarElemento(By.id("lbl_DepoBalanceValue"), "depositos");
            saldodepo = acciones.convertirDouble(By.id("lbl_DepoBalanceValue"));
            
            acciones.validarElemento(By.id("//*[@id=\"containerCard_DepositAccounts_1\"]/div[3]/div[2]"), "depositos");
            Double cuentaDepo1 = acciones.convertirDouble(By.id("lbl_DepoBalanceValue"));
            
            acciones.validarElemento(By.id("lbl_DepoBalanceValue"), "depositos");
            Double cuentaDepo2 = acciones.convertirDouble(By.id("lbl_DepoBalanceValue"));
            
            acciones.validarElemento(By.id("lbl_DepoBalanceValue"), "depositos");
            Double cuentaDepo3 = acciones.convertirDouble(By.id("lbl_DepoBalanceValue"));
            
            acciones.validarElemento(By.id("lbl_DepoBalanceValue"), "depositos");
            Double cuentaDepo4 = acciones.convertirDouble(By.id("lbl_DepoBalanceValue"));
            
            acciones.validarElemento(By.id("lbl_DepoBalanceValue"), "depositos");
            Double cuentaDepo5 = acciones.convertirDouble(By.id("lbl_DepoBalanceValue"));
			
			
			 totalCUentasDepo= cuentaDepo1+cuentaDepo2+cuentaDepo3+cuentaDepo4+cuentaDepo5;
		
			
		
			
		} catch (Exception e) {
			acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
			throw e;
		}
		

	}

	@Then("^las suma de los productos debe de ser igual al resumen$")
	public void las_suma_de_los_productos_debe_de_ser_igual_al_resumen() throws Exception {

		if(totalCUentasDepo==saldodepo) {
			System.out.println((totalCUentasDepo)+"=="+saldodepo);
			acciones.validarElemento(By.id("lbl_depInvTotalAmount"), (totalCUentasDepo)+"=="+saldodepo);
		}
		else {
			
			acciones.runevent.indicarElementoFail(By.id("lbl_DepoBalanceValue"), "no coincide la sumatoria");
		}
		tearDown();
	}

	public void tearDown() {

		try {
			acciones.runevent.closeDriver();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
