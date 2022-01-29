package com.orderbook.platform.book.restapi;

import com.orderbook.platform.book.application.BookDto;
import com.orderbook.platform.book.application.BookService;
import com.orderbook.platform.book.application.CreateBookVO;
import com.orderbook.platform.book.restapi.request.UpdateRequest;
import com.orderbook.platform.book.restapi.response.BookResponse;
import com.orderbook.platform.common.ResponseHandler;
import com.orderbook.platform.common.api.rest.BaseController;
import com.orderbook.platform.book.restapi.request.CreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(
        path = "/v1/books",
        produces = "application/json")
public class BookController extends BaseController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(
            path = "/create",
            consumes = "application/json")
    public ResponseEntity<Object> createBook(@Validated @RequestBody CreateRequest input){
            CreateBookVO form = CreateBookVO
                    .builder()
                    .isbn(input.getIsbn())
                    .title(input.getTitle())
                    .description(input.getDescription())
                    .published_on(input.getPublished_on())
                    .publisher(input.getPublisher())
                    .org_price(input.getOrg_price())
                    .author(input.getAuthor())
                    .build();

            String result = bookService.createBook(form);
            return ResponseHandler.generateResponse("Created", HttpStatus.CREATED, result);
    }

    @PutMapping(
            path = "/{bookId}",
            consumes = "application/json")
    public ResponseEntity<Object> updateBookById(
            @PathVariable("bookId") Long id,
            @Validated @RequestBody UpdateRequest input) {
        BookResponse result = BookResponse.from(bookService.updateBookById(input.toDto(), id));

        return ResponseHandler.generateResponse("Ok", HttpStatus.OK, result);
    }

    @GetMapping(path = "")
    public ResponseEntity<Object> getAllBook() {
        List<BookDto> bookDtoList = bookService.getAllBook();
        List<BookResponse> result = new ArrayList<>();
        for (BookDto bookDto: bookDtoList) {
            result.add(BookResponse.from(bookDto));
        }

        return ResponseHandler.generateResponse("OK", HttpStatus.OK, result);
    }

    @GetMapping(path = "/{bookId}")
    public ResponseEntity<Object> getBookDetailById(@PathVariable("bookId") Long bookId) {
        BookResponse result = BookResponse
                .from(bookService.getBookDetailById(bookId));

        return ResponseHandler.generateResponse("OK", HttpStatus.OK, result);
    }

    @GetMapping(path = "/book/{bookTitle}")
    public ResponseEntity<Object> getAllBookByTitle(@PathVariable("bookTitle") String bookTitle) {
        List<BookDto> bookDtoList = bookService.getAllBookByTitle(bookTitle);
        List<BookResponse> result = new ArrayList<>();
        for (BookDto bookDto: bookDtoList) {
            result.add(BookResponse.from(bookDto));
        }

        return ResponseHandler.generateResponse("OK", HttpStatus.OK, result);
    }

    @DeleteMapping(path = "/{bookId}")
    public ResponseEntity<Object> deleteBookById(@PathVariable("bookId") Long bookId) {
        try {
            bookService.deleteBookById(bookId);

            return ResponseHandler.generateResponse("Book deleted successfully", HttpStatus.OK, null);
        }catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.NO_CONTENT, null);
        }
    }
}
