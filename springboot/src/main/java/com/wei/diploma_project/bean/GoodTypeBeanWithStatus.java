package com.wei.diploma_project.bean;

import lombok.Data;

/**
 * User: 韦龙
 * Date: 2023/3/13
 * description:
 */
/* 大类对应的小类 */
@Data
public class GoodTypeBeanWithStatus {
    private Integer gtype_id;
    private Integer gcategory_id;
    private String gtype_name;
    private Integer status;
}
