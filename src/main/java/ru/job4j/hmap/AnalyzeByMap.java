package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int countSubjects = 0;
        double scope = 0D;
        for (Pupil pupil : pupils) {
            for (Subject sub : pupil.subjects()) {
                scope += sub.score();
                countSubjects += 1;
            }
        }
        return scope / countSubjects;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        double scope = 0D;
        List<Label> listLabel = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject sub : pupil.subjects()) {
                scope += sub.score();
            }
            listLabel.add(new Label(pupil.name(), scope / pupil.subjects().size()));
            scope = 0D;
        }
        return listLabel;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> listLabel = new ArrayList<>();
        LinkedHashMap<String, Double> mapScope = new LinkedHashMap<>();
        double scope;
        for (Pupil pupil : pupils) {
            scope = 0D;
            for (Subject sub : pupil.subjects()) {
                if (mapScope.containsKey(sub.name())) {
                    scope = mapScope.get(sub.name());
                }
                mapScope.put(sub.name(), scope + sub.score());
            }
        }
        for (Map.Entry<String, Double> entry: mapScope.entrySet()) {
            listLabel.add(new Label(entry.getKey(), entry.getValue() / pupils.size()));
        }
        return listLabel;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> listLabel = new ArrayList<>();
        double scope = 0D;
        for (Pupil pupil : pupils) {
            for (Subject sub : pupil.subjects()) {
                scope += sub.score();
            }
            listLabel.add(new Label(pupil.name(), scope));
            scope = 0D;
        }
        listLabel.sort(Comparator.naturalOrder());
        return listLabel.get(listLabel.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> listLabel = new ArrayList<>();
        LinkedHashMap<String, Double> mapScope = new LinkedHashMap<>();
        double scope = 0D;
        for (Pupil pupil : pupils) {
            for (Subject sub : pupil.subjects()) {
                if (mapScope.containsKey(sub.name())) {
                    scope = mapScope.get(sub.name());
                }
                mapScope.put(sub.name(), scope + sub.score());
            }
        }
        for (Map.Entry<String, Double> entry: mapScope.entrySet()) {
            listLabel.add(new Label(entry.getKey(), entry.getValue()));
        }
        listLabel.sort(Comparator.naturalOrder());
        return listLabel.get(listLabel.size() - 1);
    }
}