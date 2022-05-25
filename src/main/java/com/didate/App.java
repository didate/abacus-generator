package com.didate;

import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Parameter parameter = new Parameter(9, 5, 500,9,-9);
        AbacusGenerator sorobanOp =new AbacusGenerator(parameter);

		Map<Integer, List<Integer>> operations = sorobanOp.generateListOfOperation();

		for (List<Integer> operation : operations.values()) {
			operation.stream().forEach(operand ->{
                System.out.print(operand + ",");
            });
			System.out.println("");
		}
    }
}
