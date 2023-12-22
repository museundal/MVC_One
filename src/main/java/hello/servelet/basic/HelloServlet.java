package hello.servelet.basic;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet" , urlPatterns = "/hello") // 서블릿이 호츌되면 service 메소드가 실행이 됩니다.
public class HelloServlet extends HttpServlet {

    @Override // ctrl + o -> service 검색해서 자물쇠 있는 메소드 선택하기
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("helloServlet.service");
        System.out.println("request = " + request); // HttpServletRequest 인터페이스 구현체들이 찍힌다. 톰캣 라이브러리 이용
        System.out.println("response = " + response);
        //요청 파라미터를 읽어준다.(쿼리 파라미터)
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        //응답 (개발자 도구에서 확인 가능 -response Headers)
        //컨텐츠타입(헤더정보)
        response.setContentType("text/plain"); //단순 문자
        response.setCharacterEncoding("utf-8"); // 인코딩 정보
        //컨텐츠바디
        response.getWriter().write("Hello " + username);
    }
}
