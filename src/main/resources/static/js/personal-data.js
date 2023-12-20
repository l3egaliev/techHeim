document.addEventListener('DOMContentLoaded', function (){

})

function showView(btn_id, view_id){
    const panel_btn = document.getElementById(btn_id)
    const view = document.getElementById(view_id)
    const scroll = document.querySelector('.scroll')

    const scroll_child = scroll.children


    panel_btn.onclick = function (){
        view.style.display = 'block'

        for (let i = 0; i<scroll_child.length; i++){
            scroll.removeChild(scroll_child.item(i))
        }
        scroll.appendChild(view)
    }
}