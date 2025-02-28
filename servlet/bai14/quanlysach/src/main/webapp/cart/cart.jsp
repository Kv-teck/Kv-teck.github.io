<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2/26/2025
  Time: 10:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Giỏ hàng</title>

    <!-- Bootstrap v5.0.1 -->
    <link href="/resources/css/bootstrap.css" type="text/css" rel="stylesheet">
    <script src="/resources/js/bootstrap.bundle.js" type="text/javascript"></script>

    <!-- Bootstrap Icons v1.5.0 -->
    <link href="/resources/css/bootstrap-icons.css" type="text/css" rel="stylesheet">

    <!-- Custom Styles -->
    <link href="/resources/css/styles.css" type="text/css" rel="stylesheet">
</head>

<body>

<header class="section-header">
    <section class="header-main border-bottom">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-3 py-3">
                    <a class="text-body" href="/home">
                        <h3>Shop Bán Sách</h3>
                    </a>
                </div> <!-- col.// -->
                <div class="col-lg-4 col-xl-5">
                    <form action="#" class="search">
                        <div class="input-group w-100">
                            <input type="text" class="form-control" placeholder="Nhập từ khóa cần tìm ...">
                            <button class="btn btn-primary" type="button">
                                <i class="bi bi-search"></i>
                            </button>
                        </div>
                    </form>
                </div> <!-- col.// -->
                <div class="col-lg-5 col-xl-4">
                    <ul class="nav col-12 col-lg-auto my-2 my-lg-0 justify-content-center justify-content-lg-end text-small">
                        <li>
                            <a href="#" class="nav-link text-body">
                                <i class="bi bi-person d-block text-center fs-3"></i>
                                Tài khoản
                            </a>
                        </li>
                        <li>
                            <a href="#" class="nav-link text-body">
                                <i class="bi bi-list-check d-block text-center fs-3"></i>
                                Đơn hàng
                            </a>
                        </li>
                        <li>
                            <a href="#" class="nav-link text-body">
                                <i class="bi bi-cart d-block text-center fs-3"></i>
                                Giỏ hàng
                            </a>
                        </li>
                    </ul>
                </div> <!-- col.// -->
            </div> <!-- row.// -->
        </div> <!-- container.// -->
    </section> <!-- header-main.// -->
</header> <!-- section-header.// -->

<nav class="navbar navbar-main navbar-expand-lg navbar-light border-bottom">
    <div class="container">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        <strong><i class="bi bi-list"></i> Danh mục sản phẩm</strong>
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">Sách giáo khoa</a></li>
                        <li><a class="dropdown-item" href="#">Sách khoa học</a></li>
                        <li><a class="dropdown-item" href="#">Truyện tranh</a></li>
                        <li><a class="dropdown-item" href="#">Tiểu thuyết</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="#">Tất cả danh mục</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Sản phẩm mới</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Sản phẩm bán chạy</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Khuyến mãi</a>
                </li>
            </ul>
            <c:if test="${not empty currentUser}">
                <span class="me-2" >Xin chào, ${currentUser.fullName}</span>
                <a class="btn btn-primary" href="${applicationScope.baseUrl}/signout" role="button">Đăng xuất</a>
            </c:if>
            <c:if test="${empty currentUser}">
                <a class="btn btn-light me-2" href="#" role="button">Đăng ký</a>
                <a class="btn btn-primary" href="${applicationScope.baseUrl}/signin" role="button">Đăng nhập</a>
            </c:if>
        </div>
    </div> <!-- container.// -->
</nav> <!-- navbar-main.// -->

<section class="section-pagetop bg-light">
    <div class="container">
        <h2 class="title-page">Giỏ hàng</h2>
    </div> <!-- container.// -->
</section> <!-- section-pagetop.// -->

<section class="section-content padding-y">
    <div class="container">
        <div class="row">

            <main class="col-lg-9 mb-lg-0 mb-3">
                <div class="card">

                    <div class="table-responsive-xl">
                        <table class="cart-table table table-borderless">
                            <thead class="text-muted">
                            <tr class="small text-uppercase">
                                <th scope="col" style="min-width: 280px;">Sản phẩm</th>
                                <th scope="col" width="150" style="min-width: 150px;">Giá</th>
                                <th scope="col" width="150" style="min-width: 150px;">Số lượng</th>
                                <th scope="col" width="100" style="min-width: 100px;"></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:choose>
                                <c:when test="${empty cart.cartItems}">
                                    <tr>
                                        <td colspan="4" class="text-center text-danger">Giỏ hàng của bạn đang trống!</td>
                                    </tr>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach var="item" items="${cart.cartItems}">
                                        <tr>
                                            <td>
                                                <figure class="itemside">
                                                    <div class="float-start me-3">
                                                        <img src="" alt="Ảnh sản phẩm">
                                                    </div>
                                                    <figcaption class="info">
                                                        <a href="#" class="title"></a>
                                                    </figcaption>
                                                </figure>
                                            </td>
                                            <td>
                                                <div class="price-wrap">
                                                    <span class="price">₫</span>
                                                </div>
                                            </td>
                                            <td>
                                                <input type="number" value="${item.quantity}" min="1" class="form-control">
                                            </td>
                                            <td class="text-center text-nowrap">
                                                <a href="update-cart?productId=${item.productId}" class="btn btn-success">Cập nhật</a>
                                                <a href="delete-cart?productId=${item.productId}" class="btn btn-danger ms-1">Xóa</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                            </tbody>


                        </table>
                    </div> <!-- table.responsive-md.// -->

                    <div class="card-body border-top">
                        <a href="#" class="btn btn-primary float-end">Đặt hàng</a>
                        <a href="#" class="btn btn-light">Tiếp tục mua sắm</a>
                    </div> <!-- card-body.// -->

                </div> <!-- card.// -->
            </main> <!-- col.// -->

            <aside class="col-lg-3">

                <div class="card mb-3">
                    <div class="card-body">
                        <p class="card-title">Hình thức giao hàng</p>
                        <form action="">
                            <div class="form-check mb-2">
                                <input class="form-check-input" type="radio" name="delivery_method" id="delivery_method_1" checked>
                                <label class="form-check-label" for="delivery_method_1">Giao tiêu chuẩn</label>
                            </div>
                            <div class="form-check mb-2">
                                <input class="form-check-input" type="radio" name="delivery_method" id="delivery_method_2">
                                <label class="form-check-label" for="delivery_method_2">Giao nhanh</label>
                            </div>
                        </form>
                    </div> <!-- card-body.// -->
                </div> <!-- card.// -->

                <div class="card mb-3">
                    <div class="card-body">
                        <p class="card-title">Mã giảm giá</p>
                        <form action="">
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" placeholder="">
                                <button class="btn btn-primary" type="button">Áp dụng</button>
                            </div>
                        </form>
                    </div> <!-- card-body.// -->
                </div> <!-- card.// -->

                <div class="card">
                    <div class="card-body">
                        <dl class="row mb-0">
                            <dt class="col-xxl-6 col-lg-12 col-6">Tạm tính:</dt>
                            <dd class="col-xxl-6 col-lg-12 col-6 text-end mb-3">50.000₫</dd>
                            <dt class="col-xxl-6 col-lg-12 col-6">Phí vận chuyển:</dt>
                            <dd class="col-xxl-6 col-lg-12 col-6 text-end mb-3">10.000₫</dd>
                            <dt class="col-xxl-6 col-lg-12 col-6">Tổng cộng:</dt>
                            <dd class="col-xxl-6 col-lg-12 col-6 text-end mb-3"><strong>60.000₫</strong></dd>
                        </dl>
                    </div> <!-- card-body.// -->
                </div> <!-- card.// -->

            </aside> <!-- col.// -->

        </div> <!-- row.// -->
    </div> <!-- container -->
</section> <!-- section-content.// -->

<footer class="section-footer">
    <section class="footer-top py-5 bg-light">
        <div class="container">
            <div class="row">
                <aside class="col-sm-6 col-lg-3">
                    <h6 class="pb-2">Giới thiệu</h6>
                    <ul class="list-unstyled">
                        <li><a href="#">Về Shop</a></li>
                        <li><a href="#">Tuyển dụng</a></li>
                        <li><a href="#">Chính sách thanh toán</a></li>
                        <li><a href="#">Chính sách bảo mật</a></li>
                        <li><a href="#">Giải quyết khiếu nại</a></li>
                        <li><a href="#">Hợp tác</a></li>
                    </ul>
                </aside>
                <aside class="col-sm-6 col-lg-3">
                    <h6 class="pb-2">Hỗ trợ khách hàng</h6>
                    <ul class="list-unstyled">
                        <li>Hotline: 1900-80xx</li>
                        <li><a href="#">Câu hỏi thường gặp</a></li>
                        <li><a href="#">Hướng dẫn đặt hàng</a></li>
                        <li><a href="#">Phương thức vận chuyển</a></li>
                        <li><a href="#">Chính sách đổi trả</a></li>
                    </ul>
                </aside>
                <aside class="col-lg-5">
                    <h6 class="pb-2">Đăng ký nhận tin</h6>
                    <form action="#">
                        <div class="input-group w-100">
                            <input type="text" class="form-control" placeholder="Email của bạn ...">
                            <button class="btn btn-primary" type="button">
                                Đăng ký
                            </button>
                        </div>
                    </form>
                </aside>
            </div> <!-- row.// -->
        </div> <!-- container.// -->
    </section> <!-- footer-top.// -->

    <section class="footer-bottom text-center bg-light border-top py-3">
        <div class="container-fluid">© 2021 — Shop Bán Sách</div> <!-- container-fluid.// -->
    </section> <!-- footer-bottom.// -->
</footer> <!-- section-footer.// -->

</body>

</html>
