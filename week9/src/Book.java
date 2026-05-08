import java.util.Scanner;

public class Book {

    //count为静态属性，Book类名下的所有对象共享同一个count属性；
    private static int count=0;
    private final int id;
    private final String name;
    private BookStatus status;

    public Book(String name){
        //count用于记录构造方法Book的调用次数；
        count++;
        this.name=name;
        //将count作为书籍的id，即创建顺序编号；
        this.id=count;
        this.status=BookStatus.IDLE;
    }

    //两个get方法：
    public String getName() {
        return name;
    }

    public BookStatus getStatus() {
        return status;
    }

    //一个set方法：
    public void setStatus(BookStatus status) {
        this.status = status;
    }

    //用新的toString方法覆盖默认的toString方法；
    public String toString() {
        return String.format("%d: %s %s", this.id, this.name, this.status);
    }

    //静态方法borrowBook，相当于“借书系统”；
    //注意！这里要传入参数in，因为方法体中需要通过in去调用它的类名下的方法nextInt；
    public static void borrowBook(Scanner in,Book[] books){

        //将每一本书都遍历一遍，列出IDLE状态（即可借状态）的所有书籍；
        for(Book b:books){
            if(b.getStatus()==BookStatus.IDLE){
                System.out.println(b);
            }
        }

        System.out.println("Please input the book id:");
        int id=in.nextInt();
        //通过用户输入书籍的编号找到具体书籍；
        //该书籍位于数组中的位置下标=书籍编号-1；
        Book book=books[id-1];

        //若该书籍处于“可借”状态，则说明用户借书成功，并将该书籍的状态变更为“已借”；
        if(book.getStatus()==BookStatus.IDLE){
            book.setStatus(BookStatus.BORROWED);
            System.out.printf("borrow %s successfully\n", book.getName());
        }
    }

    //静态方法returnBook，相当于“还书系统”；
    public static void returnBook(Scanner in, Book[] books) {

        //列出所有处于“可还”状态的书籍；
        for (Book b : books) {
            if (b.getStatus() == BookStatus.BORROWED)
                System.out.println(b);
        }

        //锁定用户想要还的书籍；
        System.out.println("Please input the book id:");
        int id = in.nextInt();
        Book book = books[id - 1];

        //将用户已经还了的书籍设定为“可借”状态；
        if (book.getStatus() == BookStatus.BORROWED) {
            book.setStatus(BookStatus.IDLE);
            System.out.printf("return %s successfully\n", book);
        }
    }

    //静态方法overdueAll，将所有“可还”状态的书籍设置为“过期”状态；
    //比方说图书馆节假日闭馆，无法进行“还书”操作；或者用户超出借书规定时间不予返还，并要求全款买下；
    //此时可以将当前被借出去的书全被设置为“过期”状态，即该书籍后续永远无法被还或者被借；
    public static void overdueAll(Book[] books) {
        System.out.println("Setting all borrowed book to overdue");
        for (Book b : books) {
            if (b.getStatus() == BookStatus.BORROWED) {
                b.setStatus(BookStatus.OVERDUE);
                System.out.println(b);
            }
        }
    }
}
