package pl.sternik.kk.pilot.wentylator;

public final class Wentylator {
    private static Wentylator instance = new Wentylator();

    private Wentylator() {
        System.out.println("Tworzę sprzęt Wentylator");
    };

    public static Wentylator instance() {
        return instance;
    }

    public void wlacz() {
        System.out.println("Włączam Wentylator");
    }

    public void wylacz() {
        System.out.println("wyłączam wentylator");
    }

    public void obroty1() {
        System.out.println("Obroty na 1");
    }

    public void obroty2() {
        System.out.println("obroty na 2");
    }

    public void obroty3() {
        System.out.println("obroty na 3");
    }
}
