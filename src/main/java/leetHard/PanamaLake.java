package leetHard;

import java.util.*;
import java.util.stream.Collectors;

public class PanamaLake {


    public List<List<Integer>> pacificAtlantic(int[][] matrix) {

        if (matrix.length == 0 || matrix[0].length == 0)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Queue<String> qPacific = new LinkedList<>();
        Queue<String> qAtlantic = new LinkedList<>();

        int[][] dummyP = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix[0].length; i++) {
            dummyP[0][i] = 1;
            qPacific.add("0" + "," + i);
        }
        for (int i = 1; i < matrix.length; i++) {
            dummyP[i][0] = 1;
            qPacific.add("" + i + ",0");
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if ((matrix[i][j] >= matrix[i - 1][j] && dummyP[i - 1][j] == 1) || (matrix[i][j] >= matrix[i][j - 1] && dummyP[i][j - 1] == 1)) {
                    dummyP[i][j] = 1;
                    qPacific.add("" + i + "," + j);
                }
            }
        }

        int[][] dummyA = new int[matrix.length][matrix[0].length];
        int p = matrix.length - 1;
        for (int i = matrix[0].length - 1; i >= 0; i--) {
            dummyA[p][i] = 1;
            qAtlantic.add("" + p + "," + i);
        }
        int t = matrix[0].length - 1;
        for (int i = 0; i < matrix.length; i++) {
            dummyA[i][t] = 1;
            qAtlantic.add("" + i + "," + t);
        }
        for (int i = matrix.length - 2; i >= 0; i--) {
            for (int j = matrix[0].length - 2; j >= 0; j--) {
                if ((matrix[i][j] >= matrix[i + 1][j] && dummyA[i + 1][j] == 1) || (matrix[i][j] >= matrix[i][j + 1] && dummyA[i][j + 1] == 1)) {
                    dummyA[i][j] = 1;
                    qAtlantic.add("" + i + "," + j);
                }
            }
        }

        while (!qAtlantic.isEmpty()) {
            String str = qAtlantic.remove();
            if (qPacific.contains(str)) {
                List<String> strList = Arrays.asList(str.split(","));
                List<Integer> intList = strList.stream().map(Integer::parseInt).collect(Collectors.toList());
                result.add(intList);
            }
        }


        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        PanamaLake lake = new PanamaLake();
        lake.pacificAtlantic(matrix);
        System.out.println("Kundan");

    }
}
