public class Postfix {
    public static void main(String args[]){
        
    }
}

/*
 * An expression is called the postfix expression if the operator appears in the expression after the operands.

Example :
Infix expression: A + B  *  C – D 

Postfix expression:  A B + C D – *

Given a postfix expression, the task is to evaluate the expression. The answer could be very large, output your answer modulo (10^9+7). Also, use modular division when required.

Note:
Operators will only include the basic arithmetic operators like ‘*’, ‘/’, ‘+’, and ‘-‘.
The operand can contain multiple digits. 
The operators and operands will have space as a separator between them.
There won’t be any brackets in the postfix expression.
Input Format:
The first line of input contains an integer ‘T’ denoting the number of test cases.
The next ‘T’ lines represent the ‘T’ test cases.
The first and only line of each test case contains a postfix expression.
Output Format:
The first line of input contains an integer ‘T’ denoting the number of test cases.
For each test case, print an integer obtained by evaluating the given postfix expression.
Note:
You are not required to print the expected output; it has already been taken care of, Just implement the function.

Constraints
1 <= T <= 100
1 <= N <= 10^3
1 <= NUM <= 100
Where ‘N’ denotes the length of postfix expression and ‘NUM’ denotes the operand.

Time Limit: 1 sec
*/