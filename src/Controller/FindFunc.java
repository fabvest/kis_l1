package Controller;

import Data.WorkValues;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fab on 17.04.2017.
 */
public class FindFunc {
    private List<WorkValues> list;
    int[][] matrix;

    public FindFunc(List<WorkValues> list) {
        this.list = list;
    }

    private int[][] findM(){
        int[][] matrixEnd = new int[matrix.length][matrix.length];
        for(int i = 0; i < matrix.length; i++){
            int min = getMinM(i, matrix);
            for (int j = 0; j < matrix.length; i++){
                matrixEnd[i][j] = matrix[i][j] - min;
            }
        }
        return matrixEnd;
    }

    private int[][] findLastM(int[][] matr){
        int sum = 0;
        for(int i = 0; i < matr.length; i++){
            for (int j = 0; j < matr.length; j++) {
                if (matr[i][j] == 0) {
                    matr[i][j] = 1;
                } else matr[i][j] = 0;
            }
        }
        for(int i = 0; i < matr.length; i++){
            for (int j = 0; j < matr.length; j++) {
                sum += matr[j][i];
            }
            if(sum == 0){

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
