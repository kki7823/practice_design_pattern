package singleton;

/*
    Singleton
    - what : 단 하나의 인스턴스만 생성하여 사용하는 클래스
    - why : 공통된 객체를 여러개 생성해야 때, 최초 한번의 메모리 할당으로 생성되는 객체를
            여러 객체들이 공유하는 방식으로 사용하여 메모리 낭비를 방지하기위해 사용
    - when/where : DBCP구현 등
 */

// 기본 Singleton
// 멀티쓰레드 환경에서 여러개의 인스턴스 생성됨
public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            instance = new Singleton();
        }

        System.out.println(instance.hashCode());
        return instance;
    }

}

// synchronized 키워드 사용
class Singleton2 {
    private static Singleton2 instance;

    public Singleton2() {
    }

    //멀티 쓰레드 환경에서 동시접근 차단
    public static Singleton2 getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }

        System.out.println(instance.hashCode());
        return instance;
    }
}

// Holder를 통한 초기화
class Singleton3 {
    private Singleton3() {
    }

    private static class Holder {
        public static final Singleton3 INSTANCE = new Singleton3();
    }

    public static Singleton3 getInstance() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Holder.INSTANCE.hashCode());
        return Holder.INSTANCE;
    }
}