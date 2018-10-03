package com.accenture.web.Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.accenture.web.Acciones.LoginAcciones;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
static LoginAcciones acciones= new LoginAcciones();
	
	@Given("^el usuario procede ha acceder a la web de Banistmo$")
	public void el_usuario_procede_ha_acceder_a_la_web_de_Banistmo() throws Exception {
		acciones.setUp();
	}

	@When("^el usuario ingresa sus credenciales correctas$")
	public void el_usuario_ingresa_sus_credenciales_correctas() throws Exception {
		acciones.runevent.createTest("loginExitoso");
		try {
			
		acciones.findExpectativa("loginExitoso");
		Thread.sleep(100);
		acciones.ingresaruser(acciones.user);
		acciones.clickContinuar();
		acciones.ingresarPss(acciones.pss);
		acciones.clickIngresar();
		
		} catch (Exception e) {
		 acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
		 throw e;
		}
		
	}

	@Then("^el deberia de poder entrar a la pantalla principal$")
	public void el_deberia_de_poder_entrar_a_la_pantalla_principal() throws Exception {
		try {
			acciones.validaringreso();
			
		} catch (Exception e) {
			 acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
			 throw e;
		}
		tearDown();
	}
	
	@When("^el usuario ingresa su usuario incorrecto y su clave correcta$")
	public void el_usuario_ingresa_su_usuario_incorrecto_y_su_clave_correcta() throws Exception {
		acciones.runevent.createTest("usuarioIncorrecto");
		try {
			
			acciones.findExpectativa("usuarioIncorrecto");	
			Thread.sleep(100);
			acciones.ingresaruser(acciones.user);
			acciones.clickContinuar();
			acciones.ingresarPss(acciones.pss);
			acciones.clickIngresar();
//			acciones.validarmensajeerror("La informaciónno es válida. Por favor verifique sus datos de ingreso.");
		
		} catch (Exception e) {
			 acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
			 throw e;
		}
	}

	@Then("^el deberia de ver un mensaje de advertencia \"([^\"]*)\"$")
	public void el_deberia_de_ver_un_mensaje_de_advertencia(String mensaje) throws Exception {
		try {
			try {
				acciones.validarmensajeerrorUsuario(mensaje);
				
			}catch (Exception e) {
				// TODO: handle exception
				acciones.validarmensajeerrorUsuario("Por favor verifique los datos ingresados");
			}
//			acciones.validarmensajeerror("La informaciónno es válida. Por favor verifique sus datos de ingreso.");
		} catch (Exception e) {
			 acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
			 throw e;
		}
		tearDown();
	}
	
	@When("^el usuario ingresa su usuario correcto y clave incorrecta$")
	public void el_usuario_ingresa_su_usuario_correcto_y_clave_incorrecta() throws Exception {
		acciones.runevent.createTest("passwordIncorrecto");
		try {
		acciones.findExpectativa("passwordIncorrecto");	
		Thread.sleep(100);
		acciones.ingresaruser(acciones.user);
		acciones.clickContinuar();
		acciones.ingresarPss(acciones.pss);
		acciones.clickIngresar();
		
		} catch (Exception e) {
			acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
		 throw e;
		}
		
	}
	
	@When("^el usuario ingresa su usuario correcto y clave incorrecto tres veces$")
	public void el_usuario_ingresa_su_usuario_correcto_y_clave_incorrecto_tres_veces() throws Exception {
		acciones.runevent.createTest("loginfallidopor3vez");
		try {
			
			acciones.findExpectativa("loginfallidopor3vez");	
		Thread.sleep(100);
		acciones.ingresaruser(acciones.user);
		acciones.clickContinuar();
		acciones.ingresarPss(acciones.pss);
		acciones.clickIngresar();
		//1
//		ingresaruser(user);
//		clickContinuar();
		acciones.ingresarPss(acciones.pss);
		acciones.clickIngresar();
		//2
//		ingresaruser(user);
//		clickContinuar();
		acciones.ingresarPss(acciones.pss);
		acciones.clickIngresar();
		//3
//		acciones.validarmensajeerror("Por favor verifique los datos ingresados");
		
		} catch (Exception e) {
			acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
		 throw e;
		}
	}

	@When("^el usuario ingresa su usuario bloqueado y clave$")
	public void el_usuario_ingresa_su_usuario_bloqueado_y_clave() throws Exception {
		acciones.runevent.createTest("loginUsuarioBloqueado");  ///////////////////////////////
		try {
			
			acciones.findExpectativa("loginUsuarioBloqueado");	
			Thread.sleep(100);
			acciones.ingresaruser(acciones.user);
			acciones.clickContinuar();
			acciones.ingresarPss(acciones.pss);
			acciones.clickIngresar();
			
//		validarmensajeerror("Usuario Bloqueado");
		} catch (Exception e) {
			acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
			throw e;
		}
	}
	
	@When("^el usuario no digita su usuario$")
	public void el_usuario_no_digita_su_usuario() throws Exception {
		try {
		acciones.runevent.createTest("CampoUsuarioObligatorio");
		} catch (Exception e) {
			acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
			throw e;
		}
	}

	@Then("^el no puede seguir adelante con el ingreso de clave$")
	public void el_no_puede_seguir_adelante_con_el_ingreso_de_clave() throws Exception {
		try {
			acciones.runevent.indicarElementoEnabled(((WebDriver)acciones.runevent.getDriver()).findElements(By.id("btn_continue")).get(1), "se valida que el boton este bloqueado", true);
		} catch (Exception e) {
			acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
			throw e;
		}
		tearDown();
	}

	@When("^el usuario ingresa su usuario pero no digita su clave$")
	public void el_usuario_ingresa_su_usuario_pero_no_digita_su_clave() throws Exception {
		acciones.runevent.createTest("CampoPasswordObligatorio");
		try {
			acciones.findExpectativa("CampoPasswordObligatorio");
			acciones.ingresaruser(acciones.user);
			acciones.clickContinuar();
//			acciones.runevent.indicarElementoEnabled(((WebDriver)acciones.runevent.getDriver()).findElements(By.id("btn_login")).get(1), "se valida que el boton este bloqueado", false);
			
		} catch (Exception e) {
		 acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
		 throw e;
		}
		
	}

	@Then("^el no puede proseguir con el ingreso al home$")
	public void el_no_puede_proseguir_con_el_ingreso_al_home() throws Exception {
		try {
			
			acciones.runevent.indicarElementoEnabled(((WebDriver)acciones.runevent.getDriver()).findElements(By.id("btn_login")).get(1), "se valida que el boton este bloqueado", false);
			
		} catch (Exception e) {
		 acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
		 throw e;
		}
		tearDown();
	}
	
	@When("^el usuario intenta digitar ingrear caracteres especiales en el campo usuario$")
	public void el_usuario_intenta_digitar_ingrear_caracteres_especiales_en_el_campo_usuario() throws Exception {
		acciones.runevent.createTest("CampoUsuarioCaracteresEspeciales");
		try {
			
		acciones.findExpectativa("CampoUsuarioCaracteresEspeciales");
		Thread.sleep(100);
		acciones.ingresaruser(acciones.user);
		
		} catch (Exception e) {
		 acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
		 throw e;
		}
	}

	@Then("^el sistema no beria permitirle ingresar los caracteres especiales$")
	public void el_sistema_no_beria_permitirle_ingresar_los_caracteres_especiales() throws Exception {
		try {
//			acciones.validarTextoCaracteres();
			acciones.runevent.CompararTexto(By.cssSelector("#inp_user"), "");
			} catch (Exception e) {
			 acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
			 throw e;
			}
	}

	@When("^el usuario ingresa sus datos y le da click en la opcion de ver clave$")
	public void el_usuario_ingresa_sus_datos_y_le_da_click_en_la_opcion_de_ver_clave() throws Exception {
		acciones.runevent.createTest("btnShowpassword");
		try {
			
		acciones.findExpectativa("btnShowpassword");
		Thread.sleep(100);
		acciones.ingresaruser(acciones.user);
		acciones.clickContinuar();
		acciones.ingresarPss(acciones.pss);
		
		
		} catch (Exception e) {
		 acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
		 throw e;
		}
	}

	@Then("^el deberia de pode ver su clave$")
	public void el_deberia_de_pode_ver_su_clave() throws Exception {
		try {
			
		acciones.clickShowPasword();
			
			} catch (Exception e) {
			 acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
			 throw e;
			}
		tearDown();
	}
	
	@When("^el usuario ingresa sus datos y le da en el boton cancelar$")
	public void el_usuario_ingresa_sus_datos_y_le_da_en_el_boton_cancelar() throws Exception {
		acciones.runevent.createTest("btnCancelar");
		try {
			
		acciones.findExpectativa("btnCancelar");
		Thread.sleep(100);
		acciones.ingresaruser(acciones.user);
		acciones.clickContinuar();
		acciones.ingresarPss(acciones.pss);
		acciones.clickCancelar();
		
		} catch (Exception e) {
		 acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
		 throw e;
		}
	}

	@Then("^el deberia de regresar y poder ingresar su usuario$")
	public void el_deberia_de_regresar_y_poder_ingresar_su_usuario() throws Exception {
		try {
		
		acciones.ingresaruser(acciones.user);
		
		} catch (Exception e) {
		 acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
		 throw e;
		}
		tearDown();
	}

	@When("^el usuario ingresa su usuario y da click en el tooltip de usuario$")
	public void el_usuario_ingresa_su_usuario_y_da_click_en_el_tooltip_de_usuario() throws Exception {
		acciones.runevent.createTest("toolTipUsuario");
		try {
			
		acciones.findExpectativa("toolTipUsuario");
		Thread.sleep(100);
		acciones.ingresaruser(acciones.user);
//		acciones.clickToolTipuser();
		acciones.runevent.click(By.className("tooltip"));
		
		} catch (Exception e) {
		 acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
		 throw e;
		}
	}

	@Then("^el deberia de ver un mensaje \"([^\"]*)\"$")
	public void el_deberia_de_ver_un_mensaje(String mensaje) throws Exception {
		
		try {
//			acciones.validarmensajetolltipusuario(mensaje);
			acciones.runevent.CompararTextodeAtributo(By.className("tooltip"), mensaje, "message");
			
			} catch (Exception e) {
			 acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
			 throw e;
			}
		tearDown();
	}
	
	@When("^el usuario ingresa su usuario y clave despues da click en el tooltip clave$")
	public void el_usuario_ingresa_su_usuario_y_clave_despues_da_click_en_el_tooltip_clave() throws Exception {
		acciones.runevent.createTest("toolTipPassword");
		try {
			
		acciones.findExpectativa("toolTipPassword");
		Thread.sleep(100);
		acciones.ingresaruser(acciones.user);
		acciones.clickToolTipuser();
		acciones.ingresarPss(acciones.pss);
		acciones.runevent.click(By.className("tooltip"));
//		acciones.clickToolTippassword();
		
		} catch (Exception e) {
		 acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
		 throw e;
		}
	}

	@Then("^el deberia de ver un mensaje que le informe \"([^\"]*)\"$")
	public void el_deberia_de_ver_un_mensaje_que_le_informe(String mensaje) throws Exception {
		try {
//			acciones.validarmensajetolltippassword(mensaje);
			acciones.runevent.CompararTextodeAtributo(By.className("tooltip"), mensaje, "message");
			
		} catch (Exception e) {
			acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
			throw e;
		}
		tearDown();
	}
	
	@When("^el usuario no ingresa el minimo de caracter en el campo usuario$")
	public void el_usuario_no_ingresa_el_minimo_de_caracter_en_el_campo_usuario() throws Exception {
		acciones.runevent.createTest("longitudMinimaUsuario");
		try {
			
			acciones.findExpectativa("longitudMinimaUsuario");
			acciones.ingresaruser(acciones.user);
//			clickContinuar();
		
		} catch (Exception e) {
		 acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
		 throw e;
		}

	}

	@Then("^el deberia de ver un mensaje que le indique que se faltan datos$")
	public void el_deberia_de_ver_un_mensaje_que_le_indique_que_se_faltan_datos() throws Exception {
		try {
		
			acciones.validarmensajeerror("No cumple con la longitud mÃ­nima");
			
		
		} catch (Exception e) {
		 acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
		 throw e;
		}
		tearDown();
	}
	
	@When("^el usuario ingresa el maximo de caracteres en campo usuario$")
	public void el_usuario_ingresa_el_maximo_de_caracteres_en_campo_usuario() throws Exception {
		acciones.runevent.createTest("longitudMaximaUsuario");
		try {
			
			acciones.findExpectativa("longitudMaximaUsuario");
			acciones.ingresaruser(acciones.user);
			
		
		} catch (Exception e) {
		 acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
		 throw e;
		}
	}

	@Then("^el deberia deberia poder darle click en el boton continuar$")
	public void el_deberia_deberia_poder_darle_click_en_el_boton_continuar() throws Exception {
	try {
		
			acciones.runevent.longitudCaracteres(((WebDriver)acciones.runevent.getDriver()).findElement(By.id("inp_user")).findElement(By.cssSelector("input")), 12);
		
		} catch (Exception e) {
			 acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
			 throw e;
		}
		tearDown();
	}
	
	@When("^el usuario ingresa su usuario pero no ingresa la cantidad minima de caracteres en el campo clave$")
	public void el_usuario_ingresa_su_usuario_pero_no_ingresa_la_cantidad_minima_de_caracteres_en_el_campo_clave() throws Exception {
		
		acciones.runevent.createTest("longitudMinimapasword");
		try {

			acciones.findExpectativa("longitudMinimapasword");
			acciones.ingresaruser(acciones.user);
			acciones.clickContinuar();
			acciones.ingresarPss(acciones.pss);
			
		} catch (Exception e) {
		 acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
		 throw e;
		}
	}

	@Then("^el deberia de ver un mensaje que le informe que le faltan datos$")
	public void el_deberia_de_ver_un_mensaje_que_le_informe_que_le_faltan_datos() throws Exception {
		
		try {

			acciones.validarmensajeerror("No cumple con la longitud mÃ­nima");
			
		} catch (Exception e) {
		 acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
		 throw e;
		}
		tearDown();
	}
	
	@When("^el usuario ingresa su usuario he ingresa el maximo de caracteres en el campo clave$")
	public void el_usuario_ingresa_su_usuario_he_ingresa_el_maximo_de_caracteres_en_el_campo_clave() throws Exception {
		acciones.runevent.createTest("longitudMaximapasword");
		try {
			
			acciones.findExpectativa("longitudMaximapasword");
			acciones.ingresaruser(acciones.user);
			acciones.clickContinuar();
			acciones.ingresarPss(acciones.pss);
//			acciones.runevent.longitudCaracteres(((WebDriver)acciones.runevent.getDriver()).findElement(By.id("inp_password")).findElement(By.cssSelector("input")), 12);
		
		} catch (Exception e) {
		 acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
		 throw e;
		}
		tearDown();
	}

	@Then("^el deberia deberia poder darle en el botono ingresar$")
	public void el_deberia_deberia_poder_darle_en_el_botono_ingresar() throws Exception {
		try {
			
			acciones.runevent.longitudCaracteres(((WebDriver)acciones.runevent.getDriver()).findElement(By.id("inp_password")).findElement(By.cssSelector("input")), 12);
		
		} catch (Exception e) {
			 acciones.runevent.indicarElementoFail(((WebDriver)acciones.runevent.driver).findElement(By.cssSelector("body")), "error "+e);
			 throw e;
		}
		tearDown();
	}
	
	
	
	public void tearDown(){
		
		try {
			acciones.runevent.closeDriver();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
