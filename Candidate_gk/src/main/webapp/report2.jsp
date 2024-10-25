<%@ page import="edu.iuh.fit.candidate_gk.models.Candidate" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: FIL
  Date: 25/10/2024
  Time: 3:51 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sach ung vien co su dung gmail</title>
</head>
<body>
<table>
    <tr>
        <th>Ma ung vien</th>
        <th>Ten ung vien</th>
    </tr>

    <%
        List<Candidate> candidateList = (List<Candidate>) request.getAttribute("candidateListGmail");
        if (candidateList != null) {
            for (Candidate candidate : candidateList) {
    %>
    <tr>
        <td><%= candidate.getId() %></td>
        <td><%= candidate.getFullName() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="2">No data available</td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
