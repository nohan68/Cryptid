import Modele.Indice;
import Modele.Plateau;
import org.junit.Test;

public class TestIndice {

    @Test
    public void TestIndice(){
        Plateau p = new Plateau(10);
        Indice i = new Indice(p);
        System.out.println(i);
    }
}
