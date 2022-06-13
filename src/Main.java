import model.User;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main {
    private static Main instance;
    private Main() {}

    public void start() throws Exception {
        UserManager.getInstance().startSelector();
    }

    public static Main getInstance() throws Exception {
        if (instance == null)
            instance = new Main();
        return instance;
    }
}
