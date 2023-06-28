package cn.v2ss.common.util;

import cn.v2ss.common.exception.CIMException;
import okhttp3.*;

import java.io.IOException;

public final class HttpClient {

    private static final MediaType mediaType = MediaType.parse("application/json");

    public static Response call(OkHttpClient client, String params, String url) throws IOException {
        RequestBody requestBody = RequestBody.create(params, mediaType);
        Request req = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Response response = client.newCall(req).execute();
        if (!response.isSuccessful()) {
            throw new CIMException("Unexpected code " + response);
        }
        return response;
    }
}
