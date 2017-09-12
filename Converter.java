import java.util.Scanner;
 public class Converter
 {
    public static void main (String [] args)
  {
    
    
 
    System.out.println("Enter Infix notation expression:");
    Scanner scan = new Scanner(System.in);
    String input = scan.nextLine();
    System.out.println("Postfix notation = " + convert(input));
 
  }//main
  public static String convert(String input)
  {
    CharStack stack = new CharStack();
    char current;
    String postfix = "";
 
 
    for(int i = 0; i<input.length(); i++)
    {
       current = input.charAt(i);
       
      if(isOperand(current))
      {
       postfix += current;
      }//if
      else if(current == '(')
      {
       stack.push(current);
      }//elseIf
      else if(current == ')')
      {
        while(stack.peek() != '(')
        {
          postfix = postfix + stack.pop();
        }
        stack.pop();
      }//elseIf
      else if(isOperator(current))
      {
        while(stack.isEmpty()!=true && 
             isOperator(stack.peek()) &&
             findPrec(stack.peek())>=findPrec(current))
        {
          postfix = postfix + stack.pop();
        }//while
        stack.push(current);
      }
    }
    while(!stack.isEmpty()){
     postfix += stack.pop();
    }
    return postfix;
  }//Converter
  public static boolean isOperand(char c){
    if(
      (c>='a' && c<='z') ||
      (c>='A' && c<='Z') ||
      (c>='0' && c<='9')){
        return true;
      }else{
        return false;
      }
  }

  public static boolean isOperator(char c){
    if (c=='+' || c=='-' || c=='*' || c=='/')
    {
    return true;
      
    }
    else
    {
      return false;
    }
  }
private static int findPrec(char c){
  if(c=='/' || c=='*'){
    return 2;
  }else{
    return 1;
  }
  }
}

    