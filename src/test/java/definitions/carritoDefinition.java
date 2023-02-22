package definitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import pageobjects.carritoPage;
import pageobjects.confirmacionPage;
import pageobjects.menuPage;
import pageobjects.pagarPage;
import pageobjects.tarjetaPage;

import static support.util.evidencias;

import java.io.IOException;

public class carritoDefinition {
    menuPage menu;
    tarjetaPage tarjeta;
    carritoPage carrito;
    pagarPage pagar;
    confirmacionPage confirmacion;

    public carritoDefinition() {
        menu = new menuPage();
        tarjeta = new tarjetaPage();
        carrito = new carritoPage();
        pagar = new pagarPage();
        confirmacion = new confirmacionPage();
    }
    @Dado("que la web esta operativa")
    public void queLaWebEstaOperativa() {
        hooks.driver.get("http://demo.guru99.com/payment-gateway/purchasetoy.php");
    }

    @Cuando("se genera el numero de tarjeta")
    public void seGeneraElNumeroDeTarjeta() throws IOException {
        menu.clickGenerarTargeta();
        menu.ventanaActiva();
        tarjeta.obtenerNroTarjeta();
        tarjeta.obtenerCVV();
        tarjeta.obtenerFecha();
        evidencias();
        tarjeta.ventanaInicial();
    }
    
    @Y("selecciona la cantidad {string}")
    public void seleccionaLaCantidad(String string) throws IOException {
        carrito.seleccionarCantidad(string);
        evidencias();
    }

    @Y("realiza la compra del producto")
    public void realizaLaCompraDelProducto() {
        carrito.clickComprar();
    }
    @Y("ingresa los datos de la tarjeta")
    public void ingresaLosDatosDeLaTarjeta() throws IOException  {
    	pagar.escribirNroTarjeta(tarjetaPage.nro_tarjeta);
        pagar.seleccionarMes(tarjetaPage.mes);
        pagar.seleccionarAnio(tarjetaPage.anio);
        pagar.escribirCVV(tarjetaPage.cvv);
        evidencias();
    }

    @Y("paga el producto")
    public void pagaElProducto() {
        pagar.scrollVertical();
        pagar.clickPagar();
    }
    
    @Entonces("validar el mensaje de pago {string}")
    public void validarElMensajeDePago(String string) throws IOException {
        confirmacion.validarMensaje(string);
        confirmacion.mostrarCodigo();
        evidencias();
    }
}
