package com.didate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AbacusGeneratorTest {

    Parameter parameter;

    @BeforeEach
    void setup(){
        parameter = new Parameter(9, 2, 1,9,-9);
    }

    @Test
    void verifierSommeAvecLaSommeInfOuEgalAuMax() {

        AbacusGenerator abacus = new AbacusGenerator(parameter);
        boolean isSommeGood = abacus.isSumOfTwoElementNoGreaterThanMaxSumOperation(3,6);
        assertEquals(true, isSommeGood);
    }

    @Test
    void verifierSommeAvecLaSommeSupOuEgalAuMax() {

        AbacusGenerator abacus = new AbacusGenerator(parameter);
        boolean isSommeGood = abacus.isSumOfTwoElementNoGreaterThanMaxSumOperation(6,6);
        assertEquals(false, isSommeGood);
    }


    @Test
    void obtenirUnNombreAleatoireDansBorne() {

        AbacusGenerator abacus = new AbacusGenerator(parameter);
        int nombre = abacus.getRandomNumber();
        assertTrue(nombre >=parameter.getBorneInferieur() && nombre <= parameter.getBorneSuperieur());
    }


    @Test
    void veriferSommeOperationfalse(){
        AbacusGenerator abacus = new AbacusGenerator(parameter);
        List<Integer> operation = new ArrayList<>(Arrays.asList(2,5,6));
        boolean isOkey = abacus.isSumOfOperationNoGreaterThanMaxSumOperation(operation, -1);
        assertEquals(false, isOkey);
    }

    @Test
    void veriferSommeOperationtrue1(){
        AbacusGenerator abacus = new AbacusGenerator(parameter);
        List<Integer> operation = new ArrayList<>(Arrays.asList(2,5));
        boolean isOkey = abacus.isSumOfOperationNoGreaterThanMaxSumOperation(operation, -1);
        assertEquals(true, isOkey);
    }

    @Test
    void veriferSommeOperationtrue2(){
        AbacusGenerator abacus = new AbacusGenerator(parameter);
        List<Integer> operation = new ArrayList<>(Arrays.asList(9,-1));
        boolean isOkey = abacus.isSumOfOperationNoGreaterThanMaxSumOperation(operation, -1);
        assertEquals(true, isOkey);
    }

    @Test
    void veriferSommeOperationfalse3(){
        AbacusGenerator abacus = new AbacusGenerator(parameter);
        List<Integer> operation = new ArrayList<>(Arrays.asList(6,1));
        boolean isOkey = abacus.isSumOfOperationNoGreaterThanMaxSumOperation(operation, -8);
        assertEquals(false, isOkey);
    }


    @Test
    void generateUneOperationAvecDeuxElement(){
        parameter.setNumberOfElement(3);
        AbacusGenerator abacus = new AbacusGenerator(parameter);
        List<Integer> operation = abacus.generateOneOperation();
        
        int size = operation.size();
        assertEquals(3, size);

        boolean isOkey = abacus.isSumOfOperationNoGreaterThanMaxSumOperation(operation, 0 );
        assertEquals(true, isOkey);

    }

    @Test
    void verifierDuplicationOk(){
        parameter.setNumberOfElement(3);
        AbacusGenerator abacus = new AbacusGenerator(parameter);
        List<Integer> operation = new ArrayList<>(Arrays.asList(6,1));
     
        boolean isOkey = abacus.verifyDuplication(operation, -8);
        assertEquals(true, isOkey);
    }

    @Test
    void verifierDuplicationNotOk(){
        parameter.setNumberOfElement(3);
        AbacusGenerator abacus = new AbacusGenerator(parameter);
        List<Integer> operation = new ArrayList<>(Arrays.asList(6,-8));
     
        boolean isOkey = abacus.verifyDuplication(operation, -8);
        assertEquals(false, isOkey);
    }
    
}
