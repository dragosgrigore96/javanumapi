package homework.impl.operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import homework.interfaces.IToken;
import homework.interfaces.operators.IOperator;
import homework.interfaces.operators.IOperatorsFactory;

public final class OperatorsFactory implements IOperatorsFactory {

private static OperatorsFactory instance = null;

public static OperatorsFactory getInstance() {
if (instance == null) {
instance = new OperatorsFactory();
}
return instance;
}

private List<String> unarySymbols = new ArrayList<>();
private List<String> binarySymbols = new ArrayList<>();

private OperatorsFactory() {
binarySymbols.addAll(Arrays.asList(new String[]{"+", "-", "/", "*", "^"}));
unarySymbols.addAll(Arrays.asList(new String[] {"log", "sqrt"}));
}


/**
 * Creare operator.
 */
@Override
public IOperator createOperator(final String token) {
switch (token) {
case "+":
return new BinaryOperatorPlus();
case "-":
return new BinaryOperatorMinus();
case "*":
return new BinaryOperatorMultiply();
case "/":
return new BinaryOperatorDivide();
case "^":
return new BinaryOperatorPower();
case "log":
return new UnaryOperatorLog();
case "sqrt":
return new UnaryOperatorSqrt();
default:
return null;
}
}


/**
 * Verificare operator.
 */
@Override
public boolean isOperator(final IToken token) {
return binarySymbols.contains(token.getSymbol())
|| unarySymbols.contains(token.getSymbol());
}


/**
 * Verificare.
 */
@Override
public boolean isUnaryOperator(final IOperator operator) {
return unarySymbols.contains(operator.getSymbol());
}


/**
 * Verificare.
 */
@Override
public boolean isBinaryOperator(final IOperator operator) {
return binarySymbols.contains(operator.getSymbol());
}

}
