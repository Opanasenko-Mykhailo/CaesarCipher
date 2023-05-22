import java.util.ArrayList;

public class AlphabetList {
    public boolean isAlphabetEU;
    private ArrayList<Character> alphabet;
    private final char[] UPPER_CASE_LETTERS_UA = {'А', 'Б', 'В', 'Г', 'Ґ', 'Д', 'Е', 'Є', 'Ж', 'З', 'И', 'І', 'Ї', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ю', 'Я'};
    private final char[] LOWER_CASE_LETTERS_UA = {'а', 'б', 'в', 'г', 'ґ', 'д', 'е', 'є', 'ж', 'з', 'и', 'і', 'ї', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ю', 'я'};

    private ArrayList<Character> alphabetEU(){
        alphabet = new ArrayList<>();
        for (char i = 'a'; i <= 'z'; i++) {
            alphabet.add(i);
        }
        for (char i = 'A'; i <= 'Z'; i++) {
            alphabet.add(i);
        }
        return alphabet;
    }
    private ArrayList<Character> alphabetUA(){
        alphabet = new ArrayList<>();
        for (char letter : UPPER_CASE_LETTERS_UA) {
            alphabet.add(letter);
        }
        for (char letter : LOWER_CASE_LETTERS_UA) {
            alphabet.add(letter);
        }
        return alphabet;
    }
    // Метод визначає по першій літері, до якого алфавіту вона відноситься
    public ArrayList<Character> autoSelectAlphabet(String text){
        char firstLetter = text.charAt(0);
        if (firstLetter >= 'A' && firstLetter <= 'Z' || firstLetter >= 'a' && firstLetter <= 'z') {
            isAlphabetEU = true; // Помітка, що алфавіт Англійський
           return alphabetEU();
    } else {
            isAlphabetEU = false;
            return alphabetUA();
        }
}
}