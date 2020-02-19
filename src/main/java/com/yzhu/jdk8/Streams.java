package com.yzhu.jdk8;

import java.util.Arrays;
import java.util.Collection;

public class Streams  {
    private enum Status {
        OPEN, CLOSED
    };

    private static final class Task {
        private final Status status;
        private final Integer points;

        Task( final Status status, final Integer points ) {
            this.status = status;
            this.points = points;
        }

        public Integer getPoints() {
            return points;
        }

        public Status getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return String.format( "[%s, %d]", status, points );
        }
    }

    final Collection< Task > tasks = Arrays.asList(
            new Task( Status.OPEN, 5 ),
            new Task( Status.OPEN, 13 ),
            new Task( Status.CLOSED, 8 )
    );
    long totalPointsOfOpenTasks = tasks
            .stream()
            .filter( task -> task.getStatus() == Status.OPEN )
            .mapToInt( Task::getPoints )
            .sum();
}
