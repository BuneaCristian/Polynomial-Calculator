import java.util.*;
import java.lang.*;

public class Polinom{
    private ArrayList<Monom> polinom;

    public Polinom() {
    	this.polinom = new ArrayList<>();
    }

    public ArrayList<Monom> getPolinom() {
        return polinom;
    }

    public void setPolinom(ArrayList<Monom> polinom) {
        this.polinom = polinom;
    }
    
    public void splitFunction(String splitString) {
		splitString = splitString.replace("-","+-");
		String[] listaMonoame = splitString.split("\\+");
		String[] dateMonom = new String[2];

		for (String s : listaMonoame) {
			dateMonom = s.split("x\\^");
			double coef = Double.parseDouble(dateMonom[0]);
			int exp = Integer.parseInt(dateMonom[1]);
			Monom m = new Monom(exp, coef);
			this.polinom.add(m);
		}
	}

    public Polinom expEgali () {
    	Polinom Rez = new Polinom();
    	
    	for (Monom m1 : this.polinom) {
    		Double coef = 0.0;
    		
    		for (Monom m2 : this.polinom) {
    			if (!m2.isVis() && m1.getExp() == m2.getExp()) {
					m2.setVis(true);
    				coef = coef + m2.getCoef();
    			}
    		}
    		
    		if (coef != 0.0) {
    			Rez.polinom.add(new Monom(coef, m1.getExp()));
    		}
    	}

		for (Monom m : this.polinom){
			m.setVis(false);
		}
    	
    	return Rez;
    }
    
    public Polinom adunare(Polinom p2) {
    	Polinom Rez = new Polinom();

		//
    	Polinom p1 = this.expEgali();
		Collections.sort((List)p1.polinom);

		p2 = p2.expEgali();
		Collections.sort((List)p2.polinom);
    	
    	for (Monom m1 : p1.polinom) {
    		for (Monom m2 : p2.polinom) {
    			if (m1.getExp() == m2.getExp()) {
    				Rez.polinom.add(new Monom(m1.getCoef() + m2.getCoef(), m1.getExp()));
					m1.setVis(true);
					m2.setVis(true);
    			}
    		}
    	}

		for (Monom m1 : p1.polinom) {
			if(!m1.isVis()){
				Rez.polinom.add(new Monom(m1.getCoef(), m1.getExp()));
			}
			m1.setVis(false);
		}

		for (Monom m2 : p2.polinom) {
			if(!m2.isVis()){
				Rez.polinom.add(new Monom(m2.getCoef(), m2.getExp()));
			}
			m2.setVis(false);
		}

		Rez = Rez.expEgali();
		Collections.sort((List)Rez.polinom);
    	return Rez;
    }
    
    public Polinom scadere(Polinom p2) {
		Polinom polMinus = new Polinom();

		for(Monom m: p2.polinom){
			polMinus.polinom.add(new Monom(m.getExp(), -1.0 * m.getCoef()));
		}

		return this.adunare(polMinus);
    }
    
    Polinom inmultire(Polinom p) {
    	Polinom Rez = new Polinom();
    	
    	for (Monom m : this.polinom) {
    		for (Monom m2 : p.polinom) {
    			Rez.polinom.add(new Monom(m.getCoef() * m2.getCoef(), m.getExp() + m2.getExp()));
    		}
    	}
    	
    	Rez = Rez.expEgali();
		Collections.sort((List)Rez.polinom);
    	return Rez;
    }
    
    public Polinom derivare() {
    	Polinom Rez = new Polinom();
    	
    	for (Monom m : this.polinom) {
    		if (m.getExp() >= 1)
    		{
				Rez.polinom.add(new Monom(m.getCoef() * m.getExp(), m.getExp() - 1));
    		}
    	}

		Rez = Rez.expEgali();
		Collections.sort((List)Rez.polinom);
    	return Rez;
    }
    
    public Polinom integrare() {
    	Polinom Rez = new Polinom();
    	
    	for (Monom m : this.polinom) {
    		Rez.polinom.add(new Monom(m.getCoef() / (m.getExp() + 1), m.getExp() + 1));
    	}

		Rez = Rez.expEgali();
		Collections.sort((List)Rez.polinom);
    	return Rez;
    }

    @Override
    public String toString() {
        return "Polinom{" +
                "polinom=" + polinom +
                '}';
    }

	public String afisare() {
		String s="";
		for(Monom monom : polinom) {
			s = s+monom.getCoef() + "x^" + monom.getExp() + "+";
		}
		return s;
	}
}
