package edu.attractor.onlineshop.Dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FeedbackDto {
    private int orderFor;

    private String reviewContent;

    private LocalDateTime localDateTime;
}
