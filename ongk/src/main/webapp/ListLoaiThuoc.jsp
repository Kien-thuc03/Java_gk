<%@ page import="edu.iuh.fit.ongk.models.LoaiThuoc" %>
<%@ page import="java.util.List" %><%--
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
                  List<LoaiThuoc> loaiThuocFt = (List<LoaiThuoc>) request.getAttribute("loaiThuocList");
                  if (loaiThuocFt != null) {
                      for (LoaiThuoc loaiThuoc : loaiThuocFt) {
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
      <th>Ma loai</th>
      <th>Ten loai</th>
    </tr>

      <%
          List<LoaiThuoc> loaiThuocList = (List<LoaiThuoc>) request.getAttribute("loaiThuocList");
          if (loaiThuocList != null) {
              for (LoaiThuoc loaiThuoc : loaiThuocList) {
      %>
      <tr>
          <td><%= loaiThuoc.getMaLoai() %></td>
          <td><%= loaiThuoc.getTenLoai() %></td>
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
      </div>
    </form>
  </body>
</html>