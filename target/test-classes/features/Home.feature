@tag @tags
Feature: Revision del home 
	como usuario de la apliacion
	quiere revisar el home
	para observar que toda la informacion este disponible
	
	Background: ejecucion de la apliacion y realizar el inicio de sesion
	Given el usuario ve la pantalla principal de la app de banistmo y procede a realizar el inicio de sesion
	

@tag1	
Scenario: el usuario quiere visualizar el encabezado
	When el usuario busca el encabezado 
	Then el usuario deberia poder visualizar el encabezado en el home 

#@tag2	
#Scenario: el usuario quiere visualizar el resumen de productos
#	When el usuario busca la opcion de resumen de productos
#	Then el usuario deberia poder visualizar informacion de resumen de producto 
#
#@tag3	
#Scenario: el usuario quiere visualizar los saldos generales de Deposito de inversion
#	When el usuario busca la opcion de saldos generales Deposito de inversion
#	Then el usuario deberia poder visualizar informacion de Deposito e inversiones los cual deberian de coincidir con la opcion de resumen de productos
#
#@tag4	
#Scenario: el usuario quiere visualizar los saldos generales de Creditos prestamos
#	When el usuario busca la opcion de saldos generalesde Creditos prestamos
#	Then el usuario deberia poder visualizar informacion de saldos generales de Creditos y prestamos los cuales deberia de coincidir con la opcion de resumen de productos
#
#@tag5
#Scenario: el usuario quiere visualizar la opcion de tus productos
#	When el usuario busca la opcion de tus productos
#	Then el usuario deberia poder visualizar todas las opciones diferentes de sus productos
#
#@tag6
#Scenario: el usuario quiere navegar por la diferentes opciones de menu de transferencias
#	When el usuario se dirige al menu y elige la opcion de trsnaferencias
#	Then el usuario deberia poder navegar por las diferentes opciones del menu de trasnferencias
#
#@tag7
#Scenario: el usuario quiere navegar por la diferentes opciones de menu de pagos
#	When el usuario se dirige al menu y elige la opcion de pagos
#	Then el usuario deberia poder navegar por las diferentes opciones del menu de pagos
#
#@tag8
#Scenario: el usuario quiere navegar por la diferentes opciones de menu de recargas
#	When el usuario se dirige al menu y elige la opcion de recargas
#	Then el usuario deberia poder navegar por las diferentes opciones del menu de recargas
#	
#@tag9
#Scenario: el usuario quiere navegar por la diferentes opciones de menu de configuración
#	When el usuario se dirige al menu y elige la opcion de configuracion
#	Then el usuario deberia poder navegar por las diferentes opciones del menu de configuracion
#
#@tag10
#Scenario: el usuario quiere poder solicitar otro producto
#	When el usuario busca la opcion de solicitar otro producto
#	Then el usuario deberia poder ver la opcion de solicitar producto
#
#@tag11
#Scenario: el usuario quiere visualizar un resumen de sus productos por tipo
#	When el usuario busca la opcion de resumen de productos por tipo
#	Then el usuario deberia poder ver un resumen de sus productos por tipo
#
#@tag12
#Scenario: el usuario quiere visualizar que sus productos esten ordenados
#	When el usuario busca la opcion de tus productos para verlos por orden
#	Then el usuario deberia poder ver su productos oredenados de la forma Cuentas de deposito,Tarjetas de credito,Prestamos e Inversiones
#
#@tag13
#Scenario: el usuario quiere poder visualiza los productos asociados a un tipo de producto
#	When el usuario busca la opcion de tipo de producto
#	Then el usuario deberia poder ver los productos asociados a ese tipo de producto
#
#@tag14
#Scenario: el usuario quiere visualizar sus productos en forma de categoria
#	When el usuario busca la opcion de ver productos en forma de categoria
#	Then el usuario deberia poder ver su productos en forma de categoria
#
#@tag15
#Scenario: el usuario quiere visualizar sus productos en forma de lista
#	When el usuario busca la opcion de ver productos en forma de lista
#	Then el usuario deberia poder ver su productos en forma de lista
#	
#@tag16
#Scenario: el usuario quiere visualizar que la suma de todos los prodcutos sea igual al que se espeficia en el resumen
#	When el usuario visualiza todo los productos suma todas las cantidades
#	Then las suma de los productos debe de ser igual al resumen

