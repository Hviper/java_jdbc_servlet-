package com.example;

import java.util.*;

/**
 * @author 拾光
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        len =  candidates.length;
        List<Integer> paths = new ArrayList<>();
        backing(target,0,candidates,paths);
        return res;
    }
    int len = 0;
    public void backing(int target,int sum,int[] candidates,List<Integer> paths){
        if(sum>target){
            return;
        }
        if(sum==target){
            res.add(new ArrayList(paths));
            return;
            //收集
        }
        for(int i=0;i<len;i++){
            paths.add(candidates[i]);
            backing(target,sum+candidates[i],candidates,paths);
            paths.remove(paths.size()-1);
        }

    }
}
