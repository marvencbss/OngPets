package br.ifsul.edu.br.model;

public class Animal {

    private Long id;
    private String nome;
    private String especie;
    private String raca;
    private String descricao;
    private String imagemUrl;
    private String cidade;
    private String contato;
    private String status;
    private String dataOcorrencia;

    public Animal() {}

    public Animal(Long id, String nome, String especie, String raca,
                  String descricao, String imagemUrl, String cidade,
                  String contato, String status, String dataOcorrencia) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.descricao = descricao;
        this.imagemUrl = imagemUrl;
        this.cidade = cidade;
        this.contato = contato;
        this.status = status;
        this.dataOcorrencia = dataOcorrencia;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public String getRaca() { return raca; }
    public void setRaca(String raca) { this.raca = raca; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getImagemUrl() { return imagemUrl; }
    public void setImagemUrl(String imagemUrl) { this.imagemUrl = imagemUrl; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getContato() { return contato; }
    public void setContato(String contato) { this.contato = contato; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getDataOcorrencia() { return dataOcorrencia; }
    public void setDataOcorrencia(String dataOcorrencia) { this.dataOcorrencia = dataOcorrencia; }
}