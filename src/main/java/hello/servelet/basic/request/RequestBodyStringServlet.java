package hello.servelet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet",urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream(); // 메시지바디 내용을 바이트코드로 꺼내기
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);// 바이트 코드를 스트링으로 바꾸고  어떤 인코딩인지도 알려주기

        System.out.println("messageBody = " + messageBody);
        response.getWriter().write("ok ");

    }
}