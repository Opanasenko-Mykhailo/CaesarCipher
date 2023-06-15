import java.io.File;
import java.util.Scanner;
// Метод для вводу з консолі
public class CLI{
    private int key;
    public void alternativeLaunch() {
        Scanner scanner = new Scanner(System.in); // Створюємо сканер
        System.out.println("Type the letter corresponding to the command into the console\n [e]ncrypt\n [d]ecrypt\n [b]rute force");
        String command = scanner.nextLine();// Записуємо перший аргумент у змінну
        // Перевіряємо, чи підходить хоч по одному ключі наш аргумент
        if (command.equalsIgnoreCase("e")||command.equalsIgnoreCase("d")||command.equalsIgnoreCase("b")){
            System.out.println("Enter a link to the file");
            String path = scanner.nextLine(); // Записуємо посилання в змінну
            File file = new File(path);
            // Перевіряємо чи існує файл за посиланням
            if (file.exists()) {
                if(command.equalsIgnoreCase("b")){
                    System.out.println(new Implementation().launchBruteForce(path));
                    return;
                }
                System.out.println("Enter the key");
                try {
                    key = scanner.nextInt(); // Записуємо ключ в змінну
                } catch (Exception exception){
                    // Якщо тип введених даних не підходить, повідомляємо про це
                    System.out.println("Invalid Key");
               }
                Implementation implementation = new Implementation();
                implementation.launchCaesarCipher(command, path,key);
            } else System.out.println("Invalid link");
        } else System.out.println("Invalid data entered");
    }
}