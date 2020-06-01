package org.javaboy.vhr.mapper;

import java.util.List;
import java.util.Map;

public interface ChartMapper {
    List<Map<String, Object>> sex();

    List<Map<String, Object>> age();

    List<Map<String, Object>> point();

    List<Map<String,Object>> employee();
}
