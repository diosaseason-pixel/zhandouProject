package com.game.role.execl;

import com.game.common.entity.PropEntity;
import com.game.common.execl.convert.PropConverter;
import com.game.execl.ExcelFile;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
@ExcelFile(fileName = "BornDestiny.csv")
public class BornDestinyTable {
    // ID
    @ExcelProperty(index = 0)
    private Integer id;

    // 名称
    @ExcelProperty(index = 1)
    private String name;

    // 图片
    @ExcelProperty(index = 2)
    private String pic;

    // 描述
    @ExcelProperty(index = 3)
    private String description;

    // 获得物品，格式为JSON数组字符串
    @ExcelProperty(index = 4)
    private String gainItem;

    // 属性，格式为JSON对象：{"属性名":值}
    @ExcelProperty(index = 5, converter = PropConverter.class)
    private PropEntity properties;

    // 品质
    @ExcelProperty(index = 6)
    private Integer quality;
}
