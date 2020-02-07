/*written by Tatiana Azulay*/
import java.io.*;
import java.util.*;
public class runInterpreter {
   public static void main(String [ ] args) {
   String data="";
   try {
   Scanner console=new Scanner(System.in);
   System.out.println("Please enter the path to the text file: ");
   String path=console.nextLine();
   File file = new File(path); 
   Scanner sc = new Scanner(file); 
   while (sc.hasNextLine())
   data=data+sc.nextLine();
       Tokenizer t=new Tokenizer(data);
       Parser parser=new Parser(t.getTokenArray());
                         System.out.println();
                         parser.printSymbolTable();
   }
   catch (FileNotFoundException e) {
   e.printStackTrace();
   }             
}//main ends
}