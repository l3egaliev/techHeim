document.addEventListener('DOMContentLoaded', function (){

})

function showView(btn_id, view_id, panel_icon_class){
    const panel_btn = document.getElementById(btn_id)
    const view = document.getElementById(view_id)
    const scroll = document.querySelector('.scroll')
    const btns = document.getElementsByClassName('panel-btn')

    const scroll_child = scroll.children
    const panel_icon = document.querySelector('.'+panel_icon_class)
    const panel_icons_to_delete = document.getElementsByClassName('panel-icon-active')



    panel_btn.onclick = function (){
        view.style.display = 'block'

        removeActiveClass(btns, 'active')

        panel_btn.classList.add('active')

        removeActiveClass(panel_icons_to_delete, 'panel-icon-active')

        panel_icon.classList.add('panel-icon-active')


        for (let o = 0; o<scroll_child.length; o++){
            console.log(scroll_child.item(o))
            if(scroll_child.item(o).getAttribute('id') !== view.getAttribute('id')){
                scroll_child.item(o).style.display = 'none'
            }
        }


        // http://localhost:8082/user#{payments || personal и.т.д}
        // Показываю после # id panel-btn
        // Получить текущий URL
        var currentURL = window.location.href;

        // Удалить фрагмент
        var newURL = currentURL.split("#")[0];

        // Заменить текущий URL без фрагмента
        window.history.replaceState({}, document.title, newURL+"#"+panel_btn.id);

    }
}

function removeActiveClass(elements, active_class){
    for (let i = 0; i<elements.length; i++){
        elements.item(i).classList.remove(active_class)
    }
}