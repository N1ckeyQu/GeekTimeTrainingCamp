package homework;

import okhttp3.*;
import okio.BufferedSource;

import java.io.IOException;

/**
 * 必做第二题——使用okhttp访问localhost:8808
 *
 * HttpServer01有问题，我用的NettyHttpServer这个类作为server
 */
public class MyHttpClient {
    public static void main(String[] args) throws IOException {
        String url = "http://localhost:8808";
        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = httpClient.newCall(request);
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String string = response.body().string();
        System.out.println(string);
    }
}
