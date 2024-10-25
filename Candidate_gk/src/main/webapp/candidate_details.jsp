<%@ page import="edu.iuh.fit.candidate_gk.models.Candidate" %>
<%@ page import="java.util.List" %>
<%@ page import="edu.iuh.fit.candidate_gk.models.Experience" %><%--
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
<%
    Candidate candidate = (Candidate) request.getAttribute("candidate");
%>
    <p>Ma ung vien: <%= candidate.getId()%></p>
    <p>Ten ung vien: <%= candidate.getFullName()%></p>
    <p>Email: <%= candidate.getEmail()%>></p>
    <p>Phone: <%= candidate.getPhone()%>></p>
    <table>
        <tr>
            <th>Id</th>
            <th>From date</th>
            <th>To date</th>
            <th>Role</th>
            <th>Company</th>
            <th>work description</th>
        </tr>

        <tr>
            <%
                List<Experience> experienceList = candidate.getExperiences();
                for (Experience experience : experienceList) {
            %>
            <tr>
                <td><%= experience.getId()%></td>
                <td><%= experience.getFromDate()%></td>
                <td><%= experience.getToDate()%></td>
                <td><%= experience.getRole()%></td>
                <td><%= experience.getCompany()%></td>
                <td><%= experience.getWorkDesc()%></td>
            </tr>
            <%
                }
            %>
        </tr>
    </table>
</body>
</html>
