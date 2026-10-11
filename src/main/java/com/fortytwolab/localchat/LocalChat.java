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
        String url = "http://localhost:11434/api/chat";
        HttpClient cliente = HttpClient.newHttpClient();
        
        
        System.out.println("==========================");
        System.out.println("        LOCALCHAT");
        System.out.println("==========================");
        System.out.println("Digite 'sair' para encerrar.");
        System.out.println();
        
        
        while(true){
            System.out.print("Digite sua mensagem: ");
            String msg = sc.nextLine();
            
            if (msg.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.println();
            System.out.println("Você: " + msg);

            JsonObject mensagemJson = new JsonObject(); 
            mensagemJson.addProperty("role", "user"); 
            mensagemJson.addProperty("content", msg); 

            JsonArray mensagens = new JsonArray(); 
            mensagens.add(mensagemJson); 

            JsonObject requisicaoJson = new JsonObject();
            requisicaoJson.addProperty("model", "llama3.2:3b");
            requisicaoJson.add("messages", mensagens);
            requisicaoJson.addProperty("stream", false);

            String json = requisicaoJson.toString(); 

            HttpRequest requisicao = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> resposta = cliente.send(
                    requisicao,
                    HttpResponse.BodyHandlers.ofString()
            );

            JsonObject jsonResposta = JsonParser.parseString(resposta.body()).getAsJsonObject();

            JsonObject mensagem = jsonResposta.getAsJsonObject("message");

            String conteudo = mensagem.get("content").getAsString();

            System.out.println("Assistente: " + conteudo);
            
        }
        System.out.println();
        System.out.println("Chat encerrado.");
    }
}