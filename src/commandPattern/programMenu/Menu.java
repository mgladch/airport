package commandPattern.programMenu;

import commandPattern.Invoker;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class Menu {
    static Invoker invoker = new Invoker();
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    protected static void printSeparator(){
        System.out.println("--------------------------------------------------------------");
    }
}
