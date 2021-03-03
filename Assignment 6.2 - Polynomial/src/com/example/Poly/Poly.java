package com.example.Poly;

public class Poly {

	private final int[][] coeffPow; // 0 for coefficient and 1 for power

	public Poly(int[][] coeffPow) {
		int[][] tempPoly = new int[2][coeffPow[0].length];

		for (int i = 0; i < tempPoly.length; i++) {
			for (int j = 0; j < tempPoly[0].length; j++)
				tempPoly[i][j] = coeffPow[i][j];
		}

		this.coeffPow = sortByPow(tempPoly);
	}

	private int[][] sortByPow(int[][] poly) {
		for (int i = 0; i < poly[1].length; i++) {
			for (int j = i + 1; j < poly[1].length; j++) {
				if (poly[1][i] < poly[1][j]) {
					int temp = poly[1][i];
					poly[1][i] = poly[1][j];
					poly[1][j] = temp;

					temp = poly[0][i];
					poly[0][i] = poly[0][j];
					poly[0][j] = temp;
				}
			}
		}

		return poly;
	}

	private static int[][] addSamePow(int[][] poly) {
		for (int i = 0; i < poly[0].length; i++) {
			for (int j = i + 1; j < poly[0].length; j++) {
				if (poly[1][i] == poly[1][j]) {
					poly[0][i] += poly[0][j];
					poly[0][j] = 0;
				}
			}
		}
		return poly;
	}

	private static int[][] removeZeros(int[][] poly) {
		int count = 0;
		for (int i = 0; i < poly[0].length; i++) {
			if (poly[0][i] == 0) {
				count++;
			}
		}
		int[][] result = new int[2][poly[0].length - count];
		for (int i = 0, j = 0; i < poly[0].length && j < result[0].length; i++) {
			if (poly[0][i] != 0) {
				result[0][j] = poly[0][i];
				result[1][j] = poly[1][i];
				j++;
			}
		}
		return result;
	}

	private int[][] getCoeffPow() {
		int[][] tempPoly = new int[2][coeffPow[0].length];

		for (int i = 0; i < coeffPow[0].length; i++) {
			tempPoly[0][i] = coeffPow[0][i];
			tempPoly[1][i] = coeffPow[1][i];
		}

		return tempPoly;
	}

	public float evaluate(float x) {
		float result = 0;

		for (int i = 0; i < coeffPow[0].length; i++)
			result += coeffPow[0][i] * Math.pow(x, coeffPow[1][i]);

		return result;
	}

	public int degree() {
		return coeffPow[1][0];
	}

	public static Poly addPoly(Poly poly1, Poly poly2) {
		int[][] firstPoly = poly1.getCoeffPow();
		int[][] secondPoly = poly2.getCoeffPow();

		int[][] resultPoly = new int[2][firstPoly[0].length
				+ secondPoly[0].length];

		for (int i = 0; i < firstPoly[0].length; i++) {
			resultPoly[0][i] = firstPoly[0][i];
			resultPoly[1][i] = firstPoly[1][i];
		}

		for (int i = 0, j = firstPoly[0].length; i < secondPoly[0].length
				&& j < resultPoly[0].length; i++) {
			resultPoly[1][j] = secondPoly[1][i];
			resultPoly[0][j] = secondPoly[0][i];
			j++;
		}

		resultPoly = addSamePow(resultPoly);
		resultPoly = removeZeros(resultPoly);
		return new Poly(resultPoly);
	}

	public static Poly multiplyPolynomial(Poly p1, Poly p2) {
		int[][] first = p1.getCoeffPow();
		int[][] second = p2.getCoeffPow();

		int size = (first[0].length * second[0].length);
		int[][] result = new int[2][size];

		for (int i = 0, k = 0; i < first[0].length && k < result[0].length; i++) {
			for (int j = 0; j < second[0].length; j++) {
				result[1][k] = second[1][j] + first[1][i];
				result[0][k] = second[0][j] * first[0][i];
				k++;
			}
		}

		result = Poly.addSamePow(result);
		result = Poly.removeZeros(result);

		return new Poly(result);
	}
	
	public void DisplayPoly(){
		for(int i = 0; i < coeffPow[0].length; i++){
			if(i == 0){
				System.out.print(coeffPow[0][i] + "^" + coeffPow[1][i]);
			}else{
				System.out.print("+" + coeffPow[0][i] + "^" + coeffPow[1][i]);
			}
		}
		System.out.println();
	}
	
	public static void main(String args[]){
		
		Poly p1 = new Poly(new int[][] {{2, 6, 5}, {2, 1, 0}});
		System.out.print("Poly 1 : ");
		p1.DisplayPoly();
		
		Poly p2 = new Poly(new int[][] {{3, 2, 1}, {2, 1, 0}});
		System.out.print("Poly 2 : ");
		p2.DisplayPoly();
		
		System.out.println("Degree of Poly 1 : " + p1.degree());
		
		Poly addPoly = Poly.addPoly(p1, p2);
		System.out.print("Poly 1 + Poly 2 = ");
		addPoly.DisplayPoly();
		
		Poly multPoly = Poly.multiplyPolynomial(p1, p2);
		System.out.print("Poly 1 x Poly 2 = ");
		multPoly.DisplayPoly();
		
	}

}
