package br.usjt.ads20.appfilmes.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Dados {
    public static Heroi[] buscarHerois(String chave){
        ArrayList<Heroi> lista = criarHerois();
        ArrayList<Heroi> filtro;
        Heroi[] herois;
        if(chave == null || chave.length() == 0){
            filtro = lista;
        } else {
            filtro = new ArrayList<>();
            for(Heroi heroi : lista){
                String nome = heroi.getNome();
                if(nome.toUpperCase().contains(chave.toUpperCase())){
                    filtro.add(heroi);
                }
            }
        }
        herois = filtro.toArray(new Heroi[0]);
        Arrays.sort(herois);
        return herois;
    }

    public static ArrayList<Heroi> criarHerois() {
        ArrayList<Heroi> lista = new ArrayList<>();
        Heroi heroi;
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        heroi = new Heroi();
        heroi.setPosterPath("spiderman1.png");
        heroi.setBackdropPath("spiderman1.png");
        heroi.setNome("Homem Aranha");
        heroi.setPoderPrincipal("Reflexos de aracnídeo, escalar paredes, lançar teia");
        heroi.setDescricao("Depois de ser picado por uma aranha geneticamente modificada em uma demonstração científica, " +
                "o jovem nerd Peter Parker ganha superpoderes. Inicialmente, ele pretende usá-los para para ganhar dinheiro, " +
                "adotando o nome de Homem-Aranha e se apresentando em lutas de exibição. Porém, ao presenciar o assassinando de seu tio Ben e sentir-se culpado, " +
                "Peter decide não mais usar seus poderes para proveito próprio e sim para enfrentar o mal, " +
                "tendo como seu primeiro grande desafio o psicótico Duende Verde.");
        try {
            heroi.setDataNascimento((Date) formatter.parse("1974-08-15"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(heroi);

        heroi = new Heroi();
        heroi.setPosterPath("wolverine1.jpg");
        heroi.setBackdropPath("wolverine1.jpg");
        heroi.setNome("Wolverine");
        heroi.setPoderPrincipal("Garras de Adamantium, auto-regeneração");
        heroi.setDescricao("Ele é um mutante que possui sentidos afiados, capacidades físicas aprimoradas, habilidade regenerativa poderosa conhecida como fator de cura e " +
                "três garras retratáveis de osso em cada mão. Wolverine foi retratado de forma variada como membro do X-Men, Tropa Alfa e Vingadores.");
        try {
            heroi.setDataNascimento((Date) formatter.parse("1800-00-00"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        lista.add(heroi);

        heroi = new Heroi();
        heroi.setPosterPath("cyclops1.jpg");
        heroi.setBackdropPath("cyclops1.jpg");
        heroi.setNome("Ciclope");
        heroi.setPoderPrincipal("Dispara feixes de energia pelos olhos");
        heroi.setDescricao("Scott Summers, mais conhecido por, Ciclope é um personagem americano pertencente ao Universo Marvel Comics. " +
                "Líder da equipe conhecida como X-Men, foi criado por Stan Lee e Jack Kirby, sua estreia nos quadrinhos foi em Uncanny X-Men");
        try {
            heroi.setDataNascimento((Date) formatter.parse("1986-07-25"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(heroi);

        heroi = new Heroi();
        heroi.setPosterPath("hulk1.jpg");
        heroi.setBackdropPath("hulk1.jpg");
        heroi.setNome("Hulk / Bruce Banner");
        heroi.setPoderPrincipal("Super força");
        heroi.setDescricao("Bruce Banner é um cientista e trabalha ao lado de sua grande paixão, a bela Betty Ross, em um projeto que envolve a reconstituição de " +
                "tecidos com a utilização da radiação gama. O problema todo começa quando, após ter seus genes alterados por um acidente " +
                "envolvendo a radiação gama, Bruce Banner passa a se transformar em um ser gigantesco e verde que expressa " +
                "no corpo todos os seus demônios mais íntimos e pessoais");
        try {
            heroi.setDataNascimento((Date) formatter.parse("1969-12-18"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(heroi);

        heroi = new Heroi();
        heroi.setPosterPath("ironman1.jpg");
        heroi.setBackdropPath("ironman1.jpg");
        heroi.setNome("Homem de Ferro / Tony Stark");
        heroi.setPoderPrincipal("Traje de combate de alta tecnologia");
        heroi.setDescricao("Tony Stark é um industrial bilionário e inventor brilhante que realiza testes bélicos no exterior, mas é " +
                "sequestrado por terroristas que o forçam a construir uma arma devastadora. Em vez disso, " +
                "ele constrói uma armadura blindada e enfrenta seus sequestradores. Ao voltar para os EUA, Stark aprimora a armadura e a utiliza para combater o crime.");
        try {
            heroi.setDataNascimento((Date) formatter.parse("1970-05-29"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(heroi);

        heroi = new Heroi();
        heroi.setNome("Capitão América");
        heroi.setPosterPath("captainamerica1.jpg");
        heroi.setBackdropPath("captainamerica1.jpg");
        heroi.setPoderPrincipal("Poder do supersoro e escudo de Vibranium");
        heroi.setDescricao("Steve Rogers é um jovem que participa de experiências visando a criação do supersoldado americano. " +
                "Quando os oficiais militares conseguem transformá-lo em uma arma humana, eles percebem que não podem arriscar a vida do jovem nas batalhas de guerra.");
        try {
            heroi.setDataNascimento((Date) formatter.parse("1918-07-4"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(heroi);

        heroi = new Heroi();
        heroi.setPosterPath("humantorch1.jpg");
        heroi.setBackdropPath("humantorch1.jpg");
        heroi.setNome("Tocha Humana");
        heroi.setPoderPrincipal("Voar e transformar o corpo em chamas");
        heroi.setDescricao("O Tocha Humana foi um androide criado pelo cientista Phineas Horton. Ele podia inflamar seu corpo e voar. ... " +
                "O Tocha Humana foi um dos três personagens principais da " +
                "Timely Comics, juntamente com o Capitão América e Namor. Como muitos super-heróis, o Tocha Humana caiu na obscuridade na década de 1950.");
        try {
            heroi.setDataNascimento((Date) formatter.parse("1988-09-14"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(heroi);

        heroi = new Heroi();
        heroi.setPosterPath("daredevil1.jpg");
        heroi.setBackdropPath("daredevil1.jpg");
        heroi.setNome("Demolidor");
        heroi.setPoderPrincipal("Sentidos super aguçados");
        heroi.setDescricao("A história de origem do Demolidor acontece em Hell's Kitchen, um bairro de Nova Iorque, onde a criança Matthew " +
                "Matt Murdock salva um homem de idade de um caminhão em andamento que continha uma carga radioativa. Como consequência do acidente a carga começa a verter do " +
                "caminhão, cegando Murdock. Apesar de Murdock nunca mais conseguir ver, " +
                "a exposição à matéria radioactiva melhorou todos os seus outros sentidos para além da capacidade humana e deu-lhe um tipo de sonar que atua como a sua visão.");
        try {
            heroi.setDataNascimento((Date) formatter.parse("1986-05-10"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(heroi);

        heroi = new Heroi();
        heroi.setPosterPath("silversurfer1.jpg");
        heroi.setBackdropPath("silversurfer1.jpg");
        heroi.setNome("Surfista Prateado");
        heroi.setPoderPrincipal("Poderes de uma entidade cósmica");
        heroi.setDescricao("Surfista Prateado é um super-herói das histórias em quadrinhos norte-americanas da Marvel Comics. Teve sua primeira aparição " +
                "como vilão na revista Fantastic Four #48, em 1966. Foi criado por Stan Lee e Jack Kirby. Tornou-se um dos heróis mais importantes do Universo Marvel.");
        try {
            heroi.setDataNascimento((Date) formatter.parse("000-00-0"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(heroi);

        heroi = new Heroi();
        heroi.setPosterPath("thor1.jpg");
        heroi.setBackdropPath("thor1.jpg");
        heroi.setNome("Thor");
        heroi.setPoderPrincipal("Poderes de um deus");
        heroi.setDescricao("Thor é um personagem fictício que aparece nas histórias em quadrinhos publicadas pela Marvel Comics. ... Estreando na Era de Prata dos quadrinhos, " +
                "o personagem apareceu pela primeira vez em Journey into Mystery #83 (agosto de 1962). Ele é um membro fundador da equipe de heróis Vingadores.");
        try {
            heroi.setDataNascimento((Date) formatter.parse("000-00-0"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(heroi);

        heroi = new Heroi();
        heroi.setPosterPath("thing1.jpg");
        heroi.setBackdropPath("thing1.jpg");
        heroi.setNome("Coisa");
        heroi.setPoderPrincipal("Corpo rochoso, super força");
        heroi.setDescricao("O Coisa é um personagem de quadrinhos do universo Marvel, um dos fundadores do " +
                "Quarteto Fantástico. Foi criado por Stan Lee e Jack Kirby. Seu grito de guerra it's clobberin ' time!" +
                " é um dos bordões mais conhecidos dos quadrinhos");
        try {
            heroi.setDataNascimento((Date) formatter.parse("1979-06-18"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(heroi);

        heroi = new Heroi();
        heroi.setPosterPath("lukecage1.jpg");
        heroi.setBackdropPath("lukecage1.jpg");
        heroi.setNome("Luke Cage");
        heroi.setPoderPrincipal("Força sobre humana");
        heroi.setDescricao("O personagem foi o primeiro super-herói negro estrelar sua própria série de quadrinhos, o título mudou de nome para Luke Cage, Power Man a partir da edição 17, as " +
                "aventuras de Cage foram colocadas em uma Nova York, mais preguiçosa e dominada pelo crime do que aquela habitada por outros super-heróis Marvel da época.");
        try {
            heroi.setDataNascimento((Date) formatter.parse("000-00-0"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(heroi);

        return lista;
    }
}
