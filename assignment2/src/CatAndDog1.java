import java.util.Scanner;

public class CatAndDog1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n= in.nextInt();
        int[] cat=new int[n];
        int[] dog=new int[n];
        for (int i=0;i<n;i++){
            int num= in.nextInt();
            cat[i]=num;
        }
        for (int i=0;i<n;i++){
            int num= in.nextInt();
            dog[i]=num;
        }
        int dis= in.nextInt();
        if(cat[dis-1]==-1&&dog[dis-1]==-1){
            System.out.println(2);
        } else if (cat[dis-1]!=-1&&dog[dis-1]!=-1) {
            System.out.println(0);
        }else {
            System.out.println(1);
        }
    }
}
