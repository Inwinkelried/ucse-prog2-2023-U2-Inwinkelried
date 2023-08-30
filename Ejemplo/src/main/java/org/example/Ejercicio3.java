package org.example;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
public class Ejercicio3 {
    public static void main(String[] args)throws InterruptedException, ExecutionException  {

        CompletableFuture<Integer> tarea1 = CompletableFuture.supplyAsync(() -> {
            int valorAleatorio = generarValorAleatorio();
            simularEspera(valorAleatorio);
            return valorAleatorio;
        });

        CompletableFuture<Integer> tarea2 = CompletableFuture.supplyAsync(() -> {
            int valorAleatorio = generarValorAleatorio();
            simularEspera(valorAleatorio);
            return valorAleatorio;
        });

        CompletableFuture<Integer> tarea3 = CompletableFuture.supplyAsync(() -> {
            int valorAleatorio = generarValorAleatorio();
            simularEspera(valorAleatorio);
            return valorAleatorio;
        });

        CompletableFuture<Integer> tarea4 = CompletableFuture.supplyAsync(() -> {
            int valorAleatorio = generarValorAleatorio();
            simularEspera(valorAleatorio);
            return valorAleatorio;
        });

        CompletableFuture<Integer> combinedFuture = CompletableFuture.allOf(tarea1, tarea2, tarea3, tarea4)
                .thenApplyAsync(ignored -> tarea1.join() + tarea2.join() + tarea3.join() + tarea4.join());

        int sum = combinedFuture.get();
        System.out.println("Suma de los valores: " + sum);
    }

    private static int generarValorAleatorio() {
        Random random = new Random();
        return random.nextInt(401) + 100;
    }

    private static void simularEspera(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}