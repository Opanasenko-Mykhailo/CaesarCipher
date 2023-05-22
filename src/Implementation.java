
public class Implementation {
    private String encryptedText; // Змінна в яку запишеться зашифрований або дешифрований текст
    private String actionText; // Змінна, яка буде додана при створенні зашифрованого або дешифрованого тексту



        //Метод на вході отримує ключове слово - команду, посилання на файл і ключ
    public String launchCaesarCipher(String command, String path, int key) {
        // Читаємо вміст файлу, записуємо у змінну
        String fileContent = FileService.readFile(path);
        // Отримуємо алфавіт, відповідно до мови тексту
        var alphabet = new AlphabetList().autoSelectAlphabet(fileContent);
        if (command.equals("E") || command.equals("e") || command.equalsIgnoreCase("ENCRYPT")) {
            actionText = "[ENCRYPTED]";
            encryptedText = CaesarCipher.encrypt(fileContent, alphabet, key);
        } else if (command.equals("D") || command.equals("d")|| command.equalsIgnoreCase("DECRYPT")) {
            actionText = ("[DECRYPTED]");
            encryptedText = CaesarCipher.decrypt(fileContent, alphabet, key);
        }
        // Записуємо зашифрований або дешифрований текст у файл
        FileService.writeFile(path, encryptedText, actionText);
        // Повертаємо зашифрований або дешифрований текст(потрібно для роботи GUI)
        return encryptedText;
    }

    public int launchBruteForce(String path) {
        // Читаємо вміст файлу, записуємо у змінну
        String fileContent = FileService.readFile(path);
        AlphabetList alphabetList = new AlphabetList();
        // Отримуємо алфавіт, відповідно до мови тексту
        var alphabet = alphabetList.autoSelectAlphabet(fileContent);
        // В залежності від мови алфавіту, запускаємо Brute Force
        if (alphabetList.isAlphabetEU) {
            return new BruteForce().englishBruteForce(fileContent, alphabet);
        } else {
            return new BruteForce().ukraineBruteForce(fileContent, alphabet);
        }
    }
}