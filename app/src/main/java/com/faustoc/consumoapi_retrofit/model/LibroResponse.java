package com.faustoc.consumoapi_retrofit.model;

import java.util.ArrayList;

public class LibroResponse {

    private ArrayList<Testimonio> results;

    public ArrayList<Testimonio> getResults() {
        return results;
    }

    public void setResults(ArrayList<Testimonio> results) {
        this.results = results;
    }
}
