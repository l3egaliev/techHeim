document.addEventListener('DOMContentLoaded', function (){
    const request = new XMLHttpRequest()
    const url = 'http://localhost:8082/products/all'

    request.open('GET', url)
    request.responseType = 'json'

    request.send()
    request.onload = function (){
        if(request.status >= 200 && request.status <= 300){
            console.log(request.response)
            allProducts(request.response)
        }
    }
})

function allProducts(response){



    for(let i = 0;i < response.length; i++){
        const products = document.querySelector('.products')

        let product = document.createElement('div')
        product.classList.add('product', 'card')

        let card_body = document.createElement('div')
        card_body.classList.add('card-body')

        let product_image = document.createElement('img')
        product_image.classList.add('card-image-top')
        product_image.src = '/images/logo.svg'
        product_image.style.width = '256px'
        product_image.style.height = '190px'

        let product_title = document.createElement('a')
        product_title.classList.add('card-title')
        product_title.href = '#'

        let product_price = document.createElement('p')
        product_price.classList.add('card-text', 'price')
        product_price.textContent = '$' + response[i].price

        let product_btn = document.createElement('a')
        product_btn.classList.add('btn', 'btn-primary')
        product_btn.textContent = 'Add to card'

        let product_category = document.createElement('div')
        product_category.textContent = response[i].category
        product_category.style.display = 'none'
        product_category.classList.add('product-category')


        product_title.textContent = response[i].name
        product.style.width = '18rem'
        product.classList.add(product_category.textContent)

        card_body.appendChild(product_image)
        card_body.appendChild(product_title)
        card_body.appendChild(product_price)
        card_body.appendChild(product_btn)
        card_body.appendChild(product_category)
        product.appendChild(card_body)
        products.appendChild(product)
    }


}

function sortByCategory(id){
    const nav_link = document.getElementById(id)
    const productToRemove = document.getElementsByClassName('product')

    nav_link.addEventListener('click', function (){
        nav_link.classList.add('active')
        const product = document.querySelector('.'+id)
        console.log(product.classList.item(2))
        console.log(productToRemove)
        //     console.log(productToRemove.classList.item(2))
        // }
        for(let i = 0; i < productToRemove.length; i++){
            console.log(productToRemove.item(i))
            if(product.classList.item(2).trim() !== productToRemove.item(i).classList.item(2).trim()) {
                productToRemove.item(i).style.display = 'none'
            }else{
                productToRemove.item(i).style.display = 'block'
            }
        }
    })
}