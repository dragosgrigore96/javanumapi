package homework.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public final class RPNParser {
private static final int LEFT_ASSOC = 0;

private static final int NR_0 = 0;
private static final int NR_1 = 1;
private static final int NR_2 = 2;
private static final int NR_3 = 3;

private static final Map<String, int[]> OPERATORS = new HashMap<>();
static {
OPERATORS.put("+", new int[] {NR_0, LEFT_ASSOC});
OPERATORS.put("-", new int[] {NR_0, LEFT_ASSOC});
OPERATORS.put("*", new int[] {NR_1, LEFT_ASSOC});
OPERATORS.put("/", new int[] {NR_1, LEFT_ASSOC});
OPERATORS.put("^", new int[] {NR_2, LEFT_ASSOC});
OPERATORS.put("sqrt", new int[] {NR_3, LEFT_ASSOC});
OPERATORS.put("log", new int[] {NR_3, LEFT_ASSOC});
}
private static boolean isOperator(final String token) {
return OPERATORS.containsKey(token);
}
private RPNParser() {
}
private static boolean isAssociative(final String token,
final int type) {
if (!isOperator(token)) {
throw new IllegalArgumentException("Invalid token: " + token);
}
if (OPERATORS.get(token)[1] == type) {
return true;
}
return false;
}

private static int cmpPrecedence(final String token1,
final String token2) {
if (!isOperator(token1) || !isOperator(token2)) {
throw new IllegalArgumentException();
}
return OPERATORS.get(token1)[0] - OPERATORS.get(token2)[0];
}

public static String[] infixToRPN(final String[] inputTokens) {
ArrayList<String> out = new ArrayList<String>();
Stack<String> stack = new Stack<String>();
for (String token : inputTokens) {
if (isOperator(token)) {
while (!stack.empty() && isOperator(stack.peek())) {
if ((isAssociative(token, LEFT_ASSOC)
&& cmpPrecedence(token, stack.peek()) <= 0)) {
out.add(stack.pop());
continue;
}
break;
}
stack.push(token);
} else if (token.equals("(")) {
stack.push(token);
} else if (token.equals("[")) {
stack.push(token);
} else if (token.equals("{")) {
stack.push(token);
} else if (token.equals(")")) {
while (!stack.empty() && !stack.peek().equals("(")) {
out.add(stack.pop());
}
stack.pop();
} else if (token.equals("]")) {
while (!stack.empty() && !stack.peek().equals("[")) {
out.add(stack.pop());
}
stack.pop();
} else if (token.equals("}")) {
while (!stack.empty() && !stack.peek().equals("{")) {
out.add(stack.pop());
}
stack.pop();
} else {
out.add(token);
}
}
while (!stack.empty()) {
out.add(stack.pop());
}
String[] output = new String[out.size()];
return out.toArray(output);
}

}
