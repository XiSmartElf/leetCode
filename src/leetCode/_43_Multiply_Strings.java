package leetCode;

//for big numbers have to implement character by character using math foundations
// this one isn't working!!!!!!!!!!
public class _43_Multiply_Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(multiply("123456789","987654321"));
	}

	
    public static String multiply(String num1, String num2) {

    	Double result =(Double.parseDouble(num1)*Double.parseDouble(num2));
    	return result.toString().split("\\.")[0];
    }
}
