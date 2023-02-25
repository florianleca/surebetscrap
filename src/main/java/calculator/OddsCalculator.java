package calculator;

public class OddsCalculator {
	public static boolean isASureBet(double c1, double c2) {
		return (1 / c1) + (1 / c2) < 1;
	}

	public static boolean isASureBet(double c1, double c2, double c3) {
		System.out.println((1 / c1) + (1 / c2) + (1 / c3));
		return (1 / c1) + (1 / c2) + (1 / c3) < 1;
	}

	public static double[] howMuchToBet(double c1, double c2, double totalBetAmount) {
		double[] betAmounts = new double[2];
		if (isASureBet(c1, c2)) {
			betAmounts[0] = totalBetAmount / (1 + (c1 / c2));
			betAmounts[1] = totalBetAmount / (1 + (c2 / c1));
		}
		return betAmounts;
	}

	public static double[] howMuchToBet(double c1, double c2, double c3, double totalBetAmount) {
		double[] betAmounts = new double[3];
		if (isASureBet(c1, c2, c3)) {
			betAmounts[0] = totalBetAmount / (1 + (c1 / c2) + (c1 / c3));
			betAmounts[1] = totalBetAmount / (1 + (c2 / c1) + (c2 / c3));
			betAmounts[2] = totalBetAmount / (1 + (c3 / c1) + (c3 / c2));

		}
		return betAmounts;
	}

	public static void sureBetSimulator(double c1, double c2, double totalBetAmount) {
		double a = OddsCalculator.howMuchToBet(2, 2.1, 100)[0];
		double b = OddsCalculator.howMuchToBet(2, 2.1, 100)[1];
		System.out.println("On parie " + a + "euros sur l'issue 1 dont la cote est " + c1);
		System.out.println("On parie " + b + "euros sur l'issue 2 dont la cote est " + c2);
		System.out.println("Si l'issue 1 est gagnante, je touche " + a * c1);
		System.out.println("Si l'issue 2 est gagnante, je touche " + b * c2);
		System.out.println("Le gain net est donc de " + (a * c1 - totalBetAmount));
	}
	public static void main(String[] args) {
		System.out.println(OddsCalculator.isASureBet(2.25, 3.25, 3.1));
		System.out.println(OddsCalculator.isASureBet(2.25, 4.5, 2.15));
		System.out.println(OddsCalculator.isASureBet(2.45, 4.8, 2.1));
		System.out.println(OddsCalculator.isASureBet(2.45, 3.85, 2.35));
		System.out.println(OddsCalculator.isASureBet(5, 2.82, 1.66));
		System.out.println(OddsCalculator.isASureBet(5, 3.57, 1.5));
	}
}
