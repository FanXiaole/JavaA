import javax.swing.*;

public class CircleFrame extends JFrame {
    private final CirclePanel canvas;

    public CircleFrame() {

        //注意，以下的this指的是CircleFrame实例本身；

        //设置窗体的大小为300x400像素；
        this.setSize(300, 400);
        //设置窗体的布局为null，这样可以自定义组件的位置和大小；
        this.setLayout(null);
        //将窗体放置在屏幕中央；
        this.setLocationRelativeTo(null);
        //创建一个新的面板：CirclePanel，用于显示圆形；
        this.canvas = new CirclePanel(this.getWidth(), this.getHeight());
        //将CirclePanel面板添加到当前窗体中；
        this.add(canvas);

        //创建两个按钮：jbtEnlarge和jbtShrink，用于放大和缩小圆形的大小；
        JButton jbtEnlarge = new JButton("Enlarge");
        JButton jbtShrink = new JButton("Shrink");

        //添加点击事件监听器到按钮：jbtEnlarge；
        jbtEnlarge.addActionListener(l -> {
            //当按钮被点击时，调用CirclePanel的enlarge方法来放大圆形；
            canvas.enlarge();
        });
        //添加点击事件监听器到按钮：jbtShrink；
        jbtShrink.addActionListener(l -> {
            //当按钮被点击时，调用CirclePanel的shrink方法来缩小圆形；
            canvas.shrink();
        });

        int btnWidth = (int) (this.getWidth() * 0.4);
        int btnHeight = (int) (this.getHeight() * 0.1);
        //统一两个按钮的大小和位置；
        jbtShrink.setSize(btnWidth, btnHeight);
        jbtEnlarge.setSize(btnWidth, btnHeight);
        //两个按钮位置的y坐标相同，说明它们上下表齐，分别位于一左一右；
        jbtShrink.setLocation(10, 310);
        jbtEnlarge.setLocation(160 , 310);
        //记得将两个按钮添加到当前窗体中；
        this.add(jbtShrink);
        this.add(jbtEnlarge);
        System.out.printf("enlarge location:[%d,%d],size:[%d,%d]\n", jbtEnlarge.getX(), jbtEnlarge.getY(), jbtEnlarge.getWidth(), jbtEnlarge.getHeight());
        System.out.printf("shrink location:[%d,%d],size:[%d,%d]\n", jbtShrink.getX(), jbtShrink.getY(), jbtShrink.getWidth(), jbtShrink.getHeight());
    }

    public static void main(String[] args) {
        //创建一个新的CircleFrame窗体；
        CircleFrame frame = new CircleFrame();
        //设置窗体的标题为"ControlCircle"；
        frame.setTitle("ControlCircle");
        //窗体一旦关闭就退出程序；
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗体可见；
        frame.setVisible(true);
    }
}
