package org.example.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetResponse {
    private Map<String, String> args;
    private Headers headers;
    private String url;

    // Пустой конструктор
    public GetResponse() {}

    // Геттеры и сеттеры
    public Map<String, String> getArgs() {
        return args;
    }

    public void setArgs(Map<String, String> args) {
        this.args = args;
    }

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Headers {
        @JsonProperty("host")
        private String host;
        @JsonProperty("x-request-start")
        private String xRequestStart;
        @JsonProperty("connection")
        private String connection;
        @JsonProperty("x-forwarded-proto")
        private String xForwardedProto;
        @JsonProperty("x-forwarded-port")
        private String xForwardedPort;
        @JsonProperty("x-amzn-trace-id")
        private String xAmznTraceId;
        @JsonProperty("user-agent")
        private String userAgent;
        @JsonProperty("accept")
        private String accept;
        @JsonProperty("cache-control")
        private String cacheControl;
        @JsonProperty("postman-token")
        private String postmanToken;
        @JsonProperty("cookie")
        private String cookie;

        // Пустой конструктор
        public Headers() {}

        // Геттеры и сеттеры для каждого поля
        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getXRequestStart() {
            return xRequestStart;
        }

        public void setXRequestStart(String xRequestStart) {
            this.xRequestStart = xRequestStart;
        }

        public String getConnection() {
            return connection;
        }

        public void setConnection(String connection) {
            this.connection = connection;
        }

        public String getXForwardedProto() {
            return xForwardedProto;
        }

        public void setXForwardedProto(String xForwardedProto) {
            this.xForwardedProto = xForwardedProto;
        }

        public String getXForwardedPort() {
            return xForwardedPort;
        }

        public void setXForwardedPort(String xForwardedPort) {
            this.xForwardedPort = xForwardedPort;
        }

        public String getXAmznTraceId() {
            return xAmznTraceId;
        }

        public void setXAmznTraceId(String xAmznTraceId) {
            this.xAmznTraceId = xAmznTraceId;
        }

        public String getUserAgent() {
            return userAgent;
        }

        public void setUserAgent(String userAgent) {
            this.userAgent = userAgent;
        }

        public String getAccept() {
            return accept;
        }

        public void setAccept(String accept) {
            this.accept = accept;
        }

        public String getCacheControl() {
            return cacheControl;
        }

        public void setCacheControl(String cacheControl) {
            this.cacheControl = cacheControl;
        }

        public String getPostmanToken() {
            return postmanToken;
        }

        public void setPostmanToken(String postmanToken) {
            this.postmanToken = postmanToken;
        }

        public String getCookie() {
            return cookie;
        }

        public void setCookie(String cookie) {
            this.cookie = cookie;
        }
    }
}
