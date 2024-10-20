// scripts.js
// Danh sách sản phẩm mẫu
const products = [
    {
        id: 1,
        title: "Fan",
        price: 10000,
        thumbnail: "images/black-aesthetic-mountains-4k-9k.jpg"
    },
    {
        id: 2,
        title: "Lamp",
        price: 15000,
        thumbnail: "images/black-aesthetic-mountains-4k-9k.jpg"
    },
    {
        id: 3,
        title: "Phone",
        price: 20000,
        thumbnail: "images/black-aesthetic-mountains-4k-9k.jpg"
    }
];

// Render sản phẩm ra trang
const productList = document.getElementById('product-list');
products.forEach(product => {
    productList.innerHTML += `
        <div class="col-md-4">
            <div class="card mb-4">
                <img src="${product.thumbnail}" class="card-img-top" alt="${product.title}">
                <div class="card-body">
                    <h5 class="card-title">${product.title}</h5>
                    <p class="card-text">Price: ${product.price} VND</p>
                    <a href="javascript:void(0);" onclick="addToCart(${product.id})" class="btn btn-primary">Add to cart</a>
                    <a href="javascript:void(0);" onclick="removeFromCart(${product.id})" class="btn btn-danger">Remove from cart</a>
                </div>
            </div>
        </div>
    `;
});

// Hàm thêm sản phẩm vào giỏ hàng
function addToCart(productId) {
    let cart = localStorage.getItem('cart');
    cart = cart ? JSON.parse(cart) : [];

    const product = products.find(p => p.id === productId);
    const existingProduct = cart.find(p => p.id === productId);

    if (existingProduct) {
        existingProduct.buyQty += 1;
    } else {
        cart.push({ ...product, buyQty: 1 });
    }

    localStorage.setItem('cart', JSON.stringify(cart));
    
    // Hiển thị thông báo Toast
    showToast(`${product.title} has been added to your cart.`);
}

// Hàm xóa sản phẩm khỏi giỏ hàng
function removeFromCart(productId) {
    let cart = localStorage.getItem('cart');
    cart = cart ? JSON.parse(cart) : [];

    // Tìm chỉ mục của sản phẩm trong giỏ hàng
    const productIndex = cart.findIndex(p => p.id === productId);

    // Nếu sản phẩm được tìm thấy, xóa nó
    if (productIndex !== -1) {
        cart.splice(productIndex, 1);
        localStorage.setItem('cart', JSON.stringify(cart));
        showToast(`Product has been removed from your cart.`);
    } else {
        showToast(`Product is not in your cart.`);
    }
}

// Hàm hiển thị thông báo Toast
function showToast(message) {
    const toast = document.getElementById('toast');
    toast.textContent = message;
    toast.classList.add('show');
    
    // Ẩn thông báo sau 3 giây
    setTimeout(() => {
        toast.classList.remove('show');
    }, 3000);
}
