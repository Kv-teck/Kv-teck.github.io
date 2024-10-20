        // Hàm hiển thị thông tin giỏ hàng
        function loadCart() {
            const cart = JSON.parse(localStorage.getItem('cart')) || [];
            const orderSummary = document.getElementById('order-summary');
            let cartHTML = '';

            if (cart.length > 0) {
                let subtotal = 0;

                cart.forEach(item => {
                    subtotal += item.price * item.buyQty;
                    cartHTML += `
                        <div class="d-flex align-items-center mb-3">
                            <img src="${item.thumbnail}" alt="${item.title}" width="80" class="me-3">
                            <div>
                                <strong>${item.title}</strong><br>
                                Quantity: ${item.buyQty}<br>
                                Price: ${item.price} VND
                            </div>
                        </div>`;
                });

                cartHTML += `
                    <div>
                        <strong>Subtotal:</strong> ${subtotal} VND<br>
                        <strong>Shipping & Handling:</strong> FREE<br>
                        <strong>Total:</strong> ${subtotal} VND
                    </div>
                `;
            } else {
                cartHTML = '<p>Your cart is empty.</p>';
            }

            orderSummary.innerHTML = cartHTML;
        }

        document.getElementById('checkout-form').addEventListener('submit', function (event) {
            event.preventDefault();

            // Lấy dữ liệu người dùng nhập vào
            const order = {
                firstName: document.getElementById('fname').value,
                lastName: document.getElementById('lname').value,
                postal: document.getElementById('postal').value,
                address: document.getElementById('address').value,
                address2: document.getElementById('address2').value,
                city: document.getElementById('city').value,
                province: document.getElementById('province').value,
                country: document.getElementById('country').value,
                delivery: document.querySelector('input[name="delivery"]:checked').value,
                phone: document.getElementById('phone').value,
                email: document.getElementById('email').value,
                cart: JSON.parse(localStorage.getItem('cart')) || [],
                orderDate: new Date()
            };

            // Lưu đơn hàng vào localStorage
            let orders = JSON.parse(localStorage.getItem('orders')) || [];
            orders.push(order);
            localStorage.setItem('orders', JSON.stringify(orders));

            // Xóa giỏ hàng sau khi hoàn thành
            localStorage.removeItem('cart');

            // Chuyển hướng sang trang xác nhận đơn hàng
            window.location.href = 'confirmation.html';
        });

        // Hiển thị giỏ hàng khi tải trang
        loadCart();
