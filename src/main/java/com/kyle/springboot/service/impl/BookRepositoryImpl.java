package com.kyle.springboot.service.impl;/**
 * @Author: kyle
 * @Description:
 * @Date: Created in 17:53 2018/3/21
 * @Modified By:
 */

import com.kyle.springboot.dao.BookRepository;
import com.kyle.springboot.entity.Book;
import org.springframework.stereotype.Component;

/**
 *
 *@author kyle
 *@create 2018 - 03 - 21 17:53
 */
@Component
public class BookRepositoryImpl implements BookRepository {
    @Override
    public Book getById(Long id) {
        sleep();
        return new Book(1L,"西游记",20.0D);
    }

    private void sleep(){
        try{
            Thread.sleep(3000L);
        }catch (InterruptedException e){
            throw new IllegalStateException(e);
        }
    }
}
