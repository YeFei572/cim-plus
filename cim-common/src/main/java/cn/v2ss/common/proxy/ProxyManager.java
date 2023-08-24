package cn.v2ss.common.proxy;

import cn.v2ss.common.enums.StatusEnum;
import cn.v2ss.common.exception.CIMException;
import cn.v2ss.common.util.HttpClient;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import okhttp3.OkHttpClient;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@NoArgsConstructor
@AllArgsConstructor
public final class ProxyManager<T> {
    private Class<T> clazz;

    private String url;

    private OkHttpClient client;

    public T getInstance() {
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{clazz}, new ProxyInvocation());
    }


    private class ProxyInvocation implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            JsonObject jsonObject = new JsonObject();
            String serverUrl = url + "/" + method.getName();
            if (null != args && args.length > 1) {
                throw new CIMException(StatusEnum.VALIDATION_FAIL);
            }

            if (method.getParameterTypes().length > 0 && null != args && args.length > 0) {
                Object para = args[0];
                Class<?> parameterType = method.getParameterTypes()[0];
                for (Field filed : parameterType.getDeclaredFields()) {
                    filed.setAccessible(Boolean.TRUE);
                    Object fieldValue = filed.get(para);
                    if (fieldValue instanceof Integer || fieldValue instanceof Long) {
                        jsonObject.addProperty(filed.getName(), (Number) fieldValue);
                    } else if (fieldValue instanceof  String) {
                        jsonObject.addProperty(filed.getName(), fieldValue.toString());
                    } else if (fieldValue instanceof  Boolean) {
                        jsonObject.addProperty(filed.getName(), (Boolean) fieldValue);
                    }
                }
            }
            return HttpClient.call(client, jsonObject.toString(), serverUrl);
        }
    }
}
