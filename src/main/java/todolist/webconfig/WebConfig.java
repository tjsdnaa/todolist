package todolist.webconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 모든 엔드포인트에 대해 CORS를 허용
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")  // React 애플리케이션의 도메인 추가
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // 허용할 HTTP 메소드 설정
                .allowedHeaders("*");  // 모든 헤더 허용
    }
}