import java.util.Stack;

public class Converter {
    private int decimalBase;
    private String binaryBase;
    private Stack<Integer> numberStack;
    private Stack<Character> characterStack;
    private boolean isDecimalNegative;

    public Converter(int decimalBase) {
        this.decimalBase = decimalBase;
        numberStack = new Stack<>();
        characterStack = new Stack<>();
    }

    public Converter(String binaryBase) {
        this.binaryBase = binaryBase;
        numberStack = new Stack<>();
        characterStack = new Stack<>();
    }

    private void divideBy(int number) {
        if (decimalBase < 0) {
            isDecimalNegative = true;
            decimalBase = decimalBase * -1;
        }
        int remainder;
        int quotient = decimalBase;
        while (quotient != 0) {
            remainder = quotient % number;
            quotient = quotient / number;
            numberStack.push(remainder);
        }
    }

    public int[] toBinary() {
        divideBy(2);
        int[] numbers = new int[numberStack.size() + 1];
        if (isDecimalNegative) {
            numbers[0] = 1;
        } else {
            numbers[0] = 0;
        }
        for (int index = 1; index < numbers.length; index++) {
            numbers[index] = numberStack.pop();
        }
        return numbers;
    }

    public Integer toDecimal() {
        char[] chars = binaryBase.toCharArray();
        int result = 0;
        for (char ch : chars) {
            if(Character.getNumericValue(ch) > 1) {
                return null;
            }
            numberStack.push(Character.getNumericValue(ch));
        }
        int base = 0;
        while (numberStack.size() > 1) {
            result += numberStack.pop() * Math.pow(2,base);
            base++;
        }
        if (numberStack.peek() == 1) {
            result *= -1;
        }
        return result;
    }

    private char convertBase16(int number) {
        if (number < 10) {
            return (char) (number + '0');
        }
        switch (number) {
            case 10:
                return 'A';
            case 11:
                return 'B';
            case 12:
                return 'C';
            case 13:
                return 'D';
            case 14:
                return 'E';
            case 15:
                return 'F';
        }
        return 'G';
    }

    public String toBase16() {
        StringBuilder result = new StringBuilder();
        divideBy(16);
        for (int number : numberStack) {
            characterStack.push(convertBase16(number));
        }
        while (characterStack.size() > 0) {
            result.append(characterStack.pop());
        }
        return result.toString();
    }

}
