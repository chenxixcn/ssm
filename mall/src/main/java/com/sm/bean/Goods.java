package com.sm.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Goods {
    private Integer id;
    private String cover;
    private String name;
    private String intro;
    private String spec;
    private Double price;
    private Integer stock;
    private Integer sales;
    private String content;
    private Integer type_id;
    private String typeName;
    private Integer type;
}
