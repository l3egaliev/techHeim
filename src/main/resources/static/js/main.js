function closeModal() {
    document.getElementById('log').style.display = 'none';
}

function validateForm() {
    // ���������� ����� ������ �������� ��������� ������
    const username = document.querySelector('.username').value;
    const password = document.querySelector('.password').value;
    const errors = document.getElementById('errors')


    // ������: ��������, ��� ���� �� �����
    if (username.trim() === '' || password.trim() === '') {
        return false; // ���������� �������� ����� � �������� ��������� ���� ��������
    }



    // ������ ��������...

    // ���� ������ �������, ����� ������� ��������� ����
    return true; // ���������� �������� �����
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

    const product_elements = document.getElementsByClassName('p-element')
    const product_line = document.getElementsByClassName('icon-line')
    for(let i = 0;i<product_elements.length;i++){
        product_elements.item(i).addEventListener('click', function (){
            product_elements.item(i).style.boxShadow = '0px 1px 16px 1px #b6b6b6'
            product_line.item(i).style.backgroundImage = '/images/main/new-products/hover-line.svg'
        })
    }
})

function navOnClick(){
    const nav_link = document.querySelector('.nav-link')
    nav_link.onclick = function (){
        nav_link.classList.add('active')
    }

}