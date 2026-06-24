package Modelo;

import Modelo.Strategy.MenuStrategy;

public class AsignarMenuModelo {
    MenuStrategy menu;

    void modificarMenu(MenuStrategy menu){
        this.menu = menu;
    }

    String cocinarMenu(){
        return menu.cocinar();
    }
}
