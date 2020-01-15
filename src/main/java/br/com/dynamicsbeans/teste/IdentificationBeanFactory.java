package br.com.dynamicsbeans.teste;

import br.com.dynamicsbeans.config.AttributesDatail;

import java.util.HashMap;
import java.util.List;

public class IdentificationBeanFactory {

    //O construtor do nosso DynaBean é privado.
    private IdentificationBeanFactory() {
    }

    //Passamos como parâmetro o endereço do nosso .properties.
    public static IdentificationBean newInstance(List<AttributesDatail> attributesList) {
        IdentificationBean retorno = null;

        //Criamos uma lista de atributos para o nosso bean.
        HashMap<String, IdentificationBeanAttribute> attributes = new HashMap<>();

        try {
            String attName, attType;

            for (AttributesDatail att : attributesList) {
                attName = att.getName();
                attType = att.getType();

                //Monta lista com os atributos - nome - tipo.

                //Instanciamos um objeto de atributo e setamos seu nome e seu tipo.
                IdentificationBeanAttribute attribute = new IdentificationBeanAttribute(attName, Class.forName(attType));

                attributes.put(attName, attribute);

                if(att.getSubObject() != null){
                    attribute.setValor(newInstance(att.getSubObject()));
                }
            }

            //Cria o bean dinâmico com o nome.
            retorno = new IdentificationBean("pessoa", attributes);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return retorno;
    }
}
