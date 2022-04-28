import static org.junit.Assert.*;
import org.junit.*;

public class Testare {
    //Polinom pol = new Polinom();

    @Test
    public void adunareTest() {
        Polinom p1 = new Polinom();
        Polinom p2 = new Polinom();

        p1.splitFunction("2x^3+5x^2+1x^1+4x^0");
        p2.splitFunction("2x^4+1x^3+3x^1+2x^0");

        Polinom rezCorect = new Polinom();
        rezCorect.splitFunction("2.0x^4+3.0x^3+5.0x^2+4.0x^1+6.0x^0");

        Polinom rez = new Polinom();
        rez = p1.adunare(p2);

        for(int i = 0; i< rezCorect.getPolinom().size(); i++) {
            assertEquals(rezCorect.getPolinom().get(i).getExp(), rez.getPolinom().get(i).getExp());
            assertEquals(rezCorect.getPolinom().get(i).getCoef(), rez.getPolinom().get(i).getCoef());
        }
    }

    @Test
    public void scadereTest() {
        Polinom p1 = new Polinom();
        Polinom p2 = new Polinom();

        p1.splitFunction("2x^4+1x^3+3x^1+2x^0");
        p2.splitFunction("2x^3+5x^2+1x^1+4x^0");

        Polinom rezCorect = new Polinom();
        rezCorect.splitFunction("2.0x^4-1.0x^3-5.0x^2+2.0x^1-2.0x^0");

        Polinom rez = new Polinom();
        rez = p1.scadere(p2);

        for(int i = 0; i< rezCorect.getPolinom().size(); i++) {
            assertEquals(rezCorect.getPolinom().get(i).getExp(), rez.getPolinom().get(i).getExp());
            assertEquals(rezCorect.getPolinom().get(i).getCoef(), rez.getPolinom().get(i).getCoef());
        }
    }

    @Test
    public void inmultireTest() {
        Polinom p1 = new Polinom();
        Polinom p2 = new Polinom();

        p1.splitFunction("2x^4+1x^3+3x^1+2x^0");
        p2.splitFunction("2x^3+5x^2+1x^1+4x^0");

        Polinom rezCorect = new Polinom();
        rezCorect.splitFunction("4.0x^7+12.0x^6+7.0x^5+15.0x^4+23.0x^3+13.0x^2+14.0x^1+8.0x^0");

        Polinom rez = new Polinom();
        rez = p1.inmultire(p2);

        for(int i = 0; i< rezCorect.getPolinom().size(); i++) {
            assertEquals(rezCorect.getPolinom().get(i).getExp(), rez.getPolinom().get(i).getExp());
            assertEquals(rezCorect.getPolinom().get(i).getCoef(), rez.getPolinom().get(i).getCoef());
        }
    }

    @Test
    public void derivareTest() {
        Polinom p1 = new Polinom();
        //Polinom p2 = new Polinom();

        p1.splitFunction("2x^4+1x^3+3x^1+2x^0");
        //p2.splitFunction("2x^3+5x^2+1x^1+4x^0");

        Polinom rezCorect = new Polinom();
        rezCorect.splitFunction("8.0x^3+3x^2+3x^0");

        Polinom rez = new Polinom();
        rez = p1.derivare();

        for(int i = 0; i< rezCorect.getPolinom().size(); i++) {
            assertEquals(rezCorect.getPolinom().get(i).getExp(), rez.getPolinom().get(i).getExp());
            assertEquals(rezCorect.getPolinom().get(i).getCoef(), rez.getPolinom().get(i).getCoef());
        }
    }

    @Test
    public void integrareTest() {
        Polinom p1 = new Polinom();
        //Polinom p2 = new Polinom();

        p1.splitFunction("2x^4+1x^3+3x^1+2x^0");
        //p2.splitFunction("2x^3+5x^2+1x^1+4x^0");

        Polinom rezCorect = new Polinom();
        rezCorect.splitFunction("0.4x^5+0.25x^4+1.5x^2+2.0x^1");

        Polinom rez = new Polinom();
        rez = p1.integrare();

        for(int i = 0; i< rezCorect.getPolinom().size(); i++) {
            assertEquals(rezCorect.getPolinom().get(i).getExp(), rez.getPolinom().get(i).getExp());
            assertEquals(rezCorect.getPolinom().get(i).getCoef(), rez.getPolinom().get(i).getCoef());
        }
    }

}
