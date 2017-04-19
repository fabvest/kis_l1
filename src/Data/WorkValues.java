package Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by fab on 17.04.2017.
 */
public class WorkValues {
    List<Integer> values;

    public WorkValues(){
        values = new ArrayList<>();
        Random r = new Random();

        for(int i = 0; i < 8; i++){
            values.add(r.nextInt(10) + r.nextInt(10) + 2);
        }
    }

    public int getValueWithIndex(int index) {
        return values.get(index);
    }

    public List<Integer> getValues() {
        return values;
    }

    public void setValues(List<Integer> values) {
        this.values = values;
    }
}
