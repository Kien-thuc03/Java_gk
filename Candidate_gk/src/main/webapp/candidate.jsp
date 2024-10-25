<%@ page import="java.util.List" %>
<%@ page import="edu.iuh.fit.candidate_gk.models.Candidate" %><%--
  Created by IntelliJ IDEA.
  User: FIL
  Date: 25/10/2024
  Time: 3:51 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <th>Ma ung vien</th>
            <th>Ten ung vien</th>
            <th>View</th>
        </tr>

        <%
            List<Candidate> candidateList = (List<Candidate>) request.getAttribute("candidateList");
            if (candidateList != null) {
                for (Candidate candidate : candidateList) {
        %>
        <tr>
            <td><%= candidate.getId() %></td>
            <td><%= candidate.getFullName() %></td>
            <td><a href="control-servlet?action=ViewCandidate&id=<%= candidate.getId() %>">View</a></td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="3">No data available</td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
