package com.sm.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Orders {
    private int id;
    private Double total;
    private int amount;
    private int status;
    private int paytype;
    private String name;
    private String phone;
    private String address;
    private Date systime;
    private int user_id;

    private Users users;
    private List<Items> items;

    private String statusStr;
    private String paytypeStr;
    private String systimeStr;

    public String getStatusStr() {
        switch (status){
            case 1:
                statusStr="未付款";
                break;
            case 2:
                statusStr="已付款";
                break;
            case 3:
                statusStr="已发货";
                break;
            case 4:
                statusStr="已完成";
                break;
            default:
                break;
        }
        return statusStr;
    }

    public String getPaytypeStr() {
        switch (paytype){
            case 1:
                paytypeStr="微信";
                break;
            case 2:
                paytypeStr="支付宝";
                break;
            default:
                break;
        }
        return paytypeStr;
    }

    public String getSystimeStr(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        systimeStr=sdf.format(systime);
        return systimeStr;
    }
}
