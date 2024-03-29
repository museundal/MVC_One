package hello.servelet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servelet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "responseJsonServlet",urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Content-Type: application/json

        response.setHeader("content-type", "application/json");
        response.setCharacterEncoding("utf-8");

        HelloData data = new HelloData();
        data.setUserName("kim");
        data.setAge(20);

        ////{"username":"kim","age":20} 이렇게 바뀌려면 objectMapper가 필요합니다.
        String result = objectMapper.writeValueAsString(data);
        response.getWriter().write(result);
    }
}
