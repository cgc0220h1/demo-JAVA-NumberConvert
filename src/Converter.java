import java.util.Stack;

public class Converter {
    private int decimalBase;
    private String binaryBase;
    private Stack<Integer> numberStack;
    private boolean isDecimalNegative;

    public Converter(int decimalBase) {
        this.decimalBase = decimalBase;
        numberStack = new Stack<>();
    }

    public Converter(String binaryBase) {
        this.binaryBase = binaryBase;
        numberStack = new Stack<>();
    }

    private void divideByTwo() {
        if (decimalBase < 0) {
            isDecimalNegative = true;
            decimalBase = decimalBase * -1;
        }
        int remainder;
        int quotient = decimalBase;
        while (quotient != 0) {
            remainder = quotient % 2;
            quotient = quotient / 2;
            numberStack.push(remainder);
        }
    }

    public int[] toBinary() {
        divideByTwo();
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


}
