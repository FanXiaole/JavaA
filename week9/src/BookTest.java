import java.util.Scanner;

public class BookTest {
    public static void main(String[] args) {
        Book[] books = new Book[5];
        books[0] = new Book("Java");
        books[1] = new Book("C++");
        books[2] = new Book("Python");
        books[3] = new Book("Javascript");
        books[4] = new Book("C#");

        //重新理解：创建一个Scanner类名下的对象in，并放进构造方法中让它与输入面板建立连接；
        Scanner in = new Scanner(System.in);
        while(true) {
            //创建选择页面，供用户进行选项操作；
            System.out.println("Please select operation: " +
                    "1: Borrow. 2: Return. 3: Overdue. 0: To Stop the process");

            //用户做出相应选择；
            //重新理解：通过对象in调用Scanner类名下的方法nextInt，将输入面板的输入值赋值给op；
            int op = in.nextInt();

            //选择0号选项，表示用户想要退出“借书系统”；
            if (op == 0) {
                break;
            }

            //不同号码选择，分别进到其对应的不同方法中去；
            switch (op) {
                case 1:
                    Book.borrowBook(in, books);
                    break;
                case 2:
                    Book.returnBook(in, books);
                    break;
                case 3:
                    Book.overdueAll(books);
                    break;
            }
        }
    }
}
