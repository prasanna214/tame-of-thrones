package com.goldencrown.model;

import java.util.List;

public class Universe {
    private Kingdom ruler;
    private List<Kingdom> kingdoms;

    public Universe(List<Kingdom> kingdoms) {
        this.kingdoms = kingdoms;
    }

    public Kingdom getRuler() {
        return ruler;
    }

    public void setRuler(Kingdom ruler) {
        this.ruler = ruler;
    }

    public List<Kingdom> getKingdoms() {
        return kingdoms;
    }
}