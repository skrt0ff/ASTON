package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.api.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class PostmanEchoMethodsTest {

    @BeforeClass
    public void setup() {
        // Устанавливаем базовый URL для всех запросов
        RestAssured.baseURI = "https://postman-echo.com";
    }


    @Test
    public void testGetRequest() throws Exception {
        // Выполнение GET-запроса с параметрами
        Response response = RestAssured.given()
                .header("User-Agent", "PostmanRuntime/7.41.1")
                .header("cache-control", "no-cache")
                .header("postman-token", "2c96ab2f-07b7-47d9-87e2-ac53ad91c892")
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .get("/get");

        System.out.println("Response JSON Get: " + response.getBody().asString());
        // Проверка кода ответа
        Assert.assertEquals(response.getStatusCode(), 200);

        // Десериализация JSON ответа в POJO
        ObjectMapper objectMapper = new ObjectMapper();
        GetResponse getResponse = objectMapper.readValue(response.getBody().asString(), GetResponse.class);

        // Проверка значений полей в POJO
        Assert.assertNotNull(getResponse);

        // Проверка параметров запроса (args)
        Assert.assertEquals(getResponse.getArgs().get("foo1"), "bar1");
        Assert.assertEquals(getResponse.getArgs().get("foo2"), "bar2");

        // Проверка URL
        Assert.assertEquals(getResponse.getUrl(), "https://postman-echo.com/get?foo1=bar1&foo2=bar2");

        //Вывод тела ответа
        System.out.println(response.getBody().asString());

        // Проверка хедеров
        GetResponse.Headers headers = getResponse.getHeaders();
        Assert.assertEquals(headers.getHost(), "postman-echo.com");
        Assert.assertTrue(headers.getXRequestStart().startsWith("t="));
        Assert.assertEquals(headers.getConnection(), "close");
        Assert.assertEquals(headers.getXForwardedProto(), "https");
        Assert.assertEquals(headers.getXForwardedPort(), "443");
        Assert.assertTrue(headers.getXAmznTraceId().startsWith("Root=1-"));
        Assert.assertEquals(headers.getUserAgent(), "PostmanRuntime/7.41.1");
        Assert.assertEquals(headers.getAccept(), "*/*");
        Assert.assertEquals(headers.getCacheControl(), "no-cache");
        Assert.assertEquals(headers.getPostmanToken(), "2c96ab2f-07b7-47d9-87e2-ac53ad91c892");
        Assert.assertFalse(headers.getCookie() != null && !headers.getCookie().isEmpty());
    }

    @Test
    public void testPostRawTextRequest() throws Exception {

        Response response = RestAssured.given()
                .contentType("application/json")
                .header("User-Agent", "PostmanRuntime/7.41.1")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("cache-control", "no-cache")
                .header("postman-token", "cd469da1-97b6-4834-993a-dd60cf02c314")
                .body("{\"test\":\"value\"}")
                .when()
                .post("/post");

        Assert.assertEquals(response.statusCode(), 200, "Status code should be 201");

        System.out.println("Response JSON post raw text: " + response.getBody().asString());
        // Десериализация JSON ответа в объект
        ObjectMapper objectMapper = new ObjectMapper();
        PostRawTextResponse postRawTextResponse = objectMapper.readValue(response.getBody().asString(), PostRawTextResponse.class);

        // Вывод значения поля data для отладки
        System.out.println("Data Field: " + postRawTextResponse.getData());
        // Проверка значений в поле args
        Assert.assertTrue(postRawTextResponse.getArgs().isEmpty(), "Args map should be empty");

        // Проверяем поле data
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("test", "value");
        Assert.assertEquals(postRawTextResponse.getData(), expectedData, "Data field value should match");

        // Проверка значений в поле хедеров
        PostRawTextResponse.Headers headers = postRawTextResponse.getHeaders();
        Assert.assertEquals(headers.getHost(), "postman-echo.com", "Host should be 'postman-echo.com'");
        Assert.assertTrue(headers.getXRequestStart().startsWith("t="));
        Assert.assertEquals(headers.getConnection(), "close", "Connection should be 'close'");
        /*Assert.assertEquals(headers.getContentLength(), "23", "Content-Length should be '23'");*/
        Assert.assertEquals(headers.getXForwardedProto(), "https", "x-forwarded-proto should be 'https'");
        Assert.assertEquals(headers.getXForwardedPort(), "443", "x-forwarded-port should be '443'");
        Assert.assertTrue(headers.getXAmznTraceId().startsWith("Root=1-"));
        Assert.assertFalse(headers.getContentType().isEmpty(), "Content-Type should not be empty");
        Assert.assertEquals(headers.getUserAgent(), "PostmanRuntime/7.41.1", "User-Agent should be 'PostmanRuntime/7.41.1'");
        Assert.assertEquals(headers.getAccept(), "*/*", "Accept should be '*/*'");
        Assert.assertEquals(headers.getCacheControl(), "no-cache", "Cache-Control should be 'no-cache'");
        Assert.assertEquals(headers.getPostmanToken(), "cd469da1-97b6-4834-993a-dd60cf02c314", "Postman-Token should match");
        Assert.assertEquals(headers.getAcceptEncoding(), "gzip, deflate, br", "Accept-Encoding should match");
        Assert.assertFalse(headers.getCookie() != null && !headers.getCookie().isEmpty());

        // Проверка значения поля url
        Assert.assertEquals(postRawTextResponse.getUrl(), "https://postman-echo.com/post", "URL should be 'https://postman-echo.com/post'");
    }

    @Test
    public void testPostFormDataRequest() throws Exception {

        Response response = RestAssured.given()
                .contentType("application/json")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("User-Agent", "PostmanRuntime/7.30.1")
                .header("postman-token", "159c6495-8e5f-4ce0-bacd-ac399a86ec03")
                .header("cache-control", "no-cache")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post");

        Assert.assertEquals(response.statusCode(), 200, "Status code should be 201");

        // Вывод полного ответа для отладки
        System.out.println("Response JSON Post Form Data: " + response.getBody().asString());

        // Десериализация JSON ответа в объект
        ObjectMapper objectMapper = new ObjectMapper();
        PostFormData postFormData = objectMapper.readValue(response.getBody().asString(), PostFormData.class);

        // Проверка значений в поле data
        Assert.assertEquals(postFormData.getData(), "foo1=bar1&foo2=bar2", "Data field value should be empty");

        // Проверка значений в поле хедеров
        PostFormData.Headers headers = postFormData.getHeaders();
        Assert.assertEquals(headers.getHost(), "postman-echo.com", "Host should be 'postman-echo.com'");
        Assert.assertEquals(headers.getXForwardedProto(), "https", "x-forwarded-proto should be 'https'");
        Assert.assertEquals(headers.getXForwardedPort(), "443", "x-forwarded-port should be '443'");
        Assert.assertTrue(headers.getXAmznTraceId().startsWith("Root=1-"));
        Assert.assertEquals(headers.getContentLength(), "19", "Content-Length should be '19'");
        Assert.assertEquals(headers.getUserAgent(), "PostmanRuntime/7.30.1", "User-Agent should be 'PostmanRuntime/7.30.1'");
        Assert.assertEquals(headers.getAccept(), "*/*", "Accept should be '*/*'");
        Assert.assertEquals(headers.getCacheControl(), "no-cache", "Cache-Control should be 'no-cache'");
        Assert.assertEquals(headers.getPostmanToken(), "159c6495-8e5f-4ce0-bacd-ac399a86ec03", "Postman-Token should match");
        Assert.assertEquals(headers.getAcceptEncoding(), "gzip, deflate, br", "Accept-Encoding should match");
        Assert.assertEquals(headers.getContentType(), "application/json", "Content-Type should be 'application/x-www-form-urlencoded'");

        // Проверка значения поля url
        Assert.assertEquals(postFormData.getUrl(), "https://postman-echo.com/post", "URL should be 'https://postman-echo.com/post'");
    }

    @Test
    public void testPutRequest() throws Exception {
        Response response = RestAssured.given()
                .contentType("text/plain; charset=ISO-8859-1")
                .header("User-Agent", "PostmanRuntime/7.41.1")
                .header("cache-control", "no-cache")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("postman-token", "399ec342-62bd-474c-be25-5314508c83e8")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .put("/put");

        // Вывод полного ответа для отладки
        String responseBody = response.getBody().asString();
        System.out.println("Response JSON Put: " + responseBody);

        // Десериализация JSON ответа в объект
        ObjectMapper objectMapper = new ObjectMapper();
        PutResponse putResponse = objectMapper.readValue(responseBody, PutResponse.class);

        // Проверка значений в поле data
        Assert.assertEquals(putResponse.getData(), "This is expected to be sent back as part of response body.",
                "Data field value should match the expected value");

        // Проверка значений в поле form
        Map<String, String> form = putResponse.getForm();
        Assert.assertTrue(form.isEmpty(), "Form field should be empty");

        // Проверка значений в поле хедеров
        PutResponse.Headers headers = putResponse.getHeaders();
        Assert.assertEquals(headers.getHost(), "postman-echo.com", "Host should be 'postman-echo.com'");
        Assert.assertTrue(headers.getXRequestStart().startsWith("t="));
        Assert.assertEquals(headers.getConnection(), "close", "Connection should be 'close'");
        Assert.assertEquals(headers.getContentLength(), "58", "Content-Length should be '58'");
        Assert.assertEquals(headers.getXForwardedProto(), "https", "x-forwarded-proto should be 'https'");
        Assert.assertEquals(headers.getXForwardedPort(), "443", "x-forwarded-port should be '443'");
        Assert.assertTrue(headers.getXAmznTraceId().startsWith("Root=1-"));
        Assert.assertEquals(headers.getContentType(), "text/plain; charset=ISO-8859-1", "Content-Type should be 'text/plain'");
        Assert.assertEquals(headers.getUserAgent(), "PostmanRuntime/7.41.1", "User-Agent should be 'PostmanRuntime/7.41.1'");
        Assert.assertEquals(headers.getAccept(), "*/*", "Accept should be '*/*'");
        Assert.assertEquals(headers.getCacheControl(), "no-cache", "Cache-Control should be 'no-cache'");
        Assert.assertEquals(headers.getPostmanToken(), "399ec342-62bd-474c-be25-5314508c83e8", "Postman-Token should match");
        Assert.assertEquals(headers.getAcceptEncoding(), "gzip, deflate, br", "Accept-Encoding should match");
        Assert.assertFalse(headers.getCookie() != null && !headers.getCookie().isEmpty());

        // Проверка значения поля url
        Assert.assertEquals(putResponse.getUrl(), "https://postman-echo.com/put", "URL should be 'https://postman-echo.com/put'");
    }

    @Test
    public void testPatchRequest() throws Exception {
        // Выполнение PATCH-запроса
        Response response = RestAssured.given()
                .contentType("text/plain; charset=ISO-8859-1")
                .header("User-Agent", "PostmanRuntime/7.41.1")
                .header("cache-control", "no-cache")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("postman-token", "0843d148-d3ed-4421-97d9-8c05e6044add")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .patch("/patch");

        // Вывод полного ответа для отладки
        String responseBody = response.getBody().asString();
        System.out.println("Response JSON Patch: " + responseBody);

        // Десериализация JSON ответа в объект
        ObjectMapper objectMapper = new ObjectMapper();
        PatchResponse patchResponse = objectMapper.readValue(responseBody, PatchResponse.class);

        // Проверка значений в поле data
        Assert.assertEquals(patchResponse.getData(), "This is expected to be sent back as part of response body.",
                "Data field value should match the expected value");

        // Проверка значений в поле form
        Map<String, String> form = patchResponse.getForm();
        Assert.assertTrue(form.isEmpty(), "Form field should be empty");

        // Проверка значений в поле хедеров
        PatchResponse.Headers headers = patchResponse.getHeaders();
        Assert.assertEquals(headers.getHost(), "postman-echo.com", "Host should be 'postman-echo.com'");
        Assert.assertTrue(headers.getXRequestStart().startsWith("t="));
        Assert.assertEquals(headers.getConnection(), "close", "Connection should be 'close'");
        Assert.assertEquals(headers.getContentLength(), "58", "Content-Length should be '58'");
        Assert.assertEquals(headers.getXForwardedProto(), "https", "x-forwarded-proto should be 'https'");
        Assert.assertEquals(headers.getXForwardedPort(), "443", "x-forwarded-port should be '443'");
        Assert.assertTrue(headers.getXAmznTraceId().startsWith("Root=1-"));
        Assert.assertEquals(headers.getContentType(), "text/plain; charset=ISO-8859-1", "Content-Type should be 'text/plain'");
        Assert.assertEquals(headers.getUserAgent(), "PostmanRuntime/7.41.1", "User-Agent should be 'PostmanRuntime/7.41.1'");
        Assert.assertEquals(headers.getAccept(), "*/*", "Accept should be '*/*'");
        Assert.assertEquals(headers.getCacheControl(), "no-cache", "Cache-Control should be 'no-cache'");
        Assert.assertEquals(headers.getPostmanToken(), "0843d148-d3ed-4421-97d9-8c05e6044add", "Postman-Token should match");
        Assert.assertEquals(headers.getAcceptEncoding(), "gzip, deflate, br", "Accept-Encoding should match");
        Assert.assertFalse(headers.getCookie() != null && !headers.getCookie().isEmpty());

        // Проверка значения поля url
        Assert.assertEquals(patchResponse.getUrl(), "https://postman-echo.com/patch", "URL should be 'https://postman-echo.com/patch'");
    }

    @Test
    public void testDeleteRequest() throws Exception {
        // Выполнение DELETE-запроса
        Response response = RestAssured.given()
                .contentType("text/plain; charset=ISO-8859-1")
                .header("User-Agent", "PostmanRuntime/7.41.1")
                .header("cache-control", "no-cache")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("postman-token", "37e256d8-f79a-48de-8eba-79aa4917078c")
                .body("This is expected to be sent back as part of response body.")// Убедитесь, что тип контента соответствует ожидаемому
                .when()
                .delete("/delete");

        // Вывод полного ответа для отладки
        String responseBody = response.getBody().asString();
        System.out.println("Response JSON Delete: " + responseBody);

        // Десериализация JSON ответа в объект
        ObjectMapper objectMapper = new ObjectMapper();
        DeleteResponse deleteResponse = objectMapper.readValue(responseBody, DeleteResponse.class);

        // Проверка значений в поле data
        Assert.assertEquals(deleteResponse.getData(), "This is expected to be sent back as part of response body.",
                "Data field value should match the expected value");

        // Проверка значений в поле form
        Map<String, String> form = deleteResponse.getForm();
        Assert.assertTrue(form.isEmpty(), "Form field should be empty");

        // Проверка значений в поле хедеров
        DeleteResponse.Headers headers = deleteResponse.getHeaders();
        Assert.assertEquals(headers.getHost(), "postman-echo.com", "Host should be 'postman-echo.com'");
        Assert.assertEquals(headers.getxForwardedProto(), "https", "x-forwarded-proto should be 'http'");
        Assert.assertTrue(headers.getxRequestStart().startsWith("t="));
        Assert.assertEquals(headers.getConnection(), "close", "Connection should be 'close'");
        Assert.assertEquals(headers.getContentLength(), "58", "Content-Length should be '58'");
        Assert.assertEquals(headers.getxForwardedPort(), "443", "x-forwarded-port should be '443'");
        Assert.assertTrue(headers.getxAmznTraceId().startsWith("Root=1-"));
        Assert.assertEquals(headers.getContentType(), "text/plain; charset=ISO-8859-1", "Content-Type should be 'text/plain'");
        Assert.assertEquals(headers.getUserAgent(), "PostmanRuntime/7.41.1", "User-Agent should be 'PostmanRuntime/7.41.1'");
        Assert.assertEquals(headers.getAccept(), "*/*", "Accept should be '*/*'");
        Assert.assertEquals(headers.getCacheControl(), "no-cache", "Cache-Control should be 'no-cache'");
        Assert.assertEquals(headers.getPostmanToken(), "37e256d8-f79a-48de-8eba-79aa4917078c", "Postman-Token should match");
        Assert.assertEquals(headers.getAcceptEncoding(), "gzip, deflate, br", "Accept-Encoding should match");
        Assert.assertFalse(headers.getCookie() != null && !headers.getCookie().isEmpty());

        // Проверка значения поля url
        Assert.assertEquals(deleteResponse.getUrl(), "https://postman-echo.com/delete", "URL should be 'http://postman-echo.com/delete'");
    }
}

