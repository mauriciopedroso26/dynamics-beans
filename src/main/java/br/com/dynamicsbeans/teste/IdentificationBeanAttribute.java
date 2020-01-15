package br.com.dynamicsbeans.teste;

public class IdentificationBeanAttribute {

    private String nome;
    private Class tipo;
    private Object valor;

    public IdentificationBeanAttribute(String nome, Class tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Class getTipo() {
        return tipo;
    }

    public void setTipo(Class tipo) {
        this.tipo = tipo;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        //varifica se o valor passado é válido ao tipo de atributo,
        //Por exemplo: Atributos do tipo int não podem receber SString.
        if (tipo.isAssignableFrom(valor.getClass()))
            //se o valor for válido então seta o mesmo.
            this.valor = valor;

        else
            //Se não for válido, emite uma Exception contendo o erro
            //que informa que o tipo do valor passado como parâmetro, não
            //equivale ao tipo do atributo do bean dinâmico.
            throw new ClassCastException("Tipos incompatíveis" + tipo + "/" + valor.getClass());
    }
}
