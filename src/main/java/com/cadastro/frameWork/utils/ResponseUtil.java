package com.cadastro.frameWork.utils;
import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

    public static Map<String, Object> responseMapper(Object messages) {
        Map<String, Object> out = new HashMap<>();
        out.put("messages", messages);
         return out;
    }
}
