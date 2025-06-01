package budget.program.menu.mainmenu.addpurchasemenu;

import budget.program.menu.Menu;
import budget.program.menu.MenuOption;

public class APBackOption implements MenuOption {

    Menu AISubmenu;

    public APBackOption(Menu menu){
        AISubmenu = menu;
    }

    @Override
    public String getName() {
        return "Back";
    }

    @Override
    public void execute() {
        AISubmenu.setBack(true);
    }
}
