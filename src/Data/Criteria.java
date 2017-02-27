package Data;

import java.util.Random;

/**
 * Created by fab on 26.02.2017.
 */
public class Criteria {
    private int id;
    private int price;
    private int quality;
    private int opportunities;
    private int time;

    public Criteria() {
        Random r = new Random();

        this.price = r.nextInt(4) + 1;
        this.quality = r.nextInt(4) + 1;
        this.opportunities = r.nextInt(4) + 1;
        this.time = r.nextInt(4) + 1;
    }

    public Criteria(int price, int quality, int opportunities, int time) {
        this.price = price;
        this.quality = quality;
        this.opportunities = opportunities;
        this.time = time;
    }

    public Criteria(int id, int price, int quality, int opportunities, int time) {
        this.id = id;
        this.price = price;
        this.quality = quality;
        this.opportunities = opportunities;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getOpportunities() {
        return opportunities;
    }

    public void setOpportunities(int opportunities) {
        this.opportunities = opportunities;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
