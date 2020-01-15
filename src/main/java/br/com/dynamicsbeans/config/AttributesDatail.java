package br.com.dynamicsbeans.config;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class AttributesDatail {

    @Value("${attributes.name}")
    private String name;

    @Value("${attributes.type}")
    private String type;

    @Value("${attributes.subObject}")
    private List<AttributesDatail> subObject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<AttributesDatail> getSubObject() {
        return subObject;
    }

    public void setSubObject(List<AttributesDatail> subObject) {
        this.subObject = subObject;
    }
}
