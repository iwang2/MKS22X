import java.util.*;

public class Quiz2Redux{
    /*Returns an ArrayList<String> that contains all subsets of the
     *characters of String s. Assume s has no duplicate characters.
     *The characters should appear in the same order that they occur
     *in the original string.
     */
    public static ArrayList<String> combinations(String s){
	ArrayList<String> words = new ArrayList<String>();
	help(words, s, "", 0);
	Collections.sort(words);
	return words;
    }
    private static void help(ArrayList<String> words,
			     String o, String n, int index){
	if(index >= o.length()){
	    words.add(n);
	}else{
	    help(words, o, n, index + 1);
	    help(words, o, n + o.charAt(index), index + 1);
	}
    }

    public static void print(ArrayList<String> words){
	for(int i = 0; i < words.size(); i++){
	    System.out.print(words.get(i) + " ");
	}
	System.out.println();
    }

    public static void main(String[]args){
	System.out.print("abcd: ");
	print(combinations("abcd"));
	System.out.print("kji: ");
	print(combinations("kji"));
    }
}
