package com.kyle.springboot.dao;

import com.kyle.springboot.entity.Book;

/**
 * @Author: kyle
 * @Description:
 * @Date: Created in 17:52 2018/3/21
 * @Modified By:
 */
public interface BookRepository {
    Book getById(Long id);
}
