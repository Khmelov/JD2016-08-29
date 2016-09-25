package by.it.tsydzik.mathlab;

import by.it.tsydzik.mathlab.vars.Var;
import by.it.tsydzik.mathlab.vars.VarFloat;
import by.it.tsydzik.mathlab.vars.VarVec;

/**
 * @author Eugene Tsydzik
 * @since 09/24/16.
 */
public class Main {

	private static void printOneVar(Var v) {
		if (v != null) System.out.println(v);
	}

	public static void main(String[] args) {
		System.out.println("\nпроверка операций со скалярами");
		printOneVar(new VarFloat("1").add(new VarFloat("2")));
		printOneVar(new VarFloat("9").sub(new VarFloat("7")));
		printOneVar(new VarFloat("1.5").mul(new VarFloat("2")));
		printOneVar(new VarFloat("-4").div(new VarFloat("-1")));

		String vector = "{1,2,3}";
		System.out.println("\nпроверка операций с векторами справа и скалярами слева");
		printOneVar(new VarVec(vector).add(new VarFloat("2")));
		printOneVar(new VarVec(vector).sub(new VarFloat("1")));
		printOneVar(new VarVec(vector).mul(new VarFloat("2")));
		printOneVar(new VarVec(vector).div(new VarFloat("1")));

		System.out.println("\nпроверка операций со скалярами справа и векторами слева");
		printOneVar(new VarFloat("1").add(new VarVec(vector)));
		printOneVar(new VarFloat("2").sub(new VarVec(vector)));
		printOneVar(new VarFloat("1").mul(new VarVec(vector)));
		printOneVar(new VarFloat("2").div(new VarVec(vector)));

		System.out.println("\nпроверка операций с двумя векторами");
		printOneVar(new VarVec(vector).add(new VarVec(vector)));
		printOneVar(new VarVec(vector).sub(new VarVec(vector)));
		printOneVar(new VarVec(vector).mul(new VarVec(vector)));
		printOneVar(new VarVec(vector).div(new VarVec(vector)));
	}
}
