package com.fortytwolab.localchat;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LocalChat {

    public static void main(String[] args) throws Exception {

        String url = "http://localhost:11434/api/chat";

        String json = """
                {
                    "model": "llama3.2:3b",
                    "messages": [
                        {
                            "role": "user",
                            "content": "Explique em uma frase o que é orientação a objetos."
                        }
                    ],
                    "stream": false
                }
                """;

        HttpClient cliente = HttpClient.newHttpClient();

        HttpRequest requisicao = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> resposta = cliente.send(
                requisicao,
                HttpResponse.BodyHandlers.ofString()
        );
        
        JsonObject jsonResposta = JsonParser
        .parseString(resposta.body())
        .getAsJsonObject();

        JsonObject mensagem = jsonResposta
                .getAsJsonObject("message");

        String conteudo = mensagem
                .get("content")
                .getAsString();

        System.out.println("Resposta: " + conteudo);
        //System.out.println("Resposta: " + resposta.body());
    }
}