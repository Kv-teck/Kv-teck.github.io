<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2/27/2025
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Sách giáo khoa</title>

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
                            <a href="/cart" class="nav-link text-body">
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
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                       data-bs-toggle="dropdown"
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
            <a class="btn btn-light me-2" href="#" role="button">Đăng ký</a>
            <a class="btn btn-primary" href="#" role="button">Đăng nhập</a>
        </div>
    </div> <!-- container.// -->
</nav> <!-- navbar-main.// -->

<section class="section-pagetop bg-light">
    <div class="container">
        <c:choose>
            <c:when test="${not empty selectedCategory.name}">
                <h2 class="title-page">${selectedCategory.name}</h2>
            </c:when>
            <c:otherwise>
                <h2 class="title-page">Danh mục không tồn tại</h2>
            </c:otherwise>
        </c:choose>
            <nav>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item" aria-current="page"><a href="/home">Trang chủ</a></li>
                    <c:choose>
                        <c:when test="${not empty selectedCategory.name}">
                            <li class="breadcrumb-item active">${selectedCategory.name}</li>
                        </c:when>
                        <c:otherwise>
                            <li class="breadcrumb-item active">Không xác định</li>
                        </c:otherwise>
                    </c:choose>
                </ol>
            </nav>
    </div>
    <!-- container.// -->

</section> <!-- section-pagetop.// -->

<section class="section-content padding-y">
    <div class="container">
        <div class="row">
            <aside class="col-md-4 col-lg-3 mb-md-0 mb-3">
                <div class="card">
                    <article class="filter-group">
                        <header class="card-header my-1">
                            <a data-bs-toggle="collapse" href="#collapse_1" aria-expanded="true"
                               aria-controls="collapse_1">
                                <i class="float-end bi bi-chevron-down"></i>
                                <h6 class="title fw-bold">Nhà xuất bản</h6>
                            </a>
                        </header>
                        <div class="filter-content collapse show" id="collapse_1">
                            <div class="card-body pt-0">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="checkbox_brand_1"
                                           checked>
                                    <label class="form-check-label" for="checkbox_brand_1">
                                        NXB Giáo dục
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="checkbox_brand_2"
                                           checked>
                                    <label class="form-check-label" for="checkbox_brand_2">
                                        NXB Đại học Sư phạm Hà Nội
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="checkbox_brand_3"
                                           checked>
                                    <label class="form-check-label" for="checkbox_brand_3">
                                        NXB Đại học Sư phạm TPHCM
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="checkbox_brand_4"
                                           checked>
                                    <label class="form-check-label" for="checkbox_brand_4">
                                        NXB Đại học Quốc gia Hà Nội
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="checkbox_brand_5"
                                           checked>
                                    <label class="form-check-label" for="checkbox_brand_5">
                                        NXB Đại học Huế
                                    </label>
                                </div>
                            </div> <!-- card-body.// -->
                        </div>
                    </article>
                    <article class="filter-group">
                        <header class="card-header my-1">
                            <a data-bs-toggle="collapse" href="#collapse_2" aria-expanded="true"
                               aria-controls="collapse_2">
                                <i class="float-end bi bi-chevron-down"></i>
                                <h6 class="title fw-bold">Giá bán</h6>
                            </a>
                        </header>
                        <div class="filter-content collapse show" id="collapse_2">
                            <div class="card-body pt-0">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="checkbox_price_1"
                                           checked>
                                    <label class="form-check-label" for="checkbox_price_1">
                                        Dưới 20.000₫
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="checkbox_price_2"
                                           checked>
                                    <label class="form-check-label" for="checkbox_price_2">
                                        Từ 20.000₫ đến 100.000₫
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="checkbox_price_3"
                                           checked>
                                    <label class="form-check-label" for="checkbox_price_3">
                                        Trên 100.000₫
                                    </label>
                                </div>
                            </div> <!-- card-body.// -->
                        </div>
                    </article>
                </div> <!-- card.// -->
            </aside> <!-- col.// -->

            <main class="col-md-8 col-lg-9">

                <header class="border-bottom mb-4 pb-3">
                    <div class="form-inline d-flex justify-content-between align-items-center">
                        <span>30 sản phẩm</span>
                        <div>
                            <select class="form-select">
                                <option>Bán chạy nhất</option>
                                <option>Mới nhất</option>
                                <option>Đánh giá cao nhất</option>
                                <option>Giá thấp nhất</option>
                            </select>
                        </div>
                    </div>
                </header> <!-- sect-heading -->

                <div class="row item-grid">
                    <c:forEach var="product" items="${productModels}">
                        <div class="col-lg-4 col-md-6">
                            <div class="card p-3 mb-4">
                                <a href="/view/item-product?productId=${product.id}" class="img-wrap text-center">
                                    <img class="img-fluid" src="${product.imageName}">
                                </a>
                                <figcaption class="info-wrap mt-2">
                                    <a href="/view/item-product?productId=${product.id}"
                                       class="title">${product.name}</a>
                                    <div class="price mt-1 fw-bold">${product.price}₫</div>
                                </figcaption>
                            </div>
                        </div>
                        <!-- col.// -->
                    </c:forEach>
                </div> <!-- row end.// -->

                <nav class="mt-4">
                    <ul class="pagination">
                        <li class="page-item disabled"><a class="page-link" href="#">Trang trước</a></li>
                        <li class="page-item active"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item"><a class="page-link" href="#">Trang sau</a></li>
                    </ul>
                </nav>

            </main> <!-- col.// -->
        </div> <!-- row.// -->
    </div> <!-- container.//  -->
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