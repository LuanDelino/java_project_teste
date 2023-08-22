package com.projetojava.demo.domain.enums;

public enum ClientType {
    PESSOAFISICA(1, "Pessoa Fisica"),
    PESSOAJURIDICA(2, "Pessoa Juridica");

    private Integer cod;
    private String descricao;

    private ClientType(Integer cod, String descricao){
        this.cod = cod;
        this.descricao = descricao;
    }

    public Integer getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static ClientType toEnum(Integer cod){
        if (cod == null){ return null; }

        for (ClientType x : ClientType.values()){
            if(cod.equals(x.getCod())){ return x; }
        }

        throw new IllegalArgumentException("Id invalido: " + cod);
    }
}

