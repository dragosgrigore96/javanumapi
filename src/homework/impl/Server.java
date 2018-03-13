package homework.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import homework.impl.brackets.Bracket;
import homework.impl.brackets.BracketsFactory;
import homework.impl.operands.OperandsFactory;
import homework.impl.operands.Roman;
import homework.impl.operators.OperatorsFactory;
import homework.interfaces.IServer;
import homework.interfaces.IToken;
import homework.interfaces.brackets.IBracket;
import homework.interfaces.operands.IOperand;
import homework.interfaces.operands.IOperandsFactory;
import homework.interfaces.operators.IOperator;
import homework.interfaces.operators.IOperatorsFactory;
import homework.interfaces.operators.binaryOperators.IBinaryOperator;
import homework.interfaces.operators.unaryOperators.IUnaryOperator;

public final class Server implements IServer {

private static Server instance = null;
private Stack<IToken> myStack = new Stack<>();
private List<String> commandResults = new ArrayList<>();
private List<String> validOperators = new ArrayList<>();
private BracketsFactory bracketsFactory = BracketsFactory.getInstance();
private IOperatorsFactory operatorsFactory = OperatorsFactory.getInstance();
private IOperandsFactory operandsFactory = OperandsFactory.getInstance();

private List<String> operators =
Arrays.asList(new String[] {"+", "-", "/", "^", "*", "log", "sqrt"});

private Server() {

}

public static Server getInstance() {
if (instance == null) {
instance = new Server();
}
return instance;
}

@Override
public boolean canPublish(final String[] tokens) {
List<String> operatorsInCommand = new ArrayList<>();
for (String token : tokens) {
if (operators.contains(token)) {
operatorsInCommand.add(token);
}
}

for (String op : operatorsInCommand) {
if (!validOperators.contains(op)) {
return false;
}
}
return true;
}

public int indexFirstClosedParenthesis(final IToken[] tokens) {
for (int i = 0; i < tokens.length; i++) {
if (bracketsFactory.isBracket(tokens[i])) {
Bracket bracket = (Bracket) tokens[i];
if (bracketsFactory.isClosedBracket(bracket)) {
return i;
}
}
}
return 0;
}

private enum TokenType {
OPERATOR, OPERAND, BRACKET, NONE
}

private TokenType getTokenType(final String ce) {

if (bracketsFactory.getSymbClosedBrackets().contains(ce)
|| bracketsFactory.getSymbOpenBrackets().contains(ce)) {
return TokenType.BRACKET;
}
if (operators.contains(ce)) {
return TokenType.OPERATOR;
}
if (ce.contains(" ") || ce.isEmpty()) {
return TokenType.NONE;
}
return TokenType.OPERAND;
}

public double evaluateRPNExpression(final List<IToken> tokensList) {
Stack<IToken> tokenStack = new Stack<>();
double result = 0;
for (IToken token : tokensList) {

if (!operatorsFactory.isOperator(token)) {
tokenStack.push(token);
} else {
if (operatorsFactory.isBinaryOperator((IOperator) token)) {
IToken tokenOp2 = tokenStack.pop();
IToken tokenOp1 = tokenStack.pop();

IOperand<Number> op2 = (IOperand<Number>) tokenOp2;
IOperand<Number> op1 = (IOperand<Number>) tokenOp1;
IBinaryOperator<Number> operator =
(IBinaryOperator<Number>) token;
IOperand<Number> resultOperand = operator.calculate(
op1.getSymbolValue(), op2.getSymbolValue());
tokenStack.push(resultOperand);
} else if (operatorsFactory.isUnaryOperator((IOperator) token)) {
IToken singleToken = tokenStack.pop();
IOperand<Number> singleOperand = (IOperand<Number>) singleToken;

IUnaryOperator<Number> operator = (IUnaryOperator<Number>) token;
IOperand<Number> resultOperand =
operator.calculate(singleOperand.getSymbolValue());

tokenStack.push(resultOperand);
}
}
}
result = Double.valueOf(((IOperand<Number>) tokenStack.pop()).
getSymbolValue().doubleValue());
return result;
}

@Override
public void publish(final String commandRomans) {

if (!canPublish(commandRomans.split(" "))) {
commandResults.add("IMPOSSIBRU");
return;
}

List<IToken> commandTokens = new ArrayList<>();

for (String commandElement : RPNParser.infixToRPN(commandRomans.split(" "))) {
switch (getTokenType(commandElement)) {
case BRACKET:
IBracket bracket = bracketsFactory.createBracket(commandElement);
commandTokens.add(bracket);
break;
case OPERAND:
IOperand<Number> op = null;
try {
op = operandsFactory.createOperand(commandElement);
} catch (NumberFormatException e) {
e.printStackTrace();
}
commandTokens.add(op);
break;
case OPERATOR:
IOperator operator = operatorsFactory.createOperator(commandElement);
commandTokens.add(operator);
break;
default:
break;
}

}
double result = evaluateRPNExpression(commandTokens);
boolean negative = false;
int arabic = (int) Math.floor(result);
if (arabic < 0) {
negative = true;
}
try {
Roman roman = new Roman((int) Math.abs(arabic));
String element = "";
if (negative) {
element += "- ";
}
commandResults.add(element + roman.toString());
} catch (NumberFormatException e) {
commandResults.add("IMPOSSIBRU");
}
}

@Override
public void subscribe(final String o) {
validOperators.add(o);
}

@Override
public List<String> getResults() {
return commandResults;
}

}
