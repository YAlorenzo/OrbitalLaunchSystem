import controller.LaunchDirector;
import view.MissionControlConsole;

public class Main {
    public static void main(String[] args) {
        MissionControlConsole console = new MissionControlConsole();

        LaunchDirector director = new LaunchDirector(console);

        director.initiateLaunchSequence();
    }
}