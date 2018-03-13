package homework.impl.operands;

public final class Roman {

private final int num;

private static final int NR_1000 = 1000;
private static final int NR_900 = 900;
private static final int NR_500 = 500;
private static final int NR_400 = 400;
private static final int NR_100 = 100;
private static final int NR_90 = 90;
private static final int NR_50 = 50;
private static final int NR_40 = 40;
private static final int NR_10 = 10;
private static final int NR_9 = 9;
private static final int NR_5 = 5;
private static final int NR_4 = 4;
private static final int NR_1 = 1;
private static final int NR_3999 = 3999;
private static final int NR_MINUS_1 = -1;

private static int[] numere = {NR_1000, NR_900, NR_500, NR_400, NR_100,
NR_90, NR_50, NR_40, NR_10, NR_9, NR_5, NR_4, NR_1};

private static String[] caractere = {"M", "CM", "D", "CD", "C", "XC", "L",
"XL", "X", "IX", "V", "IV", "I"};

public Roman(final int arabic) {

if (arabic < NR_1) {
throw new NumberFormatException();
}
if (arabic > NR_3999) {
throw new NumberFormatException();
}
num = arabic;
}

public Roman(final String romanP) {

String roman = romanP;
if (roman.length() == 0) {
throw new NumberFormatException();
}

roman = roman.toUpperCase();

int i = 0;
int arabic = 0;

while (i < roman.length()) {

char letter = roman.charAt(i);
int number = letterToNumber(letter);

if (number < 0) {
throw new NumberFormatException();
}
i++;

if (i == roman.length()) {
arabic += number;
} else {
int nextNumber = letterToNumber(roman.charAt(i));
if (nextNumber > number) {
arabic += (nextNumber - number);
i++;
} else {
arabic += number;
}
}

}

num = arabic;

}

private int letterToNumber(final char letter) {
switch (letter) {
case 'I':
return NR_1;
case 'V':
return NR_5;
case 'X':
return NR_10;
case 'L':
return NR_50;
case 'C':
return NR_100;
case 'D':
return NR_500;
case 'M':
return NR_1000;
default:
return NR_MINUS_1;
}
}

/**
 * Afisare.
 */
public String toString() {
String roman = "";
int n = num;
for (int i = 0; i < numere.length; i++) {
while (n >= numere[i]) {
roman += caractere[i];
n -= numere[i];
}
}
return roman;
}

public int toInt() {
return num;
}

}
