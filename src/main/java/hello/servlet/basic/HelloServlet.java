package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")  // /hello로 오면 이게 실행됨
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.service(req, resp);  // Survlet이 호출되면 이 service 메소스가 호출된다.

        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username");
        System.out.println("username = " + username);

        // response 응답 메시지에 데이터가 담겨져 나가게 됨
        response.setContentType("text/plain");  // 단순 문자
        response.setCharacterEncoding("utf-8");  // 인코딩 정보, 한글 사용
        response.getWriter().write("hello " + username);  // http 메시지 body에 데이터가 들어감
    }
}
