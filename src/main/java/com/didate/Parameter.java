package com.didate;

public class Parameter {
   

    private int maxSommeElement;
    private int numberOfElement;
    private int numberOfOperation;
    private int borneSuperieur;
    private int borneInferieur;


    public Parameter(int maxSommeElement, int numberOfElement, int numberOfOperation, int borneSuperieur,
            int borneInferieur) {
        this.maxSommeElement = maxSommeElement;
        this.numberOfElement = numberOfElement;
        this.numberOfOperation = numberOfOperation;
        this.borneSuperieur = borneSuperieur;
        this.borneInferieur = borneInferieur;
    }
    public Parameter(int maxSommeElement, int numberOfElement, int numberOfOperation) {
        this.maxSommeElement = maxSommeElement;
        this.numberOfElement = numberOfElement;
        this.numberOfOperation = numberOfOperation;
    }

    public int getMaxSommeElement() {
        return maxSommeElement;
    }



    public void setMaxSommeElement(int maxSommeElement) {
        this.maxSommeElement = maxSommeElement;
    }



    public int getNumberOfElement() {
        return numberOfElement;
    }



    public void setNumberOfElement(int numberOfElement) {
        this.numberOfElement = numberOfElement;
    }



    public int getNumberOfOperation() {
        return numberOfOperation;
    }



    public void setNumberOfOperation(int numberOfOperation) {
        this.numberOfOperation = numberOfOperation;
    }



    public int getBorneSuperieur() {
        return borneSuperieur;
    }



    public void setBorneSuperieur(int borneSuperieur) {
        this.borneSuperieur = borneSuperieur;
    }



    public int getBorneInferieur() {
        return borneInferieur;
    }



    public void setBorneInferieur(int borneInferieur) {
        this.borneInferieur = borneInferieur;
    }


  
}
