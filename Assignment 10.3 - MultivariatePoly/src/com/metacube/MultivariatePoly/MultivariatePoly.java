package com.metacube.MultivariatePoly;

public class MultivariatePoly {

	Node head;

	public void createTerm(int coeff, int[] exponents) {

		Node newNode = new Node(coeff);

		if (head == null)
			head = newNode;
		else {
			Node temp = head;

			while (temp.nextTerm != null)
				temp = temp.nextTerm;

			temp.nextTerm = newNode;
		}

		for (int i = 0; i < exponents.length; i++) {

			Node newExpo = new Node(exponents[i]);
			newNode.exp = newExpo;
			newNode = newExpo;

		}

	}

	public int getDegree() {

		int res = 0;

		if (head == null)
			return res;
		else {
			Node temp = head;

			while (temp != null) {

				int degree = 0;

				Node term = temp;

				while (term.exp != null) {

					degree += term.exp.coeff;
					term = term.exp;

				}

				if (degree > res)
					res = degree;

				temp = temp.nextTerm;

			}
		}

		return res;

	}

}
