import controller.LaunchDirector;
import view.MissionControlConsole;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MissionControlConsole console = new MissionControlConsole();

        LaunchDirector director = new LaunchDirector(console);

        director.initiateLaunchSequence();
    }
}