package Data;

import java.util.Random;

/**
 * Created by fab on 26.02.2017.
 */
public class Reliability {
    private int id;
    private int lawsuits;
    private int customers;
    private int timeOnTheMarket;
    private int failures;

    public double getResult(){
        return this.lawsuits * 0.25 + this.failures * 0.25 + this.timeOnTheMarket * 0.25 + this.customers * 0.25;
    }

    public Reliability() {
        Random r = new Random();

        this.lawsuits = r.nextInt(4) + 1;
        this.customers = r.nextInt(4) + 1;
        this.failures = r.nextInt(4) + 1;
        this.timeOnTheMarket = r.nextInt(4) + 1;
    }

    public Reliability(int lawsuits, int customers, int timeOnTheMarket, int failures) {
        this.lawsuits = lawsuits;
        this.customers = customers;
        this.timeOnTheMarket = timeOnTheMarket;
        this.failures = failures;
    }

    public Reliability(int id, int lawsuits, int customers, int timeOnTheMarket, int failures) {
        this.id = id;
        this.lawsuits = lawsuits;
        this.customers = customers;
        this.timeOnTheMarket = timeOnTheMarket;
        this.failures = failures;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLawsuits() {
        return lawsuits;
    }

    public void setLawsuits(int lawsuits) {
        this.lawsuits = lawsuits;
    }

    public int getCustomers() {
        return customers;
    }

    public void setCustomers(int customers) {
        this.customers = customers;
    }

    public int getTimeOnTheMarket() {
        return timeOnTheMarket;
    }

    public void setTimeOnTheMarket(int timeOnTheMarket) {
        this.timeOnTheMarket = timeOnTheMarket;
    }

    public int getFailures() {
        return failures;
    }

    public void setFailures(int failures) {
        this.failures = failures;
    }
}
