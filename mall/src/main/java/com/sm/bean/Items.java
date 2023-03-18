package com.sm.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Items {
    private int id;
    private Double price;
    private int amount;
    private int order_id;
    private int good_id;

    private Goods goods;
}
