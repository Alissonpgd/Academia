package com.projetoacademia.uplife.DTO;

import com.projetoacademia.uplife.models.Aluno;
import com.projetoacademia.uplife.models.StatusAluno;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class RequisicaoFormAluno {

    @NotBlank//(message = "Por Favor Insira um Nome")//
    @NotNull
    private String nome;
    @NotBlank//(message = "Por Favor Insira um Telefone")//
    private String whatsapp;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data;

    private BigDecimal peso;

    private BigDecimal altura;
    @DecimalMin("0.0")
    @NotNull//(message = "Por Favor Insira um Valor")//
    private BigDecimal valor;
    private StatusAluno statusAluno;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public StatusAluno getStatusAluno() {
        return statusAluno;
    }

    public void setStatusAluno(StatusAluno statusAluno) {
        this.statusAluno = statusAluno;
    }

    public Aluno toAluno(){
        Aluno aluno = new Aluno();
        aluno.setNome(this.nome);
        aluno.setWhatsapp(this.whatsapp);
        aluno.setData(this.data);
        aluno.setPeso(this.peso);
        aluno.setAltura(this.altura);
        aluno.setValor(this.valor);
        aluno.setStatusAluno(this.statusAluno);

        return aluno;
    }

    public Aluno toAluno(Aluno aluno){
        aluno = new Aluno();
        aluno.setNome(this.nome);
        aluno.setWhatsapp(this.whatsapp);
        aluno.setData(this.data);
        aluno.setPeso(this.peso);
        aluno.setAltura(this.altura);
        aluno.setValor(this.valor);
        aluno.setStatusAluno(this.statusAluno);

        return aluno;
    }

    public void fromAluno(Aluno aluno){
        this.nome = aluno.getNome();
        this.whatsapp = aluno.getWhatsapp();
        this.data = aluno.getData();
        this.peso = aluno.getPeso();
        this.altura = aluno.getAltura();
        this.valor = aluno.getValor();
        this.statusAluno = aluno.getStatusAluno();
    }

    @Override
    public String toString() {
        return "RequisicaoFormAluno{" +
                "nome='" + nome + '\'' +
                ", whatsapp=" + whatsapp +
                ", data=" + data +
                ", peso=" + peso +
                ", altura=" + altura +
                ", valor=" + valor +
                ", statusAluno=" + statusAluno +
                '}';
    }
}

