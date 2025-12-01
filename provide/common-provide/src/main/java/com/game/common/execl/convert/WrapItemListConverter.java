package com.game.common.execl.convert;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.ReadConverterContext;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.util.StringUtils;
import com.game.common.execl.MetaWrapItem;
import com.game.kit.JsonKit;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * WrapItemConverter - 用于将JSON字符串转换为List<MetaWrapItem>
 */
@Slf4j
public class WrapItemListConverter implements Converter<List<MetaWrapItem>> {

    @Override
    public Class<?> supportJavaTypeKey() {
        return List.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public List<MetaWrapItem> convertToJavaData(ReadConverterContext<?> context) {
        String rewardsTxt = context.getReadCellData().getStringValue();
        if (StringUtils.isEmpty(rewardsTxt)) {
            return null;
        }

        try {
            Type listType = new TypeToken<List<int[]>>() {}.getType();
            List<int[]> rewardsList = JsonKit.gson.fromJson(rewardsTxt, listType);
            List<MetaWrapItem> result = new ArrayList<>();
            for (int[] ints : rewardsList) {
                result.add(new MetaWrapItem(ints));
            }
            return result;
        } catch (Exception e) {
            // 解析失败时记录日志或处理异常
            log.error("解析数据失败: {}", e.getMessage(), e);
        }

        return null;
    }

    @Override
    public WriteCellData<?> convertToExcelData(WriteConverterContext<List<MetaWrapItem>> context) {
        // 如果需要将List<MetaWrapItem>写回到Excel，可以在这里实现
        // 这里简单实现为将内容转为JSON
        if (context.getValue() == null || context.getValue().isEmpty()) {
            return new WriteCellData<>("");
        }
        
        try {
            List<int[]> dataList = new ArrayList<>();
            for (MetaWrapItem item : context.getValue()) {
                dataList.add(new int[]{
                    item.getItemType(),
                    item.getItemIdx(),
                    item.getItemNum(),
                    item.getItemBind()
                });
            }
            String jsonData = JsonKit.gson.toJson(dataList);
            return new WriteCellData<>(jsonData);
        } catch (Exception e) {
            log.error("转换为Excel数据失败: {}", e.getMessage(), e);
            return new WriteCellData<>("");
        }
    }
}