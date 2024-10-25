<%@ page import="edu.iuh.fit.gk_xe.models.Loaixe" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: FIL
  Date: 25/10/2024
  Time: 1:36 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Them Xe</title>
  </head>
  <body>
    <div class="container">
        <h1>Them Xe</h1>
        <form action="ControlServlet" method="post">
          <div class="form-group">
              <label for="name">Ten xe</label>
              <input type="text" name="tenXe" id="name" required>
          </div>
          <div class="form-group">
              <label for="price"  >Gia</label>
              <input type="number" name="gia" id="price" required>
          </div>
          <div class="form-group">
              <label for="year"> Nam san xuat</label>
              <input type="number" name="namSX" id="year" required>
          </div>
          <div class="form-group">
              <label for="loaiXe">Loai xe</label>
              <select name="loaiXe" id="loaiXe">
                  <%
                      List<Loaixe> loaiXeList = (List<Loaixe>) request.getAttribute("loaiXeList");
                      if (loaiXeList != null) {
                          for (Loaixe loaiXe : loaiXeList) {
                  %>
                      <option value="<%= loaiXe.getMaLoai() %>"><%= loaiXe.getTenLoai() %></option>
                  <%
                          }
                      }
                  %>
                          }
              </select>
              <div class="actions">
                  <button type="submit" name="action" value="submit">Them</button>
                  <a href="ControlServlet?action=ListXe">Huy</a>
              </div>
          </div>
        </form>
    </div>
  </body>
</html>
