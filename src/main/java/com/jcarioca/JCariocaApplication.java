package com.jcarioca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import cards.Shoe;
import game.Carioca;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class JCariocaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JCariocaApplication.class, args);
    }

    @Value("${jcarioca.game.num-players:2}")
    private int numPlayers;

    @Value("${jcarioca.game.cards-per-player:12}")
    private int cardsPerPlayer;

    @Value("${jcarioca.deck.ordered:false}")
    private boolean ordered;

    @Bean
    public Shoe shoe() {
        return new Shoe(ordered);
    }

    @Bean
    public Carioca carioca() {
        return new Carioca(ordered, numPlayers);
    }
}
