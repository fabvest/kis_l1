package Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by fab on 17.04.2017.
 */
public class WorkValues {
    ArrayList<Integer> values;

    public WorkValues(){
        values = new ArrayList<>();
        Random r = new Random();

        for(int i = 0; i < 8; i++){
            values.add(r.nextInt(10) + r.nextInt(10) + 2);
        }
    }

    public WorkValues(ArrayList<Integer> values) {
        this.values = new ArrayList<>();
        this.values = values;
    }

    public int getValueWithIndex(int index) {
        return values.get(index);
    }

    public ArrayList<Integer> getValues() {
        return values;
    }

    public void setValues(ArrayList<Integer> values) {
        this.values = values;
    }
}
