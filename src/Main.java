import Data.Subcontractor;
import GUI.MainDialog;

import java.util.ArrayList;

/**
 * Created by fab on 13.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        Subcontractor s = new Subcontractor();

        ArrayList<Subcontractor> sub = new ArrayList<>();

        for(int i = 0; i < 100; i++){
            sub.add(new Subcontractor());
            System.out.println(sub.get(i));

        }

        MainDialog dialog = new MainDialog(sub);
        dialog.pack();
        dialog.setVisible(true);
        //System.exit(0);
    }
}
