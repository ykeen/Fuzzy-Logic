package assignment3;

import java.util.ArrayList;
import java.util.Arrays;


public class Fuzzification {
    private ArrayList<Double> membershipList = new ArrayList<Double>();
    private ArrayList<Integer> trapezoidal = new ArrayList<Integer>(
            Arrays.asList(new Integer[]{0,1,1,0})
    );
    private ArrayList<Integer> triangular = new ArrayList<Integer>(
            Arrays.asList(new Integer[]{0,1,0})
    );

    public ArrayList<Double> calculateMemberships(double crisp, ArrayList<ArrayList<Integer>> alist ){
        int x1,y1,x2,y2;
        double slop , membership, c;
        membershipList = new ArrayList<Double>();
        for (int i = 0; i < alist.size(); i++) {
            for (int j = 0; j <alist.get(i).size() -1; j++) {
                if( alist.get(i).get(j) <= crisp &&  alist.get(i).get(j+1) >= crisp){ // between two points
                    x1 = alist.get(i).get(j);
                    x2 = alist.get(i).get(j+1);
                    if(alist.get(i).size() == 4){ // triangular  or not
                        y1 = trapezoidal.get(j);
                        y2 = trapezoidal.get(j+1);
                    }else {
                        y1 = triangular.get(j);
                        y2 = triangular.get(j+1);
                    }
                    slop = (y2 - y1) / (double)(x2 - x1); // y = (slop)x + c;
//                    System.out.println("slop =" + slop);
                    c = y1 -(slop * x1) ;
//                    System.out.println("c =" + c);
                    membership = slop * crisp + c;
                    membershipList.add(membership);
                    break ;
                }
                // if all of the set elemet greater than or less than crisp value 
                else if (j == alist.get(i).size() -2 && (alist.get(i).get(j) > crisp &&  alist.get(i).get(j+1) > crisp || alist.get(i).get(j) < crisp &&  alist.get(i).get(j+1)< crisp))
                {
                     membershipList.add(0.0);
                }
            }
        }
        return this.membershipList;
    }

}
