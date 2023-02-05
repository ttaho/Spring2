package org.example;

import org.example.calculate.*;

import java.util.List;

public class Calculator {

    //enum 사용할떄
//    public static int calculate(int operand1, String operator, int operand2) {
//        return ArithmeticOperator.calculate(operand1, operator, operand2);
//    }
    //NewArithmeticOperator 인터페이스 사용할때
    private static final List<NewArithmeticOperator> arithmeticOperators = List.of(new AddOperator(), new SubOperator(), new MulOperator(), new DivOperator());

    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
        return arithmeticOperators.stream()
                .filter(arithmeticOperator -> arithmeticOperator.supports(operator))
                .map(arithmeticOperator -> arithmeticOperator.calculate(operand1, operand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}
