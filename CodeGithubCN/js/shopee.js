
//Chức năng tìm kiếm
document.addEventListener('DOMContentLoaded', () => {
    const searchInput = document.getElementById('input-search');
    const searchButton = document.querySelector('button[type="submit"]');
    let products = []; // Declare the 'products' variable here

    // Function to handle the search
    function performSearch() {
        const keyword = searchInput.value.trim();
        if (keyword) {
            searchData(keyword);
        }
    }

    // Add event listener to the search button
    searchButton.addEventListener('click', (event) => {
        event.preventDefault(); // Prevent form submission
        performSearch();
    });

    // Add event listener to handle Enter key press
    searchInput.addEventListener('keypress', (event) => {
        if (event.key === 'Enter') {
            event.preventDefault(); // Prevent form submission
            performSearch();
        }
    });

    // Function to fetch product data from API
    async function searchData(keyword) {
        try {
            const url = `https://dummyjson.com/products/search?q=${keyword}&limit=21&sortBy=price&order=asc`; // API URL
            const response = await fetch(url); // Fetch data from API
            const data = await response.json(); // Convert response to JSON

            products = data.products; // Array of products

            const productList = document.getElementById('product-list');
            productList.innerHTML = ''; // Clear existing content

            // Loop through each product and generate HTML
            products.forEach(product => {
                const itemHtml = `
                            <div class="col-md-4">
                                <div class="card mb-4">
                                    <img src="${product.thumbnail}" class="card-img-top" alt="${product.title}">
                                    <div class="card-body">
                                        <h5 class="card-title">${product.title}</h5>
                                        <p class="card-text">Price: ${product.price} VND</p>
                                        <a href="#" onclick="addToCart(${product.id})" class="btn btn-primary">Add to cart</a>
                                    </div>
                                </div>
                            </div>`;
                productList.innerHTML += itemHtml;
            });
        } catch (error) {
            console.error('Error fetching products:', error);
        }
    }
});

// // Danh sách sản phẩm mẫu

let products = [];  // Global variable to store fetched products

async function getData() {
    try {
        const url = 'https://dummyjson.com/products'; // Fetch all products
        const response = await fetch(url); // Ensure 'response' is declared here
        const data = await response.json(); // Convert the response to JSON

        products = data.products; // Array of products

        const productList = document.getElementById('product-list');
        productList.innerHTML = ''; // Clear existing content

        // Loop through each product and generate HTML
        products.forEach(product => {
            const itemHtml = `
                        <div class="col-md-4">
                            <div class="card mb-4">
                                <img src="${product.thumbnail}" class="card-img-top" alt="${product.title}">
                                <div class="card-body">
                                    <h5 class="card-title">${product.title}</h5>
                                    <p class="card-text">Price: ${product.price} VND</p>
                                    <a href="#" onclick="addToCart(${product.id})" class="btn btn-primary">Add to cart</a>
                                </div>
                            </div>
                        </div>`;
            productList.innerHTML += itemHtml;
        });
    } catch (error) {
        console.error('Error fetching products:', error);
    }
}

// Call the function to load the products
getData();


// Hàm thêm sản phẩm vào giỏ hàng
function addToCart(productId) {
    // Lấy giỏ hàng từ localStorage
    let cart = localStorage.getItem('cart');
    cart = cart ? JSON.parse(cart) : [];

    // Tìm sản phẩm theo ID
    const product = products.find(p => p.id === productId);
    if (!product) {
        console.error('Product not found:', productId);
        showToast('Sản phẩm không tồn tại.');
        return;
    }

    // Kiểm tra xem sản phẩm đã có trong giỏ hàng chưa
    const existingProduct = cart.find(p => p.id === productId);

    if (existingProduct) {
        // Tăng số lượng sản phẩm nếu đã có trong giỏ hàng
        existingProduct.buyQty += 1;
    } else {
        // Thêm sản phẩm mới vào giỏ hàng
        cart.push({ ...product, buyQty: 1 });
    }

    // Lưu giỏ hàng vào localStorage
    localStorage.setItem('cart', JSON.stringify(cart));
    showToast(`${product.title} đã được thêm vào giỏ hàng.`);
}

// Hiển thị thông báo ngắn gọn cho người dùng và tự động ẩn
function showToast(message) {
    const toast = document.getElementById('toast');
    if (!toast) {
        console.error('Toast element not found.');
        return;
    }
    toast.textContent = message;
    toast.classList.add('show');

    setTimeout(() => {
        toast.classList.remove('show');
    }, 3000);
}



