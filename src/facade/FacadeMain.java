package facade;

public class FacadeMain {
    public static void main(String[] args) {
        Facade facade = new Facade("coke", "Dark Night");
        facade.viewMovie();
    }
}

class Facade {
    private String beverageName = "";
    private String movieName = "";

    Facade(String beverageName, String movieName) {
        this.beverageName = beverageName;
        this.movieName = movieName;
    }

    void viewMovie(){
        Beverage beverage = new Beverage(beverageName);
        RemoteControl remoteControl = new RemoteControl();
        Movie movie = new Movie(movieName);

        beverage.prepare();
        remoteControl.TurnOn();
        movie.searchMovie();
        movie.chargeMovie();
        movie.plauMovie();
    }
}

class RemoteControl {
    void TurnOn() {
        System.out.println("Turn on Tv");
    }

    void TurnOff() {
        System.out.println("Turn off Tv");
    }
}

class Movie {
    private String name = "";

    Movie(String name) {
        this.name = name;
    }

    void searchMovie() {
        System.out.println("Search Movie");
    }

    void chargeMovie() {
        System.out.println("Charge Movie");
    }

    void plauMovie() {
        System.out.println("Play Movie");
    }
}

class Beverage {
    private String name = "";

    Beverage(String name) {
        this.name = name;
    }

    void prepare() {
        System.out.println(name + " is ready");
    }
}