package com.game.common.execl;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@UtilityClass
public class TableManager {
    private final Map<Class<?>, TableLoader<?>> tables = new ConcurrentHashMap<>();

    public  <T> void loadTable(Class<T> clazz, String fileName) {
        TableLoader<T> loader = new TableLoader<>(clazz);
        try {
            loader.load(fileName);
            log.info("加载配置表成功 {}", clazz.getName());
        } catch (IOException | ReflectiveOperationException e) {
            throw new RuntimeException("加载配置表失败 " + clazz.getName(), e);
        }
        tables.put(clazz, loader);
    }

    @SuppressWarnings("unchecked")
    public <T> TableLoader<T> getTable(Class<T> clazz) {
        return (TableLoader<T>) tables.get(clazz);
    }

    public int tableCount() {
        return tables.size();
    }

}
