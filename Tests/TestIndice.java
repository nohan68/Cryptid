import Modele.Indice;
import Modele.Plateau;
import org.junit.Test;

public class TestIndice {

    @Test
    public void TestIndice(){
        Plateau p = new Plateau(12);
        Indice indice;
        for(int i=0; i<10;i++){
           indice = new Indice(p);
           System.out.println(indice);
        }


    }
}
