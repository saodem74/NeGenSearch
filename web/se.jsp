  <%@page contentType="text/html; charset=UTF-8"%>
  <%@page import="org.json.simple.JSONObject"%> 
  <%@page import="java.util.*" %>
  <%@page import="java.io.*" %>
  <%@page import="project.*" %>


  <%
    String inputStr = request.getParameter("query");
    System.out.println("SSSSSSS");

//    JSONObject query_response = new JSONObject();
//    JSONObject results = new JSONObject();
//
//  System.out.println("AAAA");

    out.print(query_response);
    out.flush();
  %>