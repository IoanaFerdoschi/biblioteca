import java.util.Random;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int first = s.nextInt();
		int second = s.nextInt();
		Random r = new Random();
		int count_ones = 0;
		int count_zeros = 0;
		int ones = (first * first + second) / 2;
		int zeros = first * first - ones;
		System.out.println("numarul de 1 este: " + ones
				+ " si numarul de 0 este: " + zeros);

		int[][] matrix = new int[first][first];

		for (int i = 0; i < first; i++) {
			for (int j = 0; j < first; j++) {

				matrix[i][j] = r.nextInt(2);
				if (matrix[i][j] == 1) {
					count_ones++;

				} else
					count_zeros++;

				if (count_ones == (ones+1) ) {
					if (matrix[i][j] == 1) {
						matrix[i][j] = matrix[i][j] - 1;
						
						count_zeros++;
					}
					count_ones--;
				}
				if (count_zeros == (zeros+1) ) {
					if (matrix[i][j] == 0) {
						matrix[i][j] = matrix[i][j] + 1;
						count_ones++;
					}
					count_zeros--;
				}
			}

		}
		for (int i = 0; i < first; i++) {
			for (int j = 0; j < first; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}
}
