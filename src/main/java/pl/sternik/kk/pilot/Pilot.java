package pl.sternik.kk.pilot;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import pl.sternik.kk.pilot.comands.Command;
import pl.sternik.kk.pilot.comands.menu.MenuDom;
import pl.sternik.kk.pilot.comands.menu.MenuPilota;
import pl.sternik.kk.pilot.comands.menu.MenuTv;
import pl.sternik.kk.pilot.garaz.Garaz;
import pl.sternik.kk.pilot.swiatlo.Swiatlo;
import pl.sternik.kk.pilot.tv.Telewizor;
import pl.sternik.kk.pilot.wentylator.Wentylator;

public class Pilot {

	public static void main(String[] args) {

		Swiatlo swiatlo = Swiatlo.instance();
		swiatlo.wlacz();
		swiatlo.wylacz();

		Garaz garaz = Garaz.instance();
		garaz.drzwiGora();
		garaz.drzwiGora();
		garaz.drzwiDol();

		Telewizor telewizor = Telewizor.instance();
		telewizor.glosnoscPlus();
		telewizor.kanalPlus();
		telewizor.wlacz();
		telewizor.kanalMinus();
		telewizor.glosnoscMinus();

		Wentylator wentylator = Wentylator.instance();
		wentylator.obroty2();
	}
}
