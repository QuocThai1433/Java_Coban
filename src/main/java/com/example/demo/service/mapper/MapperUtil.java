package com.example.demo.service.mapper;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapperUtil {
    MapperUtil() {
    }
    
    public static <T, R> List<T> mapList(List<R> source, Function<R, T> mapper) {
        return source.stream().map(mapper).collect(Collectors.toList());
    }
    
    public static <T, R> Set<T> mapSet(Set<R> source, Function<R, T> mapper) {
        return source.stream().map(mapper).collect(Collectors.toSet());
    }
}
