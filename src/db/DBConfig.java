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
        configMap.put("host", "185.233.36.21:3306");
        configMap.put("name", "userdb");
        configMap.put("user", "root");
        configMap.put("password", "Cfcrt.xbz963963963");
        return configMap;
    }
}

