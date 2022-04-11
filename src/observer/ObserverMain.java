package observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverMain {
    public static void main(String[] args) {
        Notice notice = new Notice();
        User1 user1 = new User1("user1");
        User2 user2 = new User2("user2");

        notice.attach(user1);
        notice.attach(user2);

        String msg = "Notice All";
        notice.notifyObservsers(msg);

        notice.detach(user1);
        msg = "Hello";
        notice.notifyObservsers(msg);
    }
}

class Notice {
    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservsers(String msg) {
        for (Observer observer : observers) {
            observer.recieve(msg);
        }
    }
}

class User1 extends Observer {
    public User1(String msg) {
        this.msg = msg;
    }
}

class User2 extends Observer {
    public User2(String msg) {
        this.msg = msg;
    }
}

class Observer {
    public String msg;

    public void recieve(String msg) {
        System.out.println(this.msg + " 에서 메세지를 받음 : " + msg);
    }
}
