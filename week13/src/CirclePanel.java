import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Random;

//类CirclePanel是JPanel的子类；
public class CirclePanel extends JPanel {
    //半径的默认初始值为50像素；
    private int radius = 50;
    //颜色的默认初始为黑色；
    private Color color = Color.BLACK;
    private final Random random = new Random();

    public CirclePanel(int width, int height) {
        //添加鼠标点击事件监听器；
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
        //设置面板的布局为null，这样可以自定义组件的位置和大小；
        setLayout(null);
        //设置面板的背景颜色为白色；
        this.setBackground(Color.WHITE);
        //设置面板的大小为传入的宽度和高度的66%；
        this.setSize(width, (int) (height * 0.66));
        //设置面板的位置为(0, 0)，即左上角处；
        this.setLocation(0, 0);
    }

    //方法enlarge()用于放大圆形的半径；
    public void enlarge() {
        radius = (int) (radius * 1.1);
        //repaint()方法会触发paintComponent方法的调用；
        this.repaint();
    }

    //方法shrink()用于缩小圆形的半径；
    public void shrink() {
        radius = (int) (radius * 0.9);
        //repaint()方法会触发paintComponent方法的调用；
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        //调用父类的paintComponent方法，确保组件正确绘制；
        super.paintComponent(g);
        //设置绘图颜色为当前的颜色，即颜色不变；
        g.setColor(this.color);
        //绘制字符串，显示当前半径的值；
        g.drawString(String.format("Radius: %d",this.radius),10,15);
        //g.fillOval方法用于填充一个椭圆形区域，这里绘制的是一个圆形；
        //该圆形的圆心在面板的中心，半径为当前的radius；
        g.fillOval(this.getWidth() / 2 - radius, this.getHeight() / 2 - radius, 2 * radius, 2 * radius);
    }

    //重写processMouseEvent方法，用于处理鼠标点击事件；
    @Override
    protected void processMouseEvent(MouseEvent e) {
        //调用父类的processMouseEvent方法，确保其他鼠标事件也能被处理；
        super.processMouseEvent(e);
        //如果鼠标事件是鼠标按下事件，则随机生成一个颜色，并重新绘制面板；
        if (e.getID() == MouseEvent.MOUSE_PRESSED) {
            //随机生成一个颜色；
            color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
            //打印当前颜色到控制台；
            System.out.println(color);
            //调用repaint方法，触发paintComponent方法的调用；
            repaint();
        }
    }
}
