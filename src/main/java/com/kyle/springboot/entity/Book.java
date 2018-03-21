package com.kyle.springboot.entity;/**
 * @Author: kyle
 * @Description:
 * @Date: Created in 10:22 2018/3/21
 * @Modified By:
 */

/**
 *book
 *@author kyle
 *@create 2018 - 03 - 21 10:22
 */
public class Book {
    private Long id;
    private String name;
    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Book(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Book() {
        super();
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
