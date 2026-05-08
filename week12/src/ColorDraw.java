public interface ColorDraw {
    //两个传参分别为：1.主题颜色 2.主题颜色中的第几个颜色？
    //这里public在接口中是默认的修饰符，所有接口中的方法都是public的，故可以省去；
    void customizedColor(ColorScheme colorScheme, int index);
}
