function renderCart() {
    let cart = localStorage.getItem('cart');
    cart = cart ? JSON.parse(cart) : [];
    const cartList = document.getElementById('cart-list');
    let grandTotal = 0;

    cartList.innerHTML = '';
    cart.forEach((item, index) => {
        const itemTotal = item.price * item.buyQty;
        grandTotal += itemTotal;

        cartList.innerHTML += `
            <tr>
                <td><img src="${item.thumbnail}" width="80"></td>
                <td>${item.title}</td>
                <td><input type="number" value="${item.buyQty}" min="1" onchange="updateQuantity(${index}, this.value)"></td>
                <td>${item.price}</td>
                <td>${itemTotal}</td>
                <td><button class="btn btn-danger" onclick="removeFromCart(${index})">Remove</button></td>
            </tr>
        `;
    });

    document.getElementById('grand-total').innerText = grandTotal;
}

function updateQuantity(index, newQty) {
    let cart = localStorage.getItem('cart');
    cart = cart ? JSON.parse(cart) : [];
    cart[index].buyQty = parseInt(newQty);
    localStorage.setItem('cart', JSON.stringify(cart));
    renderCart();
}

function removeFromCart(index) {
    let cart = localStorage.getItem('cart');
    cart = cart ? JSON.parse(cart) : [];
    cart.splice(index, 1);
    localStorage.setItem('cart', JSON.stringify(cart));
    renderCart();
}

renderCart();
