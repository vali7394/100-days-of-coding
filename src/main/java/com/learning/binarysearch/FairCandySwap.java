package com.learning.binarysearch;

import java.util.Arrays;

public class FairCandySwap {

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int[] result = new int[2];
        if(aliceSizes==null || bobSizes==null || (aliceSizes.length==0 && bobSizes.length==0)) {
            return result;
        }

        int aliceCandies = sum(aliceSizes);
        int bobCandies = sum(bobSizes);

        if(aliceCandies==bobCandies){
            return result;
        }


        return result;
    }

    private int sum(int[] input){
        return Arrays.stream(input)
                .reduce((a,b)->(a+b)).getAsInt();
    }
}
