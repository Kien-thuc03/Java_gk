package edu.iuh.fit.ongk.controlers;

import java.io.*;
import java.util.List;
import java.util.UUID;

import edu.iuh.fit.ongk.daos.LoaiThuocDAO;
import edu.iuh.fit.ongk.daos.ThuocDAO;
import edu.iuh.fit.ongk.models.LoaiThuoc;
import edu.iuh.fit.ongk.models.Thuoc;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "ThuocServlet", value = "/thuoc-servlet")
public class ThuocServlet extends HttpServlet {
    private ThuocDAO thuocDAO;
    private LoaiThuocDAO loaiThuocDAO;

    public void init() {
        thuocDAO = new ThuocDAO();
        loaiThuocDAO = new LoaiThuocDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();

        switch (action) {
            case "ListLT":
                List<LoaiThuoc> loaiThuocs = (List<LoaiThuoc>) loaiThuocDAO.findAll();
                request.setAttribute("loaiThuocList", loaiThuocs);
                request.getRequestDispatcher("ListLoaiThuoc.jsp").forward(request, response);

                List<Thuoc> thuocListByLoai = null;
                String maLoai = request.getParameter("loaiThuoc");
                if (maLoai == null || maLoai.isEmpty()) {
                    thuocListByLoai = (List<Thuoc>) thuocDAO.findAll();
                } else {
                    thuocListByLoai = (List<Thuoc>) thuocDAO.findByMaLoai(maLoai);
                }
                request.setAttribute("thuocListByLoai", thuocListByLoai);
                request.getRequestDispatcher("ListThuoc.jsp").forward(request, response);
                break;
            case "ListThuoc":

                List<LoaiThuoc> loaiTList = (List<LoaiThuoc>) loaiThuocDAO.findAll();
                request.setAttribute("loaiThuocList", loaiTList);

                List<Thuoc> thuocListFt = null;
                String maLoaiFt = request.getParameter("loaiThuoc");
                if (maLoaiFt == null || maLoaiFt.isEmpty() || maLoaiFt.equals("all")) {
                    thuocListFt = (List<Thuoc>) thuocDAO.findAll();
                } else {
                    thuocListFt = (List<Thuoc>) thuocDAO.findByMaLoai(maLoaiFt);
                }
                request.setAttribute("thuocListByLoai", thuocListFt);
                request.getRequestDispatcher("ListThuoc.jsp").forward(request, response);
                break;
            case "add":
                List<LoaiThuoc> loaiThuocList = (List<LoaiThuoc>) loaiThuocDAO.findAll();
                request.setAttribute("loaiThuocList", loaiThuocList);
                request.getRequestDispatcher("AddThuoc.jsp").forward(request, response);
                break;
            case "edit":
                handleEdit(request, response);
                break;

            default:
                request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        HttpSession session = req.getSession();

        switch (action) {
            case "submit":
                handleSave(req, resp, session);
                break;
    }
    }

    private void handleEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maThuoc = request.getParameter("maThuoc");
        request.setAttribute("thuoc", thuocDAO.findById(maThuoc).get());
        request.getRequestDispatcher("EditThuoc.jsp").forward(request, response);

    }

    private void handleSave(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        String tenThuoc = request.getParameter("tenThuoc");
        Double gia = Double.parseDouble(request.getParameter("gia"));
        Integer namSx = Integer.parseInt(request.getParameter("namSx"));
        String loaiThuoc = request.getParameter("loaiThuoc");
        Thuoc thuoc = new Thuoc(UUID.randomUUID().toString()
                , gia, namSx, tenThuoc, loaiThuocDAO.findById(loaiThuoc).get());
        thuocDAO.addThuoc(thuoc);
        response.sendRedirect("thuoc-servlet?action=ListThuoc");
    }

    public void destroy() {
    }
}