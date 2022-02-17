package com.example.jumiatask.filter;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Filter<T> {
    public List<T> filter(List<T> data , String value);
}
