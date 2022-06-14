package db;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DBConfig {
    public static Map<String, String> getDBEvseenkoConfig(){
        var configMap = new HashMap<String, String>();
        configMap.put("host", "db4free.net:3306");
        configMap.put("name", "testevseenkodv");
        configMap.put("user", "evseenko");
        configMap.put("password", "Pizzamand110");
        return configMap;
    }
}

