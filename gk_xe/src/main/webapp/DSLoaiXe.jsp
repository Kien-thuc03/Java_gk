<%@ page import="edu.iuh.fit.gk_xe.models.Loaixe" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: FIL
  Date: 25/10/2024
  Time: 1:28 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh Sach loai </title>
</head>
<body>
  <table>
    <tr>
        <th>Ma loai</th>
        <th>Ten loai</th>
        <th>Danh Xe theo loai</th>
    </tr>

    <%
        List<Loaixe> loaiXeList = (List<Loaixe>) request.getAttribute("ListLoaiXe");
        if (loaiXeList != null) {
            for (Loaixe loaiXe : loaiXeList) {
            %>
                <tr>
                    <td><%= loaiXe.getMaLoai() %></td>
                    <td><%= loaiXe.getTenLoai() %></td>
                    <td>
                        <a href="ControlServlet?action=ListXe&maLoai=<%= loaiXe.getMaLoai() %>">DS Xe</a>
                    </td>
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
