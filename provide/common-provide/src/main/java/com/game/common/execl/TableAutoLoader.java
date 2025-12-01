package com.game.common.execl;

import com.game.execl.ExcelFile;
import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Set;
import java.util.concurrent.Executors;

@Slf4j
@Configuration
public class TableAutoLoader implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        // 扫描所有配置表
        Reflections reflections = new Reflections("com.game");
        Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(ExcelFile.class);

        // 加载配置表
        for (Class<?> clazz : annotatedClasses) {
            ExcelFile excelFile = clazz.getAnnotation(ExcelFile.class);
            String fileName = "excels/" + excelFile.fileName();

            try(var executor = Executors.newVirtualThreadPerTaskExecutor()){
                executor.submit(() -> {
                    TableManager.loadTable(clazz, fileName);
                });
            }
        }
        log.info("加载配置表完成 共 {} 张", TableManager.tableCount());
    }
}
