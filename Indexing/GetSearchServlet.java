import org.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GetSearchServlet")
public class GetSearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /*
     * 1. get query String from view
     * 2. run bash to generate ResultSearch.txt
     * 3. read line one by one
     * */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){

        try {
            System.out.println("Enter Servlet Controller Post Do");
            response.setContentType("application/json");
            String inputStr = request.getParameter("query");
            System.out.println("InputString: " + inputStr);
            JSONObject query_response = new JSONObject();

//            String[] cmd = { "bash", "~/Crawler/search.sh bash search.sh software"};
//            Process p = Runtime.getRuntime().exec(cmd);

            //Solution 1
            //execute search.sh TODO

            try {
                Runtime.getRuntime().exec("bash search.sh computer");
            }catch(Exception e){
                e.printStackTrace();
            }
            //String homeDir = System.getenv("HOME");
//            String scriptName = "./project/search.sh";
//            String commands[] = new String[]{scriptName,"software"};
//
//            Runtime rt = Runtime.getRuntime();
//            Process process = null;
//            try{
//                process = rt.exec(commands);
//                process.waitFor();
//            }catch(Exception e){
//                e.printStackTrace();
//            }

            //Get data from resultSearch.txt
//            File file = new File("../classes");
//            if(file.exists()){
//                System.out.println("file Name: "+file.getName());
//                System.out.println("File exists.....");
//            }else{
//                System.out.println("File not exists.....");
//            }


            //Solution2 direct Harry Code
//            String query = "software";
//            //BasicSearchController searchController = new BasicSearchController();
//            List<String[]> res = BasicSearchController.getResultQuery(query);
//            System.out.println("Size: "+res.size());
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < res.size(); ++i) {
//                System.out.println(res.get(i)[0]);
//                System.out.println("..." + res.get(i)[1].substring(0, 100) + "...\n");
//            }


        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
