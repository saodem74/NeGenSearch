package project;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;


@WebServlet("/GetSearchServlet")
public class GetSearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /*
     * 1. get query String from view
     * 2. run bash to generate ResultSearch.txt
     * 3. read line one by one
     * */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            String inputStr = request.getParameter("query");
            System.out.println("InputString: " + inputStr);

            //TODO: run  search.sh
            bashRunController.searchQuery(inputStr);

            JSONObject query_response = new JSONObject();
            //JSONObject results = new JSONObject();
            JSONArray results = new JSONArray();

            List<String[]> res = bashRunController.getResultFromFile();
            System.out.println("========= Search result ========");
            for (int i=0;i<res.size();i++) {
                String[] ss = res.get(i);
                System.out.println(ss[0]);
                System.out.println(ss[1]);
                System.out.println();

                JSONObject result = new JSONObject();
                result.put("url",ss[0]);
                result.put("content",ss[1]);
                results.put(result);
            }

            PrintWriter out = response.getWriter();
            out.print(results.toString());
            out.flush();

    }

}
