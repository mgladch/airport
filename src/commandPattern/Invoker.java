package commandPattern;

import commandPattern.commands.Command;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
    private List<Command> doneCommands;
    private Command command;

    public Invoker() {
        doneCommands = new ArrayList<>();
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public boolean invoke(String[] parameters){
        doneCommands.add(command);
        try {
            return command.execute(parameters);
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }
}