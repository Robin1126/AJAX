import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Author : Binbin Luo
 * Date : 15.04.2023
 */
@WebServlet("/proxy")
public class ProxyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //1.获得一个httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //2.生成一个get请求
        HttpGet httpget = new HttpGet("http://localhost:8081/B/react");
        //3.执行get请求并返回结果
        CloseableHttpResponse resp = httpclient.execute(httpget);
        HttpEntity entity = resp.getEntity();
        String line = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            //4.处理结果
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(),"UTF-8"));
            while ((line = reader.readLine()) != null) {
                // 逐行读出内容
                stringBuffer.append(line);
            }
//            System.out.print(stringBuffer);

        } finally {
            resp.close();
            httpclient.close();
        }
        PrintWriter out = response.getWriter();
        out.print(stringBuffer);
    }
}
