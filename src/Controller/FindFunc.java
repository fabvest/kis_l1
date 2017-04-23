package Controller;

import Data.WorkValues;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by fab on 17.04.2017.
 */
public class FindFunc {
    private List<WorkValues> list;
    int[][] matrix;
    int[][] matrixEnd;

    public FindFunc(List<WorkValues> list) {
        this.list = list;
    }

    private int[][] findM(){
        matrixEnd = new int[matrix.length][matrix.length];
        for(int i = 0; i < matrix.length; i++){
            int min = getMinM(i, matrix);
            for (int j = 0; j < matrix.length; i++){
                matrixEnd[i][j] = matrix[i][j] - min;
            }
        }
        return matrixEnd;
    }

    private int[][] findLastM(int[][] matr){
        HashMap<Integer, Integer> values = new HashMap<>();
        int sum = 0;
        int tmp = 0;
        int[] tmpMas = new int[8];
        for(int i = 0; i < matr.length; i++){
            for (int j = 0; j < matr.length; j++) {
                if (matr[i][j] == 0) {
                    matr[i][j] = 1;
                } else matr[i][j] = 0;
            }
        }
        for(int i = 0; i < matr.length; i++){
            for (int j = 0; j < matr.length; j++) {
                if(matr[j][i] == 1){
                    tmpMas[j] = matrixEnd[j][i];
                }
                //sum += matr[j][i];
            }
            int min = tmpMas[0];
            for(int c = 1; c < tmpMas.length; c++){
                if(min > tmpMas[c]){
                    min = tmpMas[c];
                    tmp = c;
                    values.put(i, c);
                    if(sameValInMap(values, i, c)){
                        values.remove(i);
                        tmp = 9;
                    }else break;
                }else {
                    values.put(i, 0);
                    if(sameValInMap(values, i, 0)){
                        values.remove(i);
                        tmp = 9;
                    }else break;
                }
            }
            for(int q = 0; q < tmpMas.length; q++){
                if(q != tmp){
                    matr[q][i] = 0;
                }
            }

        }
    }

    private int getMinM(int i, int[][] mtx){
        int min = mtx[i][0];
        for (int j = 1; j < mtx.length; j++){
            if(min > mtx[i][j]){
                min = mtx[i][j];
            }
        }
        return min;
    }

    private boolean sameValInMap(HashMap<Integer, Integer> val, int i, int c){
        if(val.size() > 1){
            for(int it = 0; it < val.size(); it++){
                if(i != it){
                    if(val.get(it) == c){
                        return true;
                    }else return false;
                }
            }
        }else return false;
        return false;
    }

    private void getMatrix(){
        WorkValues w;
        for(int i = 0; i < this.list.size(); i++){
            w = list.get(i);
            for (int j = 0; j < this.list.size(); j++){
                matrix[i][j] = w.getValueWithIndex(j);
            }
        }
    }

    public ArrayList<WorkValues> find(){
        ArrayList<WorkValues> newList = new ArrayList<>();
        WorkValues w;
        for(int i = 0; i < list.size(); i++){
            ArrayList<Integer> integers = new ArrayList<>();
            w = list.get(i);
            int min = getMin(w.getValues());
            for (int j = 0; j < w.getValues().size(); j++){
                integers.add(w.getValueWithIndex(j) - min);
            }
            newList.add(new WorkValues(integers));
        }
        return newList;
    }

    private int getMin(ArrayList<Integer> list){
        int min = list.get(0);
        for(int i = 1; i < list.size(); i++){
            if(min > list.get(i)){
                min = list.get(i);
            }
        }
        return min;
    }

//    private ArrayList<WorkValues> findLast(ArrayList<WorkValues> list){
//        WorkValues w;
//        ArrayList<WorkValues> lastList = new ArrayList<>();
//        for(int i = 0; i < list.size(); i++) {
//            w = list.get(i);
//
//        }
//    }
}
