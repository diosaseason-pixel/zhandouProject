package com.game.common.execl.convert;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.ReadConverterContext;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.util.StringUtils;
import com.game.common.entity.PropEntity;
import com.game.kit.JsonKit;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PropConverter implements Converter<PropEntity> {

    @Override
    public Class<PropEntity> supportJavaTypeKey() {
        return PropEntity.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public PropEntity convertToJavaData(ReadConverterContext<?> context) {
        String rewardsTxt = context.getReadCellData().getStringValue();
        if (StringUtils.isEmpty(rewardsTxt)) {
            return null;
        }

        try {
            return JsonKit.fromJson(rewardsTxt, PropEntity.class);
        } catch (Exception e) {
            // 解析失败时记录日志或处理异常
            log.error("解析数据失败: {}", e.getMessage(), e);
        }
        return null;
    }

    @Override
    public WriteCellData<?> convertToExcelData(WriteConverterContext<PropEntity> context) {
        PropEntity value = context.getValue();
        if (value == null) {
            return new WriteCellData<>("");
        }
        String json = JsonKit.toJson(value);
        return new WriteCellData<>(json);
    }
}
