package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import java.time.LocalDate;
import java.time.Period;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        new Forum().getUserList().stream()
                .filter(u -> u.getSex() == 'M')
                .filter(u -> Period.between(u.getBirthDate(), LocalDate.now()).getYears() >= 20)
                .filter(u -> u.getPostCount() >= 1)
                .collect(Collectors.toMap(ForumUser::getId, u -> u)).entrySet().stream()
                .map(m -> m.getKey() + ": " + m.getValue())
                .forEach(System.out::println);
    }
}