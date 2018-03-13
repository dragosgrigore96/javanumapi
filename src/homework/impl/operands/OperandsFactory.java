package homework.impl.operands;

import homework.interfaces.operands.IOperand;
import homework.interfaces.operands.IOperandsFactory;

public final class OperandsFactory implements IOperandsFactory {

private static OperandsFactory instance = null;


public static OperandsFactory getInstance() {
if (instance == null) {
instance = new OperandsFactory();
}
return instance;
}

private OperandsFactory() {
}

@Override
public IOperand<Number> createOperand(final String token) {
IOperand<Number> operand = new ImplOperand();
operand.setSymbol(token);
Roman rom = new Roman(token);
operand.setSymbolValue(rom.toInt());
return operand;
}

@Override
public IOperand<Number> convertToRomanNumber(final Number arabNumber) {
IOperand<Number> op = new ImplOperand();
Roman rom = new Roman(arabNumber.intValue());
op.setSymbol(rom.toString());
op.setSymbolValue(rom.toInt());
return op;
}

@Override
public IOperand<Number> convertToArabNumber(final String romanNumber) {
Roman rom = new Roman(romanNumber);
IOperand<Number> op = new ImplOperand();
op.setSymbol("" + rom.toInt());
op.setSymbolValue(rom.toInt());
return op;
}
}
