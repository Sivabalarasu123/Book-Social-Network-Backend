package com.springboot.bsn.book;

import com.springboot.bsn.common.PageResponse;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor
@Tag(name = "Book")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Integer> saveBook(@Valid @RequestBody BookRequest request,
                                            Authentication connectedUser
    ) {
        return ResponseEntity.ok(bookService.save(request, connectedUser));
    }

    @GetMapping("{book-id}")
    public ResponseEntity<BookResponse> findBookById(@PathVariable("book-id") Integer bookId) {
        return ResponseEntity.ok(bookService.findBookById(bookId));
    }

    @GetMapping
    public ResponseEntity<PageResponse<BookResponse>> findAllBooks(@RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                                                   @RequestParam(name = "size", defaultValue = "10", required = false) int size,
                                                                   Authentication connectedUser) {
        return ResponseEntity.ok(bookService.findAllBooks(page,size,connectedUser));

    }

    @GetMapping("/owner")
    public ResponseEntity<PageResponse<BookResponse>> findAllBooksByOwner(@RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                                                          @RequestParam(name = "size", defaultValue = "10", required = false) int size,
                                                                          Authentication connectedUser){
        return ResponseEntity.ok(bookService.findAllBooksByOwner(page,size,connectedUser));

    }

    @GetMapping("/borrowed")
    public ResponseEntity<PageResponse<BorrowedBookResponse>> findAllBooksBorrowedBooks(@RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                                                          @RequestParam(name = "size", defaultValue = "10", required = false) int size,
                                                                          Authentication connectedUser){
        return ResponseEntity.ok(bookService.findAllBooksBorrowedBooks(page,size,connectedUser));

    }

    @GetMapping("/returned")
    public ResponseEntity<PageResponse<BorrowedBookResponse>> findAllReturnedBooks(@RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                                                                        @RequestParam(name = "size", defaultValue = "10", required = false) int size,
                                                                                        Authentication connectedUser){
        return ResponseEntity.ok(bookService.findAllReturnedBooks(page,size,connectedUser));

    }

    @PatchMapping("/shareable/{book-id}")
    public ResponseEntity<Integer> shareableStatus(@PathVariable("book-id") Integer bookId,
                                                   Authentication connectedUser){
        return ResponseEntity.ok(bookService.updateShareableStatus(bookId,connectedUser));
    }

    @PatchMapping("/archived/{book-id}")
    public ResponseEntity<Integer> archivedStatus(@PathVariable("book-id") Integer bookId,
                                                   Authentication connectedUser){
        return ResponseEntity.ok(bookService.updateArchivedStatus(bookId,connectedUser));
    }

    @PostMapping("/borrow/{book-id}")
    public ResponseEntity<Integer> borrowBook(@PathVariable("book-id") Integer bookId,
                                              Authentication connectedUser){
        return ResponseEntity.ok(bookService.borrowBook(bookId,connectedUser));
    }

    @PatchMapping("/borrow/return/{book-id}")
    public ResponseEntity<Integer> returnBorrowedBook(@PathVariable("book-id") Integer bookId,
                                                     Authentication connectedUser){
        return ResponseEntity.ok(bookService.returnBorrowedBook(bookId,connectedUser));
    }

    @PatchMapping("/borrow/return/approve/{book-id}")
    public ResponseEntity<Integer> approveReturnBorrowedBook(@PathVariable("book-id") Integer bookId,
                                                      Authentication connectedUser){
        return ResponseEntity.ok(bookService.approveReturnBorrowedBook(bookId,connectedUser));
    }

    @PostMapping(value = "/cover/{book-id}", consumes = "multipart/form-data" )
    public ResponseEntity<?> uploadBookCoverImage(@PathVariable("book-id") Integer bookId,
                                                  @Parameter()
                                                  @RequestPart("file") MultipartFile file,
                                                  Authentication connectedUser) throws IOException {
        bookService.uploadBookCoverImage(file,connectedUser,bookId);
        return ResponseEntity.accepted().build();
    }

}
