/**
 * 
 */

/**
 * 
 * @author ChenShi
 * @date   2018年4月9日下午10:42:09
 */
public class test {
	public static void main(String args[]) {
		double[][] resultData= new double[4][7];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 7; j++) {
				resultData[i][j] = i;
			}
			
		}
		double[] t = resultData[1];
		for (double d : t) {
			System.out.println(d);
		}
		
		
	}
}
