package com.game.comp.execl;

import com.alibaba.excel.annotation.ExcelProperty;
import com.game.common.execl.MetaWrapItem;
import com.game.common.execl.convert.WrapItemConverter;
import com.game.execl.ExcelFile;
import lombok.Data;

@Data
@ExcelFile(fileName = "ItemCompoment.csv")
public class ItemCompomentTable {
    
    @ExcelProperty(index = 0)
    private int id;
    
    @ExcelProperty(index = 1)
    private String name;
    
    @ExcelProperty(index = 2)
    private int componentType;
    
    @ExcelProperty(index = 3)
    private int groupId;
    
    @ExcelProperty(index = 4)
    private int mergeId;
    
    @ExcelProperty(index = 5)
    private int isMergeShowPos;
    
    @ExcelProperty(index = 6)
    private String figure;
    
    @ExcelProperty(index = 7)
    private int scale;
    
    @ExcelProperty(index = 8)
    private int hasHoverAnim;
    
    @ExcelProperty(index = 9)
    private int effectId;
    
    @ExcelProperty(index = 10)
    private int mapId;
    
    @ExcelProperty(index = 11)
    private int xpos;
    
    @ExcelProperty(index = 12)
    private int ypos;
    
    @ExcelProperty(index = 13)
    private int interactDistance;
    
    @ExcelProperty(index = 14)
    private int isReading;
    
    @ExcelProperty(index = 15, converter = WrapItemConverter.class)
    private MetaWrapItem reward;
    
    @ExcelProperty(index = 16)
    private int xposPoint;
    
    @ExcelProperty(index = 17)
    private int yposPoint;
    
    @ExcelProperty(index = 18)
    private int show;
    
    @ExcelProperty(index = 19)
    private int duplicateRefreshId;
    
    @ExcelProperty(index = 20)
    private int rowid;
}
