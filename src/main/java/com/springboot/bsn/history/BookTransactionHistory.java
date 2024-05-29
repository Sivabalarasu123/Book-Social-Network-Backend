package com.springboot.bsn.history;

import com.springboot.bsn.book.Book;
import com.springboot.bsn.common.BaseEntity;
import com.springboot.bsn.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BookTransactionHistory extends BaseEntity {

    //user relationship
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //book relationship
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private boolean isReturned;
    private boolean isReturnApproved;
}
