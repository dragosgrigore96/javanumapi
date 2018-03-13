package homework.impl.operands;

import homework.interfaces.operands.IOperand;

public class ImplOperand implements IOperand<Number> {

private String symbol;
private Number symbolValue;

/**
 * Metoda pentru preluarea unui symbol.
 */
@Override
public String getSymbol() {
return symbol;
}

/**
 * Metoda pentru setarea unui symbol.
 */
@Override
public void setSymbol(final String s) {
this.symbol = s;

}

/**
 * Metoda pentru preluarea valorii.
 */
@Override
public Number getSymbolValue() {
return symbolValue;
}

/**
 * Metoda pentru setarea valorii.
 */
@Override
public void setSymbolValue(final Number v) {
this.symbolValue = v;

}

/**
 * Afisare.
 */
@Override
public String toString() {
return "" + symbolValue;
}

}
