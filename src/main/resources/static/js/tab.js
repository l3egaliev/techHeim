function clickedLink(tabName) {
    var i, tabcontent, tablinks;

    // �������� ��� �������
    tabcontent = document.getElementsByClassName("tab-content");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    // ������������ ��� ������ �������
    tablinks = document.getElementsByClassName("tab-link");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].style.backgroundColor = "#f2f2f2";
    }

    // ���������� ��������� �������
    document.getElementById(tabName).style.display = "block";

    // ���������� ������ ��������� �������
    event.currentTarget.style.backgroundColor = "#ffffff";
}

