import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class FileService {
        public static String readFile(String filePath){
            Path path = Paths.get(filePath); // Створення об'єкта типу Path на основі заданого шляху до файлу
            byte[] encodedBytes;
            try {
                encodedBytes = Files.readAllBytes(path); // Читання усіх байтів файлу
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return new String(encodedBytes, StandardCharsets.UTF_8); // Конвертація масиву байтів у рядок, використовуючи кодування UTF-8
        }
    public static void writeFile(String filePath, String text, String action) {
        Path path = Path.of(filePath); // Створення об'єкта типу Path на основі заданого шляху до файлу
        String fileName = path.getFileName().toString(); // Отримання імені файлу
        String directory = path.getParent().toString(); // Отримання батьківського каталогу файлу
        String newFileName = addMarkerToFileName(fileName, action); // Додавання маркера до імені файлу
        Path actionFilePath = Path.of(directory, newFileName); // Створення об'єкта типу Path для нового файлу на основі батьківського каталогу та нового імені файлу

        try {
            Files.write(actionFilePath, text.getBytes(), StandardOpenOption.CREATE); // Записуємо текс у файл
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Функція для додавання маркера до імені файлу
    private static String addMarkerToFileName(String fileName, String action) {
        String extension = "";
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex != -1) {
            extension = fileName.substring(dotIndex); // Збереження розширення файлу (якщо воно існує)
            fileName = fileName.substring(0, dotIndex); // Видалення розширення з імені файлу
        }
        return fileName + action + extension; // Повернення нового імені файлу з доданим маркером та розширенням
    }
}