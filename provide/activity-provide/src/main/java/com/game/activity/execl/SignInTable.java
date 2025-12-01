package com.game.activity.execl;

import com.alibaba.excel.annotation.ExcelProperty;
import com.game.common.execl.MetaWrapItem;
import com.game.common.execl.convert.WrapItemListConverter;
import com.game.execl.ExcelFile;
import lombok.Data;

import java.util.List;

@Data
@ExcelFile(fileName = "SignIn.csv")
public class SignInTable {

    @ExcelProperty(index = 0)
    private int id;

    @ExcelProperty(index = 1)
    private String description;

    @ExcelProperty(index = 2, converter = WrapItemListConverter.class)
    private List<MetaWrapItem> rewards;

    @ExcelProperty(index = 3)
    private int rowid;

}
