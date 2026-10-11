package com.fortytwolab.localchat;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonArray;

import java.util.Scanner;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LocalChat {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite sua mensagem: ");
        String msg = sc.nextLine();

        System.out.println();
        System.out.println("Você: " + msg);

        JsonObject mensagemJson = new JsonObject(); //Cria obj JSON vazio {}.

        mensagemJson.addProperty("role", "user"); // Add ao JSON.
        mensagemJson.addProperty("content", msg); 
        //JsonObject mensagemJson representa uma mensagem da conversa.
        
        JsonArray mensagens = new JsonArray(); //Cria JSON [].
        mensagens.add(mensagemJson); //Inseri a ensagem dentro desse array.
        /**
         * [
                {
                  "role": "user",
                  "content": "Qual é a capital do Ceará?"
                }
]           ]
         */

        JsonObject requisicaoJson = new JsonObject();// Cria outro obj JSON vazio {}.

        requisicaoJson.addProperty("model", "llama3.2:3b");
        requisicaoJson.add("messages", mensagens);
        requisicaoJson.addProperty("stream", false);
        /**
         * {
            "model": "llama3.2:3b",
            "messages": [
              {
                "role": "user",
                "content": "Qual é a capital do Ceará?"
              }
            ],
            "stream": false
          }
         */

        String json = requisicaoJson.toString(); //Converte para texto o corpo da requisição.

        String url = "http://localhost:11434/api/chat";

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

        System.out.println("Assistente: " + conteudo);
    }
}