package org.example.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;

public class PostRawTextResponse {

    @JsonProperty("args")
    private Map<String, String> args = new HashMap<>();

    @JsonProperty("data")
    private Map<String, String> data;

    @JsonProperty("files")
    private Map<String, String> files = new HashMap<>();

    @JsonProperty("form")
    private Map<String, String> form = new HashMap<>();

    @JsonProperty("headers")
    private Headers headers;

    @JsonProperty("json")
    private Object json;

    @JsonProperty("url")
    private String url;

    // Пустой конструктор
    public PostRawTextResponse() {
    }

    // Геттеры и сеттеры
    public Map<String, String> getArgs() {
        return args;
    }

    public void setArgs(Map<String, String> args) {
        this.args = args;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public Map<String, String> getFiles() {
        return files;
    }

    public void setFiles(Map<String, String> files) {
        this.files = files;
    }

    public Map<String, String> getForm() {
        return form;
    }

    public void setForm(Map<String, String> form) {
        this.form = form;
    }

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    public Object getJson() {
        return json;
    }

    public void setJson(Object json) {
        this.json = json;
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

        @JsonProperty("content-length")
        private String contentLength;

        @JsonProperty("x-forwarded-proto")
        private String xForwardedProto;

        @JsonProperty("x-forwarded-port")
        private String xForwardedPort;

        @JsonProperty("x-amzn-trace-id")
        private String xAmznTraceId;

        @JsonProperty("content-type")
        private String contentType;

        @JsonProperty("user-agent")
        private String userAgent;

        @JsonProperty("accept")
        private String accept;

        @JsonProperty("cache-control")
        private String cacheControl;

        @JsonProperty("postman-token")
        private String postmanToken;

        @JsonProperty("accept-encoding")
        private String acceptEncoding;

        @JsonProperty("cookie")
        private String cookie;

        // Пустой конструктор
        public Headers() {
        }

        // Геттеры и сеттеры
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

        public String getContentLength() {
            return contentLength;
        }

        public void setContentLength(String contentLength) {
            this.contentLength = contentLength;
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

        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
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

        public String getAcceptEncoding() {
            return acceptEncoding;
        }

        public void setAcceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
        }

        public String getCookie() {
            return cookie;
        }

        public void setCookie(String cookie) {
            this.cookie = cookie;
        }
    }
}