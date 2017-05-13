package Controller;

import Data.WorkValues;

import java.util.*;

import static GUI.ChooseDialog.TOTALS;

/**
 * Created by fab on 17.04.2017.
 */
public class FindFunc {
    private List<WorkValues> list;
    int[][] matrix = new int[8][8];
    int[][] matrixEnd;
    HashMap<Integer, Integer> values = new HashMap<>();

    public int[][] findTable(){
        getMatrix();
        return lastSteps(findLastM(findM()));
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
        int count;
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
            count = 0;
            int temp = 0;
            int[] tmpMas = new int[8];
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
                    for (b = 0; b < tmpMas.length; b++) {
                        if (min > tmpMas[b] && tmpMas[b] != 0) { //TODO смотреть ниже, переписать.
                            min = tmpMas[b];
                            temp = b;
                        }
                    }
                    if (sameValInMap(values, i, temp)) {
                        tmpMas[temp] += 100;
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
                }
            }
        }
        return matr;
    }

    //в данной части метода ищутся варианты для нулевых столбцов. в каждом нулевом столбце находятся минимумы, смотрится, есть
    //ли в массиве минимумов данное значение и, в случае если его нет добавляется, в другом случае ищится новое значение, которое больше
    //прошлого минимаьного, но меньше всех остальных
    private int[][] lastSteps(int matrl[][]){
        for(int i = 0; i < matrl.length; i++) {
            boolean flag = true;

            int sum = 0;
            int sum2 = 0;
            int[] tmpMas = new int[matrl.length];

            int temp1 = 0;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < matrl.length; j++) {
                sum += matrl[j][i];
                sum2 += matrl[i][j];
                tmpMas[j] = matrix[j][i];
            }
            if(sum == 0) {
                while (flag) {
                    for (int k = 0; k < matrl.length; k++){
                        if(tmpMas[k] < min){
                            min = tmpMas[k];
                            temp1 = k;
                        }
                    }
                    if(sameValInMap(values, i, temp1)){
                        tmpMas[temp1] = Integer.MAX_VALUE;
                        min = Integer.MAX_VALUE;
                    }else {
                        values.put(i, temp1);
                        matrl[temp1][i] = 1;
                        flag = false;
                    }
                }
            }
        }
        int s = 0;
        for(int i = 0; i < values.size(); i++){
            s += matrix[i][values.get(i)];
        }
        TOTALS = s;
        return matrl;
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
        boolean flag = false;
        for (Map.Entry<Integer, Integer> entry : val.entrySet()) {
            if(entry.getValue() == c){
                return true;
            }else flag = false;
        }
        return flag;
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

}
