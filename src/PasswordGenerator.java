import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		System.out.print("Input number of characters: ");
		int size = in.nextInt(); // ввод длины пароля
		System.out.println((int)Math.pow(62, size) + " passwords can be generated.");
		String password = generatePassword(size);
		System.out.println("Your generated " + size + "-character password: " + password);

		// смотрим код нужных промежутков
		// System.out.println((int)'A' + " " + (int)'Z' + " " + (int)'a' + " " +
		// (int)'z');
		// проверяем формулы
		// System.out.println((char)('A'+0) + " " + (char)('A'+25) + " " +
		// (char)('a'+(26-26)) + " " + (char)('a'+(51-26)));
	}

	public static String generatePassword(int size) {
		String res = "";
		int letter;
		Random r = new Random();
		for (int i = 0; i < size; i++) { // каждый проход цикла - 1 символ пароля
			if (r.nextInt(2) == 0) { // если 0, режим букв
				letter = r.nextInt(51); // 52 буквы на выбор (26 прописных и 26 строчных),
										// т.е. выбор от 0 до 51
				if (letter < 26) // т.к. числовые промежутки, содержащие прописные и строчные
								// буквы, не смежны, делим выбор на 2 равные части по 26 букв,
								// 0-25 прописные, 26-51 строчные
					// получение строчной буквы из случайного номера от 0 до 25
					res += (char) ('A' + letter);
				else
					// получение строчной буквы из случайного номера от 26 до 51
					res += (char) ('a' + (letter - 26));
			} else { // если 1, режим цифр
				res += r.nextInt(9); // получение цифры от 0 до 9
			}
		}
		return res;
	}
}
