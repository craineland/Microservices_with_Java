package HandlingExceptions;

public class Main {
    public static void main(String[] args) {
        int i = 12;
        int j = 5;

        try {
            int result = i / (j-1);
            System.out.println(result);
        }
        catch (Exception ex) {
            System.out.println("Error: ");
        }
    }
}
