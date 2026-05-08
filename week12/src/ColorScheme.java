import java.awt.*;

//枚举类：颜色集合，即将与一个主题相关的一系列颜色放在同一个集合（数组）中去；
public enum ColorScheme {
    SKY(new Color[]{new Color(0, 102, 204),
            new Color(0, 128, 255),
            new Color(51, 153, 255),
            new Color(102, 178, 255),
            new Color(153, 204, 255),
            new Color(204, 229, 255)}),
    RAINBOW(new Color[]{
            Color.RED,
            Color.ORANGE,
            Color.YELLOW,
            Color.GREEN,
            Color.CYAN,
            new Color(0, 128, 255),
            new Color(204, 153, 255)}),
    GRAY(new Color[]{
            Color.DARK_GRAY,
            Color.GRAY,
            Color.LIGHT_GRAY});
    final Color[] colorList;
    ColorScheme(Color[] color) {
        colorList = color;
    }
    public Color[] getColorScheme() {
        return colorList;
    }
}
