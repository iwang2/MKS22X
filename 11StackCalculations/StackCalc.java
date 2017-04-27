import java.util.*;

public class StackCalc{

    private static boolean isOp(String s){
	if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
	    return true;
	}
	return false;
    }

    private static double apply(String op, double v1, double v2){
	if(op.equals("+")){
	    return v1 + v2;
	}else if(op.equals("-")){
	    return v2 - v1;
	}else if(op.equals("*")){
	    return v1 * v2;
	}else{
	    return v2 / v1;
	}
    }
    
    public static double eval(String s){
	String[] tokens = s.split(" ");
	Stack<Double> values = new Stack<Double>();

	for(String token: tokens){
	    if(!isOp(token)){
		values.push(Double.parseDouble(token));
	    }else{
		values.push(apply(token, values.pop(), values.pop()));
	    }
	}

	return values.pop();
    }

    public static void main(String[] args){
	System.out.println(eval("10 2 +") == 12.0);
	System.out.println(eval("10 2 -") == 8.0);
	System.out.println(eval("10 2.0 +") == 12.0);
	System.out.println(eval("11 3 - 4 + 2.5 *") == 30.0);
	System.out.println(eval("8 2 + 99 9 - * 2 + 9 -")); //839
	System.out.println(eval("10 2 + 10 * 1 + 1 1 1 + + + 10 10 + -") == 104.0);
    }
}
