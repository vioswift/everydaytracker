package GUI;

import javax.swing.*;
import java.awt.*;
import Actions.Actions;

public class Window {
    private JFrame frame;
    private JPanel container = new JPanel(new BorderLayout());
    private int width;
    private int height;
    private String title = "Untitled";
    public String[] days = { "monday", "tuesday", "wednesday", "thrusday" };
    public JList day_list;
    public JEditorPane editorPane = new JEditorPane();
    public JMenuBar menu_bar = new JMenuBar();
    public JMenu menu;
    public JMenuItem mi_open, mi_exit, mi_new;

    public Window(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;

        this.add_menu();
        this.add_day_list();
        this.add_container();
        this.add_frame();
    }

    public void add_frame() {
        frame = new JFrame(title);
        frame.add(container);
        frame.setJMenuBar(menu_bar);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void add_container() {
        container.add(day_list, BorderLayout.WEST);
        container.add(editorPane);
    }

    public void add_menu() {
        Actions actions = new Actions(this);
        menu = new JMenu("File");
        mi_open = new JMenuItem("Open");
        mi_new = new JMenuItem("New");
        mi_exit = new JMenuItem("Exit");

        mi_open.addActionListener(actions.mi_open);
        mi_new.addActionListener(actions.mi_new);
        mi_exit.addActionListener(actions.mi_exit);

        menu.add(mi_open);
        menu.add(mi_new);
        menu.add(mi_exit);

        menu_bar.add(menu);
    }

    public void add_day_list() {
        int cell_width = 100;

        day_list = new JList(days);
        day_list.setFixedCellWidth(cell_width);
        day_list.setBackground(Color.darkGray);
        day_list.setForeground(Color.white);
    }
}
