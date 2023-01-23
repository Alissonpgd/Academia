package com.projetoacademia.uplife.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    private String whatsapp;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data;
    private BigDecimal peso;
    private BigDecimal altura;
    private BigDecimal valor;
    @Enumerated(EnumType.STRING)
    private StatusAluno statusAluno;

    public Aluno() {  }

    public Aluno(String nome, String whatsapp, Date data, BigDecimal peso, BigDecimal altura, BigDecimal valor, StatusAluno statusAluno) {

        this.nome = nome;
        this.whatsapp = whatsapp;
        this.data = data;
        this.peso = peso;
        this.altura = altura;
        this.valor = valor;
        this.statusAluno = statusAluno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", whatsapp=" + whatsapp +
                ", data=" + data +
                ", peso=" + peso +
                ", altura=" + altura +
                ", valor=" + valor +
                ", statusAluno=" + statusAluno +
                '}';
    }
}
