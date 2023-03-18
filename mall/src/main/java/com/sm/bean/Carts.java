package com.sm.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Carts {
    private int id;
    private int amount;
    private int good_id;
    private int user_id;

    private Goods goods;
}
