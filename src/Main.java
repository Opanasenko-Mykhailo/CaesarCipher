
public class Main {
    public static void main(String[] args) {
        Runner runner;
        if (args.length == 2) {
            // Викликаємо конструктор з двома аргументами
            runner = new Runner(args[0], args[1]);
        } else if (args.length == 3) {
            // Викликаємо конструктор з трьома аргументами
            runner = new Runner(args[0], args[1], args[2]);
            // Викликаємо конструктор без аргументів
        } else {
            runner = new Runner();
        }
    }
}