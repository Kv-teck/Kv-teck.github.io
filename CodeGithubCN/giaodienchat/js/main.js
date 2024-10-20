document.addEventListener('DOMContentLoaded', () => {
    // Chat functionality
    const chatInput = document.querySelector('.chat-input input');
    const sendButton = document.querySelector('.chat-input button');
    const chatMessages = document.querySelector('.chat-messages');

    function addMessage(messageText, isSent) {
        const messageElement = document.createElement('div');
        messageElement.classList.add('message', isSent ? 'sent' : 'received');
        messageElement.textContent = messageText;
        chatMessages.appendChild(messageElement);
        chatMessages.scrollTop = chatMessages.scrollHeight; // Auto-scroll to the bottom
    }

    function sendMessage() {
        const messageText = chatInput.value.trim();
        if (messageText !== '') {
            addMessage(messageText, true);
            chatInput.value = '';

            // Simulate a response
            setTimeout(() => {
                addMessage('Đây là phản hồi tự động từ hệ thống.', false);
            }, 1000); // Adjust response time as needed
        }
    }

    sendButton.addEventListener('click', sendMessage);

    chatInput.addEventListener('keypress', (e) => {
        if (e.key === 'Enter') {
            sendMessage();
            e.preventDefault(); // Prevent the default action of Enter key
        }
    });

    // Dropdown menu functionality
    const profileButton = document.getElementById('profileButton');
    const dropdownMenu = document.getElementById('dropdownMenu');

    profileButton.addEventListener('click', () => {
        dropdownMenu.style.display = dropdownMenu.style.display === 'block' ? 'none' : 'block';
    });

    document.addEventListener('click', (e) => {
        if (!profileButton.contains(e.target) && !dropdownMenu.contains(e.target)) {
            dropdownMenu.style.display = 'none';
        }
    });

    // Tooltip functionality
    const iconContainer = document.querySelector('.icon-container');
    const tooltip = document.querySelector('.tooltip');

    iconContainer.addEventListener('mouseenter', () => {
        tooltip.style.visibility = 'visible';
        tooltip.style.opacity = '1';
    });

    iconContainer.addEventListener('mouseleave', () => {
        tooltip.style.visibility = 'hidden';
        tooltip.style.opacity = '0';
    });
});



