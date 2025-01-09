package com.alura.literalura.service;

public interface IDataConversor {
    <T> T getBookData(String json, Class<T> tClass);
}
