package com.tecsup.restclient;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class ProgramaCliente {

    final static String REST_URL = "http://localhost:8084/webservice/rest/programa";

    public static void main(String[] args) {

        ProgramaCliente.save();
        ProgramaCliente.list();
    }

    public static void list() {
        RestTemplate rest = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity("parameters", headers);

        String url = ProgramaCliente.REST_URL;

        ResponseEntity<String> response = rest.exchange(url, HttpMethod.GET, httpEntity, String.class);
        System.out.println(response.getBody());
    }

    public static void find(Long id) {
        RestTemplate rest = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> httpEntity = new HttpEntity("parameters", headers);

        String url = ProgramaCliente.REST_URL + "/" + id;

        ResponseEntity<String> response = rest.exchange(url, HttpMethod.GET, httpEntity, String.class);
        System.out.println(response.getBody());
    }

    public static void delete(Long id) {
        RestTemplate rest = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> httpEntity = new HttpEntity("parameters", headers);

        String url = ProgramaCliente.REST_URL + "/" + id;

        ResponseEntity<String> response = rest.exchange(url, HttpMethod.DELETE, httpEntity, String.class);
        System.out.println(response.getBody());
    }

    public static void save() {
        RestTemplate rest = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();

        map.add("nombre", "Programa REST");
        map.add("codigo", "999");

        HttpEntity<MultiValueMap<String, String>> req = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        String url = ProgramaCliente.REST_URL + "/save";

        ResponseEntity<String> response = rest.exchange(url, HttpMethod.POST, req, String.class);
        System.out.println(response.getBody());
    }

}
