package io.codelex.flightplanner.flight;

import java.util.Set;

public class SearchFlightReturn {

    Set<Flight> items;

    int totalItems;

    int page;

    public SearchFlightReturn(Set<Flight> items, int totalItems, int page) {
        this.items = items;
        this.totalItems = totalItems;
        this.page = page;
    }

    public Set<Flight> getItems() {
        return items;
    }

    public void setItems(Set<Flight> items) {
        this.items = items;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
