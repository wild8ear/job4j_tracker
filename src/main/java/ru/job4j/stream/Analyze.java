package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(Pupil -> Pupil.subjects().stream())
                .mapToDouble(Subject::score)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.map(Pupil -> new Tuple(Pupil.name(), Pupil.subjects().stream()
                .mapToDouble(Subject::score)
                .average()
                .orElse(0D)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.flatMap(Pupil -> Pupil.subjects().stream())
                .collect(Collectors.groupingBy(Subject::name, LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::score))).entrySet().stream()
                .map(item -> new Tuple(item.getKey(), item.getValue())).collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(Pupil -> new Tuple(Pupil.name(), Pupil.subjects().stream()
                        .mapToInt(Subject::score)
                        .sum())).max(Comparator.comparingDouble(Tuple::score))
                .orElse(new Tuple("", 0D));
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(Pupil -> Pupil.subjects().stream())
                .collect(Collectors.groupingBy(Subject::name, LinkedHashMap::new,
                        Collectors.summingDouble(Subject::score))).entrySet().stream()
                .map(item -> new Tuple(item.getKey(), item.getValue()))
                .max(Comparator.comparingDouble(Tuple::score))
                .orElse(new Tuple("", 0D));
    }
}