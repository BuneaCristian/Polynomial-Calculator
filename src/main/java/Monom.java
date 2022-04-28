import java.util.Comparator;

public class Monom implements Comparable<Monom> {
    private Integer exp;
    private Double coef;
    private boolean vis;

    public Monom(Integer exp, Double coef) {
        this.exp = exp;
        this.coef = coef;
        this.vis = false;
    }

    public Monom(Double coef,Integer exp) {
        this.exp = exp;
        this.coef = coef;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        exp = exp;
    }

    public Double getCoef() {
        return coef;
    }

    public void setCoef(Double coef) {
        coef = coef;
    }

    public boolean isVis() {
        return vis;
    }

    public void setVis(boolean vis) {
        this.vis = vis;
    }

    @Override
    public String toString() {
        return "Monom{" +
                "exp=" + exp +
                ", coef=" + coef +
                '}';
    }

    @Override
    public int compareTo(Monom o) {
        return o.getExp() - this.getExp();
    }
}
