public class NumberSystem {
    public static void main(String args[]){
        /*2. Find Base of a Number
        Example:
        Input: Number = 13, Base = 3
        Output: 111*/

        int number = 100;
        int base = 8;
        printBaseOfNumber(number,base);
    }

    public static void printBaseOfNumber(int number, int base){
        if(base > number){
            System.out.print(number);
            return;
        }
        int rem = number % base;
        printBaseOfNumber(number/base, base);
        System.out.print(rem);
    }
}
