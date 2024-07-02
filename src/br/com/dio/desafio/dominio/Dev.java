package br.com.dio.desafio.dominio;

import java.util.*;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
    private Set<Dev> listaDeAmigos = new HashSet<>();
    private Set<Dev> solicitacoesPendentes = new LinkedHashSet<>();
    private double xp = 0d;

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
            xp = calcularTotalXp();
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public double calcularTotalXp() {
        Iterator<Conteudo> iterator = this.conteudosConcluidos.iterator();
        double soma = 0;
        while(iterator.hasNext()){
            double next = iterator.next().calcularXp();
            soma += next;
        }
        return soma;

        /*return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();*/
    }

    public void adicionarAmigo(Dev dev){
        dev.solicitacoesPendentes.add(this);
    }

    public void aceitarSolicitacao(Dev dev){
        for (Dev d : solicitacoesPendentes){
            if (d.equals(dev)){
                this.listaDeAmigos.add(d);
                d.listaDeAmigos.add(this);
                this.solicitacoesPendentes.remove(d);
                break;
            }
        }
    }

    public void aceitarTodasSolicitacoes(){
        for (Dev d : solicitacoesPendentes){
            this.listaDeAmigos.add(d);
            d.listaDeAmigos.add(this);
        }
        Set<Dev> limparSolicitacoes = solicitacoesPendentes;
        solicitacoesPendentes.removeAll(limparSolicitacoes);
    }

    public void removerAmigo(Dev dev){
        listaDeAmigos.remove(dev);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    public Set<Dev> getListaDeAmigos() {
        return listaDeAmigos;
    }

    public void setListaDeAmigos(Set<Dev> listaDeAmigos) {
        this.listaDeAmigos = listaDeAmigos;
    }

    public Set<Dev> getSolicitacoesPendentes() {
        return solicitacoesPendentes;
    }

    public void setSolicitacoesPendentes(Set<Dev> solicitacoesPendentes) {
        this.solicitacoesPendentes = solicitacoesPendentes;
    }

    public double getXp() {
        return xp;
    }

    public void setXp(double xp) {
        this.xp = xp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }

    @Override
    public String toString() {
        return "Dev{" +
                "nome='" + nome + '\'' +
                ", xp=" + xp +
                '}';
    }
}
