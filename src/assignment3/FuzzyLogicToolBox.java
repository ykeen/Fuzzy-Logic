/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.util.ArrayList;
import java.util.Arrays;

public class FuzzyLogicToolBox {
    private ArrayList<String> names ;
    private ArrayList<ArrayList<Integer> > alist ;
    private ArrayList<String> rules ;
    private ArrayList<Integer> memberships = new ArrayList<Integer>();

    public ArrayList<String> getNames() {
        return names;
    }

    public FuzzyLogicToolBox() {
        alist  = new ArrayList<ArrayList<Integer>>();
        names  = new ArrayList<String>();
        rules  = new ArrayList<String>();
    }
    public ArrayList<String> getRules() {
        return rules;
    }

    public ArrayList<ArrayList<Integer>> getAlist() {
        return alist;
    }
    public void add(String name,ArrayList<Integer>arr){
        alist.add(arr);
        names.add(name);
    }
    public void addRule(String rule){ 
        rules.add(rule);
    }
    @Override
    public String toString() {
        return "ProjectFunding{" +
                "alist=" + alist +
                '}';
    }


}
