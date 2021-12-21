package com.orderbook.platform.book.restapi;

import com.orderbook.platform.book.application.BookService;
import com.orderbook.platform.book.application.CreateBookVO;
import com.orderbook.platform.common.api.rest.BaseController;
import com.orderbook.platform.book.restapi.request.CreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping(
        path = "/v1/books",
        produces = MediaType.APPLICATION_JSON)
public class BookController extends BaseController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(
            path = "/create",
            consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<Object> login(@Validated @RequestBody CreateRequest input){
        CreateBookVO form = CreateBookVO
                .builder()
                .title(input.getTitle())
                .description(input.getDescription())
                .published_on(input.getPublished_on())
                .publisher(input.getPublisher())
                .org_price(input.getOrg_price())
                .author(input.getAuthor())
                .build();

//        bookService.createBook(form);
        return new ResponseEntity<>(bookService.createBook(form), HttpStatus.CREATED);
//        return ApiResponseUtils
//                .buildSuccessResponse(ResponseCode.OK, "");
    }
}
