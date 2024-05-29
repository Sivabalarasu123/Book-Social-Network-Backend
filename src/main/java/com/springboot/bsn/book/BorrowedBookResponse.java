package com.springboot.bsn.book;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BorrowedBookResponse {
    private Integer id;
    private String title;
    private String authorName;
    private String isbn;
    private Double rate;
    private boolean isReturned;
    private boolean isReturnApproved;
}
