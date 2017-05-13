package Controller;

import Data.WorkValues;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static GUI.ChooseDialog.TOTALS;

/**
 * Created by fab on 17.04.2017.
 */
public class FindFunc {
    private List<WorkValues> list;
    int[][] matrix = new int[8][8];
    int[][] matrixEnd;

    public int[][] findTable(){
        getMatrix();
        return findLastM(findM());
    }

    public FindFunc(List<WorkValues> list) {
        this.list = list;
    }
    /* В данном методе производится поиск минимальных значений в кажой строке матрицы
    и вычитание данного значения из этой строчки
       В результате получается матрица со строками, где на месте минимумв стоят нули
     */
    private int[][] findM(){
        matrixEnd = new int[8][8];
        for(int i = 0; i < matrix.length; i++){
            int min = getMinM(i, matrix);
            for (int j = 0; j < matrix.length; j++){
                matrixEnd[i][j] = matrix[i][j] - min;
            }
        }
        return matrixEnd;
    }
    /*
    В данном методе матрица, которая пришла из метода findM
     */
    private int[][] findLastM(int[][] matr){
        HashMap<Integer, Integer> values = new HashMap<>();
        int sum = 0;
        int tmp = 0;
        int s = 0;
        int[] tmpMas = new int[8];
        int count = 0;
        //Матрица заполняется еденицами или нулями: 0 -> 1, !0 -> 0
        for(int i = 0; i < matr.length; i++){
            for (int j = 0; j < matr.length; j++) {
                if (matr[i][j] == 0) {
                    matr[i][j] = 1;
                } else matr[i][j] = 0;
            }
        }
        //Если в столбце есть 1, то она записывается в tmpMas и далее, если значение не одно, ищется меньшее
        //из значений. Далее значение помещается в мап, потом проверяется, есть ли в мапе такие же значения
        //если такие значения уже есть, то данные не заносятся, а столбец обнуляется.
        for(int i = 0; i < matr.length; i++) {
            int temp = 0;
            for (int j = 0; j < matr.length; j++) {
                if (matr[j][i] == 1) {
                    tmpMas[j] = matrix[j][i];
                    count++;
                }
            }
            if(count>1) {
                int min = Integer.MAX_VALUE;
                boolean flag = true;
                int b;
                while (flag) {
                    for (b = 1; b < tmpMas.length; b++) {
                        if (min > tmpMas[b] && tmpMas[b] != 0) { //TODO смотреть ниже, переписать.
                            min = tmpMas[b];
                            temp = b;
                        }else tmpMas[b] = Integer.MAX_VALUE;
                    }
                    if (sameValInMap(values, i, temp)) {
                        temp = 9;
                        tmpMas[b] = Integer.MAX_VALUE;
                        min = Integer.MAX_VALUE;
                    } else {
                        flag = false;
                        values.put(i, temp);
                    }
                }
            }
            if(count == 1){
                int min = Integer.MAX_VALUE;
                boolean flag = true;
                int b;
                while (flag) {
                    for (b = 0; b < tmpMas.length; b++) {
                        if (min > tmpMas[b] && tmpMas[b] != 0) { //TODO смотреть ниже, переписать. проблема в том, что первое знаечение
                            //большинстве случаев = 0, и соответственно, каждое следующее ненулевое значение будет всегда
                            //больше. нужно инициализировать все значения максимальным интом, а те, которые присваиваются в ифе - из матрицы
                            min = tmpMas[b];
                            temp = b;
                        }
                    }
                    if (sameValInMap(values, i, temp)) {
                        temp = 9;
                        flag = false;
                    } else{
                        flag = false;
                        values.put(i, temp);
                    }
                }
            }
            for (int q = 0; q < tmpMas.length; q++) {
                if (q != temp) {
                    matr[q][i] = 0;
                    tmpMas[q] = 0;
                }
            }
            tmpMas[temp]=0;
        }
        //в данной части метода ищутся варианты для нулевых столбцов. в каждом нулевом столбце находятся минимумы, смотрится, есть
        //ли в массиве минимумов данное значение и, в случае если его нет добавляется, в другом случае ищится новое значение, которое больше
        //прошлого минимаьного, но меньше всех остальных
        for(int i = 0; i < matr.length; i++) {
            boolean flag = true;
            int temp1 = 0;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < matr.length; j++) {
                sum += matr[j][i];
                tmpMas[j] = matrix[j][i];
            }
            if(sum == 0) {
                while (flag) {
                    for (int k = 0; k < matr.length; k++){
                        if(tmpMas[k] > min){
                            min = tmpMas[k];
                            temp1 = k;
                        }
                    }
                    if(sameValInMap(values, i, temp1)){
                        tmpMas[temp1] = Integer.MAX_VALUE;
                        min = Integer.MAX_VALUE;
                    }else {
                        values.put(i, temp1);
                        matr[temp1][i] = 1;
                        flag = false;
                    }
                }
                for(Integer x : tmpMas){
                    x = 0;
                }
            }
        }
        for(int i = 0; i < values.size(); i++){
            s += matrix[i][values.get(i)];
        }
        TOTALS = s;
        return matr;
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
            w = this.list.get(i);
            for (int j = 0; j < this.list.size(); j++){
                matrix[i][j] = w.getValueWithIndex(j);
            }
        }
    }

//    private void setMatrix(){
//        ArrayList<WorkValues> finalList = new ArrayList<>();
//        for(int i = 0; i < 8; i++){
//            WorkValues w = new WorkValues();
//            for(int j = 0; j < 8; j++){
//
//            }
//        }
//    }

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
