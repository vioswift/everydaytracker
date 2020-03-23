package Actions;

import java.awt.event.ActionListener;
import GUI.Window;

public class Actions {
    private Window window;

    public Actions(Window window) {
        this.window = window;
    }

    public ActionListener mi_open = e -> {
        File_System file_system = new File_System();

        file_system.open_file();



        window.editorPane.setText("TESTTTTT");
    };

    public ActionListener mi_new = e -> {
        System.out.println("new");
    };

    public ActionListener mi_exit = e -> {
        System.out.println("exit");
    };
}
