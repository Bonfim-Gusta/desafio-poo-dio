package br.com.dio.desafio.dominio;

public class Video {
    private String titulo;
    private String link;
    private boolean videoAssistido = false;

    public Video(String titulo, String link) {
        this.titulo = titulo;
        this.link = link;
    }

    public void play(){

    }

    public void pause(){

    }

    public void marcarComoAssistido(){
        setVideoAssistido(true);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean isVideoAssistido() {
        return videoAssistido;
    }

    public void setVideoAssistido(boolean videoAssistido) {
        this.videoAssistido = videoAssistido;
    }

    @Override
    public String toString() {
        return "Video{" +
                "titulo='" + titulo + '\'' +
                ", link='" + link + '\'' +
                ", videoAssistido=" + videoAssistido +
                '}';
    }
}
