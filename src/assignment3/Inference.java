package assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//and max
//or  min
public class Inference {
    private ArrayList<Double> newMembership = new ArrayList<Double>();
    
    ArrayList<Double> AppylyRules(ArrayList<String> rules,ArrayList<Double> PFmembership ,ArrayList<Double> TELmembership){
        ArrayList<ArrayList<String>> splitedrules = splitedRules(rules);
        for (int i = 0; i <splitedrules.size()-1; i++) {
            ArrayList<Integer> indices = returnIndices(splitedrules.get(i));
                if(splitedrules.get(i).contains("and")){
                    newMembership.add(Math.max(PFmembership.get(indices.get(0)),TELmembership.get(indices.get(1))));
                }
                else{
                    newMembership.add(Math.min(PFmembership.get(indices.get(0)),TELmembership.get(indices.get(1))));
                }
        }
        return newMembership;
    }
    ArrayList<Integer> returnIndices(ArrayList<String> rule){
        ArrayList<Integer> indices = new ArrayList<Integer>() ;
        for (int i = 0; i < rule.size()-1; i++) {
            if (!(rule.get(i).equals("and")||rule.get(i).equals("or")) ){
                indices.add(i);
            }
            if (!(rule.get(i).equals("and")&& rule.get(i).equals("or"))) {
                
            }
        }
        return indices ;
    }
    ArrayList<ArrayList<String>> splitedRules(ArrayList<String> rules){
          ArrayList<ArrayList<String>> alist = new ArrayList<ArrayList<String>>();
          ArrayList<String> splitedRule;
          for (int i = 0; i < rules.size(); i++) {
            splitedRule = new ArrayList<String>();
            String[] rule =  rules.get(i).split("\\s");
              for (int j = 0; j < rule.length; j++) {
//                  System.out.println("rule " + rule[j]);
                  if(!rule[j].equals("=")){
                      splitedRule.add(rule[j]);
//                      System.out.println("splitedRule " + splitedRule);
                  }
              }
               alist.add(i, splitedRule);
          }
         return alist ; 
    }
    public ArrayList<Double> calculateMembership(ArrayList<Double> PFmembership ,ArrayList<Double> TELmembership){
        newMembership.add(Math.max(Math.min(PFmembership.get(1),TELmembership.get(0)),PFmembership.get(0))); // forth rule
        newMembership.add(
                Math.max(
                        TELmembership.get(0),
                    Math.min(PFmembership.get(2),TELmembership.get(1))
                )
        );
        newMembership.add(Math.max(PFmembership.get(3), TELmembership.get(2))) ;// first rule
        
          // second rule
//        newMembership.add(PFmembership.get(0)); // third rule ??
        
        return this.newMembership;
    }


}
