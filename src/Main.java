import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.adicionarVideo(new Video("Boas vindas", "www.video1.com"));
        curso1.adicionarVideo(new Video("Aula 1 - introdução ao Java", "www.video2.com"));
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descrição curso js");
        curso2.adicionarVideo(new Video("Boas vindas", "www.video3.com"));
        curso2.adicionarVideo(new Video("Aula 1 - introdução js", "www.video4.com"));
        curso2.setCargaHoraria(4);

        Curso curso3 = new Curso();
        curso3.setTitulo("Banco de dados SQL");
        curso3.setDescricao("descrição curso sobre SQL");
        curso3.adicionarVideo(new Video("O que você precisa saber antes de começar?", "www.video5.com"));
        curso3.adicionarVideo(new Video("Aula 1 - resumão sobre banco de dados", "www.video6.com"));
        curso3.setCargaHoraria(3);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria");
        mentoria.setDescricao("O upgrade que você precisa na sua carreira");
        mentoria.adicionarVideo(new Video("Como desenvolver suas softskills para se difernciar no mercado de trabalho",
                "www.video7.com"));
        mentoria.setData(LocalDate.now());

        /*System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);*/

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(curso3);
        bootcamp.getConteudos().add(mentoria);

        System.out.println("X=X=X=X=X=X=X=X=X=Camila=X=X=X=X=X=X=X=X=X");
        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
        devCamila.progredir();
        devCamila.progredir();
        System.out.println("\n-------------------------------Conteudos após progressão-------------------------------");
        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos Camila:" + devCamila.getConteudosConcluidos());
        System.out.println("XP:" + devCamila.calcularTotalXp());

        System.out.println("\n\nX=X=X=X=X=X=X=X=X=Bonfim=X=X=X=X=X=X=X=X=X");
        Dev devBonfim = new Dev();
        devBonfim.setNome("Bonfim");
        devBonfim.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Bonfim:" + devBonfim.getConteudosInscritos());
        devBonfim.progredir();
        System.out.println("\n-------------------------------Conteudos após progressão-------------------------------");
        System.out.println("Conteúdos Inscritos Bonfim:" + devBonfim.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos Bonfim:" + devBonfim.getConteudosConcluidos());
        System.out.println("XP:" + devBonfim.calcularTotalXp());

        System.out.println("\n\nX=X=X=X=X=X=X=X=X=João=X=X=X=X=X=X=X=X=X");
        Dev devJoao = new Dev();
        devJoao.setNome("João");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();
        System.out.println("\n-------------------------------Conteudos após progressão-------------------------------");
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos João:" + devJoao.getConteudosConcluidos());
        System.out.println("XP:" + devJoao.calcularTotalXp());

        System.out.println("\n\nX=X=X=X=X=X=X=X=X=Adriana=X=X=X=X=X=X=X=X=X");
        Dev devAdriana = new Dev();
        devAdriana.setNome("Adriana");
        devAdriana.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Adriana:" + devAdriana.getConteudosInscritos());
        devAdriana.progredir();
        devAdriana.progredir();
        devAdriana.progredir();
        devAdriana.progredir();
        System.out.println("\n-------------------------------Conteudos após progressão-------------------------------");
        System.out.println("Conteúdos Inscritos Adriana:" + devAdriana.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos Adriana:" + devAdriana.getConteudosConcluidos());
        System.out.println("XP:" + devAdriana.calcularTotalXp());

        System.out.println("\n===============================Devs inscritos no bootcamp===============================");
        System.out.println(bootcamp.getDevsInscritos());


        System.out.println("\n\n========================Ranking de acordo com o XP do bootcamp========================");
        bootcamp.verRanking();
        System.out.println("\n\n=========================================================================================");

        devCamila.adicionarAmigo(devJoao);
        devBonfim.adicionarAmigo(devJoao);
        devBonfim.adicionarAmigo(devAdriana);
        devAdriana.aceitarSolicitacao(devBonfim);
        devJoao.aceitarTodasSolicitacoes();
        System.out.println("Lista de amigos João:" + devJoao.getListaDeAmigos());
        System.out.println("Solicitações pendentes João" + devJoao.getSolicitacoesPendentes());
        System.out.println("Lista de amigos Camila" + devCamila.getListaDeAmigos());
        System.out.println("Solicitações pendentes Camila" + devCamila.getSolicitacoesPendentes());
        System.out.println("Lista de amigos Bonfim" + devBonfim.getListaDeAmigos());
        System.out.println("Solicitações pendentes Bonfim" + devBonfim.getSolicitacoesPendentes());
        System.out.println("Lista de amigos Adriana" + devAdriana.getListaDeAmigos());
        System.out.println("Solicitações pendentes Adriana" + devAdriana.getSolicitacoesPendentes());

        System.out.println("\n\n=========================================================================================");
        for (Conteudo conteudo : bootcamp.getConteudos()){
            System.out.println("Curso: " + conteudo.getTitulo());
            System.out.println("Conteudos:");
            System.out.println(conteudo.getVideos() + "\n");
        }
    }
}
