package br.com.dynamicsbeans.teste;

import br.com.dynamicsbeans.config.AttributesConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@EnableScheduling
public class Teste {

    @Autowired
    private AttributesConfiguration attributesConfiguration;

    @Scheduled(fixedRateString = "30000")
    public void teste() {
        Map<String, Object> values = new HashMap<>();

        values.put("messageCode", "Mauricio Maslowski Pedroso");
        values.put("inputMode", "input");
        values.put("traceId", "trace");
        values.put("processingCode", "processing");
        values.put("terminal", "bean2");
        values.put("card", "card");
        values.put("authorizer", "authorizer");
        values.put("sender", "sender");

        values.put("id", "Mauricio Maslowski Pedroso");
        values.put("terminalType", "input");
        values.put("transactionId", "trace");
        values.put("transactionTimestamp", "processing");
        values.put("establishmentId", "bean2");

        values.put("teste", "testando");

        values.put("card_teste", "cardTeste");

        values.put("teste_quarto", "quartoTeste");

        values.put("teste_quinto", "quintoTeste");

        IdentificationBean identificationBean = this.isoConverte(values);
    }

    public IdentificationBean isoConverte(Map<String, Object> values, IdentificationBean... identificationBeans) {
        //Contruimos o Bean.
        IdentificationBean bean = IdentificationBeanFactory.newInstance(attributesConfiguration.getAttributes());

        values.forEach((s, s2) -> {
            if (bean.getAttribute(s) instanceof IdentificationBean || (identificationBeans != null &&
                identificationBeans.length > 0)) {

                IdentificationBean attribute;

                if (identificationBeans != null && identificationBeans.length > 0) {
                    attribute = (IdentificationBean) identificationBeans[0].getAttribute(s);
                } else {
                    attribute = (IdentificationBean) bean.getAttribute(s);
                }

                if (attribute != null) {
                    this.isoConverte(values, attribute);
                }
            }

            if (identificationBeans != null && identificationBeans.length > 0) {
                if (identificationBeans[0].getAttribute(s) == null) {
                    identificationBeans[0].setAttribute(s, s2);
                }
            } else if (bean.getAttribute(s) == null) {
                bean.setAttribute(s, s2);
            }
        });

        return bean;
    }
}
