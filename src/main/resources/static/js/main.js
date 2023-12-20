function closeModal() {
    document.getElementById('log').style.display = 'none';
}

function validateForm() {
    // Реализуйте здесь логику проверки введенных данных
    const username = document.querySelector('.username').value;
    const password = document.querySelector('.password').value;
    const errors = document.getElementById('errors')


    // Пример: проверка, что поля не пусты
    if (username.trim() === '' || password.trim() === '') {
        return false; // Остановить отправку формы и оставить модальное окно открытым
    }



    // Другие проверки...

    // Если данные валидны, можно закрыть модальное окно
    return true; // Продолжить отправку формы
}

document.addEventListener('DOMContentLoaded', function (){
    const dropdown = document.querySelector('.dropdown')
    const logBtn = document.getElementById('loginBtn')
    const url = 'http://localhost:8082/userInfo'
    const request = new XMLHttpRequest()
    const username = document.querySelector('.info-username')
    const user_email = document.querySelector('.info-email')


    request.open('GET', url)
    request.responseType = 'json'

    request.send()
    request.onload = function (){
        if(request.status >= 200 && request.status <= 300){
            username.textContent = request.response.username
            user_email.textContent = request.response.email

            logBtn.style.display = 'none'
            dropdown.style.display = 'block'
        }else{
            dropdown.style.display = 'none'
        }
    }

    navOnClick()
})

function navOnClick(){
    const nav_link = document.querySelector('.nav-link')
    nav_link.onclick = function (){
        nav_link.classList.add('active')
    }

}