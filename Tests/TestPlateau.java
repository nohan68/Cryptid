import Modele.Plateau;
import org.junit.Assert;
import org.junit.Test;

public class TestPlateau {
    @Test
    public void testCreerPlateau(){
        Plateau p = new Plateau(12);
        Assert.assertEquals(p.getTaille(), 12);
    }
}
