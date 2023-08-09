package chapter03;

public class ArrayUtil {

	public static double[] intToDouble(int[] a) {
		
		double[] d = new double[a.length];
		
		for(int i=0;i<a.length;i++) {
			d[i] = a[i];
		}
		
		return d;
	}

	public static int[] doubleToInt(double[] b) {
		
		int[] c = new int[b.length];
		
		for(int i=0;i<b.length;i++) {
			c[i] = (int)b[i];
		}
		
		return c;
	}

	public static int[] concat(int[] a1, int[] a2) {
		
		int[] a3 = new int[a1.length+a2.length];
		
		for(int i=0,j=0;i<a1.length && j<a2.length;i++,j++) {
			a3[i] = a1[i];
			a3[a1.length+j] = a2[j];
		}
		
		return a3;
	}

}
