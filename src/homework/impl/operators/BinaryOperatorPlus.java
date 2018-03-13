package homework.impl.operators;

import homework.impl.operands.ImplOperand;
import homework.interfaces.operands.IOperand;
import homework.interfaces.operators.binaryOperators.IBinaryOperator;

public final class BinaryOperatorPlus implements IBinaryOperator<Number> {


private String symbol;

public BinaryOperatorPlus() {
symbol = "+";
}

/**
 * Getter setter method.
 */
@Override
public int getPriority() {
return 0;
}

/**
 * Getter setter method.
 */
@Override
public String getSymbol() {
return symbol;
}

/**
 * Getter setter method.
 */
@Override
public void setSymbol(final String s) {
this.symbol = s;
}

/**
 * Calculd.
 */
@Override
public IOperand<Number> calculate(final Number leftOperand,
final Number rightOperand) {
ImplOperand result = new ImplOperand();
Number res = leftOperand.doubleValue() + rightOperand.doubleValue();
result.setSymbolValue(res);
result.setSymbol(null);
return result;
}

}
