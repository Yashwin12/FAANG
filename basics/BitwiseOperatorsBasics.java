
// HACK: https://www.geeksforgeeks.org/bitwise-operators-in-java/
public class BitwiseOperatorsBasics {
    public static void main(String[] args) {
        // Initial values
        int a = 5;
        int b = 7;

        // 1) bitwise and
        // 0101 & 0111 => 0101 = num 5
        System.out.println("a&b = " + (a & b)); // a&b = 5

        // 2) bitwise or
        // 0101 | 0111 => 0111 = num 7
        System.out.println("a|b = " + (a | b)); // a|b = 7

        // 3) bitwise xor
        // IMPORTANT XOR properties : 
            // a) A ^ B == B ^ A 
            // b) A ^ B ^ A == B
            // c) A ^ 0 = A
            // d) A ^ A = 0
            
        // 0101 ^ 0111 => 0010 = num 2
        System.out.println("a^b = " + (a ^ b)); // a^b = 2

        // 4) bitwise and
        // ~0101=1010
        // will give 2's complement of 1010 = -6
        System.out.println("~a = " + ~a); // ~a = -6

        // 5) can also be combined with assignment operator to provide shorthand
        // assignment
        // a = a & b can be written as below
        a &= b;
        System.out.println("a= " + a); // a= 5

        a = 5;
        b = -10;
        // HACK: Signed vs unsigned numbers: https://www.youtube.com/watch?v=miwMEUfkqfY
        // Signed number -> Has positive (denoted as 0 at the left most bit) or negative number (denoted as 1 at the left most bit)
        // Unsigned number -> only positive number

        // 6) Left shift operator: num << n => Multiplies num by 2^n times.
        // 0000 0101<<2 => 0001 0100( num 20)
        // similar to 5*(2^2)
        System.out.println("a<<2 = " + (a << 2));

        // 7) Signed right shift operator : num >> n => Divides num by 2^n times.
        // NOTE: >> preserves the sign bit.
        // 0000 0101 >> 2 => 0000 0001( num 1)
        // similar to 5/(2^2)
        System.out.println("b>>2 = " + (b >> 2));

        // 8) Unsigned right shift operator
        // NOTE: DOES NOT preserve the sign bit. 
        System.out.println("b>>>2 = " + (b >>> 2));

    }
}