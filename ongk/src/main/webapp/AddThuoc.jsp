<%@ page import="edu.iuh.fit.ongk.models.LoaiThuoc" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: FIL
  Date: 24/10/2024
  Time: 11:27 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Them Thuoc</title>
</head>
<body>
<div class="container">
    <h1>Them Thuoc</h1>
    <form action="thuoc-servlet" method="post">
        <div class="form-group">
            <label for="name">Ten thuoc</label>
            <input type="text" name="tenThuoc" id="name" required>
        </div>
        <div class="form-group">
            <label for="price"  >Gia</label>
            <input type="number" name="gia" id="price" required>
        </div>
        <div class="form-group">
            <label for="year"> Nam san xuat</label>
            <input type="number" name="namSx" id="year" required>
        </div>
        <div class="form-group">
            <label for="loaiThuoc">Loai thuoc</label>
            <select name="loaiThuoc" id="loaiThuoc">
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
        </div>
        <div class="actions">
            <button type="submit" name="action" value="submit">Them</button>
            <a href="thuoc-servlet?action=ListThuoc">Huy</a>
        </div>
    </form>
</div>
</body>
</html>
