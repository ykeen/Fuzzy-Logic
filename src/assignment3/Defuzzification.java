/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ghost
 */
public class Defuzzification {
    
     private ArrayList<Integer> trapezoidal = new ArrayList<Integer>(
            Arrays.asList(new Integer[]{0,1,1,0})
    );
    private ArrayList<Integer> triangular = new ArrayList<Integer>(
            Arrays.asList(new Integer[]{0,1,0})
    );
    double calculatePridectedCrispValue(ArrayList<Double> membership,ArrayList<ArrayList<Integer>> risk ){
        double sumMembership = 0 ;
        double sumFuzzyset = 0;
        ArrayList<Double> centriodvalues  = calculateCenteroidOSet(risk);
        for (int i = 0; i < centriodvalues.size(); i++) {
            sumMembership+= membership.get(i);
            sumFuzzyset += membership.get(i) *centriodvalues.get(i) ;
        }
       return sumFuzzyset/sumMembership ;
    }
    ArrayList<Double> calculateCenteroidOSet(ArrayList<ArrayList<Integer>> risk){
        ArrayList<Double> centriodvalues = new ArrayList<Double>();
        int sum ;
        for (int i = 0; i < risk.size(); i++) {
            sum = 0;
            for (int j = 0; j <risk.get(i).size(); j++) {
                sum+=risk.get(i).get(j);
            }
//            System.out.println("sum" + sum);
            centriodvalues.add(i, sum/(double)risk.get(i).size());
//            System.out.println("center = " + sum/(double)risk.get(i).size());
        }
        return centriodvalues ;
    }

//     ArrayList<Double> calculateCenteroidOSet(ArrayList<ArrayList<Integer>> risk){
//         ArrayList<Double> centriodvalues = new ArrayList<Double>();
//         double sum ,area;
//         int x1, x2 , y1 ,y2 ;
//         for (int i = 0; i <risk.size(); i++) {
//             sum = 0;
//             area =0;
//            for (int j = 0; j <risk.get(i).size()-1; j++) {
//                x1 = risk.get(i).get(j);
//                x2 = risk.get(i).get(j+1);
//                if(risk.get(i).size() == 4){ // triangular  or not
//                        y1 = trapezoidal.get(j);
//                        y2 = trapezoidal.get(j+1);
//                }else {
//                        y1 = triangular.get(j);
//                        y2 = triangular.get(j+1);
//                }
//                sum += (x1+x2)*((x1*y2)-(x2*y1));
//                area += ((x1*y2)-(x2*y1));
//            }
//             centriodvalues.add(i, (1/(6*0.5*area))*sum);
//        }
//         return centriodvalues ;
//     }
     
}
