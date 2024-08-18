package org.example.api;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;

public class DeleteResponse {
    private Map<String, String> args = new HashMap<>();
    @JsonProperty("data")
    private String data;
    private Map<String, String> files = new HashMap<>();
    private Map<String, String> form = new HashMap<>();
    private Headers headers;
    private Map<String, String> json;
    private String url;

    @JsonProperty("args")
    public Map<String, String> getArgs() {
        return args;
    }

    @JsonProperty("args")
    public void setArgs(Map<String, String> args) {
        this.args = args;
    }

    @JsonProperty("data")
    public String getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(String data) {
        this.data = data;
    }

    @JsonProperty("files")
    public Map<String, String> getFiles() {
        return files;
    }

    @JsonProperty("files")
    public void setFiles(Map<String, String> files) {
        this.files = files;
    }

    @JsonProperty("form")
    public Map<String, String> getForm() {
        return form;
    }

    @JsonProperty("form")
    public void setForm(Map<String, String> form) {
        this.form = form;
    }

    @JsonProperty("headers")
    public Headers getHeaders() {
        return headers;
    }

    @JsonProperty("headers")
    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    @JsonProperty("json")
    public Map<String, String> getJson() {
        return json;
    }

    @JsonProperty("json")
    public void setJson(Map<String, String> json) {
        this.json = json;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    public static class Headers {
        @JsonProperty("x-request-start")
        private String xRequestStart;
        @JsonProperty("x-forwarded-proto")
        private String xForwardedProto;
        @JsonProperty("x-forwarded-port")
        private String xForwardedPort;
        @JsonProperty("host")
        private String host;
        @JsonProperty("x-amzn-trace-id")
        private String xAmznTraceId;
        @JsonProperty("content-length")
        private String contentLength;
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
        @JsonProperty("content-type")
        private String contentType;
        @JsonProperty("connection")
        private String connection;
        @JsonProperty("cookie")
        private String cookie;


        public String getConnection() {
            return connection;
        }

        public void setConnection(String connection) {
            this.connection = connection;
        }

        public String getCookie() {
            return cookie;
        }

        public void setCookie(String cookie) {
            this.cookie = cookie;
        }

        public String getxRequestStart() {
            return xRequestStart;
        }

        public void setxRequestStart(String xRequestStart) {
            this.xRequestStart = xRequestStart;
        }

        public String getxForwardedProto() {
            return xForwardedProto;
        }

        public void setxForwardedProto(String xForwardedProto) {
            this.xForwardedProto = xForwardedProto;
        }

        public String getxForwardedPort() {
            return xForwardedPort;
        }

        public void setxForwardedPort(String xForwardedPort) {
            this.xForwardedPort = xForwardedPort;
        }

        public String getxAmznTraceId() {
            return xAmznTraceId;
        }

        public void setxAmznTraceId(String xAmznTraceId) {
            this.xAmznTraceId = xAmznTraceId;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getContentLength() {
            return contentLength;
        }

        @JsonProperty("content-length")
        public void setContentLength(String contentLength) {
            this.contentLength = contentLength;
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

        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }
    }
}