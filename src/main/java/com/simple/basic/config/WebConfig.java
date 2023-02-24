package com.simple.basic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.simple.basic.controller.HomeController;
import com.simple.basic.util.UserAuthHandler;
import com.simple.basic.util.UserSuccessHandler;

@Configuration //개별적인 스프링 빈 설정 파일
public class WebConfig implements WebMvcConfigurer {

	/*
	//빈을 보관하고 있는 장소 (스프링 컨테이너)
	@Autowired
	ApplicationContext applicationContext;
	
	//@Value("${어플리케이션프로퍼티 변수명}")
	//properties파일에 선언된 변수를 바로 참조
	@Value("${server.port}")
	String port;
	
	
	@Bean //빈 어노테이션이 붙어있으면 해당 메서드 실행하게 됨 
	public void test() {
		TestBean t = applicationContext.getBean(TestBean.class);
		System.out.println(t); //아래 테스트빈 생성 확인
		
		HomeController h = applicationContext.getBean(HomeController.class);
		System.out.println(h); //컨트롤러가 빈으로 생성됐는지 확인
	
		int c = applicationContext.getBeanDefinitionCount(); //빈 개수 확인
		System.out.println("빈의개수:" + c);
		
		System.out.println("properies에 선언된값:" + port);
		
		
	} //이 메서드는 빈으로 생성되지 않음 void라 반환이 없어서...
	
	//빈생성(수동)
	@Bean //해당 메서드 실행하게 됨 
	public TestBean testBean() {
		//System.out.println("테스트 빈 실행됨2");
		return new TestBean(); //빈으로 등록
	}
	*/
	
	@Bean
	public UserAuthHandler userAuthHandler() {
		return new UserAuthHandler(); //빈으로 등록
	}
	@Bean 
	public UserSuccessHandler userSuccessHandler() {
		return new UserSuccessHandler(); //빈으로 등록
	}
	
	//WebMvcConfigurer클래스가 제공해주는 인터셉터 추가 함수
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(userAuthHandler())
				.addPathPatterns("/user/*") //패스경로포함
				.excludePathPatterns("/user/login"); //패스경로제외-로그인페이지는 세션없이도 들어갈 수 있기때문에
		
		//경로별로 인터셉터를 다르게 등록
		//포스트핸들러
		registry.addInterceptor(userSuccessHandler())
				.addPathPatterns("/user/*")
				.excludePathPatterns("/user/login");
	}
	
	
	
	
}
