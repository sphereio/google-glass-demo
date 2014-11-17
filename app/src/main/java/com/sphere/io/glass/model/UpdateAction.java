package com.sphere.io.glass.model;

import java.util.ArrayList;

/**
 * Created by Francisco Villalba on 14/11/14.
 */
public class UpdateAction {
        private int version;
    private ArrayList<Action> actions;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }


    public ArrayList<Action> getActions() {
        return actions;
    }

    public void setActions(ArrayList<Action> actions) {
        this.actions = actions;
    }
}
