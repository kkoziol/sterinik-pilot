package pl.sternik.kk.pilot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import pl.sternik.kk.pilot.comands.Command;
import pl.sternik.kk.pilot.comands.CommandMakro;
import pl.sternik.kk.pilot.comands.CommandPrzelaczMenu;
import pl.sternik.kk.pilot.comands.CommandPusty;
import pl.sternik.kk.pilot.comands.CommandTrybKanapowy;
import pl.sternik.kk.pilot.comands.CommandWylaczWszystko;
import pl.sternik.kk.pilot.comands.CommandZakoncz;
import pl.sternik.kk.pilot.comands.garaz.CommandGarazOtworzDrzwi;
import pl.sternik.kk.pilot.comands.garaz.CommandGarazZamknijDrzwi;
import pl.sternik.kk.pilot.comands.swiatlo.CommandSwiatloWlacz;
import pl.sternik.kk.pilot.comands.swiatlo.CommandSwiatloWylacz;
import pl.sternik.kk.pilot.comands.tv.CommandTelewizorGlosnoscMinus;
import pl.sternik.kk.pilot.comands.tv.CommandTelewizorGlosnoscPlus;
import pl.sternik.kk.pilot.comands.tv.CommandTelewizorKanalMinus;
import pl.sternik.kk.pilot.comands.tv.CommandTelewizorKanalPlus;
import pl.sternik.kk.pilot.comands.tv.CommandTelewizorWlacz;
import pl.sternik.kk.pilot.comands.tv.CommandTelewizorWylacz;
import pl.sternik.kk.pilot.comands.wentylator.CommandWentylatorObroty1;
import pl.sternik.kk.pilot.comands.wentylator.CommandWentylatorObroty2;
import pl.sternik.kk.pilot.comands.wentylator.CommandWentylatorObroty3;
import pl.sternik.kk.pilot.comands.wentylator.CommandWentylatorWlacz;
import pl.sternik.kk.pilot.comands.wentylator.CommandWentylatorWylacz;

public class Pilot {

    private Map<String, Command> przyciski = new HashMap<>();
    private boolean menuTelewizyjne=true;

    public Pilot() {
        przelaczMenu();
    }

    public static void main(String[] args) {

        Pilot pilot = new Pilot();
        boolean czyDalej = true;
        String wybranyNr = null;

        do {
            System.out.println("");

            pilot.wyswietlMenu();
            System.out.print("Wybierz opcję: ");
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
                wybranyNr = br.readLine();
                System.out.println("");
                pilot.kliknijPrzyciskNr(wybranyNr);
                czyDalej = czyWcisnietoZnakWyjscia(wybranyNr);
            } catch (Exception e) {
                System.out.println("");
                System.out.println("Błędny wybór, spróbuj ponownie");
            }

        } while (czyDalej);
    }

    public void kliknijPrzyciskNr(String numer) {
        Command command = getCommandForKey(numer.toUpperCase());
        System.out.println("Kliknięto: " + numer);
        command.execute();
    }

    private static boolean czyWcisnietoZnakWyjscia(String znak) {
        return !(znak.toUpperCase().equals("Z"));
    }

    private Command getCommandForKey(String upperCase) {
        return przyciski.get(upperCase);
    }

    private void wyswietlMenu() {
        System.out.println("------>Menu Pilota<------");
        for (Map.Entry<String, Command> entry : przyciski.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue().getOpis());
        }
    }

    public void przelaczMenu() {

        if (menuTelewizyjne) {
            menuTelewizyjne = false;
            przyciski.put("1", new CommandSwiatloWlacz());
            przyciski.put("2", new CommandSwiatloWylacz());
            przyciski.put("3", new CommandGarazOtworzDrzwi());
            przyciski.put("4", new CommandGarazZamknijDrzwi());
            przyciski.put("5", new CommandWentylatorWlacz());
            przyciski.put("6", new CommandWentylatorObroty1());
            przyciski.put("7", new CommandWentylatorObroty2());
            przyciski.put("8", new CommandWentylatorObroty3());
            przyciski.put("9", new CommandWentylatorWylacz());
            przyciski.put("0", new CommandPrzelaczMenu(this));
            przyciski.put("Z", new CommandZakoncz());
        } else {
            menuTelewizyjne = true;
            przyciski.put("1", new CommandTelewizorWlacz());
            przyciski.put("2", new CommandTelewizorWylacz());
            przyciski.put("3", new CommandTelewizorGlosnoscPlus());
            przyciski.put("4", new CommandTelewizorGlosnoscMinus());
            przyciski.put("5", new CommandTelewizorKanalPlus());
            przyciski.put("6", new CommandTelewizorKanalMinus());
            przyciski.put("7", new CommandPusty());
            Command[] commands = { new CommandTelewizorWylacz(), new CommandWentylatorWylacz() };
            przyciski.put("8", new CommandMakro(commands));
            przyciski.put("9", new CommandPusty());
            // przyciski.put("8", new CommandTrybKanapowy());
            // przyciski.put("9", new CommandWylaczWszystko());
            przyciski.put("0", new CommandPrzelaczMenu(this));
            przyciski.put("Z", new CommandZakoncz());
        }

    }
}
