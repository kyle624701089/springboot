package com.kyle.springboot;/**
 * @Author: kyle
 * @Description:
 * @Date: Created in 17:59 2018/3/21
 * @Modified By:
 */

import com.kyle.springboot.dao.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 *@author kyle
 *@create 2018 - 03 - 21 17:59
 */
@Component
public class BookTest implements CommandLineRunner{
    private static final Logger logger = LoggerFactory.getLogger(BookTest.class);

    private final BookRepository bookRepository;

    public BookTest(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info(".... Fetching books");
        logger.info("isbn-1234 -->" + bookRepository.getById(1L));
        logger.info("isbn-4567 -->" + bookRepository.getById(1L));
        logger.info("isbn-1234 -->" + bookRepository.getById(1L));
        logger.info("isbn-4567 -->" + bookRepository.getById(1L));
        logger.info("isbn-1234 -->" + bookRepository.getById(1L));
        logger.info("isbn-1234 -->" + bookRepository.getById(1L));
    }
}
