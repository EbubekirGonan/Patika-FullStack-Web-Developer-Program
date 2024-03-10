package dev.patika.api;

import dev.patika.business.abstracts.IAuthorService;
import dev.patika.business.abstracts.IBookService;
import dev.patika.business.abstracts.ICategoryService;
import dev.patika.business.abstracts.IPublisherService;
import dev.patika.core.config.modelMapper.IModelMapperService;
import dev.patika.core.result.Result;
import dev.patika.core.result.ResultWithData;
import dev.patika.core.utilities.ResultHelper;
import dev.patika.dto.request.book.BookSaveRequest;
import dev.patika.dto.request.book.BookUpdateRequest;
import dev.patika.dto.response.CursorResponse;
import dev.patika.dto.response.book.BookResponse;
import dev.patika.entities.Author;
import dev.patika.entities.Book;
import dev.patika.entities.Publisher;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/books")
public class BookController {
    private final IBookService bookService;
    private final IAuthorService authorService;
    private final IPublisherService publisherService;
    private final ICategoryService categoryService;
    private final IModelMapperService modelMapper;

    //CRUD
    //create, read, update, delete
    //+cursor

    public BookController(IBookService bookService, IAuthorService authorService, IPublisherService publisherService, ICategoryService categoryService, IModelMapperService modelMapper) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.publisherService = publisherService;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultWithData<BookResponse> save(@Valid @RequestBody BookSaveRequest bookSaveRequest){
        Book book = this.modelMapper.forRequest().map(bookSaveRequest, Book.class);

        Author author = this.authorService.get(bookSaveRequest.getAuthorId());
        book.setAuthor(author);

        Publisher publisher = this.publisherService.get(bookSaveRequest.getPublisherId());
        book.setPublisher(publisher);

        book.setCategoryList(this.categoryService.findAllByIds(bookSaveRequest.getCategoryIds()));

        this.bookService.save(book);
        return ResultHelper.success(this.modelMapper.forResponse().map(book, BookResponse.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<BookResponse> get(@PathVariable("id") int id){
        Book book = this.bookService.get(id);
        return ResultHelper.success(this.modelMapper.forResponse().map(book, BookResponse.class));
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<BookResponse> update(@Valid @RequestBody BookUpdateRequest bookUpdateRequest){
        Book updateBook = this.modelMapper.forRequest().map(bookUpdateRequest, Book.class);

        Author author = this.authorService.get(bookUpdateRequest.getAuthorId());
        updateBook.setAuthor(author);

        Publisher publisher = this.publisherService.get(bookUpdateRequest.getPublisherId());
        updateBook.setPublisher(publisher);

        this.bookService.update(updateBook);
        return ResultHelper.success(this.modelMapper.forResponse().map(updateBook, BookResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id){
        this.bookService.delete(id);
        return ResultHelper.ok();
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<CursorResponse<BookResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ){
        Page<Book> bookPage = this.bookService.cursor(page, pageSize);
        Page<BookResponse> bookResponses = bookPage.map(book -> this.modelMapper.forResponse().map(book, BookResponse.class));
        return ResultHelper.cursor(bookResponses);
    }

}
