import org.example.AvionPrivado;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AvionPrivadoTest {
    @Test
    public void volarTest(){
        //Instancio el avion
        AvionPrivado avionPrivado = new AvionPrivado(1000, 10);

        //Testeo su cantidad de combustible necesaria
        Assertions.assertEquals(600,avionPrivado.volar(10));
    }
}
