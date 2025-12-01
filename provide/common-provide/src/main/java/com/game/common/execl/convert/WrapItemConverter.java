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

/**
 * WrapItemConverter - 用于将JSON字符串转换为List<MetaWrapItem>
 */
@Slf4j
public class WrapItemConverter implements Converter<MetaWrapItem> {

    @Override
    public Class<MetaWrapItem> supportJavaTypeKey() {
        return MetaWrapItem.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public MetaWrapItem convertToJavaData(ReadConverterContext<?> context) {
        String rewardsTxt = context.getReadCellData().getStringValue();
        if (StringUtils.isEmpty(rewardsTxt)) {
            return null;
        }

        try {
            Type listType = new TypeToken<int[]>() {}.getType();
            int[] data = JsonKit.gson.fromJson(rewardsTxt, listType);
            return new MetaWrapItem(data);
        } catch (Exception e) {
            // 解析失败时记录日志或处理异常
            log.error("解析数据失败: {}", e.getMessage(), e);
        }

        return null;
    }

    @Override
    public WriteCellData<?> convertToExcelData(WriteConverterContext<MetaWrapItem> context) {
        MetaWrapItem metaWrapItem = context.getValue();
        if (metaWrapItem == null) {
            return new WriteCellData<>("");
        }
        String json = JsonKit.gson.toJson(metaWrapItem);
        return new WriteCellData<>(json);
    }
}