package com.springboot.bsn.feedback;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackResponse {

    Double rating;
    String comment;
    private boolean ownFeedback;
}
