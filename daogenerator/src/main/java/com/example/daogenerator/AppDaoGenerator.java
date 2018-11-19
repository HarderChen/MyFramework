package com.example.daogenerator;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class AppDaoGenerator {
    public static void main(String...args){
        Schema rootSchema = new Schema(1, "com.example.myframework.dao");
        addAuthUser(rootSchema);
        addTraceUser(rootSchema);
        addBookMarkUser(rootSchema);
        addLocalUser(rootSchema);
        try {
            new DaoGenerator().generateAll(rootSchema, "../app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * add auth user
     * @param schema
     */
    private static void addAuthUser(Schema schema){
        Entity entity = schema.addEntity("AuthUser");
        entity.addStringProperty("accessToken").primaryKey().notNull();
        entity.addDateProperty("authTime").notNull();
        entity.addIntProperty("expireIn").notNull();
        entity.addStringProperty("scope").notNull();
        entity.addBooleanProperty("selected").notNull();

        entity.addStringProperty("loginId").notNull();
        entity.addStringProperty("name");
        entity.addStringProperty("avatar");
    }

    private static void addTraceUser(Schema schema){
        Entity entity = schema.addEntity("TraceUser");
        entity.addStringProperty("login").primaryKey().notNull();
        entity.addStringProperty("name");
        entity.addStringProperty("avatarUrl");
        entity.addIntProperty("followers");
        entity.addIntProperty("following");

        entity.addDateProperty("startTime");
        entity.addDateProperty("latestTime");
        entity.addIntProperty("traceNum");
    }

    private static void addBookMarkUser(Schema schema){
        Entity entity = schema.addEntity("BookMarkUser");
        entity.addStringProperty("login").primaryKey().notNull();
        entity.addStringProperty("name");
        entity.addStringProperty("avatarUrl");
        entity.addIntProperty("followers");
        entity.addIntProperty("following");

        entity.addDateProperty("markTime");
    }
    private static void addLocalUser(Schema schema){
        Entity entity = schema.addEntity("LocalUser");
        entity.addStringProperty("login").primaryKey().notNull();
        entity.addStringProperty("name");
        entity.addStringProperty("avatarUrl");
        entity.addIntProperty("followers");
        entity.addIntProperty("following");
    }
}
