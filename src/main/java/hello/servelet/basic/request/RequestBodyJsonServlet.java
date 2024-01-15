package hello.servelet.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servelet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {
    //jackson 라이브러리 이용해서 json객체로 읽기
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //메시지 바디 읽기
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        System.out.println("messageBody = " + messageBody);
    
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        System.out.println("helloData.userName = "+ helloData.getUserName());
        System.out.println("helloData.age = "+ helloData.getAge());
        response.getWriter().write("ok");
    }
}
