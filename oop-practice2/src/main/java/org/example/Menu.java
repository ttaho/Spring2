package org.example;

import java.util.List;

public class Menu {
    private final List<MenuItem> menuItems;

    public Menu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public MenuItem choose(String name) {
        return this.menuItems.stream()
                .filter(menuItem -> menuItem.matches(name)) //name이랑 매칭했을때 같은거중
                .findFirst() //첫번째를 가져온다
                .orElseThrow(() -> new IllegalArgumentException("잘못된 메뉴 이름입니다."));//만약에 하나도 일치하는것이 없다면 잘못된메뉴이름입니다를 출력
    }
}
