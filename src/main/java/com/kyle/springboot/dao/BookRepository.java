package com.kyle.springboot.dao;

import com.kyle.springboot.entity.Book;

/**
 * @Author: kyle
 * @Description:
 * @Date: Created in 17:52 2018/3/21
 * @Modified By:
 */
public interface BookRepository {
    /**
     * @author: kyle
     * @date: 2018/3/22 9:52
     * @description: 通过id查找对应book
     * @param: [id]
     * @return: com.kyle.springboot.entity.Book
     * @throws:
     */
    Book getById(Long id);
}
