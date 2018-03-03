package pl.sternik.kk.pilot.comands;

public class CommandMakro implements Command {

    private final Command[] commands;

    public CommandMakro(Command[] commands) {
        this.commands = commands;
    }

    public void execute() {
        for (int i = 0; i < commands.length; i++) {
            commands[i].execute();
        }
    }

    public String getOpis() {
        StringBuilder opis = new StringBuilder("Makro:");
        for (int i = 0; i < commands.length; i++) {
            opis.append(commands[i].getOpis());
        }
        return opis.toString();
    }
}