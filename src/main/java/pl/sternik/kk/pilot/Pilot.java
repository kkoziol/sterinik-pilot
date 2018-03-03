package pl.sternik.kk.pilot;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import pl.sternik.kk.pilot.comands.Command;
import pl.sternik.kk.pilot.comands.menu.MenuDom;
import pl.sternik.kk.pilot.comands.menu.MenuPilota;
import pl.sternik.kk.pilot.comands.menu.MenuTv;
import pl.sternik.kk.pilot.swiatlo.Swiatlo;

public class Pilot {

	public static void main(String[] args) {

		Swiatlo swiatlo = Swiatlo.instance();
		swiatlo.wlacz();
		swiatlo.wylacz();
	}
}
