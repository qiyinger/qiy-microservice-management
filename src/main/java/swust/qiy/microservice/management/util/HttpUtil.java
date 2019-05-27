package swust.qiy.microservice.management.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import okhttp3.Call;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.FormBody;
import okhttp3.FormBody.Builder;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by binwang on 18/4/17.
 */
public class HttpUtil {


    private static final String SUCCESS_JSON = "{status:200}";
    private static HttpUtil httpUtil;

    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    public HttpUtil setHeaders(Headers headers) {
        this.headers = headers;
        return httpUtil;
    }

    private Headers headers;


    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    private OkHttpClient okHttpClient = new OkHttpClient().newBuilder().cookieJar(new CookieJar() {
        private final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();

        public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
            cookieStore.put(httpUrl.host(), list);
        }

        public List<Cookie> loadForRequest(HttpUrl httpUrl) {
            return Optional.ofNullable(cookieStore.get(httpUrl.host())).orElse(new ArrayList<Cookie>());
        }
    }).build();

    public Headers getHeaders() {
        return this.headers;
    }

    public static HttpUtil getInstance() {
        if (null == httpUtil) {
            httpUtil = new HttpUtil();
        }
        return httpUtil;
    }

    @SuppressWarnings("rawtypes")
	private void handleError(String result) {
        Optional.ofNullable(result).ifPresent(r -> {
            if (r.indexOf("\"exception\"") > -1) {
                Map map = null;
                try {
                    map = new ObjectMapper().readValue(result, Map.class);
                } catch (IOException e) {
                  throw new RuntimeException(map.get("message").toString());
                }
            }
        });
    }

    private String call(Request request) {
        Call call = okHttpClient.newCall(request);
        try {
            logger.debug(request.url().toString());
            Response response = call.execute();
            String result = response.body().string();
            if(response.code() > 300){
                throw new RuntimeException("网络错误");
            }
            handleError(result);
            return "".equals(result) ? SUCCESS_JSON : result;
        } catch (IOException e) {
            logger.error(e.toString());
          throw new RuntimeException("网络错误");
        }
    }

    MediaType JSON = MediaType.parse("Constants.CONTENTT_YPE");

    private RequestBody getRequestBody(Map<String, String> params) {
        try {
            return RequestBody.create(JSON, new ObjectMapper().writeValueAsString(params));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            logger.error(String.format("JSON 转化失败!%s", params.toString()));
            return null;
        }
    }

    public String post(String url, Map<String, String> bodyData) {
    	Optional<Headers> headerOpt = Optional.ofNullable(getHeaders());
        return call(new Request.Builder()
                .headers(headerOpt.orElseGet(()->Headers.of("Content_Type", ContentType.APPLICATION_JSON.toString(), "Accept", ContentType.APPLICATION_JSON.toString())))
                .url(url)
                .post(getRequestBody(bodyData))
                .build());
    }

    /**
     * @param url
     * @param bodyData
     * @return
     */
    public String put(String url, Map<String, String> bodyData) {
    	Optional<Headers> headerOpt = Optional.ofNullable(getHeaders());
        return call(new Request.Builder()
                .headers(headerOpt.orElseGet(()->Headers.of("Content_Type", ContentType.APPLICATION_JSON.toString(), "Accept", ContentType.APPLICATION_JSON.toString())))
                .url(url)
                .put(getRequestBody(bodyData))
                .build());
    }

    public String get(String url) {
    	Optional<Headers> headerOpt = Optional.ofNullable(getHeaders());
        return call(new Request.Builder()
                .headers(headerOpt.orElseGet(()->Headers.of("Content_Type", ContentType.APPLICATION_JSON.toString(), "Accept", ContentType.APPLICATION_JSON.toString())))
                .url(url)
                .get()
                .build());
    }

    public String delete(String url) {
    	Optional<Headers> headerOpt = Optional.ofNullable(getHeaders());
        return call(new Request.Builder()
                .headers(headerOpt.orElseGet(()->Headers.of("Content_Type", ContentType.APPLICATION_JSON.toString(), "Accept", ContentType.APPLICATION_JSON.toString())))
                .url(url)
                .delete()
                .build());
    }
    
    
    public String postFormData(String url, Map<String, String> params){
    	Optional<Headers> headerOpt = Optional.ofNullable(getHeaders());
		Builder builder = new FormBody.Builder();
		for (Map.Entry<String, String> entry : params.entrySet()) {  
			builder.add(entry.getKey(), entry.getValue());
		}

		return call(new Request.Builder()
				.headers(headerOpt.orElseGet(()->Headers.of("Content_Type", ContentType.APPLICATION_JSON.toString(), "Accept", ContentType.APPLICATION_JSON.toString())))
				.url(url)
				.post(builder.build())
				.build());
    }


}
