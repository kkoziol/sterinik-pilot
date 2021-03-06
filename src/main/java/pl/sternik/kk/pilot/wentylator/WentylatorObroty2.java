package pl.sternik.kk.pilot.wentylator;

class WentylatorObroty2 implements WentylatorStan {

    private Wentylator wentylator;

	public WentylatorObroty2(Wentylator wentylator) {
    	this.wentylator = wentylator;
    }

	public WentylatorStan wlacz() {
        System.out.println("Nic nie robię");
        return this;
    }

    public WentylatorStan wylacz() {
        System.out.println("Nic nie robię");
        return this;
    }

    public WentylatorStan obroty1() {
        System.out.println("Zmniejszam obroty na 1");
        return wentylator.OBROTY1;
	}

    public WentylatorStan obroty2() {
        System.out.println("Nic nie robię");
        return this;
    }

    public WentylatorStan obroty3() {
        System.out.println("Zwiększam obroty na 3");
        return wentylator.OBROTY3;
    }
}
