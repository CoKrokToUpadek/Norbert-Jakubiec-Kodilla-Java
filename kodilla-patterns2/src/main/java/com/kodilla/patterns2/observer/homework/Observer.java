package com.kodilla.patterns2.observer.homework;

import com.kodilla.patterns2.observer.forum.ForumTopic;

public interface Observer {
    void update(KodillaUser kodillaUser, int taskNo);
}