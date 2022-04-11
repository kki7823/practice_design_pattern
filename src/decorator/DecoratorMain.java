package decorator;

public class DecoratorMain {
    public static void main(String[] args) {
        Display display = new RoadDisplay();
        display.draw();

        Display displayWithLane = new LaneDecorator(display);
        displayWithLane.draw();
    }
}

abstract class DisplayDecorator extends Display{
    private Display decoratedDisplay;

    public DisplayDecorator(Display decoratedDisplay) {
        this.decoratedDisplay = decoratedDisplay;
    }

    @Override
    void draw() {
        decoratedDisplay.draw();
    }
}

abstract class Display {
    abstract void draw();
}

class RoadDisplay extends Display {
    @Override
    void draw() {
        System.out.println("기본 도로 표시");
    }
}

class LaneDecorator extends DisplayDecorator {
    public LaneDecorator(Display decoratedDisplay) {
        super(decoratedDisplay);
    }

    @Override
    void draw() {
        super.draw();
        drawLane();
    }

    private void drawLane(){
        System.out.println("차선 표시");
    }
}
