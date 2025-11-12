// Implements basic arithmetic and sqrt without using built-in operators or Math.sqrt

public class Algebra {

	public static void main(String args[]) {
	    // Tests for all implemented methods
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
	    System.out.println(minus(2,7));  // 2 - 7
	    System.out.println(times(3,4));  // 3 * 4
	    System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
	    System.out.println(pow(5,3));      // 5^3
	    System.out.println(pow(3,5));      // 3^5
	    System.out.println(div(12,3));   // 12 / 3    
	    System.out.println(div(5,5));    // 5 / 5  
	    System.out.println(div(25,7));   // 25 / 7
	    System.out.println(mod(25,7));   // 25 % 7
	    System.out.println(mod(120,6));  // 120 % 6    
	    System.out.println(sqrt(36));    // sqrt(36)
	    System.out.println(sqrt(263169));// sqrt(263169)
	    System.out.println(sqrt(76123)); // sqrt(76123)
	}  

	// Adds x1 and x2 without using +
	public static int plus(int x1, int x2) {
		int answer = x1;
		if (x2 > 0) {
			for (int i = 0; i < x2; i++) answer++;
		}
		if (x2 < 0) {
			for (int i = 0; i > x2; i--) answer--;
		}
		return answer;
	}

	// Subtracts x2 from x1 without using -
	public static int minus(int x1, int x2) {
		int answer = x1;
		if (x2 < 0) {
			for (int i = 0; i > x2; i--) answer++;
		}
		if (x2 > 0) {
			for (int i = 0; i < x2; i++) answer--;
		}
		return answer;
	}

	// Multiplies x1 by x2 using repeated addition/subtraction
	public static int times(int x1, int x2) {
		int answer = 0;
		if (x2 > 0) {
			for (int i = 0; i < x2; i++) answer = plus(answer, x1);
		}
		if (x2 < 0) {
			for (int i = 0; i > x2; i--) answer = minus(answer, x1);
		}
		return answer;
	}

	// Computes x to the power of n (n>=0) by repeated multiplication
	public static int pow(int x, int n) {
		int answer = 1;
		for (int i = 0; i < n; i++) {
			answer = times(answer, x);
		}		
		return answer;	
	}

	// Integer division: returns quotient part of x1 / x2
	public static int div(int x1, int x2) {
		int remainder = x1;
		int answer = 0;
		if (x1 > 0) {			
			if (x2 > 0) {
				while (remainder >= x2) {
					remainder = minus(remainder, x2);
					answer++;
				}			
			}
			if (x2 < 0) {
				while (remainder <= x2) {
					remainder = minus(remainder, x2);
					answer--;
				}			
			}
		}
		if (x1 < 0) {			
			if (x2 < 0) {
				while (remainder <= x2) {
					remainder = minus(remainder, x2);
					answer++;
				}			
			}
			if (x2 > 0) {
				while (remainder <= times(minus(0, 1), x2)) {
					remainder = plus(remainder, x2);
					answer--;
				}			
			}
		}
		return answer;
	}

	// Calculates modulus: returns remainder of x1 divided by x2
	public static int mod(int x1, int x2) {
		int remainder = x1;
		int answer = 0;
		if (x1 > 0) {			
			if (x2 > 0) {
				while (remainder >= x2) {
					remainder = minus(remainder, x2);
					answer++;
				}			
			}
			if (x2 < 0) {
				while (remainder <= x2) {
					remainder = minus(remainder, x2);
					answer--;
				}			
			}
		}
		if (x1 < 0) {			
			if (x2 < 0) {
				while (remainder <= x2) {
					remainder = minus(remainder, x2);
					answer++;
				}			
			}
			if (x2 > 0) {
				while (remainder <= times(minus(0, 1), x2)) {
					remainder = plus(remainder, x2);
					answer--;
				}			
			}
		}
		return remainder;
	}	

	// Returns integer part of square root of x using trial and error
	public static int sqrt(int x) {
		int answer = 0;
		for (int i = 0; pow(i,2) < x; i++) {
			answer = i;
		}
		if (pow(answer+1, 2) > x) {
			return answer;
		} else {
			return answer+1;
		}
	}	  	  
}
