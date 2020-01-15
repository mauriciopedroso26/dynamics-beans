package br.com.dynamicsbeans.teste;

import java.util.HashMap;
import java.util.Map;

public class IdentificationBean {

    private String nome;
    private HashMap<String, IdentificationBeanAttribute> attributes;

    //Contrutor do nosso bean dinâmico.
    public IdentificationBean(String nome, HashMap<String, IdentificationBeanAttribute> attributes) {
        //É a interessante setarmos um nome para o nosso objeto.
        // Isso facilitaria na ação de persistência do mesmo em algum banco de dados,
        //porém, não iremos aplicar isto neste caso.
        this.nome = nome;
        //Setamos nosso conjunto de atributos para o nosso bean no evento de contrução do objeto.
        this.attributes = attributes;
    }

    public void setAttribute(String att, Object value) {
        try {
            //Capturamos o nosso atributo e setamos o seu valor passado como parâmetro.
            //Se houver erro, ativamos um exception.
            attributes.get(att).setValor(value);
        } catch (Exception e) {
        }
    }

    public Object getAttribute(String att) {
        try {
            //Capturamos o valor do nosso atributo dinamicamente.
            return attributes.get(att).getValor();
        } catch (Exception e) {
            return null;
        }
    }

    public Map<String, IdentificationBeanAttribute> getAttributes() {
        return attributes;
    }
}
