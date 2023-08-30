import org.example.AvionComercial;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class AvionComercialTest {
    @Test
    public void testVolar(){
        AvionComercial avionComercial = new AvionComercial(1000, 10);
        Assertions.assertEquals(100, avionComercial.volar(10));
    }

    @Test
    public void testGetConsumoCombustible(){
        AvionComercial avionComercial = new AvionComercial(1000, 10);
        Assertions.assertEquals(10, avionComercial.getConsumoCombustible());
    }
}
