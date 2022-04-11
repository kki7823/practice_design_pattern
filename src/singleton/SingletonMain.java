package singleton;

public class SingletonMain {
    public static void main(String[] args) {
        for(int i = 0; i<5; i++){
            Thread thread = new Thread(() -> {
                Singleton3 singleton = Singleton3.getInstance();
            });

            thread.start();
        }
    }
}
