package homework.impl.operators;

import homework.impl.operands.ImplOperand;
import homework.interfaces.operands.IOperand;
import homework.interfaces.operators.unaryOperators.IUnaryOperator;

public final class UnaryOperatorLog implements IUnaryOperator<Number> {

private String symbol;

private static final int PRIORITY = 3;

public UnaryOperatorLog() {
this.symbol = "log";
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
Number res = operand.doubleValue();
result.setSymbolValue(Math.log(res.doubleValue()));
result.setSymbol(null);
return result;
}


/**
 * Afisare.
 */
@Override
public String toString() {
return symbol;
}
}
