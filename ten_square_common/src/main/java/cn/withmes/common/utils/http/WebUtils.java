package cn.withmes.common.utils.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.CookieHandler;
import java.nio.charset.Charset;

/**
 * @Description: WEB Utils for request
  * @author liming@haokukeji.com
  * @date 2018/5/3
  *
  * =================================================================================================
  *     Task ID			  Date			     Author		      Description
  * ----------------+----------------+-------------------+-------------------------------------------
 */
public class WebUtils {
    private static final Logger LOG = LoggerFactory.getLogger(WebUtils.class);
    public static final Charset CHARSET_UTF8 = Charset.forName("UTF-8");
    public static final String     METHOD_POST     = "POST";
    public static final String     METHOD_GET      = "GET";

    private static SSLContext       ctx             = null;
    private static HostnameVerifier verifier        = null;

    private static SSLSocketFactory socketFactory   = null;
    private static CookieHandler cookieManager   	= null;

    private static final int CONNECT_TIMEOUT = 10000;
    private static final int READ_TIMEOUT = 60000;

  /*  private static class DefaultTrustManager implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }
    }
    static {
        try {
            ctx = SSLContext.getInstance("TLS");
            ctx.init(new KeyManager[0], new TrustManager[] { new DefaultTrustManager() }, new SecureRandom());
            ctx.getClientSessionContext().setSessionTimeout(15);
            ctx.getClientSessionContext().setSessionCacheSize(1000);
            socketFactory = ctx.getSocketFactory();
        } catch (Exception e) {
            LOG.info("initialize SocketFactory fail!");
        }
        verifier = new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return false;//默认认证不通过，进行证书校验。
            }
        };
    }

    private WebUtils() {
    }
    *//**
     * 是否启用Cookie管理
     * @param enabled
     *//*
    public static void setCookieEnabled(boolean enabled) {
        CookieHandler defaultManager = CookieManager.getDefault();
        if (enabled) {
            if (defaultManager == null) {
                if (cookieManager == null)
                    cookieManager = new CookieManager(null, CookiePolicy.ACCEPT_ALL);
                CookieManager.setDefault(cookieManager);
            }
        } else {
            if (defaultManager != null && cookieManager == null)
                cookieManager = defaultManager;
            CookieManager.setDefault(null);
        }
    }

    *//**
     * 获取Cookie管理器
     * @return
     *//*
    public static CookieHandler getCookieHandler() {
        return CookieManager.getDefault();
    }



    *//**
     * 执行HTTP POST请求。
     *
     * @param url 请求地址
     * @param textParams 请求参数
     * @return 响应字符串
     * @throws IOException
     *//*
    public static String doPost(String url, Map<String, Object> textParams) throws IOException {
        return doPost(url, textParams, CHARSET_UTF8, null);
    }
    *//**
     * 执行HTTP POST请求。
     *
     * @param url 请求地址
     * @param textParams 请求参数
     * @param charset 字符集，如UTF-8, GBK, GB2312
     * @param headerMap 请求头属性设置
     * @return 响应字符串
     * @throws IOException
     *//*
    public static String doPost(String url, Map<String, Object> textParams, Charset charset, Map<String, String> headerMap) throws IOException {
        return doPost(url, textParams, charset, CONNECT_TIMEOUT, READ_TIMEOUT, headerMap);
    }


    *//**
     * 执行HTTP POST请求。
     *
     * @param url 请求地址
     * @param textParams 请求参数对
     * @param charset 字符集，如UTF-8, GBK, GB2312
     * @param connectTimeout 连接超时时间
     * @param readTimeout 读取超时时间
     * @param headerMap 请求头属性设置
     * @return 响应字符串
     * @throws IOException
     *//*
    public static String doPost(String url, Map<String, Object> textParams, Charset charset, int connectTimeout, int readTimeout, Map<String, String> headerMap) throws IOException {
        if (charset == null) {
            charset = CHARSET_UTF8;
        }
        return doPost(url, buildQuery(textParams, charset), charset, connectTimeout, readTimeout, headerMap);
    }

    *//**
     * 执行HTTP POST请求。
     *
     * @param url 请求地址
     * @param content 请求内容
     * @param charset 字符集，如UTF-8, GBK, GB2312
     * @param connectTimeout 连接超时时间
     * @param readTimeout 读取超时时间
     * @param headerMap 请求头属性设置
     * @return 响应字符串
     * @throws IOException
     *//*
    public static String doPost(String url, String content, Charset charset, int connectTimeout, int readTimeout, Map<String, String> headerMap) throws IOException {
        if (charset == null) {
            charset = CHARSET_UTF8;
        }
        String cType = "application/x-www-form-urlencoded;charset=" + charset;
        HttpURLConnection conn = getConnection(url, METHOD_POST, cType, connectTimeout, readTimeout, headerMap);
        return doRequest(conn, content, charset);
    }
    *//**
     * 执行HTTP POST请求。
     *
     * @param url 请求地址
     * @param content 请求内容
     * @param headerMap 请求头属性设置
     * @return 响应字符串
     * @throws IOException
     *//*
    public static String doPost(String url, String content, Map<String, String> headerMap) throws IOException {
        return doPost(url, content, CHARSET_UTF8, CONNECT_TIMEOUT, READ_TIMEOUT, headerMap);
    }
    *//**
     * 执行HTTP POST请求。
     *
     * @param url 请求地址
     * @param content 请求内容
     * @return 响应字符串
     * @throws IOException
     *//*
    public static String doPost(String url, String content) throws IOException {
        return doPost(url, content, null);
    }

    *//**
     * 执行HTTP请求。
     * @param conn 请求连接
     * @param content 请求内容
     * @param charset 请求字符集
     * @return
     * @throws IOException
     *//*
    public static String doRequest(HttpURLConnection conn, String content, Charset charset) throws IOException {
        if (conn == null) {
            throw new IOException("connection is null");
        }
        OutputStream out = null;
        try {
            if (content != null && content.length() > 0) {
                out = conn.getOutputStream();
                out.write(content.getBytes(charset != null ? charset : CHARSET_UTF8));
            }
            return getResponseAsString(conn);
        } finally {
            if (out != null) {try {out.close();} catch (IOException e) {}}
            conn.disconnect();
        }
    }
    *//**
     * 执行HTTP请求。
     * @param conn 请求连接
     * @param content 请求内容
     * @return
     * @throws IOException
     *//*
    public static String doRequest(HttpURLConnection conn, String content) throws IOException {
        return doRequest(conn, content, null);
    }

    *//**
     * 执行带文件上传的HTTP POST请求。
     *
     * @param url 请求地址
     * @param textParams 文本请求参数
     * @param fileParams 文件请求参数
     * @return 响应字符串
     * @throws IOException
     *//*
    public static String doPost(String url, Map<String, Object> textParams,  Map<String, FileItem> fileParams) throws IOException {
        return doPost(url, textParams, fileParams, null);
    }
    *//**
     * 执行带文件上传的HTTP POST请求。
     *
     * @param url 请求地址
     * @param textParams 文本请求参数
     * @param fileParams 文件请求参数
     * @param headerMap
     * @return 响应字符串
     * @throws IOException
     *//*
    public static String doPost(String url, Map<String, Object> textParams, Map<String, FileItem> fileParams, Map<String, String> headerMap) throws IOException {
        if (fileParams == null || fileParams.isEmpty()) {
            return doPost(url, textParams, CHARSET_UTF8, CONNECT_TIMEOUT, READ_TIMEOUT, headerMap);
        } else {
            return doPost(url, textParams, fileParams, CHARSET_UTF8, CONNECT_TIMEOUT, 0, headerMap);
        }
    }

    *//**
     * 执行带文件上传的HTTP POST请求。
     *
     * @param url 请求地址
     * @param textParams 文本请求参数
     * @param fileParams 文件请求参数
     * @param charset 字符集，如UTF-8, GBK, GB2312
     * @param connectTimeout 连接超时时间
     * @param readTimeout 读取超时时间
     * @param headerMap
     * @return 响应字符串
     * @throws IOException
     *//*
    public static String doPost(String url, Map<String, Object> textParams, Map<String, FileItem> fileParams, Charset charset, int connectTimeout, int readTimeout, Map<String, String> headerMap)
            throws IOException {
        if (fileParams == null || fileParams.isEmpty()) {
            return doPost(url, textParams, charset, connectTimeout, readTimeout, headerMap);
        }
        if (charset == null) {
            charset = CHARSET_UTF8;
        }
        String boundary = System.currentTimeMillis() + ""; // 随机分隔线
        HttpURLConnection conn = null;
        OutputStream out = null;
        try {
            String cType = "multipart/form-data;boundary=" + boundary + ";charset=" + charset;
            conn = getConnection(url, METHOD_POST, cType, connectTimeout, readTimeout, headerMap);
            out = conn.getOutputStream();
            byte[] entryBoundaryBytes = ("\r\n--" + boundary + "\r\n").getBytes(charset);
            if (textParams != null) { // 组装文本请求参数
                Set<Entry<String, Object>> textEntrySet = textParams.entrySet();
                for (Entry<String, Object> textEntry : textEntrySet) {
                    String value = BeanHelper.convert(textEntry.getValue(), String.class);
                    byte[] textBytes = getTextEntry(textEntry.getKey(), value, charset);
                    out.write(entryBoundaryBytes);
                    out.write(textBytes);
                }
            }
            // 组装文件请求参数
            Set<Entry<String, FileItem>> fileEntrySet = fileParams.entrySet();
            for (Entry<String, FileItem> fileEntry : fileEntrySet) {
                FileItem fileItem = fileEntry.getValue();
                byte[] fileBytes = getFileEntry(fileEntry.getKey(), fileItem.getFileName(), fileItem.getMimeType(), charset);
                out.write(entryBoundaryBytes);
                out.write(fileBytes);
                out.write(fileItem.getContent());
            }
            // 添加请求结束标
            byte[] endBoundaryBytes = ("\r\n--" + boundary + "--\r\n").getBytes(charset);
            out.write(endBoundaryBytes);
            return getResponseAsString(conn);
        } finally {
            IOUtils.closeQuietly(out);
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    private static byte[] getTextEntry(String fieldName, String fieldValue, Charset charset) throws IOException {
        StringBuilder entry = new StringBuilder();
        entry.append("Content-Disposition:form-data;name=\"");
        entry.append(fieldName);
        entry.append("\"\r\nContent-Type:text/plain\r\n\r\n");
        entry.append(fieldValue);
        return entry.toString().getBytes(charset);
    }

    private static byte[] getFileEntry(String fieldName, String fileName, String mimeType, Charset charset) throws IOException {
        StringBuilder entry = new StringBuilder();
        entry.append("Content-Disposition:form-data;name=\"");
        entry.append(fieldName);
        entry.append("\";filename=\"");
        entry.append(fileName);
        entry.append("\"\r\nContent-Type:");
        entry.append(mimeType);
        entry.append("\r\n\r\n");
        return entry.toString().getBytes(charset);
    }

    *//**
     * 执行HTTP GET请求。
     *
     * @param url 请求地址
     * @param textParams 请求参数
     * @return 响应字符串
     * @throws IOException
     *//*
    public static String doGet(String url, Map<String, Object> textParams) throws IOException {
        return doGet(url, textParams, CHARSET_UTF8);
    }
    *//**
     * 执行HTTP GET请求。
     *
     * @param url 请求地址
     * @return 响应字符串
     * @throws IOException
     *//*
    public static String doGet(String url) throws IOException {
        return doGet(url, (String) null);
    }

    *//**
     * 执行HTTP GET请求。
     *
     * @param url 请求地址
     * @param textParams 请求参数
     * @param charset 字符集，如UTF-8, GBK, GB2312
     * @return 响应字符串
     * @throws IOException
     *//*
    public static String doGet(String url, Map<String, Object> textParams, Charset charset) throws IOException {
        if (charset == null) {
            charset = CHARSET_UTF8;
        }
        return doGet(url, buildQuery(textParams, charset), charset, CONNECT_TIMEOUT, READ_TIMEOUT, null);
    }

    *//**
     * 执行HTTP GET请求。
     *
     * @param url 请求地址
     * @param params 请求参数
     * @param headerMap
     * @return 响应字符串
     * @throws IOException
     *//*
    public static String doGet(String url, String params, Map<String, String> headerMap) throws IOException {
        String ctype = "application/x-www-form-urlencoded;charset=" + CHARSET_UTF8;
        HttpURLConnection conn = getConnection(buildGetUrl(url, params), METHOD_GET, ctype, CONNECT_TIMEOUT, READ_TIMEOUT, headerMap);
        return doRequest(conn, null, CHARSET_UTF8);
    }

    *//**
     * 执行HTTP GET请求。
     *
     * @param url 请求地址
     * @param params 请求参数
     * @param charset 字符集，如UTF-8, GBK, GB2312
     * @param connectTimeout 连接超时时间
     * @param readTimeout 读取超时时间
     * @param headerMap
     * @return 响应字符串
     * @throws IOException
     *//*
    public static String doGet(String url, String params, Charset charset, int connectTimeout, int readTimeout, Map<String, String> headerMap) throws IOException {
        if (charset == null) {
            charset = CHARSET_UTF8;
        }
        String ctype = "application/x-www-form-urlencoded;charset=" + charset;
        HttpURLConnection conn = getConnection(buildGetUrl(url, params), METHOD_GET, ctype, connectTimeout, readTimeout, headerMap);
        return doRequest(conn, null, charset);
    }

    *//**
     * 执行HTTP GET请求。
     *
     * @param url 请求地址
     * @param params 请求参数
     * @return 响应字符串
     * @throws IOException
     *//*
    public static String doGet(String url, String params) throws IOException {
        return doGet(url, params, null);
    }

    *//**
     * 获取连接
     * @param url
     * @param method
     * @param ctype
     * @param connectTimeout
     * @param readTimeout
     * @param headerMap
     * @return
     *//*
    public static HttpURLConnection getConnection(String url, String method, String ctype, int connectTimeout, int readTimeout, Map<String, String> headerMap) {
        HttpURLConnection conn = null;
        try {
            URL endPoint = new URL(url);
            if ("https".equals(endPoint.getProtocol())) {
                HttpsURLConnection connHttps = (HttpsURLConnection) endPoint.openConnection();
                conn = connHttps;
                connHttps.setSSLSocketFactory(socketFactory);
                connHttps.setHostnameVerifier(verifier);
            } else {
                conn = (HttpURLConnection) endPoint.openConnection();
            }
            conn.setRequestMethod(method);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestProperty("User-Agent", "fdm-api-client");
            if (ctype != null) {
                conn.setRequestProperty("Content-Type", ctype);
            }
            if (connectTimeout >= 0) {
                conn.setConnectTimeout(connectTimeout);
            }
            if (readTimeout >= 0) {
                conn.setReadTimeout(readTimeout);
            }
            if (headerMap != null && !headerMap.isEmpty()) {
                Iterator<Entry<String, String>> iterator = headerMap.entrySet().iterator();
                while (iterator.hasNext()) {
                    Entry<String, String> entry = iterator.next();
                    conn.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
        } catch (Exception e) {
            LOG.error(e.toString(), e);
        }
        return conn;
    }

    *//**
     * 获取连接
     * @param url
     * @param method
     * @param ctype
     * @return
     *//*
    public static HttpURLConnection getConnection(String url, String method, String ctype) {
        return getConnection(url, method, ctype, null);
    }

    *//**
     * 获取连接
     * @param url
     * @param method
     * @param ctype
     * @param headerMap
     * @return
     *//*
    public static HttpURLConnection getConnection(String url, String method, String ctype, Map<String, String> headerMap) {
        return getConnection(url, method, ctype, CONNECT_TIMEOUT, READ_TIMEOUT, headerMap);
    }

    private static String buildGetUrl(String strUrl, String query) throws IOException {
        if (StringUtils.isEmpty(query)) {
            return strUrl;
        }
        int index = strUrl.indexOf('?');
        if (index > 0 && index < strUrl.length() - 1) {
            if (strUrl.endsWith("&")) {
                strUrl = strUrl + query;
            } else {
                strUrl = strUrl + "&" + query;
            }
        } else {
            if (strUrl.endsWith("?")) {
                strUrl = strUrl + query;
            } else {
                strUrl = strUrl + "?" + query;
            }
        }
        return strUrl;
    }

    public static String buildQuery(Map<String, Object> textParams, Charset charset) {
        if (textParams == null || textParams.isEmpty()) {
            return null;
        }
        StringBuilder query = new StringBuilder();
        Set<Entry<String, Object>> entries = textParams.entrySet();
        boolean hasParam = false;
        for (Entry<String, Object> entry : entries) {
            String name = entry.getKey();
            String value = BeanHelper.convert(entry.getValue(), String.class);
            // 忽略参数名或参数值为空的参数
            if (StringUtils.isNotEmpty(value)) {
                if (hasParam) {
                    query.append("&");
                } else {
                    hasParam = true;
                }
                query.append(name).append("=").append(encode(value, charset));
            }
        }
        return query.toString();
    }

    private static String getResponseAsString(HttpURLConnection conn) throws IOException {
        Charset charset = getResponseCharset(conn.getContentType());
        if (conn.getResponseCode() < 400) {
            return getStreamAsString(conn.getInputStream(), charset, conn.getContentEncoding());
        } else {
            String msg = getStreamAsString(conn.getErrorStream(), charset, conn.getContentEncoding());
            if (StringUtils.isEmpty(msg)) {
                throw new IOException(conn.getResponseCode() + ":" + conn.getResponseMessage());
            } else {
                throw new IOException(conn.getResponseCode() + ":" + msg);
            }
        }
    }

    *//**
     * 获取数据流内容, 会关闭流
     * @param input
     * @param charset
     * @param contentEncoding
     * @return
     * @throws IOException
     *//*
    public static String getStreamAsString(InputStream input, Charset charset, String contentEncoding) throws IOException {
        try {
            if (input == null) {
                return "";
            }
            if ("gzip".equalsIgnoreCase(contentEncoding)) {
                input = new GZIPInputStream(input);
            }
            if (charset == null) {
                charset = CHARSET_UTF8;
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(input, charset));
            StringWriter writer = new StringWriter();
            char[] chars = new char[256];
            int count = 0;
            while ((count = reader.read(chars)) > 0) {
                writer.write(chars, 0, count);
            }
            return writer.toString();
        } finally {
            IOUtils.closeQuietly(input);
        }
    }
    *//**
     * 获取数据流内容, 会关闭流
     * @param input
     * @return
     * @throws IOException
     *//*
    public static String getStreamAsString(InputStream input) throws IOException {
        return getStreamAsString(input, null, null);
    }

    private static Charset getResponseCharset(String ctype) {
        Charset charset = CHARSET_UTF8;
        if (StringUtils.isEmpty(ctype)) {
            return charset;
        }
        Resolver resolver = ResolverUtils.createResolver(";", "=", true);
        resolver.reset(ctype);
        while (resolver.hasNext()) {
            if (resolver.isInTokens() && resolver.nextEquals("charset") && resolver.hasNext()) {
                String charsetName = resolver.next();
                try {
                    charset = Charset.forName(charsetName);
                } catch (Exception e) {
                    LOG.error("编码" + charsetName + "不支持");
                }
                break;
            }
        }
        return charset;
    }

    *//**
     * 使用默认的UTF-8字符集反编码请求参数值。
     *
     * @param value 参数值
     * @return 反编码后的参数值
     *//*
    public static String decode(String value) {
        return decode(value, CHARSET_UTF8);
    }

    *//**
     * 使用默认的UTF-8字符集编码请求参数值。
     *
     * @param value 参数值
     * @return 编码后的参数值
     *//*
    public static String encode(String value) {
        return encode(value, CHARSET_UTF8);
    }

    *//**
     * 使用指定的字符集反编码请求参数值。
     *
     * @param value 参数值
     * @param charset 字符集
     * @return 反编码后的参数值
     *//*
    public static String decode(String value, Charset charset) {
        if (!StringUtils.isEmpty(value) && charset != null) {
            try {
                value = URLDecoder.decode(value, charset.name());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return value;
    }

    *//**
     * 使用指定的字符集编码请求参数值。
     *
     * @param value 参数值
     * @param charset 字符集
     * @return 编码后的参数值
     *//*
    public static String encode(String value, Charset charset) {
        if (!StringUtils.isEmpty(value) && charset != null) {
            try {
                value = URLEncoder.encode(value, charset.name());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return value;
    }

    public static String buildForm(String baseUrl, Map<String, Object> parameters) {
        StringBuilder sb = new StringBuilder();
        sb.append("<form name=\"submit_form\" method=\"post\" action=\"");
        sb.append(baseUrl);
        sb.append("\">\n");
        buildHiddenFields(sb, parameters);
        sb.append("<input type=\"submit\" value=\"submit\" style=\"display:none\" >\n");
        sb.append("</form>\n");
        sb.append("<script>document.forms[0].submit();</script>");
        String form = sb.toString();
        return form;
    }

    private static void buildHiddenFields(StringBuilder sb, Map<String, Object> parameters) {
        if (parameters == null || parameters.isEmpty()) {
            return;
        }
        Set<Entry<String, Object>> entries = parameters.entrySet();
        for (Entry<String, Object> entry : entries) {
            String value = BeanHelper.convert(entry.getValue(), String.class);
            // 除去参数中的空值
            if (entry.getKey() == null || value == null)
                continue;
            buildHiddenField(sb, entry.getKey(), value);
        }
    }

    private static void buildHiddenField(StringBuilder sb, String key, String value) {
        sb.append("<input type=\"hidden\" name=\"");
        sb.append(key);
        sb.append("\" value=\"");
        //转义特殊字符
        if (value.indexOf('&') >= 0) {
            value = value.replace("&", "&amp;");
        }
        if (value.indexOf('<') >= 0) {
            value = value.replace("<", "&lt;");
        }
        if (value.indexOf('\"') >= 0) {
            value = value.replace("\"", "&quot;");
        }
        sb.append(value).append("\">");
    }

    *//**
     * 获取文件的真实后缀名。目前只支持JPG, GIF, PNG, BMP四种图片文件。
     *
     * @param fileBytes 文件字节流
     * @return JPG, GIF, PNG or null
     *//*
    public static String getFileSuffix(byte[] fileBytes) {
        if (fileBytes == null || fileBytes.length < 10) {
            return null;
        }
        if (fileBytes[0] == 'G' && fileBytes[1] == 'I' && fileBytes[2] == 'F') {
            return "gif";
        } else if (fileBytes[1] == 'P' && fileBytes[2] == 'N' && fileBytes[3] == 'G') {
            return "png";
        } else if (fileBytes[6] == 'J' && fileBytes[7] == 'F' && fileBytes[8] == 'I' && fileBytes[9] == 'F') {
            return "jpg";
        } else if (fileBytes[0] == 'B' && fileBytes[1] == 'M') {
            return "bmp";
        } else {
            return null;
        }
    }

    *//**
     * 获取文件的真实媒体类型。目前只支持JPG, GIF, PNG, BMP四种图片文件。
     *
     * @param fileBytes 文件字节流
     * @return 媒体类型(MEME-TYPE)
     *//*
    public static String getMimeType(byte[] fileBytes) {
        String suffix = getFileSuffix(fileBytes);
        String mimeType;
        if ("jpg".equals(suffix)) {
            mimeType = "image/jpeg";
        } else if ("gif".equals(suffix)) {
            mimeType = "image/gif";
        } else if ("png".equals(suffix)) {
            mimeType = "image/png";
        } else if ("bmp".equals(suffix)) {
            mimeType = "image/bmp";
        } else {
            mimeType = "application/octet-stream";
        }
        return mimeType;
    }
*/
}
