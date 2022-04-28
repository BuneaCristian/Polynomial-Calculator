import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private View v;
    //private Polinom polinom = new Polinom();

    public Controller(View v) {
        this.v = v;
    }


    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == v.clear) {
            v.clearText();
        }

        if(source == v.adunare) {
            Polinom pol1 = new Polinom();
            Polinom pol2 = new Polinom();
            pol1.splitFunction(v.getPol1());
            pol2.splitFunction(v.getPol2());

            Polinom rezultat = new Polinom();
            rezultat = pol1.adunare(pol2);
            String rez = rezultat.afisare();
            System.out.println(rez);
            v.setRezultat(rez);

        }

        if(source == v.scadere) {
            Polinom pol1 = new Polinom();
            Polinom pol2 = new Polinom();
            pol1.splitFunction(v.getPol1());
            pol2.splitFunction(v.getPol2());

            Polinom rezultat = new Polinom();
            rezultat = pol1.scadere(pol2);
            String rez = rezultat.afisare();
            System.out.println(rez);
            v.setRezultat(rez);

        }

        if(source == v.inmultire) {
            Polinom pol1 = new Polinom();
            Polinom pol2 = new Polinom();
            pol1.splitFunction(v.getPol1());
            pol2.splitFunction(v.getPol2());

            Polinom rezultat = new Polinom();
            rezultat = pol1.inmultire(pol2);
            String rez = rezultat.afisare();
            System.out.println(rez);
            v.setRezultat(rez);

        }

        if(source == v.derivare) {
            Polinom pol1 = new Polinom();
            Polinom pol2 = new Polinom();
            pol1.splitFunction(v.getPol1());
            //pol2.splitFunction(v.getPol2());

            Polinom rezultat = new Polinom();
            rezultat = pol1.derivare();
            String rez = rezultat.afisare();
            System.out.println(rez);
            v.setRezultat(rez);

        }

        if(source == v.integrare) {
            Polinom pol1 = new Polinom();
            Polinom pol2 = new Polinom();
            pol1.splitFunction(v.getPol1());
            //pol2.splitFunction(v.getPol2());

            Polinom rezultat = new Polinom();
            rezultat = pol1.integrare();
            String rez = rezultat.afisare();
            System.out.println(rez);
            v.setRezultat(rez);

        }

    }
}
