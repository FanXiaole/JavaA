import java.util.Scanner;

public class CatAndDog2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] cat = new int[n];
        int[] dog = new int[n];
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            cat[i] = num;
        }
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            dog[i] = num;
        }
        int m = in.nextInt();
        if (cat[0] == -1 && cat[1] != -1) {
            cat[0] = cat[1] * 4 / 5;
        }
        if (cat[n - 1] == -1 && cat[n - 2] != -1) {
            cat[n - 1] = cat[n - 2] * 4 / 5;
        }
        if (dog[0] == -1 && dog[1] != -1) {
            dog[0] = dog[1] * 4 / 5;
        }
        if (dog[n - 1] == -1 && dog[n - 2] != -1) {
            dog[n - 1] = dog[n - 2] * 4 / 5;
        }
        for (int i = 1; i <= n - 2; i++) {
            if (cat[i] == -1 && cat[i - 1] != -1 && cat[i + 1] != -1) {
                cat[i] = (cat[i - 1] * 2 + cat[i + 1] * 3) / 5;
            }
            if (dog[i] == -1 && dog[i - 1] != -1 && dog[i + 1] != -1) {
                dog[i] = (dog[i - 1] * 2 + cat[i + 1] * 3) / 5;
            }
        }
        if (cat[m - 1] == -1 && dog[m - 1] == -1) {
            System.out.println("ALL DATA LOST");
        } else if (cat[m - 1] == -1 && dog[m - 1] != -1) {
            System.out.println("CAT DATA LOST");
        } else if (cat[m - 1] != -1 && dog[m - 1] == -1) {
            System.out.println("DOG DATA LOST");
        } else {
            System.out.println(cat[m - 1] + dog[m - 1]);
        }
    }
}
