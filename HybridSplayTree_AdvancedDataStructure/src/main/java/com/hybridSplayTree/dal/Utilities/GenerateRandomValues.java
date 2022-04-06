package com.hybridSplayTree.dal.Utilities;

import java.util.LinkedList;
import java.util.List;

public class GenerateRandomValues {

    private int countLowerBound = 10;
    private int countUpperBound = 50;
    private int valueLowerBound = countLowerBound*10;
    private int valueUpperBound = countUpperBound*1000;


    public List<Integer> newData = null;

    public GenerateRandomValues(){
        newData = new LinkedList<>();
    }

    public List<Integer> getNewData(){
        int count = ((int)(Math.random()*100000%(countUpperBound-countLowerBound+1)))+countLowerBound;

        for(int iter = 0; iter<count; iter++){

            int temp = ((int)(Math.random()*100000%(valueUpperBound-valueLowerBound+1)))+valueLowerBound;
            newData.add(temp);
        }

        return newData;

    }

}
