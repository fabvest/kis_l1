package Data;

import java.util.Random;

/**
 * Created by fab on 14.02.2017.
 */
public class Subcontractor {
    private int id;
    private double rang;

    public double getRang() {
        return rang;
    }

    public void setRang(double rang) {
        this.rang = rang;
    }

    private String name;
    private Criteria criteria;
    private Reliability reliability;

    public Subcontractor() {
        Random r = new Random();
        this.name = String.valueOf(r.nextInt());
        reliability = new Reliability();
        criteria = new Criteria();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Criteria getCriteria() {
        return criteria;
    }

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    public Reliability getReliability() {
        return reliability;
    }

    public void setReliability(Reliability reliability) {
        this.reliability = reliability;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
