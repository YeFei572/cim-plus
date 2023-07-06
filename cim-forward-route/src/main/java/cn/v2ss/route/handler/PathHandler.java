package cn.v2ss.route.handler;

import cn.hutool.core.util.ReUtil;
import cn.v2ss.common.kit.SpringUtils;
import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.*;
import java.util.regex.Pattern;

@Data
@Component
public class PathHandler implements InitializingBean {

    private static final Pattern PATTERN = Pattern.compile("\\{(.*?)}");

    private List<String> paths = new ArrayList<>();

    @Override
    public void afterPropertiesSet() {
        Set<String> set = new HashSet<>();
        RequestMappingHandlerMapping mapping = SpringUtils.getBean("requestMappingHandlerMapping", RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();
        map.keySet().forEach(info -> {
            if (Objects.nonNull(info.getPathPatternsCondition())) {
                Objects.requireNonNull(info.getPathPatternsCondition().getPatterns())
                        .forEach(url -> set.add(ReUtil.replaceAll(url.getPatternString(), PATTERN, "*")));
            }
        });
        paths.addAll(set);
    }
}
