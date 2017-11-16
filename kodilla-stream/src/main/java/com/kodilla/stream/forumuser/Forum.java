package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {

    private final List<ForumUser> userList = new ArrayList<>();

    public Forum() {
        userList.add(new ForumUser(1,"mickey", 'M', LocalDate.of(2008,10,13), 13));
        userList.add(new ForumUser(2,"johny", 'M', LocalDate.of(2001,1,3), 7));
        userList.add(new ForumUser(3,"susan", 'F', LocalDate.of(1989,11,22), 1057));
        userList.add(new ForumUser(4,"ToSexyForMySelf", 'M', LocalDate.of(1979,5,29), 106));
        userList.add(new ForumUser(5,"speedy", 'M', LocalDate.of(1996,11,14), 56));
        userList.add(new ForumUser(6,"justagirl", 'F', LocalDate.of(2008,4, 4), 11));
        userList.add(new ForumUser(7,"alice", 'F', LocalDate.of(1997,11, 15), 37));
        userList.add(new ForumUser(8,"alpha", 'M', LocalDate.of(2002,12,31), 1));
        userList.add(new ForumUser(9,"user", 'M', LocalDate.of(1983,9,6), 567));
        userList.add(new ForumUser(10,"frank", 'M', LocalDate.of(1998,4,19), 77));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(userList);
    }
}
