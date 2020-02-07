/******************************************************************************
 *  Compilation:  javac runInterpreter.java
 *  Execution:    java runInterpreter
 *
 *  The interpreter asks the user to input a path to a text file with a program consisting of assignments.
 *  It interprets the assignments and (1) detects lexical and syntax errors; 
 *  (2) reports uninitialized variables; 
 *  (3) performs the assignments if there is no error and prints out the values of all the variables after all the assignments are done.
 *
 ******************************************************************************/
Language description:
-it consists of assignments and each variable is the integer type. 
-only operators that give integer values are included. 
Program:
Assignment*
Assignment:  Identifier = Exp;
Exp:   Exp + Term | Exp - Term | Term
Term:  Term * Fact  | Fact
Fact:  ( Exp ) | - Fact | + Fact | Literal | Identifier
Identifier:  Letter [Letter | Digit]*
Letter:  a|...|z|A|...|Z|_
Literal:  0 | NonZeroDigit Digit*		
NonZeroDigit:  1|...|9
Digit:  0|1|...|9

Sample input and output:
Input:
x = 1;
y = 2;
z = ---(x+y)*(x+-y);
a = 4;
b_c= a*6-4;
t=a+1;
u=5;
r=4-(-4);
d=(7-a)+1;

Output:
x = 1
y = 2
z = 3
a = 4
b_c = 20
t = 5
u = 5
r = 8
d = 4
