package chapter03;

import java.util.Arrays;

public class ArrayUtilTest {

	public static void main(String[] args) {
		
		double[] b = ArrayUtil.intToDouble(new int[] {10,20,30,40});
		System.out.println(Arrays.toString(b));
		
		int[] c = ArrayUtil.doubleToInt(new double[] {10.0,20.0,30.0,40.0});
		System.out.println(Arrays.toString(c));
		
		int[] a3 = ArrayUtil.concat(new int[] {1,2,3},new int[] {4,5,6});
		System.out.println(Arrays.toString(a3));
	}

}
