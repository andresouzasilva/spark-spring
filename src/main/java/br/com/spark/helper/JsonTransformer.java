package br.com.spark.helper;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import spark.ResponseTransformer;

@Component
public class JsonTransformer implements ResponseTransformer {

    private Gson gson = new Gson();

    @Override
    public String render(Object model) {
        return gson.toJson(model);
    }

}
