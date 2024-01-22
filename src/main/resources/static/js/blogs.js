// function getAllBlogs(){
//     const url = 'http://localhost:8082/blogs/all';
//     const request = new XMLHttpRequest()
//
//     request.open('GET', url);
//     request.send();
//     request.onload = function(){
//         if(request.status >= 200 || request.status <= 300){
//             showAllBlogs(JSON.parse(request.response));
//         }
//     }
//
// }
//
//
// function showAllBlogs(response){
//     for (let i=0;i<response.length;i++){
//         console.log(response[i])
//         let blogs = document.querySelector('.blogs')
//         let blog, title, min_desc;
//         blog = document.createElement('div')
//         title = document.createElement('button')
//         min_desc = document.createElement('p')
//
//         blog.classList.add('blog')
//         title.classList.add('blog-title')
//         min_desc.classList.add('blog-min-desc')
//
//         title.textContent = response[i].title
//         min_desc.textContent = response[i].paragraphs[0].paragraph
//
//         blog.appendChild(title)
//         blog.appendChild(min_desc)
//         blogs.appendChild(blog)
//
//         title.onclick = function (){
//             window.open('http://localhost:8082/blogs/'+response[i].id, 'blank')
//             showOneBlog(response[i].id)
//         }
//     }
//
// }
//
// function showOneBlog(id){
//     const url = "https://localhost:8082/blogs/"+id;
//     const request = new XMLHttpRequest()
//
//     request.open('GET', url)
//     request.send()
//     request.onload = function(){
//         if (request.status >= 200 || request.status <= 300){
//             console.log(request.response)
//         }else{
//             console.log('not working')
//         }
//     }
// }
//
//
// document.addEventListener("DOMContentLoaded", function(){
//     getAllBlogs()
// })

