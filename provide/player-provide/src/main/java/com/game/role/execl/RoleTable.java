package com.game.role.execl;

import com.alibaba.excel.annotation.ExcelProperty;
import com.game.common.entity.PropEntity;
import com.game.common.execl.MetaWrapItem;
import com.game.common.execl.convert.PropConverter;
import com.game.common.execl.convert.WrapItemListConverter;
import com.game.execl.ExcelFile;
import lombok.Data;

import java.util.List;

@Data
@ExcelFile(fileName = "Role.csv")
public class RoleTable {
    // 等级
    @ExcelProperty(index = 0)
    private Integer id;

    // 品阶
    @ExcelProperty(index = 1)
    private Integer grade;

    // 阶段
    @ExcelProperty(index = 2)
    private Integer stage;

    // 药品限制
    @ExcelProperty(index = 3)
    private Integer drugLimit;

    // 需要身体阶段
    @ExcelProperty(index = 4)
    private Integer needBodyStage;

    // 需要经验
    @ExcelProperty(index = 5)
    private Integer needExp;

    // 需要道具，格式为JSON数组字符串：[[类型,道具ID,数量]]
    @ExcelProperty(index = 6,converter =  WrapItemListConverter.class)
    private List<MetaWrapItem> needItem;

    // 是否可营救
    @ExcelProperty(index = 7)
    private Integer isRescue;

    // 等级属性，格式为JSON对象：{"BaseHp":值,"DcMin":值,"DcMax":值,"Ac":值}
    @ExcelProperty(index = 8, converter = PropConverter.class)
    private PropEntity levelProp;

    // 挂机经验上限
    @ExcelProperty(index = 9)
    private Integer handupExpLimit;

    // 通知
    @ExcelProperty(index = 10)
    private Integer notice;
}
