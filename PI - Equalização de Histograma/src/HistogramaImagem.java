import javax.swing.JOptionPane;

public class HistogramaImagem {

	public static void main(String args[]) {
		
		int soma0 = 0,soma1,soma2,soma3,soma4,soma5,soma6,soma7,soma8,soma9 = 0;
		
		int[] arrayN = new int[20];
		arrayN[0] = 1;arrayN[1] = 2;arrayN[2] = 3;arrayN[3] = 4;arrayN[4] = 5;arrayN[5] = 6;arrayN[6] = 7;
		arrayN[7] = 8;arrayN[8] = 9;arrayN[9] = 10;arrayN[10] = 11;arrayN[11] = 12;arrayN[12] = 13;arrayN[13] = 14;
		arrayN[14] = 15;arrayN[15] = 16;arrayN[16] = 17;arrayN[17] = 18;arrayN[18] = 19;arrayN[19] = 20;
		
		int[] fX = new int[20];
		fX[0] = 7;fX[1] = 4;fX[2] = 0;fX[3] = 9;fX[4] = 4;fX[5] = 1;fX[6] = 0;
		fX[7] = 8;fX[8] = 3;fX[9] = 0;fX[10] = 6;fX[11] = 8;fX[12] = 1;fX[13] = 8;
		fX[14] = 1;fX[15] = 2;fX[16] = 9;fX[17] = 4;fX[18] = 5;fX[19] = 4;
		
		int[] arrayK = new int [10];
		arrayK[0] = 1;arrayK[1] = 2;arrayK[2] = 3;arrayK[3] = 4;arrayK[4] = 5;arrayK[5] = 6;arrayK[6] = 7;
		arrayK[7] = 8;arrayK[8] = 9;
		
	for(int i = 0; i < arrayK.length; i++) {
		for(int j = 0; j < fX.length; j++) {
			if(fX[j] == arrayK[i]) {
				soma0 = soma0 + 1;
			}
			System.out.println(soma0);
		}
	}
		
		
			
	}

}
