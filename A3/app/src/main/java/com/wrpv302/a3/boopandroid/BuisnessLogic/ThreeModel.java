package com.wrpv302.a3.boopandroid.BuisnessLogic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreeModel {
   public boolean Contains = false;
   List<List<Integer[]>> Threes;

   public static boolean CheckDuplicateThree(ThreeModel model, List<Integer[]> list) {
      List<List<Integer[]>> Big = model.Threes;
      boolean temp = false;
      for (int i = 0; i < Big.size(); i++) {
         List<Integer[]> big = Big.get(i);
         //List<Integer[]> Cbig = new ArrayList(big);
         //List<Integer[]> Clist = new ArrayList(list);
         if(big.contains(list))
            return true;
      }
      return false;
   }
}
