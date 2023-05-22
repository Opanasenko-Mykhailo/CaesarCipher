import java.util.ArrayList;

public class CaesarCipher {
    public static String encrypt(String message, ArrayList<Character> alphabet, int key) {
        String encryptedMessage = ""; // Змінна, в яку буде записаний зашифрований текст
        // Проходимося по отриманому тексту через масив
        for (int i = 0; i < message.length(); i++) {
            char letter = message.charAt(i); // Записуємо кожну ітерацію по 1 букві в змінну
            // Перевірка, чи ця літера є в алфавіті
            if (alphabet.contains(letter)) {
                int index = alphabet.indexOf(letter); // Отримуємо індекс літери, і записуємо в змінну
                int encryptedIndex = (index + key) % alphabet.size(); // Додаємо до індексу ключ для шифрування
                char encryptedLetter = alphabet.get(encryptedIndex); // Отримуємо зашифровану літеру
                encryptedMessage += encryptedLetter; // Додаємо літеру в змінну, де буде записаний зашифрований текст
            } else {
                encryptedMessage += letter; // Якщо літера не відноситься до алфавіту, то додаємо її без змін
            }
        }
        return encryptedMessage;
    }

    public static String decrypt(String message, ArrayList<Character> alphabet, int key) {
        String decryptedMessage = ""; // Змінна, в яку буде записаний дешифрований текст
        // Проходимося по отриманому тексту через масив
        for (int i = 0; i < message.length(); i++) {
            char letter = message.charAt(i); // Записуємо кожну ітерацію по 1 букві в змінну
            // Перевірка, чи ця літера є в алфавіті
            if (alphabet.contains(letter)) {
                int index = alphabet.indexOf(letter); // Отримуємо індекс літери, і записуємо в змінну
                int decryptedIndex = (index - key + alphabet.size()) % alphabet.size(); // Віднімаємо від індексу ключ для дешифрування
                char decryptedLetter = alphabet.get(decryptedIndex); // Отримуємо дешифровану літеру
                decryptedMessage += decryptedLetter; // Додаємо літеру в змінну, де буде записаний дешифрований текст
            } else {
                decryptedMessage += letter; // Якщо літера не відноситься до алфавіту, то додаємо її без змін
            }
        }
        return decryptedMessage;
    }
}
