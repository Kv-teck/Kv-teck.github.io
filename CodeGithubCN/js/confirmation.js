function loadOrderConfirmation() {
    let orders = localStorage.getItem('orders');
    orders = orders ? JSON.parse(orders) : [];
    const order = orders[orders.length - 1]; // Lấy đơn hàng mới nhất

    if (order) {
        const orderConfirmation = document.getElementById('order-confirmation');
        orderConfirmation.innerHTML = `
            <h3>Thank you for your order, ${order.firstName} ${order.lastName}!</h3>
            <p>Your order has been placed successfully on <strong>${new Date(order.orderDate).toLocaleString()}</strong>.</p>
            <h4>Order Summary:</h4>
            <ul>
                ${order.cart.map(item => `
                    <li class="d-flex align-items-center mb-3">
                        <img src="${item.thumbnail}" alt="${item.title}" width="80" class="me-3">
                        <div>
                            <strong>${item.title}</strong><br>
                            Quantity: ${item.buyQty}<br>
                            Price: ${item.price} VND
                        </div>
                    </li>
                `).join('')}
            </ul>
            <h4>Shipping Details:</h4>
            <p>
                ${order.firstName} ${order.lastName}<br>
                ${order.address}<br>
                ${order.city}, ${order.country}<br>
                Postal Code: ${order.postal}<br>
            </p>
            <h4>Total Amount: ${order.cart.reduce((total, item) => total + (item.price * item.buyQty), 0)} VND</h4>
        `;
    } else {
        document.getElementById('order-confirmation').innerHTML = '<p>No recent orders found.</p>';
    }
}

loadOrderConfirmation();
