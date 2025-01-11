package com.alura.literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConversor implements IDataConversor{
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T getBookData(String json, Class<T> tClass) {
        try {
            JsonNode rootNode = objectMapper.readTree(json).get("results").get(0);
            return objectMapper.treeToValue(rootNode, tClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
