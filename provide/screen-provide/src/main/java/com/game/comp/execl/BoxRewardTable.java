package com.game.comp.execl;

import com.alibaba.excel.annotation.ExcelProperty;
import com.game.common.execl.MetaWrapItem;
import com.game.comp.constant.PersonCompInteractionType;
import com.game.execl.ExcelFile;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ExcelFile(fileName = "BoxReward.csv")
public class BoxRewardTable {
    
    // 交互类型: 获取道具
    public static final int INTERACTION_TYPE_GET_PROP = 1; // 假设1是获取道具的类型，实际值需要确认
    
    @ExcelProperty(index = 0)
    private int id;
    
    @ExcelProperty(index = 1)
    private String Name;
    
    @ExcelProperty(index = 2)
    private int ButtonConditionType;
    
    @ExcelProperty(index = 3)
    private String Condition;
    
    @ExcelProperty(index = 4)
    private String DiscontentNotice;
    
    @ExcelProperty(index = 5)
    private int InteractionType;
    
    @ExcelProperty(index = 6)
    private String InteractionParameter;
    
    @ExcelProperty(index = 7)
    private int InteractionType1;
    
    @ExcelProperty(index = 8)
    private String InteractionParameter1;
    
    @ExcelProperty(index = 9)
    private int InteractionType2;
    
    @ExcelProperty(index = 10)
    private String InteractionParameter2;
    
    @ExcelProperty(index = 11)
    private int PopType;
    
    @ExcelProperty(index = 12)
    private String PopValue;
    
    @ExcelProperty(index = 13)
    private String InteractionName;
    
    @ExcelProperty(index = 14)
    private int rowid;
    
    /**
     * 获取互动按钮表中的奖励道具
     * 对应Lua中的getRewardByMeta方法
     * @return 奖励道具列表
     */
    public List<MetaWrapItem> getRewardItems() {
        List<MetaWrapItem> rewardArray = new ArrayList<>();
        
        // 检查第一个交互类型
        if (InteractionType == PersonCompInteractionType.GET_PROP) {
            List<MetaWrapItem> items = parseItemArray(InteractionParameter);
            rewardArray.addAll(items);
        }
        
        // 检查第二个交互类型
        if (InteractionType1 == PersonCompInteractionType.GET_PROP) {
            List<MetaWrapItem> items = parseItemArray(InteractionParameter1);
            rewardArray.addAll(items);
        }
        
        // 检查第三个交互类型
        if (InteractionType2 == PersonCompInteractionType.GET_PROP) {
            List<MetaWrapItem> items = parseItemArray(InteractionParameter2);
            rewardArray.addAll(items);
        }
        
        return rewardArray;
    }
    
    /**
     * 解析道具字符串为道具信息列表
     * 对应Lua中的FunsUtil:parseItemArray方法
     * @param itemString 道具字符串，格式如: "1:10001:5:0,1:10002:6:0"
     * @return 道具信息列表
     */
    private List<MetaWrapItem> parseItemArray(String itemString) {
        if (itemString == null || itemString.isEmpty()) {
            return new ArrayList<>();
        }
        
        List<MetaWrapItem> itemArray = new ArrayList<>();
        String[] items = itemString.split(",");
        
        for (String item : items) {
            String[] info = item.split(":");
            if (info.length >= 3) {
                try {
                    int[] data = new int[4];
                    // 前三个值必须有
                    data[0] = Integer.parseInt(info[0]); // itemType
                    data[1] = Integer.parseInt(info[1]); // itemIdx
                    data[2] = Integer.parseInt(info[2]); // itemNum
                    // 第四个值(绑定)是可选的
                    data[3] = info.length > 3 ? Integer.parseInt(info[3]) : 0; // itemBind
                    
                    MetaWrapItem metaItem = new MetaWrapItem(data);
                    itemArray.add(metaItem);
                } catch (NumberFormatException e) {
                    // 解析失败，跳过
                }
            }
        }
        
        return itemArray;
    }
}
