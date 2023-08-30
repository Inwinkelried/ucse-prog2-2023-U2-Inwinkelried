package org.example;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Ejercicio4 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> tarea1 = CompletableFuture.supplyAsync(() -> {
            int randomValue = generarNumeroAleatorio();
            simularEspera(randomValue);
            return randomValue;
        });

        CompletableFuture<Integer> tarea2 = CompletableFuture.supplyAsync(() -> {
            int randomValue = generarNumeroAleatorio();
            simularEspera(randomValue);
            return randomValue;
        });

        CompletableFuture<Integer> tarea3 = CompletableFuture.supplyAsync(() -> {
            int randomValue = generarNumeroAleatorio();
            simularEspera(randomValue);
            return randomValue;
        });

        CompletableFuture<Integer> tarea4 = CompletableFuture.supplyAsync(() -> {
            int randomValue = generarNumeroAleatorio();
            simularEspera(randomValue);
            return randomValue;
        });

        CompletableFuture<Object> anyOfResult = CompletableFuture.anyOf(tarea1, tarea2, tarea3, tarea4);
        CompletableFuture<Integer> tareaRapida = anyOfResult.thenApply(result -> (Integer) result);

        int fastestValue = tareaRapida.get();
        System.out.println("Valor de la tarea más rápida: " + fastestValue);
    }

    private static int generarNumeroAleatorio() {
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

