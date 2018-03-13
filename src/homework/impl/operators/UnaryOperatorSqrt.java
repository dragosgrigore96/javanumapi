package homework.impl.operators;

import homework.impl.operands.ImplOperand;
import homework.interfaces.operands.IOperand;
import homework.interfaces.operators.unaryOperators.IUnaryOperator;

public final class UnaryOperatorSqrt  implements IUnaryOperator<Number> {

private String symbol;

private static final int PRIORITY = 3;

public UnaryOperatorSqrt() {
this.symbol = "sqrt";
}


/**
 * Getter setter method.
 */
@Override
public int getPriority() {
return PRIORITY;
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
 * Calcul.
 */
@Override
public IOperand<Number> calculate(final Number operand) {
ImplOperand result = new ImplOperand();
Number res = Math.sqrt(operand.doubleValue());
result.setSymbolValue(res);
result.setSymbol(null);
return result;
}
}
