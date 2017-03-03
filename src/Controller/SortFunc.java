package Controller;

import Data.Criteria;
import Data.Reliability;
import Data.Subcontractor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class SortFunc {
    private List<Subcontractor> sub;
    private int count;

    public List<Subcontractor> sort(int time, int quality, int price, int opportunities, int saifty){
        int flag = flagWeight(time, quality, price, opportunities, saifty);
        return sortWithParams(findWeight(time, quality, price, opportunities, saifty, flag), flag);

    }

    public SortFunc() {
    }

    public SortFunc(List<Subcontractor> sub) {
        this.sub = sub;
    }

    public int flagWeight(int time, int quality, int price, int opportunities, int saifty) {
        int flag = 0;
        if ((time == quality) && (price == opportunities) && (saifty == time) && (time == price)) {
            switch (time) {
                case 1:
                    flag = 1;
                    break;
                case 2:
                    flag = 2;
                    break;
                case 3:
                    flag = 3;
                    break;
                case 4:
                    flag = 4;
                    break;
            }
        }else flag = 0;


        return flag;
    }

    public List<Double> findWeight ( int time, int quality, int price, int opportunities, int saifty, int flag){
            List<Double> doubles = new ArrayList<>();
            List<Double> notNormal = new ArrayList<>();
            List<Integer> integers = new ArrayList<>();
            integers.add(time);
            integers.add(quality);
            integers.add(price);
            integers.add(opportunities);
            integers.add(saifty);
            double temp;
            double sum = 0;

            if(flag == 0) {
                for (Integer integer : integers) {
                    temp = (integer.doubleValue() - 1.0) / (4.0 - 1.0) * 100.0;
                    notNormal.add(temp);
                }
                for (Double aaNotNormal : notNormal) {
                    sum += aaNotNormal;
                }
                for (Double aNotNormal : notNormal) {
                    temp = (aNotNormal / sum) * 100;
                    doubles.add(temp);
                }

                integers.clear();
                notNormal.clear();
                return doubles;
            }
            else {
                for(int i = 0; i < 5; i++){
                    doubles.add(i, 0.20);
                }
                return doubles;
            }
        }

    public List<Subcontractor> sortWithParams (List<Double> doubles, int flag) {
        Subcontractor s;
        Criteria c;
        Reliability r;
        List<Subcontractor> nSub = new ArrayList<>();

        if (flag == 0) {
            for (int i = 0; i < sub.size(); i++) {
                s = sub.get(i);
                c = s.getCriteria();
                r = s.getReliability();

                s.setRang(c.getTime() * doubles.get(0) + c.getQuality() * doubles.get(1) +
                        c.getPrice() * doubles.get(2) + c.getOpportunities() * doubles.get(3) +
                        r.getResult() * doubles.get(4));

                nSub.add(s);
            }

            nSub.sort((o1, o2) -> {
                if (o1.getRang() > o2.getRang()) return -1;
                if (o1.getRang() < o2.getRang()) return 1;
                else return 0;
            });

            return nSub;
        } else {
            return nSub;
        }
    }

        public List<Subcontractor> replaceList(List<Subcontractor> sub){
            List<Subcontractor> nSub = new ArrayList<>();
            //TODO replace
            return nSub;
        }
    }
