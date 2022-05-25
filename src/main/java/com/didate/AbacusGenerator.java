package com.didate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AbacusGenerator {

    

    private Parameter parameter;

    public AbacusGenerator(Parameter parameter) {
        this.parameter = parameter;
    }

    public Map<Integer, List<Integer>> generateListOfOperation(){
        Map<Integer, List<Integer>> listDesOperations = new HashMap<>();

        for (int i = 0; i < parameter.getNumberOfOperation(); i++) {
            listDesOperations.put(i+1, generateOneOperation());
        }

        return listDesOperations;
    }

    public List<Integer> generateOneOperation(){
        List<Integer> operation = new ArrayList<>();
        int unNombre = getRandomNumber();

        for (int i = 0; i < parameter.getNumberOfElement(); i++) {
            while(!isSumOfOperationNoGreaterThanMaxSumOperation(operation, unNombre) || !verifyDuplication(operation, unNombre)){
                unNombre = getRandomNumber();
            }
            operation.add(unNombre);
        }
        return operation;
    }

    public boolean isSumOfOperationNoGreaterThanMaxSumOperation(List<Integer> noperation, int unNombre){
        
        List<Integer> operation = new ArrayList<>(noperation);
        operation.add(unNombre);
        if(operation.size() > 1){
            int somme = 0;
            for (int i = 0; i < operation.size(); i++) {
                somme += operation.get(i);
                if(!isElementNoGreaterThanMaxSumOperation(somme)){
                    return false;
                }
            }
            return true;
        }else{
            return isElementNoGreaterThanMaxSumOperation(unNombre);
        }
    }


    public boolean isSumOfTwoElementNoGreaterThanMaxSumOperation(int element1, int element2) {
        return element1 + element2 <= parameter.getMaxSommeElement() && element1 + element2>0;
    }
    public boolean isElementNoGreaterThanMaxSumOperation(int element1) {
        return element1  <= parameter.getMaxSommeElement() && element1 >0;
    }

    public boolean verifyDuplication(List<Integer> noperation, int unNombre){
        int numberOfDuplication =0;
        List<Integer> operation = new ArrayList<>(noperation);
        operation.add(unNombre);

        for (Integer item : operation) {
            if(item == unNombre){
                numberOfDuplication++;
            }
        }
        
        return numberOfDuplication <= parameter.getNumberOfElement()/2;
    }

    public int getRandomNumber() {
        Random r = new Random();
        int randomNumber = r.nextInt(parameter.getBorneSuperieur()-parameter.getBorneInferieur()) + parameter.getBorneInferieur();
        while(randomNumber ==0){
            randomNumber = r.nextInt(parameter.getBorneSuperieur()-parameter.getBorneInferieur()) + parameter.getBorneInferieur();
        }
        return randomNumber;
    }

   
    

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }
}
