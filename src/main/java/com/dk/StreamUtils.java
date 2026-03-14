package com.dk;

import java.util.stream.Stream;

public class StreamUtils {
    public static Stream<String> wordStream(){
        return Stream.of("Hello", "World", "Fun", "Java");
    }
}
