package hello.servelet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setStatus(200); // 응답 상태 입력 가능
        //[status-line]
        response.setStatus(HttpServletResponse.SC_OK); // 200 직접 적는 것보단 이렇게!
//        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        //[resoponse-header]
        response.setHeader("Content-Type","text/plain;charset=utf-8");
        response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); // 응답을 캐시하지 말 것
        response.setHeader("Pragma","no-cache"); //라우저나 서버가 웹 페이지의 정보를 임시 저장하는 것을 방지(구버전)
        response.setHeader("doyeon-header","hello");
        //[Header 편의 메서드]
        content(response);
        cookie(response);
        redirect(response);
        PrintWriter writer = response.getWriter();
        writer.println("안녕하세요");


    }

    private void content(HttpServletResponse response) { //컨텐츠 편의 메서드
        //Content-Type: text/plain;charset=utf-8
        //Content-Length: 2

        //response.setHeader("Content-Type", "text/plain;charset=utf-8"); 이렇게 해두 되고 밑에 setContentType ,setCharacterEncoding 으로 해도된다.
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        //response.setContentLength(2); //(생략시 자동 생성)
    }

    private void cookie(HttpServletResponse response) { // 쿠키 편의 메서드
        //Set-Cookie: myCookie=good; Max-Age=600;
        //response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600"); 이런 방식으로 해도 되고 밑에처럼 해도되고!
        Cookie cookie = new Cookie("myCookie", "good"); // 쿠키 객체 만듬다음 !
        cookie.setMaxAge(600); //600초
        response.addCookie(cookie);
    }

    private void redirect(HttpServletResponse response) throws IOException {
        //Status Code 302
        //Location: /basic/hello-form.html
        //첫번째 방법
        //response.setStatus(HttpServletResponse.SC_FOUND); //302
        //response.setHeader("Location", "/basic/hello-form.html");

        //두번째 방법
        response.sendRedirect("/basic/hello-form.html");
    }
}
