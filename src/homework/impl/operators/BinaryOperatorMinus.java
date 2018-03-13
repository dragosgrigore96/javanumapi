package homework.impl.operators;

import homework.impl.operands.ImplOperand;
import homework.interfaces.operands.IOperand;
import homework.interfaces.operators.binaryOperators.IBinaryOperator;

public final class BinaryOperatorMinus implements IBinaryOperator<Number> {

private String symbol;

public BinaryOperatorMinus() {
symbol = "-";
}

/**
 * Getter.
 */
@Override
public int getPriority() {
return 0;
}

/**
 * Setter.
 */
@Override
public String getSymbol() {
return symbol;
}

/**
 * Setter.
 */
@Override
public void setSymbol(final String s) {
this.symbol = s;
}

/**
 * Calcul.
 */
@Override
public IOperand<Number> calculate(final Number leftOperand,
final Number rightOperand) {
ImplOperand result = new ImplOperand();
Number res = leftOperand.doubleValue() - rightOperand.doubleValue();
result.setSymbolValue(res);
result.setSymbol(null);
return result;
}
}
