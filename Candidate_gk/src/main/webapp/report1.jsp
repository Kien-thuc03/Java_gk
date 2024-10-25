<%@ page import="java.util.List" %>
<%@ page import="edu.iuh.fit.candidate_gk.enums.Roles" %>
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
    <title>Candidate By Role</title>
</head>
<body>
    <form>
        <select name="Roles">
            <%
                List<Roles> roles = (List<Roles>) request.getAttribute("rolesList");
                if (roles != null) {
                    for (Roles role : roles) {
            %>
            <option value="<%= role %>"><%= role %></option>
            <%
                    }
                }
            %>
        </select>
        <button type="submit" name="action" value="Views">Views</button>
    </form>
    <table>
        <tr>
            <th>Ma ung vien</th>
            <th>Ten ung vien</th>
        </tr>

        <%
            List<Candidate> candidateList = (List<Candidate>) request.getAttribute("candidateByRole");
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
            <td colspan="2">Chon vai tro de xem</td>
        <%
            }
        %>
</body>
</html>
