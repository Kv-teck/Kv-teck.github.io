document.getElementById('send-button').addEventListener('click', sendMessage);
document.getElementById('chat-input').addEventListener('keypress', function (e) {
    if (e.key === 'Enter') {
        sendMessage();
    }
});

function sendMessage() {
    const inputElement = document.getElementById('chat-input');
    const message = inputElement.value.trim();

    if (message !== '') {
        displayMessage(message, 'user');
        inputElement.value = '';
        
        setTimeout(() => {
            getBotResponse(message);
        }, 500);
    }
}

function displayMessage(message, sender) {
    const chatBox = document.getElementById('chat-box');
    const messageElement = document.createElement('div');
    messageElement.classList.add('chat-message', sender);

    const messageContent = document.createElement('div');
    messageContent.classList.add('message-content');
    messageContent.textContent = message;

    messageElement.appendChild(messageContent);
    chatBox.appendChild(messageElement);

    chatBox.scrollTop = chatBox.scrollHeight;
}

function getBotResponse(userMessage) {
    // Simple bot response logic
    const botMessage = "You said: " + userMessage;
    displayMessage(botMessage, 'bot');
}
