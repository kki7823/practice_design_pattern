package abstractfactory;
/*
    AbstractFactory
    - what : 추상화된 Factory를 구현, 예를 들어 동일한 부품구조를 가진 서로 다른 회사의 제품을 만들때,
             Factory를 각 회사별로 구현
 */

public class AbstractFactoryMain {
    public static void main(String[] args) {
        GuiFactory windowGuiFactory = new WindowGuiFactory();
        Button button = windowGuiFactory.createButton();
        Text text = windowGuiFactory.createText();

        button.click_Button();
        text.text_Description();
    }
}

//ConcreteFactory
class WindowGuiFactory implements GuiFactory{
    @Override
    public Button createButton() {
        return new WindowButton();
    }

    @Override
    public Text createText() {
        return new WindowText();
    }
}

//Product
class WindowButton implements Button{
    @Override
    public void click_Button() {
        System.out.println("WindowButton Clicked");
    }
}

class WindowText implements Text{
    @Override
    public void text_Description() {
        System.out.println("Window Text");
    }
}

class MacButton implements Button{
    @Override
    public void click_Button() {
        System.out.println("MacButton Clicked");
    }
}

class MacText implements Text{
    @Override
    public void text_Description() {
        System.out.println("Mac Text");
    }
}

//AbstractFactory
 interface GuiFactory{
    public Button createButton();
    public Text createText();
}

//AbstractProduct
 interface Button{
    public void click_Button();
}

 interface Text{
    public void text_Description();
}
