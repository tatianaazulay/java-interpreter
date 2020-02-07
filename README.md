 <h1>java-interpreter</h1>
 
 *  Compilation:  javac runInterpreter.java
 *  Execution:    java runInterpreter
 *  The interpreter asks the user to input a path to a text file with a program consisting of assignments.
 *  It interprets the assignments and
 *  (1) detects lexical and syntax errors; 
 *  (2) reports uninitialized variables; 
 *  (3) performs the assignments if there is no error and prints out the values of all the variables after all the assignments are done.


Language description:<br/>
*it consists of assignments and each variable is the integer type.<br/>
*only operators that give integer values are included: addition, substraction, multiplication.<br/>
Program:<br/>
Assignment * <br/>
Assignment:  Identifier = Exp<br/>
Exp:   Exp + Term | Exp - Term | Term<br/>
Term:  Term * Fact  | Fact<br/>
Fact:  ( Exp ) | - Fact | + Fact | Literal | Identifier<br/>
Identifier:  Letter [Letter | Digit]*<br/>
Letter:  a|...|z|A|...|Z|_<br/>
Literal:  0 | NonZeroDigit Digit*		<br/>
NonZeroDigit:  1|...|9<br/>
Digit:  0|1|...|9<br/>

Sample input and output:<br/>
Input:<br/>
x = 1;<br/>
y = 2;<br/>
z = ---(x+y)*(x+-y);<br/>
a = 4;<br/>
b_c= a*6-4;<br/>
t=a+1;<br/>
u=5;<br/>
r=4-(-4);<br/>
d=(7-a)+1;<br/>

Output:<br/>
x = 1<br/>
y = 2<br/>
z = 3<br/>
a = 4<br/>
b_c = 20<br/>
t = 5<br/>
u = 5<br/>
r = 8<br/>
d = 4<br/>
