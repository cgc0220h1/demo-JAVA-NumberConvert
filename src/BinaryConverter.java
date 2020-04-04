import java.util.Stack;

public class BinaryConverter {
    private int decimalBase;
    private Stack<Integer> numberStack;
    private boolean isDecimalNegative;

    public BinaryConverter(int decimalBase) {
        this.decimalBase = decimalBase;
        numberStack = new Stack<>();
    }

    public int getDecimalBase() {
        return decimalBase;
    }

    public void setDecimalBase(int decimalBase) {
        this.decimalBase = decimalBase;
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
}
