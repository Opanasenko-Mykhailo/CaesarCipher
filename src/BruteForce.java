import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteForce {
    // Списки популярних слів і суфіксів для англійської та української мови
    private final List<String> ENGLISH_POPULAR_WORDS = Arrays.asList(
            "the", "be", "to", "of", "and", "a", "in", "that", "have", "I",
            "it", "for", "not", "on", "with", "he", "as", "you", "do", "at"
    );

    private final List<String> ENGLISH_POPULAR_SUFFIXES = Arrays.asList(
            "tion", "ing", "ed", "ly", "al", "ful", "able", "less", "ous", "ence",
            "ment", "er", "est", "ive", "ize", "ness", "sion", "ent", "ance", "ist"
    );

    private final List<String> UKRAINE_POPULAR_WORDS = Arrays.asList(
            "привіт", "як", "ти", "це", "що", "також", "можна", "будь-ласка", "чи", "ні",
            "ви", "добре", "день", "вечір", "сонце", "місяць", "зірка", "любов", "друже", "родина"
    );

    private final List<String> UKRAINE_POPULAR_SUFFIXES = Arrays.asList(
            "ень", "ать", "уть", "ти", "ина", "ка", "ця", "ся", "ити", "ння",
            "ання", "ість", "ова", "ія", "ина", "тик", "ив", "єво", "їн", "ка"
    );

    // Метод для перебору шифрування для англійської мови
    public int englishBruteForce(String cipherText, ArrayList<Character> alphabet) {
        int maxMatchCount = getMaxMatchCount(cipherText.length());

        // Перебираємо всі можливі ключі
        for (int key = 0; key < alphabet.size(); key++) {
            String plainText = CaesarCipher.decrypt(cipherText, alphabet, key);
            int wordMatchCount = 0;
            int suffixMatchCount = 0;

            // Перевіряємо співпадіння з популярними словами
            for (String word : ENGLISH_POPULAR_WORDS) {
                if (plainText.contains(word)) {
                    wordMatchCount++;
                    if (wordMatchCount > maxMatchCount) {
                        return key;
                    }
                }
            }

            // Перевіряємо співпадіння з популярними суфіксами
            for (String suffix : ENGLISH_POPULAR_SUFFIXES) {
                if (plainText.endsWith(suffix)) {
                    suffixMatchCount++;
                    if (suffixMatchCount > maxMatchCount) {
                        return key;
                    }
                }
            }
        }
        return -1; // Якщо немає збігів
    }

    // Метод для перебору шифрування для української мови
    public int ukraineBruteForce(String cipherText, ArrayList<Character> alphabet) {
        int maxMatchCount = getMaxMatchCount(cipherText.length());

        // Перебираємо всі можливі ключі
        for (int key = 0; key < alphabet.size(); key++) {
            String plainText = CaesarCipher.decrypt(cipherText, alphabet, key);
            int wordMatchCount = 0;
            int suffixMatchCount = 0;

            // Перевіряємо співпадіння з популярними словами
            for (String word : UKRAINE_POPULAR_WORDS) {
                if (plainText.contains(word)) {
                    wordMatchCount++;
                    if (wordMatchCount > maxMatchCount) {
                        return key;
                    }
                }
            }

            // Перевіряємо співпадіння з популярними суфіксами
            for (String suffix : UKRAINE_POPULAR_SUFFIXES) {
                if (plainText.endsWith(suffix)) {
                    suffixMatchCount++;
                    if (suffixMatchCount > maxMatchCount) {
                        return key;
                    }
                }
            }
        }
        return -1; // Якщо немає збігів
    }

    // Метод для визначення максимальної кількості збігів в залежності від довжини тексту
    private int getMaxMatchCount(int textLength) {
        if (textLength < 500) {
            return 2;
        } else if (textLength < 1000) {
            return 3;
        } else if (textLength < 3000) {
            return 4;
        } else if (textLength < 10000) {
            return 5;
        } else {
            return 6;
        }
    }
}