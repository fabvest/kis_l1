package Controller;

import Data.Criteria;
import Data.Reliability;
import Data.Subcontractor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fab on 14.02.2017.
 */
public class SortFunc {
    private List<Subcontractor> sub;
    private int count;



    public SortFunc(List<Subcontractor> sub) {
        this.sub = sub;
    }

    public List<Subcontractor> sortWithParams(int time, int quality, int price, int opportunities, int saifty){
        Subcontractor s;
        Criteria c;
        Reliability r;
        List<Subcontractor> nSub = new ArrayList<>();

        for(int i = 0; i < sub.size(); i++){
            s = sub.get(i);
            c = s.getCriteria();
            r = s.getReliability();





        }



        return nSub;
    }
}
