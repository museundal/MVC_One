package hello.servelet.basic;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet" , urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override // ctrl + o -> service 검색해서 자물쇠 있는거 선택하기
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("helloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        //컨텐츠타입
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        //컨텐츠바디
        response.getWriter().write("Hello " + username);
    }
}
