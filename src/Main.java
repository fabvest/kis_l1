import Data.Subcontractor;
import GUI.MainDialog;

import java.util.ArrayList;

/**
 * Created by fab on 13.02.2017.
 */
public class Main {
    public static void main(String[] args) {
       ArrayList<Subcontractor> sub = new ArrayList<>();

//        for(int i = 0; i < 100; i++){
//            sub.add(new Subcontractor());
//            System.out.println(sub.get(i));
//
//        }

        MainDialog dialog = new MainDialog();
        dialog.pack();
        dialog.setVisible(true);
        //System.exit(0);
    }
}
