package homework.impl.brackets;

import homework.interfaces.brackets.IBracket;

public class Bracket implements IBracket {

private String symbol;

/**
 * Gets the symbol.
 */
@Override
public String getSymbol() {
return symbol;
}

/**
 * Sets the symbol.
 */
@Override
public void setSymbol(final String s) {
this.symbol = s;
}


public Bracket(final String s) {
this.symbol = s;
}
public Bracket() {
}

/**
 * Metoda pentru afisarea instantei curente.
 */
@Override
public String toString() {
return symbol;
}
}
