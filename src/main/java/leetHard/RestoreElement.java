package leetHard;

import java.util.*;

public class RestoreElement {
   static List<Integer> visited=new ArrayList<>();
   static Map<Integer,List<Integer>> graph=new HashMap<>();
   static List<Integer> list=new ArrayList<>();
    public static void dfs(int u){
        if(visited.contains(u)) return;
        visited.add(u);

        List<Integer> adjacent=graph.get(u);
        if(adjacent!=null){
            for(Integer v:adjacent){
                dfs(v);
            }
        }
    }

    public static int[] restoreArray(int[][] adjacentPairs) {

        for(int i=0;i<adjacentPairs.length;i++){
            List<Integer> temp=graph.getOrDefault(adjacentPairs[i][0],new ArrayList<>());
            temp.add(adjacentPairs[i][1]);
            graph.put(adjacentPairs[i][0],temp);

            List<Integer> temp1=graph.getOrDefault(adjacentPairs[i][1],new ArrayList<>());
            temp1.add(adjacentPairs[i][0]);
            graph.put(adjacentPairs[i][1],temp1);

        }
        int startPoint=Integer.MAX_VALUE;
        for(Map.Entry<Integer,List<Integer>> entry:graph.entrySet())
        {
            if(entry.getValue().size()==1)
            {
                startPoint=entry.getKey();
                break;
            }
        }

        dfs(startPoint);

        int[] res=new int[visited.size()];
        for(int i=0;i<visited.size();i++)
            res[i]=visited.get(i);

        return res;


    }


    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        //int[][] adjacentPairs = {{2, 1}, {3, 4}, {3, 2}};
         int[][] adjacentPairs = {{4,-2},{1,4},{-3,1}};
        restoreArray(adjacentPairs);


    }
}
