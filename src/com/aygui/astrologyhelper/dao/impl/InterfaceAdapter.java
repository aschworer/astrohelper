package com.aygui.astrologyhelper.dao.impl;


import com.aygui.astrologyhelper.model.Characteristics;
import com.aygui.astrologyhelper.utils.Utils;
import com.google.gson.*;

import java.lang.reflect.Type;

final class InterfaceAdapter<T> implements /*JsonSerializer<T>, */JsonDeserializer<T> {
//    @Override
//    public JsonElement serialize(ConnectionType src, Type typeOfSrc, JsonSerializationContext context) {
//
//        return context.serialize(src.getKey());
//    }

//    public JsonElement serialize(T object, Type interfaceType, JsonSerializationContext context) {
//        final JsonObject wrapper = new JsonObject();
//        final JsonPrimitive primitive = new JsonPrimitive(((Characteristics)object).getString());
//        System.out.println("1: "+object);
//        wrapper.addProperty("type", object.getClass().getName());
//        JsonElement el =  context.serialize(((Characteristics)object).getString());
//        return el;
//    }

    public T deserialize(JsonElement elem, Type interfaceType, JsonDeserializationContext context) throws JsonParseException {
        final JsonPrimitive wrapper = (JsonPrimitive) elem;
        Characteristics characteristic = Utils.getByString(elem.getAsString());
        try {
            final Type actualType = characteristic.getClass();
            return context.deserialize(wrapper, actualType);
        } catch (Exception e) {
            System.err.println(e);//todo
        }
        return null;
    }
}