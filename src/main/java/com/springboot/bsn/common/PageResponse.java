package com.springboot.bsn.common;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageResponse<T> {

    private List<T> content;
    private int number;
    private int size;
    private long totalElement;
    private int totalPages;
    private boolean isFirst;
    private boolean isLast;
}
