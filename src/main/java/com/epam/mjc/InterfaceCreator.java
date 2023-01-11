package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for (String value : x) {
                if (!Character.isUpperCase(value.charAt(0))) return false;
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> listOfIntegers = List.copyOf(x);
            listOfIntegers.forEach(num -> {
                if (num % 2 == 0) x.add(num);
            });
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {

        return () -> {
            return values.stream()
                    .filter(val -> Character.isUpperCase(val.charAt(0))
                            && val.split(" ").length > 3
                            && val.endsWith(".")).collect(Collectors.toList());
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        Map<String, Integer> map = new HashMap<>();
        return x -> {
            x.forEach(val -> map.put(val, val.length()));
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (x, y) -> {
            List<Integer> merged = new ArrayList<>(x);
            merged.addAll(y);
            return merged;
        };
    }
}
