function clickedLink(tabName) {
    var i, tabcontent, tablinks;

    // Скрываем все вкладки
    tabcontent = document.getElementsByClassName("tab-content");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    // Деактивируем все кнопки вкладок
    tablinks = document.getElementsByClassName("tab-link");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].style.backgroundColor = "#f2f2f2";
    }

    // Отображаем выбранную вкладку
    document.getElementById(tabName).style.display = "block";

    // Активируем кнопку выбранной вкладки
    event.currentTarget.style.backgroundColor = "#ffffff";
}

