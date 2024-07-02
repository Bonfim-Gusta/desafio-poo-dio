package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Set;

public abstract class Conteudo {

    protected static final double XP_PADRAO = 10d;

    private String titulo;
    private String descricao;
    private Set<Video> videos = new LinkedHashSet<>();
    private Set<Video> videosFavoritos = new LinkedHashSet<>();

    public abstract double calcularXp();

    public void listarVideos(){
        System.out.println(videos);
    }

    public void adicionarVideo(Video video){
        videos.add(video);
    }

    public void marcarVideoComoFavorito(Video video){
        videosFavoritos.add(video);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Video> getVideos() {
        return videos;
    }

    public void setVideos(Set<Video> videos) {
        this.videos = videos;
    }

    public Set<Video> getVideosFavoritos() {
        return videosFavoritos;
    }

    public void setVideosFavoritos(Set<Video> videosFavoritos) {
        this.videosFavoritos = videosFavoritos;
    }
}
