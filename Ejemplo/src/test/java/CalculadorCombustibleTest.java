import org.example.AvionComercial;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.example.CalculadorCombustible;
public class CalculadorCombustibleTest {
    @Test
    //testear el metodo calcularCombustible()
    public void testCalcularCombustible() {
        CalculadorCombustible calculadorCombustible = CalculadorCombustible.getInstance();
        int resultado = calculadorCombustible.calcularCombustible(new AvionComercial(100, 10), 10);
        int esperado = 100;
        Assert.assertEquals(esperado, resultado);
    }
}
