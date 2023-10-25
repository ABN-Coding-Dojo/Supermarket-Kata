package org.suupaamaaketto.api;

import com.google.gson.Gson;

public class Main {

    private Gson gson;

    public Main() {
        this.gson = new Gson();
    }

    public String call(String route) {
        return this.gson.toJson(new Object());
    }
}
// Bart Knaack
