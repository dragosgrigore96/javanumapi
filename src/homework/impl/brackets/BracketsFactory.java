package homework.impl.brackets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import homework.interfaces.IToken;
import homework.interfaces.brackets.IBracket;
import homework.interfaces.brackets.IBracketsFactory;

public final class BracketsFactory implements IBracketsFactory {

private List<String> symbOpenBrackets = new ArrayList<>();
private List<String> symbClosedBrackets = new ArrayList<>();

private static BracketsFactory instance = null;

public static BracketsFactory getInstance() {
if (instance == null) {
instance = new BracketsFactory();
}
return instance;
}

private BracketsFactory() {
symbOpenBrackets.addAll(Arrays.asList(new String[] {"(", "[", "{" }));
symbClosedBrackets.addAll(Arrays.asList(new String[] {")", "]", "}" }));
}

@Override
public IBracket createBracket(final String token) {
return new Bracket(token);
}

@Override
public boolean isBracket(final IToken token) {
return symbOpenBrackets.contains(token.getSymbol())
|| symbClosedBrackets.contains(token);
}

@Override
public boolean isOpenedBracket(final IBracket bracket) {
return symbOpenBrackets.contains(bracket.getSymbol());
}

@Override
public boolean isClosedBracket(final IBracket bracket) {
return symbClosedBrackets.contains(bracket.getSymbol());
}



public List<String> getSymbOpenBrackets() {
return symbOpenBrackets;
}

public void setSymbOpenBrackets(final List<String> s) {
this.symbOpenBrackets = s;
}

public List<String> getSymbClosedBrackets() {
return symbClosedBrackets;
}

public void setSymbClosedBrackets(final List<String> s) {
this.symbClosedBrackets = s;
}

@Override
public boolean isBracketPair(final IBracket openBracket,
final IBracket closeBracket) {
if (openBracket.getSymbol().equals("(")
&& closeBracket.getSymbol().equals(")")) {
return true;
}
if (openBracket.getSymbol().equals("[")
&& closeBracket.getSymbol().equals("]")) {
return true;
}
if (openBracket.getSymbol().equals("{")
&& closeBracket.getSymbol().equals("}")) {
return true;
}
return false;
}

}
