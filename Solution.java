import java.io.*;
import java.util.*;
import java.lang.Math;


public class Solution {

    private static void getMaxAdditionalDinersCountDriver() {
        Cafeteria solution = new Cafeteria();
        long N = 10;
        long K = 1;
        int  M = 2;
        long[] S = { 2, 6 };
        long result = solution.getMaxAdditionalDinersCount(N, K, M, S);
        System.out.println(result);
    }

    private static void PhotographerDriver() {
        Photographer P = new Photographer();
        String[] s = { "APABA", "APABA", ".PBAAP.B" };
        int[] X = { 1, 2, 1 };
        int[] Y = { 2, 3, 3 };
        for (int i=0; i<s.length; i++) {
            long r = P.getArtisticPhotographCount(s[i].length(), s[i], X[i], Y[i]);
            System.out.printf("%s [%d-%d]: %d", s[i], X[i], Y[i], r);
            System.out.println();
        }
    }

    private static void KaitenzushiDriver() {
        Kaitenzushi K = new Kaitenzushi();
        int[][] Ds = {{1,2,3,3,2,1}, {1,2,3,3,2,1}, {1,2,1,2,1,2,1}};
        int[] Ks = {1,2,2};
        for (int i=0; i<Ds.length; i++) {
            int result = K.getMaxDishes(Ds[i].length, Ds[i], Ks[i]);
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        PhotographerDriver();
    }


}


