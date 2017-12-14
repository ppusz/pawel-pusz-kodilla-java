package com.kodilla.patterns.builder.bigmac;

public class Bun {

    private boolean sesame;

    public Bun(boolean sesame) {
        this.sesame = sesame;
    }

    public boolean withSesame() {
        return sesame;
    }

    @Override
    public String toString() {
        return "with" + (sesame ? "" : "out") + " sesame seeds";
    }
}
