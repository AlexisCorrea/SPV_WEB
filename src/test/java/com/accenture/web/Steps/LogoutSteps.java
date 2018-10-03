package com.accenture.web.Steps;

import org.openqa.selenium.By;

import com.accenture.web.Acciones.LoginAcciones;
import com.accenture.web.Acciones.LogoutAcciones;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LogoutSteps {
	
	static LogoutAcciones acciones= new LogoutAcciones();
	static LoginAcciones login = new LoginAcciones();
	
	@Given("^el usuario procede ha acceder a la web de Banistmo y hacer su login$")
	public void el_usuario_procede_ha_acceder_a_la_web_de_Banistmo_y_hacer_su_login() throws Exception {
		acciones.setUp();
		login.loginExitoso("osorioJuan", "12345678", acciones.runevent);
	}

	@When("^el usuario de click en la opcion logout$")
	public void el_usuario_de_click_en_la_opcion_logout() throws Exception {
		
		acciones.runevent.createTest("logoutExitoso");
		try {
			acciones.findExpectativa("caso1");
			acciones.runevent.clickWait(By.id("btn_logout"));
			

		} catch (Exception e) {
			acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
			acciones.tearDown();
			throw e;
		}
		
	}

	@Then("^el usuario deberia salir a la pagian principal de login$")
	public void el_usuario_deberia_salir_a_la_pagian_principal_de_login() throws Exception {
		
		try {
			
			acciones.runevent.clickWait(By.id("btn_accept"));

		} catch (Exception e) {
			acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
			acciones.tearDown();
			throw e;
		}
		acciones.tearDown();
	}

	@When("^el usurio cierre el navegador$")
	public void el_usurio_cierre_el_navegador() throws Exception {
		acciones.runevent.createTest("logOut_cerrandoNavegador");
		try {
			
			acciones.runevent.indicarElemento(By.className("logo"), "logo del banco");
			((WebDriver)acciones.runevent.getDriver()).quit();
            } catch (Exception e) {
			acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
			acciones.tearDown();
			throw e;
		}

		
	}

	@Then("^a volver a ingresar al sitio web deberia de ingresar nuevamente sus credenciales$")
	public void a_volver_a_ingresar_al_sitio_web_deberia_de_ingresar_nuevamente_sus_credenciales() throws Exception {
		acciones.runevent.createTest("logOut_cerrandoNavegador");
		try {
			
            acciones.setUp();
			acciones.runevent.gotoUrl("https://d3c7mdofqu33va.cloudfront.net/home");
			acciones.runevent.indicarElemento(By.id("inp_user"), "trato de volver al home de la svp");
		} catch (Exception e) {
			acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
			acciones.tearDown();
			throw e;
		}

		acciones.tearDown();
	}

	@When("^el usuario cambie de url en el navegador y el usuario quiera volver atras copiando la url$")
	public void el_usuario_cambie_de_url_en_el_navegador_y_el_usuario_quiera_volver_atras_copiando_la_url() throws Exception {
	
		acciones.runevent.createTest("lologOut_cambioDeUrl");
		try {
			acciones.runevent.indicarElemento(By.className("logo"), "logo del banco");
			
			acciones.runevent.gotoUrl("https://www.google.com");
			acciones.runevent.indicarElemento(By.id("hplogo"), "se cambio de pagina");
			
			} catch (Exception e) {
			acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
			acciones.tearDown();
			throw e;
		}

		
	}

	@Then("^el usuario deberia de ser redireccionado al login$")
	public void el_usuario_deberia_de_ser_redireccionado_al_login() throws Exception {
		
		try {
			
			acciones.runevent.gotoUrl("https://d3c7mdofqu33va.cloudfront.net/home");
			acciones.runevent.indicarElemento(By.id("inp_user"), "trato de volver al home de la svp");
		} catch (Exception e) {
			acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
			acciones.tearDown();
			throw e;
		}

		acciones.tearDown();
	}

	@When("^el usuario cambie de url en el navegador y el usuario quiera volver atras dando click en el boto volver$")
	public void el_usuario_cambie_de_url_en_el_navegador_y_el_usuario_quiera_volver_atras_dando_click_en_el_boto_volver() throws Exception {
		acciones.runevent.createTest("logOut_botonNativoVolver");
		try {
			acciones.runevent.indicarElemento(By.className("logo"), "logo del banco");
			acciones.runevent.gotoUrl("https://es-la.facebook.com/");
			acciones.runevent.indicarElemento(By.className("fb_logo"), "se cambio de pagina");
			((WebDriver)acciones.runevent.getDriver()).navigate().back();
			
			acciones.runevent.indicarElemento(By.id("inp_user"), "trato de volver al home de la svp");
		} catch (Exception e) {
			acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
			acciones.tearDown();
			throw e;
		}
		
	}

	@Then("^el usuario deberia se redireccionado al login$")
	public void el_usuario_deberia_se_redireccionado_al_login() throws Exception {
		try {
			
			acciones.runevent.indicarElemento(By.id("inp_user"), "trato de volver al home de la svp");
		} catch (Exception e) {
			acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
			acciones.tearDown();
			throw e;
		}
		acciones.tearDown();
	}
}
