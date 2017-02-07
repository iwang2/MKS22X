public class Recursion{
    public static String name(){
	return "Wang,Ida";
    }

    public static double sqrt(double n){
	if(n < 0){
	    throw new IllegalArgumentException();
	}else if(n < 1){
	    return helper(n, 1);
	}else if(n < 4){
	    return helper(n, n);
	}else{
	    return helper(n, n / 2);
	}
    }

    public static double helper(double n, double guess){
	if(n == 0){
	    return 0;
	}else if(guess * guess / n < 1.000000000000001){
	    return guess;
	}else{
	    return helper(n, (n / guess + guess) / 2);
	}
    }

    public static void main(String[]args){
	//System.out.println(name());
	try{
	    System.out.print(args[0] + ": ");
	    System.out.println(sqrt(Double.parseDouble(args[0])));
	}
	catch(IllegalArgumentException e){
	    System.out.println("input must be greater than or equal to 0");
	}
	catch(IndexOutOfBoundsException b){
	    for(int i = 0; i <= 100; i++){
		System.out.println(i + ": " + sqrt(i));
	    }
	    for (int i = 0; i < 16; i++){
		System.out.println(i*i + ": " + sqrt(i*i));
	    }
	    //System.out.println("Please type in a number to calculate its square root.");
	}
    }
}
