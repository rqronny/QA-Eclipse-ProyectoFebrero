# language: es
@primeraFuncionalidad
Característica: Funcionalidad del carrito de compras
@smoke
Escenario: Compra de un productazo
  Dado que la web esta operativa
  Cuando se genera el numero de tarjeta
  Y selecciona la cantidad "5"
  Y realiza la compra del producto
  Y ingresa los datos de la tarjeta
  Y paga el producto
  Entonces validar el mensaje de pago "Payment successfull!"

@regresion
  	Esquema del escenario: Compra de un producto con varias cantidades
    Dado que la web esta operativa
    Cuando se genera el numero de tarjeta
    Y selecciona la cantidad "<cantidad>"
    Y realiza la compra del producto
    Y ingresa los datos de la tarjeta
    Y paga el producto
  Entonces validar el mensaje de pago "<mensaje>"
    Ejemplos: Tabla de cantidades
    |cantidad|mensaje|
    |4       |Payment successfull!|
    |6       |Payment successfull!|
    |8       |Payment successfull!|