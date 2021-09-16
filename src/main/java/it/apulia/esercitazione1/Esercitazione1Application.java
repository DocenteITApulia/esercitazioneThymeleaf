package it.apulia.esercitazione1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Esercitazione1Application {

    public static void main(String[] args) {
        SpringApplication.run(Esercitazione1Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Ecco l'elenco dei bean in esecuzione: ");

            /*queste istruzioni servono per stampare i bean correntemente in uso da spring*/
            String[] nomiBean = ctx.getBeanDefinitionNames();
            Arrays.sort(nomiBean);
            for(String nomeBean: nomiBean) {
                System.out.println(nomeBean) ;
            }
        };
    }
// Questo è un commento
}
