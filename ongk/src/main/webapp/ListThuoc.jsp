<%@ page import="edu.iuh.fit.ongk.models.Thuoc" %>
<%@ page import="java.util.List" %>
<%@ page import="edu.iuh.fit.ongk.models.LoaiThuoc" %><%--
  Created by IntelliJ IDEA.
  User: FIL
  Date: 24/10/2024
  Time: 11:26 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sach loai thuoc</title>
</head>
<body>
<form method="get" action="thuoc-servlet">
<div class="form-group">
    <label for="loaiThuoc">Loai thuoc</label>
    <select name="loaiThuoc" id="loaiThuoc">
        <option value="all">All</option>
        <%
            List<LoaiThuoc> loaiThuocList = (List<LoaiThuoc>) request.getAttribute("loaiThuocList");
            if (loaiThuocList != null) {
                for (LoaiThuoc loaiThuoc : loaiThuocList) {
        %>
        <option value="<%= loaiThuoc.getMaLoai() %>"><%= loaiThuoc.getTenLoai() %></option>
        <%
                }
            }
        %>
        }
    </select>
    <button type="submit" name="action" value="ListThuoc">Loc</button>


    <table>
        <tr>
            <th>Ma thuoc</th>
            <th>Ten thuoc</th>
            <th>Don gia</th>
            <th>Nam san xuat</th>
            <th>Ma loai</th>
            <th>Actions</th>
        </tr>

        <%
            List<Thuoc> thuocList = (List<Thuoc>) request.getAttribute("thuocListByLoai");
            if (thuocList != null) {
                for (Thuoc thuoc : thuocList) {
        %>
            <tr>
                <td><%= thuoc.getMaThuoc() %></td>
                <td><%= thuoc.getTenThuoc() %></td>
                <td><%= thuoc.getGia() %></td>
                <td><%= thuoc.getNamSx() %></td>
                <td><%= thuoc.getMaLoai().getMaLoai()%></td>
                <td>
                    <a href="thuoc-servlet?action=ListLT">DS Loai Thuoc</a>
                    <a href="thuoc-servlet?action=add">Them thuoc</a>
                </td>
            </tr>
        <%
            }
        } else {
        %>
            <tr>
                <td colspan="6">No data available</td>
            </tr>
        <%
            }
        %>

        </table>
</div>
</form>
</body>
</html>
