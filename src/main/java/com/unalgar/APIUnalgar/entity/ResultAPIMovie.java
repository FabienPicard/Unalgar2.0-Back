package com.unalgar.APIUnalgar.entity;

import java.util.List;

public class ResultAPIMovie {

    private Long page;
    private List<Movie>results;

    public ResultAPIMovie() {
    }

    public ResultAPIMovie(Long page, List<Movie> results) {
        this.page = page;
        this.results = results;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }
}
