
// Наглядный пример, почему базово не предусмотрена операция * для строки и числа.
// Причина: восприятие разных людей о значении данной операции может варьироваться,
// а установленных стандартов нет (по той же причине).

public class MultiplyString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char example = 'S';
		System.out.println("Дабы далее тебе было более понятно, напоминаю:");
		System.out.println(
				"У кадого символа есть свой порядковый номер (код), представленый в таблице символов ASCII.\n");
		System.out.println(
				"Отдельный символ хранится в переменной типа char. При конвертации его в тип int можно получить его порядковый номер в таблице. \nАналогично, из целого числа можно получить символ (если число не больше количества символов в таблице).\n");
		System.out.println("Например, буква (символ) 'S', записанная в char, выводится так (в виде самой буквы): " + example
				+ ". А при конвертации в int мы видим ее номер (код): " + (int) example + ".\n");
		System.out.println(
				"Так как каждый символ имеет номер (код), мы можем производить с ним обычные арифметические операции. \n(Важно! Итог будет иметь тип int и выводиться как число, чтобы получить символ нужно результат представить в виде типа char)\nНапример, если к char 'S' прибавить 1 ('S'+1) и вывести в виде char, \nполучим следующий в таблице символ: "
						+ (char)(example + 1) + ", который имеет номер (код) int: " + ((int) example + 1)
						+ ".\n\n\n\tНачало самой программы.\n");
		System.out.println();

		String s = "So many choises";
		int i = 5;
		System.out.println("Исходная строка: '" + s + "'. Число: " + i + ".");
		System.out.println();
		System.out.println("1. Просуммировать номера символов и умножить на число " + i + ":");
		System.out.println(characterString(s, i));
		System.out.println();
		System.out.println("2. Просуммировать номера первых " + i + " символов строки:");
		System.out.println(boundIntCharacterString(s, i));
		System.out.println();
		System.out.println("3. Просуммировать номера первых " + i + " символов строки и умножить на " + i + ":");
		System.out.println(boundMultIntCharacterString(s, i));
		System.out.println();
		System.out.println("4. Умножить номер каждого символа строки на " + i + " и вернуть сумму:");
		System.out.println(multiplyEachCharacterString(s, i));
		System.out.println();
		System.out.println(
				"5. Умножить номер каждого элемента строки на " + i + " (изменяется сам символ) и вернуть новую строку:");
		System.out.println(newCharacterString(s, i));
		System.out.println();
		System.out.println("6. Вывести первые " + i + " элементов строки:");
		boundStringCharacterString(s, i);
		System.out.println();
		System.out.println("7. Вывести строку " + i + " раз (каждый раз с новой строки):");
		printStringNTimesNewLine(s, i);
		System.out.println();
		System.out.println("8. Вывести строку " + i + " раз (каждый раз на той же строке без пробела):");
		printStringNTimesSameLineNoSpace(s, i);
		System.out.println("\n");
		System.out.println("9. Вывести строку " + i + " раз (каждый раз на той же строке с пробелом):");
		printStringNTimesSameLineWithSpace(s, i);
	}

	// 1. просуммировать номера символов строки и умножить полученную сумму на число
	private static int characterString(String s, int i) {
		char[] charArray = s.toCharArray();
		int mult = 0;
		for (char c : charArray) {
			mult += c;
		}
		return mult * i;
	}

	// 2. просуммировать номера первых (число) символов строки
	private static int boundIntCharacterString(String s, int i) {
		char[] charArray = s.toCharArray();
		int mult = 0;
		for (int j = 0; j < i; j++) {
			mult += charArray[j];
		}
		return mult;
	}

	// 3. просуммировать номера первых (число) символов строки и умножить на (число)
	private static int boundMultIntCharacterString(String s, int i) {
		char[] charArray = s.toCharArray();
		int mult = 0;
		for (int j = 0; j < i; j++) {
			mult += charArray[j];
		}
		return mult * i;
	}

	// 4. умножить номер каждого символа строки на (число) и вернуть сумму
	private static int multiplyEachCharacterString(String s, int i) {
		char[] charArray = s.toCharArray();
		int res = 0;
		for (int j = 0; j < charArray.length; j++) {
			res += charArray[j] * i;
		}
		return res;
	}

	// 5. умножить номер каждого элемента строки на (число) (изменяется сам символ) и
	// вернуть новую строку
	private static String newCharacterString(String s, int i) {
		char[] charArray = s.toCharArray();
		String res = "";
		for (int j = 0; j < charArray.length; j++) {
			res += (char)(charArray[j] * i);
		}
		return res;
	}

	// 6. вывести первые (число) элементов строки
	private static void boundStringCharacterString(String s, int i) {
		char[] charArray = s.toCharArray();
		String mult = "";
		for (int j = 0; j < i; j++) {
			mult += charArray[j];
		}
		System.out.println(mult);
	}

	// 7. вывести строку (число) раз (каждый раз с новой строки)
	private static void printStringNTimesNewLine(String s, int n) {
		for (int i = 0; i < n; i++)
			System.out.println(s);
	}

	// 8. вывести строку (число) раз (каждый раз на той же строке без пробела)
	private static void printStringNTimesSameLineNoSpace(String s, int n) {
		for (int i = 0; i < n; i++)
			System.out.print(s);
	}

	// 9. вывести строку (число) раз (каждый раз на той же строке с пробелом)
	private static void printStringNTimesSameLineWithSpace(String s, int n) {
		for (int i = 0; i < n; i++)
			System.out.print(s + " ");
	}

}
