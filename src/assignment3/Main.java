/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        double projectFunding = 50, experianceLevel = 40;
        Fuzzification fuzzification = new Fuzzification();
        Defuzzification defuzzification = new Defuzzification();
        Inference inference = new Inference();
        FuzzyLogicToolBox PF = new FuzzyLogicToolBox();
        PF.add("very low",new ArrayList<Integer> (Arrays.asList(new Integer[]{0,0,10,30})));
        PF.add("low" ,new ArrayList<Integer> (Arrays.asList(new Integer[]{10,30,40,60})));
        PF.add("medium" ,new ArrayList<Integer> (Arrays.asList(new Integer[]{40,60,70,90})));
        PF.add("high" ,new ArrayList<Integer> (Arrays.asList(new Integer[]{70,90,100,100})));

        FuzzyLogicToolBox  TEL = new FuzzyLogicToolBox();
        TEL.add("beginner" ,new ArrayList<Integer> (Arrays.asList(new Integer[]{0,15,30})));
        TEL.add("intermediate",new ArrayList<Integer> (Arrays.asList(new Integer[]{15,30,45})));
        TEL.add("expert",new ArrayList<Integer> (Arrays.asList(new Integer[]{30,60,60})));

        FuzzyLogicToolBox risk = new FuzzyLogicToolBox();
        risk.add("high" ,new ArrayList<Integer> (Arrays.asList(new Integer[]{0,25,50})));
        risk.add("normal",new ArrayList<Integer> (Arrays.asList(new Integer[]{25,50,75})));
        risk.add("low",new ArrayList<Integer> (Arrays.asList(new Integer[]{50,100,100})));
        
        risk.addRule("high or expert = low");
        risk.addRule("medium and intermediate or beginner = normal");
        risk.addRule("verylow = high");
        risk.addRule("low and beginner = high");

        ArrayList<Double> membershipPF = fuzzification.calculateMemberships(projectFunding,PF.getAlist());
        ArrayList<Double> membershipTEL = fuzzification.calculateMemberships(experianceLevel,TEL.getAlist());
        ArrayList<Double> membershipRules =inference.calculateMembership(membershipPF, membershipTEL);
        double pridectedValue = defuzzification.calculatePridectedCrispValue(membershipRules, risk.getAlist());
        ArrayList<Double> membershipOutput = fuzzification.calculateMemberships(pridectedValue,risk.getAlist());
        int indexOfMax = 0;
        for (int i = 0; i < membershipOutput.size() -1; i++) {
           if(membershipOutput.get(i)> membershipOutput.get(i+1)){
               indexOfMax= i;
           }
           else{
               indexOfMax=i+1;
           }
        }
        System.out.println("memberships Of Project Funding = " + membershipPF);
        System.out.println("memberships Of Team Experience Level = " + membershipTEL);
        System.out.println("memberships of Risk = " + membershipOutput);
        System.out.println("Predicted Value = "+pridectedValue);
        System.out.println("Risk will be "+ risk.getNames().get(indexOfMax));
        
        
        
    }
}
