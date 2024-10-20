        // // Danh sách sản phẩm mẫu
        // const products = [
        //     {
        //         id: 1,
        //         title: "Fan",
        //         price: 10000,
        //         thumbnail: "images/black-aesthetic-mountains-4k-9k.jpg"
        //     },
        //     {
        //         id: 2,
        //         title: "Lamp",
        //         price: 15000,
        //         thumbnail: "images/black-aesthetic-mountains-4k-9k.jpg"
        //     },
        //     {
        //         id: 3,
        //         title: "Phone",
        //         price: 20000,
        //         thumbnail: "images/black-aesthetic-mountains-4k-9k.jpg"
        //     }
        // ];

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



        // // Render sản phẩm ra trang
        // const productList = document.getElementById('product-list');
        // products.forEach(product => {
        //     productList.innerHTML += `
        //         <div class="col-md-4">
        //             <div class="card mb-4">
        //                 <img src="${product.thumbnail}" class="card-img-top" alt="${product.title}">
        //                 <div class="card-body">
        //                     <h5 class="card-title">${product.title}</h5>
        //                     <p class="card-text">Price: ${product.price} VND</p>
        //                     <a href="cart.html" onclick="addToCart(${product.id})" class="btn btn-primary">Add to cart</a>
        //                 </div>
        //             </div>
        //         </div>
        //     `;
        // });

        // // Hàm thêm sản phẩm vào giỏ hàng
        // function addToCart(productId) {
        //     let cart = localStorage.getItem('cart');
        //     cart = cart ? JSON.parse(cart) : [];

        //     const product = products.find(p => p.id === productId);
        //     const existingProduct = cart.find(p => p.id === productId);

        //     if (existingProduct) {
        //         existingProduct.buyQty += 1;
        //     } else {
        //         cart.push({ ...product, buyQty: 1 });
        //     }

        //     localStorage.setItem('cart', JSON.stringify(cart));
        //     alert(`${product.title} has been added to your cart.`);
        // }
        // Hàm thêm sản phẩm vào giỏ hàng
        function addToCart(productId) {
            let cart = localStorage.getItem('cart');
            cart = cart ? JSON.parse(cart) : [];

            const product = products.find(p => p.id === productId);
            if (!product) {
                console.error('Product not found:', productId);
                return;
            }

            const existingProduct = cart.find(p => p.id === productId);

            if (existingProduct) {
                existingProduct.buyQty += 1;
            } else {
                cart.push({ ...product, buyQty: 1 });
            }

            localStorage.setItem('cart', JSON.stringify(cart));
            showToast(`${product.title} has been added to your cart.`);
        }

        //hiển thị thông báo ngắn gọn cho người dùng và tự động ẩn
        function showToast(message) {
            const toast = document.getElementById('toast');
            toast.textContent = message;
            toast.classList.add('show');

            setTimeout(() => {
                toast.classList.remove('show');
            }, 3000);
        }
