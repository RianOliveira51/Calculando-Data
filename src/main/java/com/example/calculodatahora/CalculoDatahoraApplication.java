package com.example.calculodatahora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class CalculoDatahoraApplication {

    public static void main(String[] args) {
        LocalDate d04 = LocalDate.parse("2022-07-20");
        LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26");
        Instant d06 = Instant.parse("2022-07-20T01:30:26Z");

        //vamos usar de exemplo o d04, calculando para uma semana antes.
        //minus = menos;
        LocalDate pastWeekLocalDate = d04.minusDays(7);

        //plus = mais
        LocalDate nextWeekLocalDate = d04.plusDays(7);

        System.out.println("pastWeekLocalDate: " + pastWeekLocalDate);
        System.out.println("nextWeekLocalDate: " + nextWeekLocalDate);

        //LocalDateTime
        LocalDateTime pastWeekLocalDateTime = d05.minusDays(7);
        LocalDateTime nextWeekLocalDateTime = d05.plusDays(7);

        System.out.println("pastWeekLocalDateTime: " + pastWeekLocalDateTime);
        System.out.println("nextWeekLocalDateTime: " + nextWeekLocalDateTime);

        //Instant
        Instant pastWeekInstant = d06.minus(7, ChronoUnit.DAYS);
        Instant nextWeekInstant = d06.plus(7, ChronoUnit.DAYS);

        System.out.println("pastWeekInstant: " + pastWeekInstant);
        System.out.println("nextWeekInstant: " + nextWeekInstant);

        //Calcular duração entre duas datas
        //Usamos a função Duration
        Duration t2 = Duration.between(pastWeekLocalDateTime, d05);
        System.out.println("LocalDateTime T2 dias = " + t2.toDays());


        // função não aceita somenta LocalData, temos que conver para DataTime, usando a função .atTime - colocar hora e minuto manual
        // ou usamos o atStartOfDay, ele já define a hora para voce
        Duration t1 = Duration.between(pastWeekLocalDate.atTime(0,0), d04.atTime(0,0));
        System.out.println("LocalDate T1 dias = " + t1.toDays());

        //Instant
        Duration t3 = Duration.between(pastWeekInstant, d06);
        Duration t4 = Duration.between(d06, pastWeekInstant);
        System.out.println("Instant T3 dias = " + t3.toDays());
        System.out.println("Instant T4 dias = " + t4.toDays());

    }

}
