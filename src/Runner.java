import java.io.File;
import java.util.Scanner;


public class Runner {
    private int key;

    // Конструктор з двома аргументами(BruteForce)
    public Runner(String arg1, String arg2) {
        File file = new File(arg2);
        if (file.exists()) {
            if(arg1.equalsIgnoreCase("BRUTE_FORCE")){
                System.out.println("KEY : " + new Implementation().launchBruteForce(arg2));
                return;
            }
        } else System.out.println("Invalid link");
    }

    // Конструктор з трьома аргументами(Caesar Cipher)
    public Runner(String arg1, String arg2, String arg3) {
        if (arg1.equalsIgnoreCase("ENCRYPT")||arg1.equalsIgnoreCase("DECRYPT")){
            File file = new File(arg2);
            if (file.exists()) {
                try {
                   key = Integer.parseInt(arg3);
                } catch (Exception exception){
                    System.out.println("Invalid Key");
                    new Runner();
                }
                Implementation implementation = new Implementation();
                implementation.launchCaesarCipher(arg1, arg2, key);
                System.out.println("Success");
                return;
            } else System.out.println("Invalid link");{
                new Runner();
            }
        } else {
            System.out.println("Invalid data entered");
            new Runner();
        }
    }
    // Конструктор без аргументів
    public Runner(){
        Scanner console = new Scanner(System.in);
        System.out.println("Choose a convenient mode\n 1. Console mode(CLI)\n 2. Interface mode(GUI)");
        try {
            int mode = console.nextInt();
            if(mode == 1){
                new CLI().alternativeLaunch();
            } else if (mode == 2) {
                new GUI().swingInterface();
            }else new Runner();
        }
        catch (Exception e){
            System.out.println("Incorrect data");
        }

    }
}