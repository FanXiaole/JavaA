import javax.swing.*;
import java.awt.*;

public class DisplayJpg {

    public static void main(String[] args) {
        //创建一个新的窗体；
        JFrame frame = new JFrame();
        //导入一个image图像；
        //注意：这里的图片路径是相对于项目根目录的路径；
        Image image = Toolkit.getDefaultToolkit().getImage("week13/picture.jpg").getScaledInstance(100, 100, Image.SCALE_FAST);

        //ImageComponent是JComponent的子类；
        JComponent imageComponent = new ImageComponent(image);
        //自定义imageComponent的大小（宽和高）；
        imageComponent.setSize(100, 100);
        System.out.printf("imageComponent [%d,%d]\n", imageComponent.getWidth(), imageComponent.getHeight());

        //将frame窗体居中处理；
        frame.setLocationRelativeTo(null);
        //直接根据上一级中像素点进行布局；
        //后面有将imageComponent添加到frame中，所以imageComponent在frame中的位置是(50, 50)；
        imageComponent.setLocation(50, 50);
        //将frame的布局设置为null，这样可以自定义组件的位置和大小；
        frame.setLayout(null);
        //setVisible(true)会导致imageComponent的paintComponent方法被调用，进而可以显示给用户；
        frame.setVisible(true);
        //将组件添加到窗体中；
        frame.add(imageComponent);
        //设置窗体的大小；
        frame.setSize(imageComponent.getWidth() + 100, 200);
        System.out.printf("window Frame [%d,%d]\n", frame.getWidth(), frame.getHeight());
        //关闭窗体，程序终止运行；
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //ImageComponent类继承自JComponent，用于显示图像；
    static class ImageComponent extends JComponent {
        Image paintImage;

        public ImageComponent(Image image) {
            //不使用布局，手动设置组件的位置和大小；
            this.setLayout(null);
            //focusable是指组件是否可以获得焦点；
            this.setFocusable(true);
            this.paintImage = image;
            //repaint方法会调用paintComponent方法；
            repaint();
        }

        //ImageComponent这个组件要画的内容均在paintComponent方法中实现；
        //注意到paintComponent方法不是由用户调用的，而是通过repaint方法触发的；
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(paintImage, 0, 0, paintImage.getWidth(this), paintImage.getHeight(this), this);
        }
    }
}
