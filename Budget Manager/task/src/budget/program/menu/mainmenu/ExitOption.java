package budget.program.menu.mainmenu;

import budget.program.menu.Menu;
import budget.program.menu.MenuOption;

public class ExitOption implements MenuOption {

    private Menu mainMenu;

    public ExitOption (Menu mainMenu) {
        this.mainMenu = mainMenu;
    }

    @Override
    public String getName() {
        return "Exit";
    }

    @Override
    public void execute() {
        System.out.println("Bye!");
        mainMenu.setBack(true);
    }
}
