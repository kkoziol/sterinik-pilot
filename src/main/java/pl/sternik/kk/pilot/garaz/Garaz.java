package pl.sternik.kk.pilot.garaz;

public final class Garaz {
	private static Garaz instance = new Garaz();

	private Garaz() {
		System.out.println("Tworzę sprzęt Garaz");
	};

	public static Garaz instance() {
		return instance;
	}

	public void drzwiDol() {
		System.out.println("Opuszczam drzwi");
	}

	public void drzwiGora() {
		System.out.println("Podnosze drzwi");
	}
}
