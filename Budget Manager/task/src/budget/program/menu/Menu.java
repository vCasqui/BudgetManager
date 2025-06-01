package budget.program.menu;

import java.util.List;

public abstract class Menu {
    protected List<MenuOption> options;
    protected boolean back;

    public abstract void show();
    public abstract boolean getBack();
    public abstract void setBack(boolean flag);
}
