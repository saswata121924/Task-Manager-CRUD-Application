package com.example.MongoDBDemo;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskCreateRequest {

    private String description;
    private int severity;
    private String assignee;
    private int storyPoint;

    public Task to(){
        return Task.builder()
                .description(description)
                .assignee(assignee)
                .storyPoint(storyPoint)
                .severity(severity)
                .build();
    }
}
