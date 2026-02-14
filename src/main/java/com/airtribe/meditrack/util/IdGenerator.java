package com.airtribe.meditrack.util;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {

    private static final AtomicInteger counter = new AtomicInteger(1);
    private static final IdGenerator instance = new IdGenerator();

    private IdGenerator() {
        System.out.println("IdGenerator initialized");
    }

    public static IdGenerator getInstance() {
        return instance;
    }

    public int generateId() {
        return counter.getAndIncrement();
    }
}
