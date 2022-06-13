
public class Main {
    private static Main instance;
    private Main() throws Exception {}

    public void start() throws Exception {
        UserManager.getInstance().startSelector();
    }

    public static Main getInstance() throws Exception {
        if (instance == null)
            instance = new Main();
        return instance;
    }
}
