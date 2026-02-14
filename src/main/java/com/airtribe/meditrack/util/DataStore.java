package com.airtribe.meditrack.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataStore<T> {

    private List<T> dataList;

    public DataStore() {
        this.dataList = new ArrayList<>();
    }

    public void add(T item) {
        dataList.add(item);
    }

    public List<T> getAll() {
        return dataList;
    }

    public Optional<T> findByIndex(int index) {
        if (index >= 0 && index < dataList.size()) {
            return Optional.of(dataList.get(index));
        }
        return Optional.empty();
    }

    public void remove(T item) {
        dataList.remove(item);
    }
}
