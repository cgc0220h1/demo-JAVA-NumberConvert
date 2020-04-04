public class Main {
    public static void main(String[] args) {
        String str = "abc123";
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            System.out.print(Character.getNumericValue(ch));
        }
        System.out.println("\n");

        Converter converter = new Converter(63);
        int[] result = converter.toBinary();
        for (Integer number : result) {
            System.out.print(number);
        }
        System.out.println("\n");

        converter = new Converter(-12345);
        System.out.println(converter.toBase16());
    }
}
