package com.game.common.execl;


import cn.hutool.core.util.ReflectUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.support.ExcelTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
public class TableLoader<T> {
    private final Class<T> dataClass;
    private final Map<Integer, T> dataMap = new ConcurrentHashMap<>();

    public TableLoader(Class<T> clazz) {
        this.dataClass = clazz;
    }

    public void load(String fileName) throws IOException, ReflectiveOperationException {
        ClassPathResource resource = new ClassPathResource(fileName);
        EasyExcel.read(resource.getInputStream(), dataClass, new TableReadListener())
                .excelType(ExcelTypeEnum.CSV)
                .headRowNumber(0)
                .sheet()
                .doRead();
    }

    public T get(Integer key) {
        return dataMap.get(key);
    }

    public T get(Long key) {
        return dataMap.get(key.intValue());
    }

    public T get(Predicate<T> predicate) {
        return dataMap.values().stream()
                .filter(predicate)
                .findFirst()
                .orElse(null);
    }

    // 多条件查询
    public List<T> query(Predicate<T> predicate) {
        return dataMap.values().stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    @SuppressWarnings("unchecked")
    private class TableReadListener implements ReadListener {
        @Override
        public void invoke(Object object, AnalysisContext analysisContext) {
            // 获取Id字段值
            Integer key = (Integer) ReflectUtil.getFieldValue(object, "id");
            dataMap.put(key, (T) object);
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {}

        @Override
        public void onException(Exception exception, AnalysisContext context) throws Exception {
            log.error("解析配置表异常 ", exception);

            // 打印第几行出错
            log.error("解析配置表异常行号 {}", context.readRowHolder().getRowIndex());
        }
    }

}

