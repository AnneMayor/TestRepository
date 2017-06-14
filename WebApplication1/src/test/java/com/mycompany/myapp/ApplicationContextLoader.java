package com.mycompany.myapp;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	// file이외에 classpath가 올 때도 있음.
	"file:WebContent/WEB-INF/spring/applicationContext.xml",
	"file:WebContent/WEB-INF/spring/dispatcher-servlet.xml"
})
// @WebAppConfiguration() -> WebContent가 src/main/webapp/WEB-INF에 존재
// STS로 웹프로젝트를 만들게 되면 위의 경로 밑에 WEB-INF가 존재함. 그러나 우리는 Maven 프로젝트로 사용하기에 "WebContent"라고 명시해줘야 함. 
@WebAppConfiguration("WebContent")
public class ApplicationContextLoader {
	
}