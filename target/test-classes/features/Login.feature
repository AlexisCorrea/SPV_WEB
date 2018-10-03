@tag @tags
Feature: revicion de login
	como usuario de la apliacion
	quiere revisar el login
	para observar que todos los componentes que lo conforman
	
	Background: ejecucion de la apliacion
	Given el usuario procede ha acceder a la web de Banistmo 
	
@tag1
Scenario: el usuario hace un login exito
    When el usuario ingresa sus credenciales correctas 
    Then el deberia de poder entrar a la pantalla principal
    
@tag2
Scenario: el usuario hace un login con su usuario incorrecto
    When el usuario ingresa su usuario incorrecto y su clave correcta
    Then el deberia de ver un mensaje de advertencia " The information is not valid. Please, verify your login information. "
    
@tag3
Scenario: el usuario hace un login con su clave incorrecto
    When el usuario ingresa su usuario correcto y clave incorrecta 
    Then el deberia de ver un mensaje de advertencia " The information is not valid. Please, verify your login information. "
    
@tag4
Scenario: el usuario hace tres veces un login fallido
    When el usuario ingresa su usuario correcto y clave incorrecto tres veces 
    Then el deberia de ver un mensaje de advertencia " The information is not valid. Please, verify your login information. "
    
@tag5
Scenario: el usuario intenta acceder a la web con su usuario bloqueado
    When el usuario ingresa su usuario bloqueado y clave 
    Then el deberia de ver un mensaje de advertencia " The user has been blocked for security. "
    
@tag6
Scenario: el usuario no ingresa datos en el campo usuario
    When el usuario no digita su usuario
    Then el no puede seguir adelante con el ingreso de clave
    
@tag7
Scenario: el usuario no digita su clave
    When el usuario ingresa su usuario pero no digita su clave 
    Then el no puede proseguir con el ingreso al home
    
@tag8
Scenario: el usuario intenta ingresa caracteres especiales 
    When el usuario intenta digitar ingrear caracteres especiales en el campo usuario
    Then el sistema no beria permitirle ingresar los caracteres especiales
    
@tag9
Scenario: el usuario digita pocos caracter en el campo usuario
    When el usuario no ingresa el minimo de caracter en el campo usuario
    Then el deberia de ver un mensaje que le indique que se faltan datos 
    
@tag10
Scenario: el usuario digita el maximo de caracteres en el campo usuario
    When el usuario ingresa el maximo de caracteres en campo usuario 
    Then el deberia deberia poder darle click en el boton continuar
    
@tag11
Scenario: el usuario digita pocos caracter en el campo clave
    When el usuario ingresa su usuario pero no ingresa la cantidad minima de caracteres en el campo clave
    Then el deberia de ver un mensaje que le informe que le faltan datos
    
@tag12
Scenario: el usuario digita el maximo de caracteres en el campo clave
    When el usuario ingresa su usuario he ingresa el maximo de caracteres en el campo clave
    Then el deberia deberia poder darle en el botono ingresar   
    
@tag13
Scenario: el usuario ve su clave
    When el usuario ingresa sus datos y le da click en la opcion de ver clave
    Then el deberia de pode ver su clave
   
@tag14
Scenario: el usuario cancela el proceso de login
    When el usuario ingresa sus datos y le da en el boton cancelar
    Then el deberia de regresar y poder ingresar su usuario
   
@tag15
Scenario: el usuario da click en el tooltip de usuario
    When el usuario ingresa su usuario y da click en el tooltip de usuario
    Then el deberia de ver un mensaje "You define it when registering in the People Virtual Branch or Banistmo APP, it is personal and non-transferable "

@tag16
Scenario: el usuario da click en el tooltip de clave
    When el usuario ingresa su usuario y clave despues da click en el tooltip clave
    Then el deberia de ver un mensaje que le informe "The password was defined by you at the time of registration to the Personal Branch or Banistmo APP, is personal and non-transferable "
    