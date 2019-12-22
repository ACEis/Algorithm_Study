package cn.edu.cqu.bitoperation;

public class CompareWithoutSymbol {
	public static void main(String[] args) {
		System.out.println(getMax2(-15 , 12));
	}
	
	public static int flip(int n) {
		return n ^ 1;
	}
	
	public static int sign(int n) {
		return (n >> 31) & 1;
	}
	
	//a-b可能溢出
	public static int getMax1(int a, int b) {
		int c = a - b;
		int scA = sign(c);
		int scB = flip(scA);
		return scA * b + scB * a;
	}
	
	//解决溢出
	public static int getMax2(int a , int b) {
		int c = a - b;
		int as = sign(a);
		int bs = sign(b);
		int cs = sign(c);
		int dif = as ^ bs;
		int same = flip(dif);
		int returnA = same * flip(cs) + dif * flip(as);
		int returnB = flip(returnA);
		return returnA * a + returnB * b;
	}

}
