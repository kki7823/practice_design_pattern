package factorymethod;
/*
    FactoryMethod
    - what : 객체의 생성을 Factory가 담당
    - why : 확장성을 높이기 위해
            생성 할 클래스를 미리 알지 못해도, 팩토리 클래스가 객체 생성
 */
public class FactoryMethodMain {
    public static void main(String[] args) {
        ShapeFactory.getShape("CIRCLE").draw();
        ShapeFactory.getShape("RECTANGLE").draw();
        ShapeFactory.getShape("SQUARE").draw();
    }
}

class ShapeFactory{
    public static Shape getShape(String shapeType){
        if(shapeType == null) return null;

        if(shapeType.equals("CIRCLE")) return new Circle();
        else if(shapeType.equals("RECTANGLE")) return new Rectangle();
        else if(shapeType.equals("SQUARE")) return new Square();
        else return null;
    }
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("This is Circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("This is Rectangle");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("This is Square");
    }
}

interface Shape {
    void draw();
}