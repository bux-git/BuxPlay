package com.example.lym.buxplay.di.module;

import com.example.lym.buxplay.PlayApplication;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @description：
 * @author：bux on 2018/4/2 16:11
 * @email: 471025316@qq.com
 */

@Module
public class AppModule {

    private PlayApplication mApplication;

    public AppModule(PlayApplication application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    PlayApplication provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return  new GsonBuilder()
                .registerTypeAdapter(
                        new TypeToken<TreeMap<String, Object>>(){}.getType(),
                        new JsonDeserializer<TreeMap<String, Object>>() {
                            @Override
                            public TreeMap<String, Object> deserialize(
                                    JsonElement json, Type typeOfT,
                                    JsonDeserializationContext context) throws JsonParseException {

                                TreeMap<String, Object> treeMap = new TreeMap<>();
                                JsonObject jsonObject = json.getAsJsonObject();
                                Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
                                for (Map.Entry<String, JsonElement> entry : entrySet) {
                                    treeMap.put(entry.getKey(), entry.getValue());
                                }
                                return treeMap;
                            }
                        }).create();
    }
}
