package cn.v2ss.route.config;

import cn.dev33.satoken.dao.SaTokenDao;
import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.v2ss.common.kit.SpringUtils;
import cn.v2ss.route.handler.CimSaTokenHandler;
import cn.v2ss.route.handler.PathHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.warn("加载拦截器。。。。。。。。。。。。。。。。。。。。。");
        registry.addInterceptor(new SaInterceptor(handle -> {
                    PathHandler pathHandler = SpringUtils.getBean(PathHandler.class);
                    SaRouter.match(pathHandler.getPaths()).check(StpUtil::checkLogin);
                }))
                .addPathPatterns("/**")
                .excludePathPatterns("/login", "/v3/api-docs/**");
    }

    /**
     * 自定义dao层存储
     */
    @Bean
    public SaTokenDao saTokenDao() {
        return new CimSaTokenHandler();
    }

}
