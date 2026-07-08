function hello(){
    alert("안녕하세요.");
}

let btn = document.getElementById("btn");

btn.addEventListener("click", () => {
    alert("하이");
});