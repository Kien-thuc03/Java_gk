<%@ page import="edu.iuh.fit.gk_xe.models.Xe" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: FIL
  Date: 25/10/2024
  Time: 1:27 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sach Xe</title>
</head>
<body>
    <table>
        <tr>
            <td>Ten xe</td>
            <td>Gia</td>
            <td>Nam san xuat</td>
            <td>Ma loai</td>
        </tr>

    <% List<Xe> xeList = (List<Xe>) request.getAttribute("ListXe");
        if (xeList != null) {
            for (Xe xe : xeList) {
        %>
            <tr>
                <td><%= xe.getTenXe() %></td>
                <td><%= xe.getGia() %></td>
                <td><%= xe.getNamSX() %></td>
                <td><%= xe.getMaLoai().getMaLoai() %></td>
            </tr>
        <%
            }
        } else {
        %>
            <tr>
                <td colspan="4">No data available</td>
            </tr>
        <%
            }
        %>
    </table>

<a href="ControlServlet?action=add">Them Xe</a>
<a href="ControlServlet?action=ListLoaiXe">DS Loai Xe</a>
</body>
</html>
