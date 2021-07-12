package com.company.GameFrame;

import java.util.HashMap;

public interface Levels {
    HashMap<String, Integer> levels = new HashMap<>(){{
        put("easy", 100);
        put("medium", 70);
        put("hard", 40);
    }};

    HashMap<String, Integer> gameUnit = new HashMap<>(){{
        put("small", 45);
        put("medium", 30);
        put("huge", 10);
    }};
}
