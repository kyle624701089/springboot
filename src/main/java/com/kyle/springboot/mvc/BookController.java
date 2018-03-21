package com.kyle.springboot.mvc;/**
 * @Author: kyle
 * @Description:
 * @Date: Created in 10:27 2018/3/21
 * @Modified By:
 */

import com.kyle.springboot.entity.Book;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *@author kyle
 *@create 2018 - 03 - 21 10:27
 */
@RestController
@RequestMapping("/books")
public class BookController {
    private Map<Long, Book> books = Collections.synchronizedMap(new HashMap<Long,Book>());

    @ApiOperation(value = "创建book",notes = "创建图书实体")
    @ApiImplicitParam(value = "图书实体",name = "book",dataType = "Book",required = true)
    @RequestMapping(value = "",method = RequestMethod.POST)
    public String addBook(@RequestBody Book book){
        books.put(book.getId(),book);
        return "success";
    }

    @ApiOperation(value = "根据id获取book",notes = "从url中获取id，然后查询book")
    @ApiImplicitParam(value = "ID",name = "id",dataType = "Long",required = true,paramType = "path")
    @RequestMapping(value= "/{id}",method=RequestMethod.GET)
    public Book getBookById(@PathVariable Long id){
        return books.get(id);
    }

    @ApiOperation(value = "根据id删除book",notes = "从url中获取id，然后删除book")
    @ApiImplicitParam(value = "ID",name = "id",dataType = "Long",required = true,paramType = "path")
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String delBookById(@PathVariable Long id){
        books.remove(id);
        return "success";
    }

    @ApiOperation(value = "更新book",notes = "从url中获取id，然后查出book并进行更新")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "ID",name = "id",dataType = "Long",required = true,paramType = "path")
            ,@ApiImplicitParam(value = "图书实体",name = "book",dataType = "Book",required = true)
    })
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String updateBook(@PathVariable Long id, @RequestBody Book book){
        Book book1 = books.get(id);
        book1.setName(book.getName());
        book1.setPrice(book.getPrice());
        books.put(id,book1);
        return "success";
    }

    @ApiIgnore//使用该注解忽略这个API
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String  jsonTest() {
        return " hi you!";
    }
}
