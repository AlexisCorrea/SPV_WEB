Feature: logout 
	como usuario del sitio web
	quiere hace el correcto logout de su cuenta
	
	Background: Ejecucion de la apliacion y login
	Given el usuario procede ha acceder a la web de Banistmo y hacer su login
	
	
	Scenario: Logout correcto
	When el usuario de click en la opcion logout
	Then el usuario deberia salir a la pagian principal de login
#	
#	Scenario: Logout cierre del navegador
#	When el usurio cierre el navegador 
#	Then a volver a ingresar al sitio web deberia de ingresar nuevamente sus credenciales
#	
#	Scenario: Logout cambio de url
#	When el usuario cambie de url en el navegador y el usuario quiera volver atras copiando la url
#	Then el usuario deberia de ser redireccionado al login
#	
#	Scenario: Logout boton volver
#	When el usuario cambie de url en el navegador y el usuario quiera volver atras dando click en el boto volver
#	Then el usuario deberia se redireccionado al login
#	
#	