package br.com.dynamicsbeans.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class AttributesConfiguration {

    /** Client list.
     */
    private List<AttributesDatail> attributes = new ArrayList<>();

    public List<AttributesDatail> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AttributesDatail> clientList) {
        this.attributes = clientList;
    }

}
